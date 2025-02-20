-- Primero, borrar los tipos en el orden correcto para evitar dependencias
DROP TYPE VENTA FORCE;
DROP TYPE LINEA_VENTA_TABLA;
DROP TYPE LINEA_VENTA FORCE;
DROP TYPE PRODUCTO FORCE;
DROP TYPE CLIENTE FORCE;
DROP TYPE DIRECCION;
DROP TYPE TELEFONOS_VARRAY;

-- 1. Definir un tipo/TYPE varray de dimensión 3 para contener los teléfonos
-- Este tipo varray permite almacenar hasta 3 números de teléfono para cada cliente
CREATE OR REPLACE TYPE TELEFONOS_VARRAY AS VARRAY(3) OF VARCHAR2(15);

-- 2. Crear los tipos dirección, cliente, producto y línea de venta
-- Definición del tipo dirección que contendrá los datos de ubicación
CREATE OR REPLACE TYPE DIRECCION AS OBJECT (
    direccion VARCHAR2(50),
    poblacion VARCHAR2(50),
    codPostal NUMBER(5),
    provincia VARCHAR2(40)
);

-- Definición del tipo cliente que incluye todos sus datos personales y de contacto
CREATE OR REPLACE TYPE CLIENTE AS OBJECT (
    id NUMBER,
    nombre VARCHAR2(50),
    direccion DIRECCION,
    telefonos TELEFONOS_VARRAY,
    nif VARCHAR2(9)
);

-- 3. Definición del tipo producto con sus características básicas
CREATE OR REPLACE TYPE PRODUCTO AS OBJECT (
    id NUMBER,
    descripcion VARCHAR2(80),
    pvp NUMBER,
    stockActual NUMBER
);

-- 4. Definición del tipo línea de venta que relaciona productos con cantidades
CREATE OR REPLACE TYPE LINEA_VENTA AS OBJECT (
    idVenta NUMBER,
    numeroLinea NUMBER,
    producto REF PRODUCTO,
    cantidad NUMBER
);

-- 3. Crear un tipo tabla anidada para contener las líneas de una venta
-- Este tipo permite almacenar múltiples líneas de venta para cada venta
CREATE OR REPLACE TYPE LINEA_VENTA_TABLA AS TABLE OF LINEA_VENTA;

-- 4. Crear un tipo venta para los datos de las ventas
-- Este tipo incluye todas las propiedades necesarias para una venta completa
CREATE OR REPLACE TYPE VENTA AS OBJECT (
    id NUMBER,
    cliente REF CLIENTE,
    fechaVenta DATE,
    lineas LINEA_VENTA_TABLA,
    MEMBER FUNCTION total_venta RETURN NUMBER,
    MEMBER FUNCTION num_lineas RETURN NUMBER
);

-- 5. Crear el cuerpo/BODY del tipo VENTA
-- Implementación de las funciones miembro para calcular totales y contar líneas
CREATE OR REPLACE TYPE BODY VENTA AS
    MEMBER FUNCTION total_venta RETURN NUMBER IS
        total NUMBER := 0;
        linea LINEA_VENTA;
    BEGIN
        IF SELF.lineas IS NOT NULL THEN
            FOR i IN 1..SELF.lineas.COUNT LOOP
                linea := SELF.lineas(i);
                total := total + linea.cantidad * linea.producto.pvp;
            END LOOP;
        END IF;
        RETURN total;
    END total_venta;
    
    MEMBER FUNCTION num_lineas RETURN NUMBER IS
    BEGIN
        RETURN NVL(SELF.lineas.COUNT, 0);
    END num_lineas;
END;

-- 6. Crear las tablas objeto-relacional
-- Tabla para almacenar las direcciones --
CREATE TABLE DIRECCIONES_OBJ OF DIRECCION (
    direccion PRIMARY KEY
);
-- Tabla para almacenar los clientes con sus datos
CREATE TABLE CLIENTES_OBJ OF CLIENTE (
    id PRIMARY KEY,
    nif UNIQUE
);

-- Tabla para almacenar los productos disponibles
CREATE TABLE PRODUCTOS_OBJ OF PRODUCTO (
    id PRIMARY KEY
);

-- Tabla para almacenar las ventas realizadas
CREATE TABLE VENTAS_OBJ OF VENTA (
    id PRIMARY KEY
);

-- 7. Insertar dos clientes y cinco productos
-- Insertar datos de prueba
INSERT INTO DIRECCIONES_OBJ VALUES (
    DIRECCION('Calle Principal 1', 'Madrid', 28001, 'Madrid')
);
INSERT INTO DIRECCIONES_OBJ VALUES (
    DIRECCION('Avenida Central 2', 'Barcelona', 08002, 'Barcelona')
);

-- Insertar clientes
DECLARE
    dir_ref REF DIRECCION;
BEGIN
    SELECT REF(d) INTO dir_ref FROM DIRECCIONES_OBJ d WHERE d.direccion = 'Calle Principal 1';
    INSERT INTO CLIENTES_OBJ VALUES (
        CLIENTE(
            1,
            'Ana García',
            dir_ref,
            TELEFONOS_VARRAY('912345678', '913456789', '912345679'),
            '12345678A'
        )
    );
END;

DECLARE
    dir_ref REF DIRECCION;
BEGIN
    SELECT REF(d) INTO dir_ref FROM DIRECCIONES_OBJ d WHERE d.direccion = 'Avenida Central 2';
    INSERT INTO CLIENTES_OBJ VALUES (
        CLIENTE(
            2,
            'Carlos López',
            dir_ref,
            TELEFONOS_VARRAY('934567890', '935678901', '934567891'),
            '23456789B'
        )
    );
