-- 1. Crear la base de datos (si no existe)
CREATE DATABASE IF NOT EXISTS mi_app_db;

-- 2. Usar la base de datos recién creada
USE mi_app_db;

-- 3. Crear la tabla para las carreras académicas
CREATE TABLE carrera_academica (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(255) NOT NULL
);

-- 4. Crear la tabla para los usuarios
CREATE TABLE usuarios (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

-- 5. (Opcional) Insertar algunos datos de ejemplo para probar
INSERT INTO carrera_academica (nombre) VALUES ('Ingeniería de Software'), ('Administración de Empresas');
INSERT INTO usuarios (nombre, email, password) VALUES ('Admin User', 'admin@example.com', 'password123');

