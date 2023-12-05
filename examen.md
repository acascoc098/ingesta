# Ingesta de tareas batch

Desde el sistema de reservas de Viajes El Corte Gallego cada día nos pasan una tarea **batch** con las reservas que han hecho sus agentes comerciales para confirmarlas con nosotros (nosotros somos el tour operador Expedición Mórbida).

## Instrucciones

* Nos dan el esqueleto de la aplicación, es **obligatorio** usar este esqueleto MAVEN. 
* Hay que modificar el **pom.xml** para que incluya el driver de la base de datos
* Hay que usar la configuración que viene por defecto en el docker-compose que se da (ver carpeta stack) para que  conecte con la base de datos. **No se puede modificar el docker-compose.yml**. Atención con los datos que vienen en este archivo.
* Levanta los nuevos contenedores antes de comenzar a programar.
* La base de datos se llamará **reservas**, *NO SE ADMITIRÁ OTRO NOMBRE*.
* Si la base de datos no está creada, nuestro programa debe crearla.
* Si las tablas no están creadas, nuestro programa debe crearlas.
* **Sólo hay un main** todo lo tiene que hacer el mismo programa.
* Las tablas deben tener sus respectivas claves foráneas.
* Se puede elegir hacerlo con XML o con JSON, las dos opciones valen igual.
* Hacer los DAO necesarios para todas las entidades.
* Cada clase entidad en un archivo diferente, no se pueden poner todas en el mismo archivo.
* Hay que hacer una rutina de carga del JSON a MySQL que se ejecute desde maven (ya está configurado el pom.xml). Puedes probar como funciona ejecutando ***mvn exec:java***. Antes de meter los datos en la base de datos, si no existen, por ejemplo, algunos clientes, deberán ser introducidos previamente a la inserción, o bien modificar el DAO para que arregle, que si da una excepción que no está esa clave foránea, de de alta el cliente para poder seguir (como veremos que se puede hacer con herramientas ORM).

La **tarea batch** no es más que un JSON con este formato:

**Version JSON**

json
{
   "reservas": [
      {
         "cliente": {
            "id": 1,
            "nombre": "Juan Perez",
            "contacto": {
               "email": "juan.perez@email.com",
               "telefono": "+123456789"
            }
         },
         "reserva": {
            "alojamiento": {
               "id": 2,
               "tipo": "hotel",
               "nombre": "Hotel Ejemplo",
               "direccion": "Calle Principal 123, Ciudad",
               "telefono": "+987654321"
            },
            "entrada": "2023-01-01",
            "salida": "2023-01-05",
            "pension": "pension_completa"
         }
      },
      {
         "cliente": {
            "id": 2,
            "nombre": "Maria Rodriguez",
            "contacto": {
               "email": "maria.rodriguez@email.com",
               "telefono": "+987654321"
            }
         },
         "reserva": {
            "alojamiento": {
               "id": 3,
               "tipo": "hostal",
               "nombre": "Otro Hostal",
               "direccion": "Avenida Secundaria 456, Ciudad",
               "telefono": "+123456789"
            },
            "entrada": "2023-02-10",
            "salida": "2023-02-15",
            "pension": "media_pension"
         }
      },
      {
         "cliente": {
            "id": 3,
            "nombre": "Ana Gomez",
            "contacto": {
               "email": "ana.gomez@email.com",
               "telefono": "+555555555"
            }
         },
         "reserva": {
            "alojamiento": {
               "id": 4,
               "tipo": "piso_turistico",
               "nombre": "Piso Turistico Acogedor",
               "direccion": "Plaza Principal 789, Ciudad",
               "telefono": "+555555555"
            },
            "entrada": "2023-03-20",
            "salida": "2023-03-25",
            "pension": "sin_pension"
         }
      },
      {
         "cliente": {
            "id": 4,
            "nombre": "Carlos Martinez",
            "contacto": {
               "email": "carlos.martinez@email.com",
               "telefono": "+333333333"
            }
         },
         "reserva": {
            "alojamiento": {
               "id": 5,
               "tipo": "hotel",
               "nombre": "Nuevo Hotel",
               "direccion": "Calle Nueva 789, Ciudad",
               "telefono": "+111111111"
            },
            "entrada": "2023-04-10",
            "salida": "2023-04-15",
            "pension": "alojamiento_desayuno"
         }
      },
      {
         "cliente": {
            "id": 5,
            "nombre": "Elena Lopez",
            "contacto": {
               "email": "elena.lopez@email.com",
               "telefono": "+999999999"
            }
         },
         "reserva": {
            "alojamiento": {
               "id": 6,
               "tipo": "piso_turistico",
               "nombre": "Piso en el Centro",
               "direccion": "Calle Central 567, Ciudad",
               "telefono": "+444444444"
            },
            "entrada": "2023-05-15",
            "salida": "2023-05-20",
            "pension": "sin_pension"
         }
      },
      {
         "cliente": {
            "id": 6,
            "nombre": "Pedro Sanchez",
            "contacto": {
               "email": "pedro.sanchez@email.com",
               "telefono": "+777777777"
            }
         },
         "reserva": {
            "alojamiento": {
               "id": 7,
               "tipo": "hostal",
               "nombre": "Hostal Amistoso",
               "direccion": "Calle Amistad 789, Ciudad",
               "telefono": "+666666666"
            },
            "entrada": "2023-06-25",
            "salida": "2023-06-30",
            "pension": "media_pension"
         }
      }
   ]
}


