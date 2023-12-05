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
DROP TABLE IF EXISTS cliente;
DROP TABLE IF EXISTS contacto;

CREATE TABLE alojamiento(
    id INT AUTO_INCREMENT PRIMARY KEY,
    tipo VARCHAR(20),
    nombre VARCHAR(25),
    direccion VARCHAR(25),
    telefono VARCHAR(20)
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
    telefono VARCHAR(20)
);

CREATE TABLE cliente(
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(25) UNIQUE, 
    contacto VARCHAR(25), 
    reserva INT,
    FOREIGN KEY (contacto) REFERENCES contacto(email)
);
```

## ENTIDADES/MODELOS

Para cada tabla crearemos una clase en java:

#### Alojamiento.java

La clase alojamiento según su tabla vemos que tiene los siguientes atributos:

```java
public class Alojamiento {
    private int id;
    private String tipo;
    private String nombre;
    private String direccion;
    private int telefono;
    
    //Creamos su constructor
    public Alojamiento(int id, String tipo, String nombre, String direccion, int telefono) {
        this.id = id;
        this.tipo = tipo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    //Creamos sus getter y setter de cada atributo
    ...

    //Métodos toString(), equals() y hasCode()
    ...
}
```

#### Reserva.java

La clase reserva según su tabla vemos que tiene los siguientes atributos:

```java
public class Reserva {
    private Alojamiento alojamiento;
    private LocalDate entrada;
    private LocalDate salida;
    private String pension;

    //Creamos constructor
    public Reserva(Alojamiento alojamiento, LocalDate entrada, LocalDate salida, String pension) {
        this.alojamiento = alojamiento;
        this.entrada = entrada;
        this.salida = salida;
        this.pension = pension;
    }

    //Creamos sus getter y setter de cada atributo
    ...

    //Métodos toString(), equals() y hasCode()
    ...
}
```

#### Contacto.java

La clase contacto según su tabla vemos que tiene los siguientes atributos:

```java
public class Contacto {
    private String email;
    private int telefono;

    //Creamos el constructor
    public Contacto(String email, int telefono) {
        this.email = email;
        this.telefono = telefono;
    }

    //Creamos sus getter y setter de cada atributo
    ...

    //Métodos toString(), equals() y hasCode()
    ...
}
```

#### Cliente.java

La clase cliente según su tabla vemos que tiene los siguientes atributos:

```java
public class Cliente {
    private int id;
    private String nombre;
    private Contacto contact;
    private Reserva reserva;

    //Creamos su constructor
    public Cliente(int id, String nombre, Contacto contact, Reserva reserva) {
        this.id = id;
        this.nombre = nombre;
        this.contact = contact;
        this.reserva = reserva;
    }

    //Creamos sus getter y setter de cada atributo
    ...

    //Métodos toString(), equals() y hasCode()
    ...
}
```

## HACEMOS LOS DAO

¡¡Todos estos están comentados dentro de la clase!!

#### Alojamiento.java


```java
public interface AlojamientoDAO {
    public Alojamiento create(Alojamiento Alojamiento) throws ExcDAO;

    public List<Alojamiento> findAll() throws ExcDAO;
    
    public Alojamiento findById(int id) throws ExcDAO;
    
    public Alojamiento update(int idOldAlojamiento, Alojamiento newAlojamiento) throws ExcDAO;
    public Alojamiento update(Alojamiento OldAlojamientoe, Alojamiento newAlojamiento) throws ExcDAO;
    
    public Alojamiento delete(int idAlojamiento) throws ExcDAO;    
    public Alojamiento delete(Alojamiento alojamiento) throws ExcDAO;
}

```

#### Reserva.java

La clase reserva según su tabla vemos que tiene los siguientes atributos:

```java
public interface ReservaDAO {
    
    public Reserva create(Reserva Reserva) throws ExcDAO;

    
    public List<Reserva> findAll() throws ExcDAO;
    
    
    public Reserva findById(int id) throws ExcDAO;
    
    
    public Reserva update(int idOldReserva, Reserva newReserva) throws ExcDAO;
    public Reserva update(Reserva oldReserva, Reserva newReserva) throws ExcDAO;
    
    
    public Reserva delete(int idReserva) throws ExcDAO;    
    public Reserva delete(Reserva Reserva) throws ExcDAO;

    
    public List<Reserva> findByAlojamiento(Alojamiento alojamiento) throws ExcDAO;
}
```

#### Contacto.java

La clase contacto según su tabla vemos que tiene los siguientes atributos:

```java
public interface ContactoDAO {
    
    public Contacto create(Contacto contacto) throws ExcDAO;

    
    public List<Contacto> findAll() throws ExcDAO;
    
    
    public Contacto findById(int id) throws ExcDAO;
    
    public Contacto update(int idOldContacto, Contacto newContacto) throws ExcDAO;
    public Contacto update(Contacto OldContacto, Contacto newContacto) throws ExcDAO;
    
    
    public Contacto delete(int idContacto) throws ExcDAO;    
    public Contacto delete(Contacto Contacto) throws ExcDAO;
}
```

#### Cliente.java

La clase cliente según su tabla vemos que tiene los siguientes atributos:

```java
public interface ClienteDAO {
    
    public Cliente create(Cliente cliente) throws ExcDAO;

    
    public List<Cliente> findAll() throws ExcDAO;
    
    
    public Cliente findById(int id) throws ExcDAO;
    
    
    public Cliente update(int idOldCliente, Cliente newCliente) throws ExcDAO;
    public Cliente update(Cliente OldCliente, Cliente newCliente) throws ExcDAO;
    
    
    
    public Cliente delete(int idCliente) throws ExcDAO;

    
    public Cliente delete(Cliente Cliente) throws ExcDAO;

    
    public List<Cliente> findByReserva(Reserva reserva) throws ExcDAO;
}
```