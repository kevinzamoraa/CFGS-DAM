-- Crear base de datos
CREATE DATABASE IF NOT EXISTS biblioteca;
USE biblioteca;

-- Tabla libros
CREATE TABLE libros (
    id_libro INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    autor VARCHAR(255) NOT NULL,
    genero VARCHAR(50),
    anio_publicacion INT,
    disponible BOOLEAN DEFAULT TRUE
);

-- Tabla prestamos
CREATE TABLE prestamos (
    id_prestamo INT AUTO_INCREMENT PRIMARY KEY,
    id_libro INT NOT NULL,
    nombre_usuario VARCHAR(255) NOT NULL,
    fecha_prestamo DATE NOT NULL,
    fecha_devolucion DATE,
    FOREIGN KEY (id_libro) REFERENCES libros(id_libro) ON DELETE CASCADE
);

-- Insertar datos en libros
INSERT INTO libros (titulo, autor, genero, anio_publicacion, disponible) VALUES
('Cien años de soledad', 'Gabriel García Márquez', 'Novela', 1967, TRUE),
('1984', 'George Orwell', 'Ciencia Ficción', 1949, TRUE),
('Don Quijote de la Mancha', 'Miguel de Cervantes', 'Novela', 1605, TRUE),
('El Principito', 'Antoine de Saint-Exupéry', 'Fábula', 1943, TRUE),
('Harry Potter y la piedra filosofal', 'J.K. Rowling', 'Fantasía', 1997, TRUE),
('La Odisea', 'Homero', 'Épico', -800, TRUE),
('El Hobbit', 'J.R.R. Tolkien', 'Fantasía', 1937, TRUE),
('Crimen y Castigo', 'Fiódor Dostoyevski', 'Novela', 1866, TRUE),
('Orgullo y Prejuicio', 'Jane Austen', 'Romance', 1813, TRUE),
('Fahrenheit 451', 'Ray Bradbury', 'Ciencia Ficción', 1953, TRUE);

-- Insertar datos en prestamos
INSERT INTO prestamos (id_libro, nombre_usuario, fecha_prestamo, fecha_devolucion) VALUES
(1, 'Juan Pérez', '2024-01-01', NULL),
(2, 'María López', '2024-01-05', NULL),
(3, 'Carlos García', '2024-01-08', NULL),
(4, 'Ana Fernández', '2024-01-10', '2024-01-15'),
(5, 'Luis Sánchez', '2024-01-12', NULL),
(6, 'Sofía Martínez', '2024-01-15', '2024-01-20'),
(7, 'Daniel Gómez', '2024-01-18', NULL),
(8, 'Laura Ruiz', '2024-01-20', NULL),
(9, 'Diego Torres', '2024-01-22', NULL),
(10, 'Paula Herrera', '2024-01-25', NULL);