**Version XML**

xml
<reservas>
    <cliente>
        <id>1</id>
        <nombre>Juan Perez</nombre>
        <contacto>
            <email>juan.perez@email.com</email>
            <telefono>+123456789</telefono>
        </contacto>
        <reserva>
            <alojamiento>
                <id>2</id>
                <tipo>hotel</tipo>
                <nombre>Hotel Ejemplo</nombre>
                <direccion>Calle Principal 123, Ciudad</direccion>
                <telefono>+987654321</telefono>
            </alojamiento>
            <entrada>2023-01-01</entrada>
            <salida>2023-01-05</salida>
            <pension>pension_completa</pension>
        </reserva>
    </cliente>
    <cliente>
        <id>2</id>
        <nombre>Maria Rodriguez</nombre>
        <contacto>
            <email>maria.rodriguez@email.com</email>
            <telefono>+987654321</telefono>
        </contacto>
        <reserva>
            <alojamiento>
                <id>3</id>
                <tipo>hostal</tipo>
                <nombre>Otro Hostal</nombre>
                <direccion>Avenida Secundaria 456, Ciudad</direccion>
                <telefono>+123456789</telefono>
            </alojamiento>
            <entrada>2023-02-10</entrada>
            <salida>2023-02-15</salida>
            <pension>media_pension</pension>
        </reserva>
    </cliente>
    <cliente>
        <id>3</id>
        <nombre>Ana Gomez</nombre>
        <contacto>
            <email>ana.gomez@email.com</email>
            <telefono>+555555555</telefono>
        </contacto>
        <reserva>
            <alojamiento>
                <id>4</id>
                <tipo>piso_turistico</tipo>
                <nombre>Piso Turistico Acogedor</nombre>
                <direccion>Plaza Principal 789, Ciudad</direccion>
                <telefono>+555555555</telefono>
            </alojamiento>
            <entrada>2023-03-20</entrada>
            <salida>2023-03-25</salida>
            <pension>sin_pension</pension>
        </reserva>
    </cliente>
    <cliente>
        <id>4</id>
        <nombre>Carlos Martinez</nombre>
        <contacto>
            <email>carlos.martinez@email.com</email>
            <telefono>+333333333</telefono>
        </contacto>
        <reserva>
            <alojamiento>
                <id>5</id>
                <tipo>hotel</tipo>
                <nombre>Nuevo Hotel</nombre>
                <direccion>Calle Nueva 789, Ciudad</direccion>
                <telefono>+111111111</telefono>
            </alojamiento>
            <entrada>2023-04-10</entrada>
            <salida>2023-04-15</salida>
            <pension>alojamiento_desayuno</pension>
        </reserva>
    </cliente>
    <cliente>
        <id>5</id>
        <nombre>Elena Lopez</nombre>
        <contacto>
            <email>elena.lopez@email.com</email>
            <telefono>+999999999</telefono>
        </contacto>
        <reserva>
            <alojamiento>
                <id>6</id>
                <tipo>piso_turistico</tipo>
                <nombre>Piso en el Centro</nombre>
                <direccion>Calle Central 567, Ciudad</direccion>
                <telefono>+444444444</telefono>
            </alojamiento>
            <entrada>2023-05-15</entrada>
            <salida>2023-05-20</salida>
            <pension>sin_pension</pension>
        </reserva>
    </cliente>
    <cliente>
        <id>6</id>
        <nombre>Pedro Sanchez</nombre>
        <contacto>
            <email>pedro.sanchez@email.com</email>
            <telefono>+777777777</telefono>
        </contacto>
        <reserva>
            <alojamiento>
                <id>7</id>
                <tipo>hostal</tipo>
                <nombre>Hostal Amistoso</nombre>
                <direccion>Calle Amistad 789, Ciudad</direccion>
                <telefono>+666666666</telefono>
            </alojamiento>
            <entrada>2023-06-25</entrada>
            <salida>2023-06-30</salida>
            <pension>media_pension</pension>
        </reserva>
    </cliente>
