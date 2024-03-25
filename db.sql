CREATE DATABASE reto_tecnico;

USE reto_tecnico;

CREATE TABLE usuarios(
	id INT NOT NULL PRIMARY KEY,
    nombres VARCHAR(50) NOT NULL,
    correo VARCHAR(50) NOT NULL
);


CREATE TABLE compras(
	id INT NOT NULL PRIMARY KEY,
    cantidad INT NOT NULL,
    id_usuario INT NOT NULL,
    id_producto INT NOT NULL
);

CREATE TABLE productos(
	id INT PRIMARY KEY NOT NULL,
    nombre VARCHAR(25) NOT NULL,
    descripcion VARCHAR(50),
    precio DOUBLE NOT NULL,
    categoria INT NOT NULL
);

SELECT * FROM productos;


CREATE TABLE categorias(
	id INT PRIMARY KEY NOT NULL,
    descripcion VARCHAR(25) NOT NULL
);


INSERT INTO categorias VALUE (1, "Frutas");
INSERT INTO categorias VALUE (2, "Verduras");
INSERT INTO categorias VALUE (3, "Conservas");
INSERT INTO categorias VALUE (4, "Carnes");


