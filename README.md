BIBLIOTECA - PROYECTO SPRING BOOT

## Descripción
Este proyecto es una **aplicación de gestión de biblioteca** desarrollada con **Spring Boot**, que permite agregar libros, listar los existentes y prestar libros, controlando el stock disponible. Ideal para aprender y demostrar conocimientos de **Java, Spring Boot, JPA y H2 Database**.

---

## Tecnologías utilizadas
- Java 21
- Spring Boot
- Spring Data JPA
- H2 Database (en memoria)
- Maven
- IntelliJ IDEA

---

## Funcionalidades
1. **Agregar libros** a la biblioteca (POST `/Libros`)  
2. **Listar libros** existentes (GET `/Libros`)  
3. **Prestar libros** descontando stock (POST `/Libros/Prestar/{id}`)  

---

## Estructura del proyecto

src/
└─ main/
└─ java/
└─ com.giovanna.biblioteca/
├─ BibliotecaApplication.java # Clase principal Spring Boot
├─ controller/
│ └─ BibliotecaController.java # Endpoints REST
├─ model/
│ └─ Libro.java # Entidad Libro
└─ repository/
└─ LibroRepository.java # Interfaz JPA


---

## Cómo ejecutar el proyecto

1. Clonar el repositorio:
```bash
git clone https://github.com/GiovannaLeonF/biblioteca.git
cd biblioteca
```

2. Ejecutar la aplicación desde IntelliJ IDEA o por terminal:
mvn spring-boot:run

3. Acceder a la API en: http://localhost:8080/Libros

4. Probar los endpoints con Postman o tu cliente HTTP favorito.
Endpoints de ejemplo

- Agregar libro (POST /Libros)
```json
{
    "titulo": "El Principito",
    "autor": "Antoine de Saint-Exupéry",
    "stock": 3
}
```

- Listar libros (GET /Libros)
- Prestar libro (POST /Libros/Prestar/1)

Autor
Giovanna Luisa León Fuentes

Repositorio de práctica y proyecto demostrativo de Spring Boot para nivel junior.
