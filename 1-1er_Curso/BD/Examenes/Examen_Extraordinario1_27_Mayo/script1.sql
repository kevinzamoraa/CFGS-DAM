CREATE OR REPLACE TYPE alumno AS OBJECT (
    cod_alumno VARCHAR2(8),
    contrasenya VARCHAR2(15),
    nombre VARCHAR2(20),
    apellidos VARCHAR2(30),
    fecha_nacimiento DATE,
    direccion VARCHAR2(50),
    ciudad VARCHAR2(30),
    cp INT(11),
    provincia VARCHAR2(20),
    email VARCHAR2(50),
    num_telefono VARCHAR2(15),
    semestre INT(11),
    cod_plan VARCHAR2(15)
);
/

CREATE OR REPLACE TYPE docente AS OBJECT (
    cod_docente VARCHAR2(8),
    contrasenya VARCHAR2(15),
    nombre VARCHAR2(20),
    apellidos VARCHAR2(30),
    direccion VARCHAR2(50),
    ciudad VARCHAR2(30),
    cp INT(11),
    provincia VARCHAR2(20),
    nivel_academico VARCHAR2(20),
    cod_departamento INT(11)
);
/

CREATE OR REPLACE TYPE carrera AS OBJECT (
    cod_carrera INT(11),
    nombre_carrera VARCHAR2(20),
    especialidad VARCHAR2(20)
);
/

CREATE OR REPLACE TYPE plan AS OBJECT (
    cod_plan VARCHAR2(15),
    descripcion VARCHAR2(30),
    cod_carrera INT(11)
);
/

CREATE OR REPLACE TYPE grupo AS OBJECT (
    cod_grupo VARCHAR2(4),
    cod_materia VARCHAR2(4),
    cod_docente VARCHAR2(8),
    periodo VARCHAR2(50),
    ANYO YEAR(4)
);
/

CREATE OR REPLACE TYPE materia AS OBJECT (
    cod_materia VARCHAR2(8),
    nombre VARCHAR2(25),
    creditos INT(11),
    coste FLOAT
);
/

CREATE OR REPLACE  TYPE departamento AS OBJECT (
    cod_departamento INT(11),
    nombre_departamento VARCHAR2(20),
    area VARCHAR2(20)
);
/

CREATE OR REPLACE TYPE coordinador AS OBJECT (
    cod_coordinador VARCHAR2(8),
    contrasenya VARCHAR2(15),
    nombre VARCHAR2(20),
    apellidos VARCHAR2(30),
    fecha_nacimiento DATE,
    direccion VARCHAR2(50),
    ciudad VARCHAR2(30),
    cp INT(11),
    provincia VARCHAR2(20),
    nivel_academico VARCHAR2(20)
);
/

-- DECLARE
   -- cod_alumno VARCHAR2(8),
   -- cod_grupo VARCHAR2(4),
   -- cod_materia VARCHAR2(4),
   -- estado VARCHAR2(30),
   -- nota FLOAT (2,2)
-- BEGIN
    
-- END;
-- /

CREATE TABLE materias OF materia;
CREATE TABLE alumnos OF alumno;
CREATE TABLE docentes OF docente;
DECLARE
    materias materia;
    alumnos alumno;
    docentes docente;
BEGIN
        INSERT INTO materias VALUES (1, 'Matemáticas', 6, 150);
        INSERT INTO materias VALUES (2, 'Historia', 6, 150);
        INSERT INTO materias VALUES (3, 'Física', 6, 150);
        
        INSERT INTO alumnos VALUES (1, '1234A', 'Alumno1', 'A B', 2006/10/1, 'Calle 1', 
        'Vinaros', 12500, 'Castellón', 'a@a.es', 123456789, 1, '123456789');
        INSERT INTO alumnos VALUES (2, '1234B', 'Alumno2', 'A B', 2006/10/1, 'Calle 1', 
        'Vinaros', 12500, 'Castellón', 'a@a.es', 123456789, 1, '123456789');
        
        INSERT INTO docentes VALUES (1, '1234A', 'Docente1', 'A B', 'Calle 1', 
        'Vinaros', 12500, 'Castellón', 'grado universitario', 1);
END;
/

SELECT * FROM alumnos WHERE plan = 'Informática Plan 2010';


