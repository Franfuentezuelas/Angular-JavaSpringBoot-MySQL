# Proyecto Angular-JavaSpringBoot-MySQL

Este proyecto consiste en la integración de tres contenedores Docker que incluyen el frontend desarrollado en Angular, el backend desarrollado con Java Spring Boot, y la base de datos MySQL. A través de Docker Compose, estos contenedores se comunican entre sí para formar un sistema completo y funcional de la aplicación web.

## Estructura del proyecto

El proyecto está organizado en las siguientes carpetas:

- **contenedorPrincipal**: En este contenedor se incluyen todas las carpetas del proyecto, además de un `docker-compose.yml` y el propio archivo `README.md` que realmente son los únicos archivos necesarios para probar el funcionamiento del proyecto, el resto de carpetas amplian la informacion del mismo y apartir de ellas se puede ampliar dicho proyecto.
- **Front**: Contiene el código fuente del frontend desarrollado en Angular junto con un archivo `Dockerfile` para crear su imagen Docker.
- **Back**: Contiene el código fuente del backend desarrollado con Java Spring Boot y un archivo `Dockerfile` para crear su imagen Docker.
- **BD**: Contiene la configuración de la base de datos MySQL, incluyendo un archivo `init.sql` para inicializar la base de datos con datos desde el principio y disponer siempre de datos, junto con un archivo `Dockerfile` para crear su imagen Docker.

## Creación de las imágenes Docker

Cada contenedor tiene un archivo `Dockerfile` con las instrucciones necesarias para crear su respectiva imagen Docker. Los comandos utilizados para crear las imágenes son los siguientes:

```bash
# Crear la imagen del backend
cd contenedorBack
docker build -t franfuentezuelas/java-springboot-mysql:v1.1 .

# Crear la imagen del frontend
cd ../contenedorAngular
docker build -t franfuentezuelas/contenedor-angular:v1 .

# Crear la imagen de la base de datos
cd ../contenedorMySQL
docker build -t franfuentezuelas/datos-mysql:v1 .
```

## Subida de las imágenes a Docker Hub

Una vez creadas las imágenes, se suben al repositorio de Docker Hub utilizando el siguiente comando:

```bash
# Subir la imagen del backend
docker push franfuentezuelas/java-springboot-mysql:v1.1

# Subir la imagen del frontend
docker push franfuentezuelas/contenedor-angular:v1

# Subir la imagen de la base de datos
docker push franfuentezuelas/datos-mysql:v1
```

## Configuración con Docker Compose

El archivo `docker-compose.yml` se utiliza para unir los tres contenedores y configurar las redes necesarias para su comunicación entre los diferentes contenedores. Además, se tienen en cuenta las dependencias de los contenedores, ya que sin base de datos el contenedor backend no tiene acceso a información. Este archivo define:

- El contenedor del frontend que realiza peticiones a la API del backend.
- El contenedor del backend que consulta y procesa la información de la base de datos.
- El contenedor de la base de datos que contiene los datos iniciales cargados desde `init.sql`.

Para ejecutar el proyecto completo utilizando Docker Compose, basta con descargar el archivo `docker-compose.yml` y ejecutarlo con el siguiente comando:

```bash
docker-compose up
```

## Puertos expuestos

- **Frontend (Angular)**: Disponible en el puerto `4200`.
- **Backend (Java Spring Boot)**: Disponible en el puerto `9000`.
- **Base de datos (MySQL)**: Disponible en el puerto `3306`.

## Flujo de funcionamiento

1. **Frontend (Angular)**: Envía peticiones HTTP a la API del backend.
2. **Backend (Java Spring Boot)**: Recibe las peticiones del frontend, interactúa con la base de datos y devuelve las respuestas al frontend.
3. **Base de datos (MySQL)**: Proporciona la información inicial cargada desde `init.sql` para que el backend pueda procesarla.

## Requisitos previos

- Tener Docker y Docker Compose instalados en tu máquina.
- Descargar el archivo `docker-compose.yml` del repositorio del proyecto.

## Ejecución del proyecto

1. Descarga el archivo `docker-compose.yml`.
2. Asegúrate de tener acceso a las imágenes subidas a Docker Hub.
3. Ejecuta el siguiente comando:

   ```bash
   docker-compose up
   ```

4. Una vez cargados todos los contenedores, accede a las diferentes partes del proyecto:

   - **Frontend**: Disponible en [http://localhost:4200/](http://localhost:4200/).
   - **Backend**: 
     - Si accedemos a [http://localhost:9000](http://localhost:9000), se muestra la interfaz de mantenimiento de los datos almacenados en la base de datos.
     - Las rutas que comienzan con `alumnos/api` son peticiones a otro controlador para la API, por ejemplo:
       - Ver todos los datos almacenados en la base de datos: [http://localhost:9000/alumnos/api/all](http://localhost:9000/alumnos/api/all).
       - Ver un usuario específico por su ID: [http://localhost:9000/alumnos/api/5](http://localhost:9000/alumnos/api/5).
   - **Base de datos**: Aunque no es necesario acceder directamente, puedes usar el puerto `3306` si lo deseas.

En esta aplicación, la modificación de datos en la base de datos puede realizarse desde el backend.

---

¡Con esto, el proyecto estará funcionando y podrás visualizar la interacción entre los tres contenedores! 🚀
