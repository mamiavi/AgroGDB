# AgroGDB
Proyecto final de carrera del estudiante de Ingeniería Geomática y Topografía Manuel Miñambres Vidal

-Para el uso de la palicación, será necesario instalar PostgreSQL y PGAdmin en el ordenadro que hará de servidor.
-Seguidamente, mediante el archivo AgroGDB.sql instalamos la base de datos en PGAdmin (Restore)
-Dentro de Android Studio, acudiremos a la clase de Java "ConexiónPSQL.java" y modificaremos la linea 21
-De dicha linea, modificaremos la IP y el puerto.
-La IP deberá ser la IP pública del servidor, mientras que el puerto será aquel en el que se instaló PostgreSQL (5432 por defecto)

Al tratarse de una prueba local, los móviles que hagan uso de la aplicación deberán estar conectados a la misma red local en la que se encuentre el servidor
En caso de disponer de un servidor abierto, no será necesario este último paso.
