--Borramos y creamos la database, solo lo hacemos una vez
DROP DATABASE IF EXISTS reservas;
CREATE DATABASE reservas;

use reservas;

--Borramos la tablas existentes y creamos, cada vez que modifiquemos la base
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