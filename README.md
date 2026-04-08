# 📚 Biblioteca API - Sistema de Gestión de Libros

## 🚀 Descripción

API REST desarrollada con Spring Boot para la gestión de una biblioteca. Permite administrar libros, consultar el catálogo y gestionar préstamos con control de stock disponible.

El sistema implementa lógica de negocio para evitar préstamos cuando no hay disponibilidad, simulando un entorno real de gestión.

---

## 🛠️ Tecnologías utilizadas

- Java 21
- Spring Boot
- Spring Data JPA
- Base de datos H2 (en memoria)
- Maven

---

## ⚙️ Funcionalidades principales

- 📌 Alta de libros
- 📌 Listado de libros disponibles
- 📌 Gestión de préstamos
- 📌 Control automático de stock

---

## 📡 Endpoints

### ➕ Crear libro
`POST /libros`

```json
{
  "titulo": "El Principito",
  "autor": "Antoine de Saint-Exupéry",
  "stock": 3
}
```
📋 Listar libros

GET /libros

📚 Prestar libro

POST /libros/prestar/{id}
- Reduce el stock disponible
- Valida disponibilidad antes de realizar el préstamo
---
📑 Documentación de la API

Disponible con Swagger en:

http://localhost:8080/swagger-ui/index.html

---
## Estructura del proyecto
```text
src/main/java/com/giovanna/biblioteca
├── controller
├── model
├── repository
└── BibliotecaApplication.java
```
---

## Cómo ejecutar el proyecto
```bash
git clone https://github.com/GiovannaLeonF/Biblioteca.git
cd biblioteca
mvn spring-boot:run
```

Acceder a la API 
http://localhost:8080/libros

🧠 Conceptos aplicados

- Arquitectura REST
- Persistencia con JPA
- Separación en capas (Controller, Model, Repository)
- Lógica de negocio aplicada (control de stock)
- Documentación de API con Swagger

Autor
Giovanna Luisa León Fuentes
Backend Developer (Java | Spring Boot)
