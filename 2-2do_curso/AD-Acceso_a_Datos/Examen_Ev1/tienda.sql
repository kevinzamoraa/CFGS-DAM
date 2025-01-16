CREATE DATABASE tienda;
USE tienda;

-- Tabla de usuarios
CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE
);

-- Tabla de pedidos
CREATE TABLE pedidos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT,
    producto VARCHAR(100) NOT NULL,
    cantidad INT NOT NULL,
    fecha DATE NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id) ON DELETE CASCADE
);

-- Insertar datos ficticios en la tabla de usuarios
INSERT INTO usuarios (nombre, email) VALUES
('Juan Pérez', 'juan.perez@example.com'),
('Ana Gómez', 'ana.gomez@example.com'),
('Luis Martínez', 'luis.martinez@example.com');

-- Insertar datos ficticios en la tabla de pedidos
INSERT INTO pedidos (usuario_id, producto, cantidad, fecha) VALUES
(1, 'Laptop', 1, '2025-01-01'),
(2, 'Mouse', 2, '2025-01-02'),
(3, 'Teclado', 1, '2025-01-03'),
(1, 'Monitor', 1, '2025-01-04');