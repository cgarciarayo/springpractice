# Práctica Spring Boot - Servicios REST

En esta práctica he desarrollado una pequeña aplicación utilizando **Spring Boot** para practicar la creación de servicios REST.

El objetivo principal ha sido aprender cómo funcionan los métodos **GET, POST y PUT**, cómo enviar y recibir datos desde el cliente y cómo trabajar con objetos Java dentro de una aplicación Spring.

---

## Tecnologías utilizadas

Para realizar esta práctica he utilizado:

- Java  
- Spring Boot  
- Maven  
- IntelliJ IDEA  
- Postman  
- Git y GitHub  

---

## Estructura del proyecto

He organizado el proyecto separando las clases en distintos paquetes para que el código esté más ordenado y sea más fácil de entender.

src/main/java/com/example/springpractice

beans  
  Person.java  
  Persons.java  

controllers  
  PersonController.java  

SpringpracticeApplication.java

- **beans** → Aquí defino las clases que representan los datos de la aplicación.  
- **controllers** → Aquí implemento los servicios REST.  
- **SpringpracticeApplication** → Clase principal que inicia la aplicación Spring Boot.

---

## Ejercicios realizados

### Ejercicio 1 - Servicio GET

En este ejercicio implemento un endpoint de tipo **GET** que devuelve los datos de una persona en formato JSON.

Endpoint:

GET /person

El objeto `Person` contiene los siguientes datos:

- Nombre  
- Primer apellido  
- Segundo apellido  
- Nombre completo  
- Fecha de nacimiento  
- Sexo  

---

### Ejercicio 2 - Servicio POST

En este ejercicio implemento un servicio **POST** que recibe datos enviados desde el cliente.

Endpoint:

POST /envioFormulario

Parámetros recibidos:

- nombre  
- apellido1  
- apellido2  
- fechaNacimiento  
- sexo  

Cuando recibo los datos:

1. Creo un objeto `Person`.  
2. Guardo los datos en memoria.  
3. Muestro la información recibida en la consola de la aplicación.

---

### Ejercicio 3 - Servicios GET y PUT

En este ejercicio trabajo con una **lista de personas almacenadas en memoria**.

Para ello creo un bean `Persons` que contiene una lista de objetos `Person`.  
Cuando se inicia la aplicación se cargan **10 personas ficticias**.

#### Buscar persona por DNI

Endpoint:

GET /personByDni?dni=XXXXXXXX

Este servicio devuelve los datos de la persona cuyo DNI coincide con el enviado.

---

#### Modificar persona por DNI

Endpoint:

PUT /personByDni?dni=XXXXXXXX

En este caso recibo un objeto `Person` mediante **@RequestBody** con los nuevos datos.

Después actualizo la persona correspondiente dentro de la lista.

Finalmente vuelvo a hacer una petición **GET** para comprobar que los datos se han modificado correctamente.

---

## Pruebas realizadas

Para comprobar que los endpoints funcionan correctamente he utilizado **Postman**, realizando diferentes peticiones:

- GET  
- POST  
- PUT  

También he revisado en la consola de la aplicación que los datos se reciban y se procesen correctamente.

---

## Ejecución del proyecto

Para ejecutar el proyecto:

1. Abrir el proyecto en IntelliJ IDEA  
2. Ejecutar la clase:

SpringpracticeApplication.java

3. La aplicación se inicia en:

http://localhost:8082

---
