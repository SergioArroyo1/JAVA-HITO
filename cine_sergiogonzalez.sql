CREATE DATABASE cine_sergiogonzalez;

USE cine_sergiogonzalez;

CREATE TABLE genero (
    id_genero VARCHAR(5) PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL
);

CREATE TABLE pelicula (
    id_pelicula VARCHAR(10) PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    director VARCHAR(100),
    ano INT,
    duracion INT,
    id_genero VARCHAR(5),
    FOREIGN KEY (id_genero) REFERENCES genero(id_genero)
);

INSERT INTO genero VALUES ('G1', 'Acción'), ('G2', 'Comedia');

INSERT INTO pelicula VALUES 
('P001', 'Inception', 'Christopher Nolan', 2010, 148, 'G1'),
('P002', 'The Hangover', 'Todd Phillips', 2009, 100, 'G2');

