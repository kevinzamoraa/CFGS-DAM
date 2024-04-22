/* Activar la posibilidad de mostrar datos por pantalla */
SET SERVEROUTPUT ON;

/* Ej.1 */
CREATE OR REPLACE TYPE Personal AS OBJECT (
    codigo INTEGER,
    dni VARCHAR2(10),
    nombre VARCHAR2(30),
    apellidos VARCHAR2(30),
    sexo VARCHAR2(1),
    fecha_nac DATE
) NOT FINAL;
/

CREATE OR REPLACE TYPE Responsable UNDER Personal (
    /* Declaración de los atributos */
    tipo  CHAR,
    antiguedad INTEGER,

    /* Declaración de los métodos */
    /* Ej. 2 */
    CONSTRUCTOR FUNCTION Responsable(codigo INTEGER, nombre VARCHAR2, 
        primer_apellido VARCHAR2, segundo_apellido VARCHAR2, tipo CHAR)
        RETURN SELF AS RESULT,
    /* Ej. 3 */
    VARCHAR PROCEDURE getNombreCompleto(codigoInt INTEGER),
    /* apellidos = primer_apellido + ' ' + segundo_apellido */
    /* Desconozco como realizar dicha operación y pasarla como nuevo parámetro */
);
/

/* Cuerpo del tipo de objeto Responsable */
CREATE OR REPLACE TYPE BODY Responsable AS
    /* Implementación del método constructor */
    /* Ej. 2 */
    CONSTRUCTOR FUNCTION Responsable(codigo INTEGER, nombre VARCHAR2, 
        primer_apellido VARCHAR2, segundo_apellido VARCHAR2, tipo CHAR)
        RETURN SELF AS RESULT IS
        BEGIN
            SELF.apellidos = CONCAT (primer_apellido, segundo_apellido);
        END;
    
    /* Implementación de los métodos referente a Responsable */
    /* Ej. 3 */
    VARCHAR PROCEDURE getNombreCompleto (codigoInt) IS
    BEGIN
        SELF.nombre := nombre;
        SELF.apellidos := apellidos;
        nombreCompleto = CONCAT (apellidos, nombre);
        RETURN nombreCompleto;
    END getNombreCompleto;
    
END;
/

/* Ej.1 */
CREATE TYPE Zonas (
    /* Declaración de parámetros */
    codigo INTEGER, 
    nombre VARCHAR2(20), 
    refRespon REF Responsable, 
    codigoPostal CHAR(5),
    
    /* eJ. 9 */
    /* Declaración de métodos */
    MAP Zonas FUNCTION ordenarZonas RETURN VARCHAR2
);
/
/* Ej. 1 */
CREATE TYPE zonaComercial;
CREATE TYPE Comercial UNDER Personal (
    zonaComercial Zonas
);

/* Ej. 3 */
CREATE FUNCTION getNombreCompleto(codigo1 INTEGER) RETURN NUMBER;
BEGIN
    SELECT apellidos, nombre INTO nombreCompleto FROM Responsable WHERE codigo = codigo1;
    RETURN nombreCompleto;
END;
/

/* Ej.4 */
CREATE TYPE TablaResponsables;
DECLARE
    TYPE TablaResponsables IS TABLE OF Responsable;
    r1 Responsable;
    r2 Responsable;
BEGIN
    r1 := NEW Responsable(5, 51083099F, 'ELENA', 'POSTA LLANOS', 'F', '31/03/1975', 'N', 4);
    r2 := NEW Responsable(6, null , 'JAVIER', 'JARAMILLO HERNANDEZ', null , null , 'C', null);
    INSERT INTO TablaResponsables VALUES (r1);
    INSERT INTO TablaResponsables VALUES (r2);
END;
SELECT * FROM TablaResponsables;

/* Ej. 5 */
CREATE TYPE listaZonas;
DECLARE
    TYPE listaZonas IS TABLE OF Zonas;
BEGIN
END;
CREATE TYPE listaZonas1;
DECLARE
    TYPE listaZonas1 IS TABLE OF Zonas;
    zona1 Zonas;
    zona2 Zonas;
BEGIN
    zona1 := NEW Zonas(1, 'zona 1', 'Referencia al responsable cuyo código es 6', 06834);
    zona2 := NEW Zonas(2, 'zona 2', 'Referencia al responsable cuyo DNI es 51083099F', 28003 );
    INSERT INTO listaZonas1 VALUES (zona1);
    INSERT INTO listaZonas1 VALUES (zona2);
END;
SELECT * FROM listaZonas1;

/* Ej. 6 */
CREATE TYPE TablaComerciales;
DECLARE
    TYPE TablaComerciales IS TABLE OF Comercial;
    c1 Comercial;
    c2 Comercial;
    unComercial Comercial;
BEGIN
    c1 := NEW Comercial(100, '23401092Z', 'MARCOS', 'SUAREZ LOPEZ', 'M', '30/3/1990', zonaComercial);
    c2 := NEW Comercial(102, '69322BBV', 'ANASTASIA', 'GOMES PEREZ', 'F', '28/11/1984', zonaComercial);
    INSERT INTO TablaComerciales VALUES (c1);
    INSERT INTO TablaComerciales VALUES (c2);
    
    /* Ej. 7 */
    INSERT INTO unComercial VALUES (SELECT * INTO unComercial FROM TablaComerciales WHERE codigo = 100);
    
    /* Ej. 8 */
    UPDATE unComercial
        SET unUsuario.codigo = 101
        WHERE unUsuario.codigo = 100;
END;
SELECT * FROM TablaComerciales;

/* Ej 9 */

/* Cuerpo del tipo de objeto Zonas */
CREATE OR REPLACE TYPE BODY Zonas AS
    
    MAP Zonas FUNCTION ordenarZonas (VARCHAR zonaInt) RETURN VARCHAR2 IS
    BEGIN
        responsableSelec = SELECT * FROM Responsable WHERE zona := zonaInt;
        RETURN ( responsableSelec.getNombreCompleto() );
    END ordenarZonas;
    
END;
/

/* Ej. 10 */

/* Disculpa no haber podido completar mejor los ejercicios realizados pero, 
mi mente funciona como buenamente puede, nunca había tocado la BBDD de Oracle 
y no he resultado capaz de lograr que funcionen completamente. Sin otro particular, 
agradecería que pudieras explicarme brevemente cómo se debería realizar */