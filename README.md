## Descripción del proyecto 📄
**ForoHub** es una API Rest diseñada para gestionar tópicos de discusión (preguntas o dudas sobre temas específicos) con funcionalidades CRUD completas. Los tópicos creados se almacenan en una base de datos MySQL, administrada mediante Flyway Migration para controlar las versiones y cambios en las consultas SQL.

Para interactuar con la API, se requiere una herramienta como **Postman** o **Insomnia Rest**, utilizando solicitudes HTTP como:
- **POST**: Crear un tópico.
- **GET**: Leer todos los tópicos o uno en específico.
- **PUT**: Actualizar un tópico.
- **DELETE**: Eliminar un tópico.

Todos los datos enviados y recibidos deben estar en formato JSON.

---

## Estado del proyecto
✅ **Proyecto completado.**

---

## Demostración de funcionalidades
### Funcionalidades del proyecto 🔧
1. **Registrar un tópico**  
   Registra un tópico en la base de datos con los siguientes campos:
   - Título
   - Mensaje
   - Fecha de creación
   - Estado
   - Autor
   - Curso  
   
   ⚠️ **Nota:** No se permiten registros duplicados (mismo título y mensaje).

2. **Listar todos los tópicos**  
   Devuelve un listado de todos los tópicos registrados en la base de datos.

3. **Listar un tópico específico**  
   Devuelve los datos de un único tópico, utilizando su `id` como parámetro en la URI.

4. **Actualizar un tópico**  
   Permite modificar uno o más campos de un tópico existente.  
   - Requiere enviar el `id` del tópico en el cuerpo de la solicitud.
   - Los datos no pueden ser nulos o vacíos.

5. **Eliminar un tópico**  
   Borra un tópico de la base de datos utilizando su `id` como parámetro en la URI.

6. **Conexión a la base de datos**  
   Toda la información se almacena en una base de datos MySQL.  
   ⚠️ **Nota:** Es necesario configurar el archivo `application.properties` para conectar correctamente la aplicación a tu base de datos. Modifica las siguientes variables:
   - `${DATASOURCE_URL}` → Formato: `jdbc:mysql://localhost:(puerto)/(nombre_base_datos)`
   - `${DATASOURCE_USERNAME}` → Por defecto es `root`, o el nombre configurado al instalar MySQL.
   - `${DATASOURCE_PASSWORD}` → Contraseña utilizada durante la instalación de MySQL.
   - `${JWT_SECRET}` → Contraseña utilizada para generar el token JWT.

7. **Respuestas con códigos HTTP**  
   La API devuelve los códigos HTTP correspondientes según la operación realizada:
   - 201: Recurso creado con éxito.
   - 404: Recurso no encontrado.
   - Otros códigos según el caso.

8. **Seguridad en operaciones CRUD**  
   Implementa **Spring Security**, asegurando que solo los usuarios autenticados puedan acceder a las funcionalidades CRUD.

9. **Inicio de sesión (Login)**  
   Permite iniciar sesión mediante un nombre de usuario y contraseña.  
   - Devuelve un token JWT para autenticar las operaciones CRUD.  
   ⚠️ **Nota:** Es necesario introducir manualmente la información del usuario en la base de datos antes de iniciar sesión.  
   Para generar una contraseña encriptada, utiliza esta herramienta: [Bcrypt Encrypt](https://www.browserling.com/tools/bcrypt).

---

## Tecnologías utilizadas 🔨
- **Java 17**
- **Spring Boot 3**
- **Maven**
- **Spring Web**
- **Spring Data JPA**
- **Spring Boot DevTools**
- **Lombok**
- **Flyway Migration**
- **Validation**
- **Spring Security**
- **Postman o Insomnia Rest** (para simular cliente)
- **MySQL Workbench**

