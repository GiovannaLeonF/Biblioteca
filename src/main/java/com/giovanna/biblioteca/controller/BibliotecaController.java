package com.giovanna.biblioteca.controller;
import com.giovanna.biblioteca.model.Libro;
import com.giovanna.biblioteca.repository.LibroRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libros") //Todos los endpoints empiezan con /Libros
@Tag(name = "Biblioteca", description = "Gestión de libros y préstamos")
public class BibliotecaController {

    private final LibroRepository libroRepository;

    public BibliotecaController(LibroRepository libroRepository){
        this.libroRepository = libroRepository;
    }
    @Operation(summary = "Listar todos los libros")
    @GetMapping
    public List<Libro> listraLibro(){
        return libroRepository.findAll();
    }
    //Agregar libro nuevo
    @Operation(summary = "Agregar un nuevo libro")
    @PostMapping
    public Libro agregarLibro(@RequestBody Libro libro){
        return libroRepository.save(libro);
    }

    @Operation(summary = "Prestar un libro")
    @PutMapping("/prestar/{id}")
    public ResponseEntity<String> prestarLibro (@PathVariable Long id){
        return libroRepository.findById(id).map(libro -> {
            if (libro.getStock() > 0){
                libro.setStock(libro.getStock() -1); //descontar Stock
                libroRepository.save(libro);
                return ResponseEntity.ok( "Libro prestado: " + libro.getTitulo() + ". Stock restante: " + libro.getStock()
                );
            }else {
                return ResponseEntity.badRequest().body("No hay unidades disponibles para: " + libro.getTitulo()
                );
            }
        }).orElseGet(() ->
                ResponseEntity.status(404).body("Libro no encontrado"));
    }
}
