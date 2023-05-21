
# Prueba técnica OHTIC

Antes de comenzar es importante tener instalado docker y docker-compose en el equipo ya que se necesitan para levantar la base de datos en el fichero docker-compose. Las instrucciones para la instalación se encuentran [aquí](https://docs.docker.com/compose/install/)

## Instrucciones de ejecución
Lo primero que tendremos que hacer será levantar la base de datos con el comando docker-compose utilizando el fichero incluido en el repositorio docker-compose.yml

Una vez levatada la base de datos podremos proceder a ejecutar el proyecto de springboot abriéndolo en un IDE como IntelliJ y ejecutando el método Main.

La version de Java utilizada ha sido la OpenJDK 20.

## Concepto y modo de uso
El proyecto presenta un sencillo sistema de votos para películas.

Los usuarios registran películas en la base de datos y estos a su vez también pueden poner notas a dichas películas.

La API presenta las operaciones CRUD típicas para atacar a las diferentes tablas de base de datos así como un par de endpoints para dar de alta a nuevos usuarios o registrarlos.

Para usar la aplicación es necesario acceder a la URL de [swagger](localhost:8080/swagger-ui/index.html) con la aplicación funcionando.
Una vez dentro deberemos o bién registrarnos si no lo habiamos hecho antes; o iniciar sensión con los enpoints destinados para ello.
La aplicación nos devolverá un token que pegaremos en el dialogo mostrado por el botón Authenticate para poder acceder al resto de las operaciones de la APIRest.

También se ha incluido una clase de testing para uno de los servicios de la aplicación.


