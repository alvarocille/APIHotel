# API de Hoteles

Esta es una API para gestionar hoteles y habitaciones, permitiendo realizar operaciones CRUD sobre los datos. La API está construida usando SpringBoot, documentada con OpenAPI y dotada de seguridad con JWT.

## Características

- Autenticación de usuarios
- Buscar hoteles por localidad
- Buscar hoteles por categoría
- Agregar un nuevo hotel
- Buscar habitaciones por tamaño y precio
- Agregar una nueva habitación
- Eliminar una habitación por ID
- Modificar el estado de ocupación de una habitación

## Endpoints

| Método | Endpoint                           | Descripción                                            |
|--------|------------------------------------|--------------------------------------------------------|
| POST   | /authenticate                      | Autenticar usuarios y generar un token JWT             |
| GET    | /api/hoteles/localidad/{localidad} | Buscar hoteles por localidad                           |
| GET    | /api/hoteles/categoria/{categoria} | Buscar hoteles por categoría                           |
| POST   | /api/hoteles                       | Agregar un nuevo hotel                                 |
| GET    | /api/habitaciones/buscar           | Buscar habitaciones por tamaño y precio                |
| POST   | /api/habitaciones                  | Agregar una nueva habitación                           |
| DELETE | /api/habitaciones/{id}             | Eliminar una habitación por ID                         |
| PUT    | /api/habitaciones/{id}/estado      | Modificar estado de ocupación de una habitación por ID |
| GET    | /v3/api-docs                       | Obtener JSON de la documentación                       |

## Ejemplos de Uso

### Autenticar usuario y obtener token JWT
POST /authenticate
{
  "username": "usuario",
  "password": "contraseña"
}

### Buscar hoteles por localidad
GET /api/hoteles/localidad/{localidad}

### Buscar hoteles por categoría
GET /api/hoteles/categoria/{categoria}

### Agregar un nuevo hotel
POST /api/hoteles
{
  "name": "Hotel Ejemplo",
  "location": "Ciudad Ejemplo",
  "rating": 4.5
}

### Buscar habitaciones por tamaño y precio
GET /api/habitaciones/buscar?tamaño=20&precioMin=50&precioMax=200

### Agregar una nueva habitación
POST /api/habitaciones
{
  "number": 101,
  "size": 25,
  "price": 150,
  "occupied": false
}

### Eliminar una habitación por ID
DELETE /api/habitaciones/123456

### Modificar estado de ocupación de una habitación por ID
PUT /api/habitaciones/123456/estado
{
  "ocupada": true
}

### Acceder a documentación Swagger
GET /v3/api-docs