END;

-- Insertar productos
INSERT INTO PRODUCTOS_OBJ VALUES (
    PRODUCTO(1, 'Laptop XPS', 999.99, 10)
);
INSERT INTO PRODUCTOS_OBJ VALUES (
    PRODUCTO(2, 'Mouse Inalámbrico', 29.99, 50)
);
INSERT INTO PRODUCTOS_OBJ VALUES (
    PRODUCTO(3, 'Teclado Mecánico', 89.99, 20)
);
INSERT INTO PRODUCTOS_OBJ VALUES (
    PRODUCTO(4, 'Monitor 24"', 199.99, 15)
);
INSERT INTO PRODUCTOS_OBJ VALUES (
    PRODUCTO(5, 'Altavoces USB', 49.99, 30)
);

-- 8. Insertar la primera venta (IDVENTA 1) para el cliente 1
DECLARE
    c_ref REF CLIENTE;
BEGIN
    SELECT REF(c) INTO c_ref 
    FROM CLIENTES_OBJ c 
    WHERE c.id = 1;
    
    INSERT INTO VENTAS_OBJ VALUES (
        VENTA(
            1,
            c_ref,
            DATE '2025-02-15',
            LINEA_VENTA_TABLA()
        )
    );
END;

-- 9. Insertar dos líneas de venta para la venta 1
DECLARE
    v_venta VENTA;
    p1_ref REF PRODUCTO;
    p2_ref REF PRODUCTO;
BEGIN
    -- Obtener referencias
    SELECT REF(p) INTO p1_ref FROM PRODUCTOS_OBJ p WHERE p.id = 1;
    SELECT REF(p) INTO p2_ref FROM PRODUCTOS_OBJ p WHERE p.id = 2;
    
    -- Obtener la venta
    SELECT VALUE(v) INTO v_venta 
    FROM VENTAS_OBJ v 
    WHERE v.id = 1 FOR UPDATE;
    
    -- Añadir líneas de venta
    v_venta.lineas.EXTEND(2);
    v_venta.lineas(1) := LINEA_VENTA(1, 1, p1_ref, 1);
    v_venta.lineas(2) := LINEA_VENTA(1, 2, p2_ref, 2);
    
    -- Actualizar la venta
    UPDATE VENTAS_OBJ v SET v = v_venta WHERE v.id = 1;
END;

-- 10. Insertar la segunda venta (IDVENTA 2) para el cliente 1
DECLARE
    c_ref REF CLIENTE;
BEGIN
    SELECT REF(c) INTO c_ref 
    FROM CLIENTES_OBJ c 
    WHERE c.id = 1;
    
    INSERT INTO VENTAS_OBJ VALUES (
        VENTA(
            2,
            c_ref,
            DATE '2025-02-15',
            LINEA_VENTA_TABLA()
        )
    );
END;

-- 11. Insertar tres líneas de venta para la venta 2
DECLARE
    v_venta VENTA;
    p1_ref REF PRODUCTO;
    p4_ref REF PRODUCTO;
    p5_ref REF PRODUCTO;
BEGIN
    -- Obtener referencias
    SELECT REF(p) INTO p1_ref FROM PRODUCTOS_OBJ p WHERE p.id = 1;
    SELECT REF(p) INTO p4_ref FROM PRODUCTOS_OBJ p WHERE p.id = 4;
    SELECT REF(p) INTO p5_ref FROM PRODUCTOS_OBJ p WHERE p.id = 5;
    
    -- Obtener la venta
    SELECT VALUE(v) INTO v_venta 
    FROM VENTAS_OBJ v 
    WHERE v.id = 2 FOR UPDATE;
    
    -- Añadir líneas de venta
    v_venta.lineas.EXTEND(3);
    v_venta.lineas(1) := LINEA_VENTA(2, 1, p1_ref, 2);
    v_venta.lineas(2) := LINEA_VENTA(2, 2, p4_ref, 1);
    v_venta.lineas(3) := LINEA_VENTA(2, 3, p5_ref, 4);
    
    -- Actualizar la venta
    UPDATE VENTAS_OBJ v SET v = v_venta WHERE v.id = 2;
END;

-- 12. Crear procedimiento para visualizar los datos de una venta
CREATE OR REPLACE PROCEDURE mostrar_venta(p_id_venta NUMBER) AS
    v_venta VENTA;
    v_linea LINEA_VENTA;
BEGIN
    -- Obtener la venta
    SELECT VALUE(v) INTO v_venta 
    FROM VENTAS_OBJ v 
    WHERE v.id = p_id_venta;
    
    -- Mostrar datos de la venta
    DBMS_OUTPUT.PUT_LINE('Venta Nº: ' || v_venta.id);
    DBMS_OUTPUT.PUT_LINE('Fecha: ' || v_venta.fechaVenta);
    DBMS_OUTPUT.PUT_LINE('Cliente: ' || v_venta.cliente.nombre);
    DBMS_OUTPUT.PUT_LINE('Total: ' || v_venta.total_venta());
    DBMS_OUTPUT.PUT_LINE('Número de líneas: ' || v_venta.num_lineas());
    
    -- Mostrar líneas de venta
    FOR i IN 1..v_venta.num_lineas() LOOP
        v_linea := v_venta.lineas(i);
        DBMS_OUTPUT.PUT_LINE('Línea ' || i || ': ' ||
            v_linea.producto.descripcion || ' - Cantidad: ' || 
            v_linea.cantidad || ' - Subtotal: ' || 
            (v_linea.cantidad * v_linea.producto.pvp));
    END LOOP;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Venta no encontrada');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;