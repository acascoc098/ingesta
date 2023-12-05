# Documentación

### POM

Para el pon he añadido las siguientes dependecnias:

```xml
    <dependency>
      <groupId>com.google.code.gson</groupId>
      <artifactId>gson</artifactId>
      <version>2.10.1</version>
    </dependency>
    <dependency>
      <groupId>mysql</groupId>
      <artifactId>mysql-connector-java</artifactId>
      <version>8.0.33</version>
    </dependency>
    <dependency>
      <groupId>org.codehaus.mojo</groupId>
      <artifactId>jaxb2-maven-plugin</artifactId>
      <version>2.5.0</version>
    </dependency>
    <dependency>
      <groupId>javax.xml.bind</groupId>
      <artifactId>jaxb-api</artifactId>
      <version>2.4.0-b180725.0427</version>
    </dependency>
    <dependency>
      <groupId>javax.activation</groupId>
      <artifactId>activation</artifactId>
      <version>1.1.1</version>
    </dependency>
```

### DOCKER
 Por otro lado, para levantar los contenedores usamos el documento ***docker-compose.yml***, lo que haremos será ir a la carpeta stack, donde está el fichero ***.yml***, y ejecutaremos el siguiente comando:

 ```
 docker-compose -f docker-compose.yml up -d
 ```

 Comprobamos que se han levantado bien poniéndolos en marcha y a través de: **localhost:8181** (OJO por si hay más contenedores con la misma dirección). Como la base de datos no está creada, ejecutamos el siguiente comando sql:

```sql
DROP DATABASE IF EXISTS reservas;
CREATE DATABASE reservas;
```

Y posteriormente creamos las tablas que, guiándome con el ***.xml***, serían las siguientes:

```sql
use reservas;

DROP TABLE IF EXISTS reserva;
DROP TABLE IF EXISTS alojamiento;
DROP TABLE IF EXISTS contacto;
DROP TABLE IF EXISTS cliente;

CREATE TABLE alojamiento(
    id INT AUTO_INCREMENT PRIMARY KEY,
    tipo VARCHAR(20),
    nombre VARCHAR(25),
    direccion VARCHAR(25),
    telefono INT CONSTRAINT telefono_restric_a CHECK (telefono > 600000000 ), CHECK (telefono< 999999999)
);

CREATE TABLE reserva(
    alojamiento INT PRIMARY KEY,
    entrada DATE,
    salida DATE,
    pension VARCHAR(20),
    FOREIGN KEY (alojamiento) REFERENCES alojamiento(id)
);

CREATE TABLE contacto(
    email VARCHAR(25) PRIMARY KEY,
    telefono INT CONSTRAINT telefono_restric_c CHECK (telefono > 600000000 ), CHECK (telefono< 999999999)
);

CREATE TABLE cliente(
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(25) UNIQUE, 
    contacto VARCHAR(25), 
    reserva INT,
    FOREIGN KEY (contacto) REFERENCES contacto(email)
);
```