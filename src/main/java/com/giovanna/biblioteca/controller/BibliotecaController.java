package com.giovanna.biblioteca.controller;
import com.giovanna.biblioteca.model.Libro;
import com.giovanna.biblioteca.repository.LibroRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libros") //Todos los endpoints empiezan con /Libros
public class BibliotecaController {

    private final LibroRepository libroRepository;

    public BibliotecaController(LibroRepository libroRepository){
        this.libroRepository = libroRepository;
    }
    @GetMapping
    public List<Libro> listraLibro(){
        return libroRepository.findAll();
    }
    //Agregar libro nuevo
    @PostMapping
    public Libro agregarLibro(@RequestBody Libro libro){
        return libroRepository.save(libro);
    }

    @PutMapping("/prestar/{id}")
    public String prestarLibro (@PathVariable Long id){
        return libroRepository.findById(id).map(libro -> {
            if (libro.getStock() > 0){
                libro.setStock(libro.getStock() -1); //descontar Stock
                libroRepository.save(libro);
                return "Libro prestado: " + libro.getTitulo() + ". Stock restante: " + libro.getStock();
            }else {
                return "No hay unidades disponibles para: " + libro.getTitulo();
            }
        }).orElse("Libro no encontrado con ID: " + id);
    }
}