</reservas>


Hay que implementar lo siguiente:

1) Nos piden que hagamos un programa que introduzca este JSON en la base de datos. Deberás crear, desde Java, las tablas si no existen, y además crear los clientes y otras tablas necesarias antes de las reservas.
2) Crea un disparador (o impleméntalo en JAVA) que impida que una misma persona haga reservas para fechas que ya tiene otra reserva anterior.

Puedes probar si el punto 2 funciona con esta nueva tarea batch:

**Versión JSON**:

json
{
   "reservas": [
      {
         "cliente": {
            "id": 5,
            "nombre": "Elena Lopez",
            "contacto": {
               "email": "elena.lopez@email.com",
               "telefono": "+999999999"
            }
         },
         "reserva": {
            "alojamiento": {
               "id": 8,
               "tipo": "hostal",
               "nombre": "Otro Hostal",
               "direccion": "Avenida Secundaria 456, Ciudad",
               "telefono": "+123456789"
            },
            "entrada": "2023-05-16",
            "salida": "2023-05-19",
            "pension": "media_pension"
         }
      },
      {
         "cliente": {
            "id": 6,
            "nombre": "Pedro Sanchez",
            "contacto": {
               "email": "pedro.sanchez@email.com",
               "telefono": "+777777777"
            }
         },
         "reserva": {
            "alojamiento": {
               "id": 7,
               "tipo": "hostal",
               "nombre": "Hostal Amistoso",
               "direccion": "Calle Amistad 789, Ciudad",
               "telefono": "+666666666"
            },
            "entrada": "2023-06-25",
            "salida": "2023-06-30",
            "pension": "media_pension"
         }
      }
   ]
}




**Version XML**:

xml
<reservas>
    <cliente>
        <id>5</id>
        <nombre>Elena Lopez</nombre>
        <contacto>
            <email>elena.lopez@email.com</email>
            <telefono>+999999999</telefono>
        </contacto>
        <reserva>
			<alojamiento>
                <id>8</id>
                <tipo>hostal</tipo>
                <nombre>Otro Hostal</nombre>
                <direccion>Avenida Secundaria 456, Ciudad</direccion>
                <telefono>+123456789</telefono>
            </alojamiento>
            <entrada>2023-05-16</entrada>
            <salida>2023-05-19</salida>
            <pension>media_pension</pension>        
        </reserva>
    </cliente>
    <cliente>
        <id>6</id>
        <nombre>Pedro Sanchez</nombre>
        <contacto>
            <email>pedro.sanchez@email.com</email>
            <telefono>+777777777</telefono>
        </contacto>
        <reserva>
            <alojamiento>
                <id>9</id>
                <tipo>hostal</tipo>
                <nombre>Hostal Amistoso</nombre>
                <direccion>Calle Amistad 789, Ciudad</direccion>
                <telefono>+666666666</telefono>
            </alojamiento>
            <entrada>2023-06-25</entrada>
            <salida>2023-06-30</salida>
            <pension>media_pension</pension>
        </reserva>
    </cliente>
</reservas>

