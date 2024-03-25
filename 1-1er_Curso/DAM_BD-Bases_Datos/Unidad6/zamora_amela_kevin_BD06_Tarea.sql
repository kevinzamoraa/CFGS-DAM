// ACTIVIDAD 1
CREATE OR REPLACE PROCEDURE CambiarCategoria
( id_CategoriaOrigen productos.cod_categoria%type, 
id_CategoriaDestino productos.cod_categoria%type )
AS
    categorias_iguales exception;
    categoria_origen_no_existe exception;
    categoria_destino_no_existe exception;
    numCategoriaOrigen number(8);
    numCategoriaDestino number(8);
    nombreCategoriaOrigen categorias.nombre%type;
    nombreCategoriaDestino categorias.nombre%type;
    numProductos number(8);
BEGIN

    IF id_CategoriaOrigen = id_CategoriaDestino THEN
        RAISE categorias_iguales;
    END IF;
    
    SELECT COUNT(*) INTO numCategoriaOrigen 
        FROM productos 
        WHERE cod_categoria = id_CategoriaOrigen;
        
    IF numCategoriaOrigen = 0 THEN 
        RAISE categoria_origen_no_existe;
    END IF;
    
    SELECT COUNT(*) INTO numCategoriaDestino
        FROM productos 
        WHERE cod_categoria = id_CategoriaDestino;
        
    IF numCategoriaDestino = 0 THEN 
        RAISE categoria_destino_no_existe;
    END IF;
    
    SELECT nombre INTO nombreCategoriaOrigen
        FROM categorias
        WHERE cod_categoria = id_CategoriaOrigen;
        
    SELECT nombre INTO nombreCategoriaDestino
        FROM categorias
        WHERE cod_categoria = id_CategoriaDestino;
        
    SELECT COUNT(*) INTO numProductos
    FROM productos
    WHERE cod_categoria = id_CategoriaOrigen;
    
    UPDATE productos SET cod_categoria = id_CategoriaDestino 
        WHERE cod_categoria = id_CategoriaOrigen;
        DBMS_OUTPUT.PUT_LINE('Se han trasladado ' || numProductos || 
        ' productos de la categoria ' || nombreCategoriaOrigen || 
        ' a la categoria ' || nombreCategoriaDestino );

EXCEPTION
    WHEN categorias_iguales THEN
    DBMS_OUTPUT.PUT_LINE('Las categorias no pueden ser iguales');
    WHEN categoria_origen_no_existe THEN
    DBMS_OUTPUT.PUT_LINE('La categoria origen no existe');
    WHEN categoria_destino_no_existe THEN
    DBMS_OUTPUT.PUT_LINE('La categoria destino no existe');
END;
/

/* Intento de comprobacion -> Al ejecutar la función desde un bloque anonimo, no 
   nuestra ningún mensaje de error y en consola comenta 'copilado con errores' */
BEGIN
    CambiarCategoria(111111,111111);
END;
/

// Actividad 2
CREATE OR REPLACE TRIGGER controlar_variables
BEFORE INSERT OR UPDATE ON productos FOR EACH ROW
BEGIN

    SELECT cod_producto,
        CASE
            WHEN LENGTH(cod_producto) > 10 THEN 'La clave de producto no puede contener 
                más de 10 carácteres'
/*                RAISE_APPLICATION_ERROR(-20001, 'La clave de producto no puede contener 
                más de 10 carácteres'); */
            END AS cod_producto
    FROM productos;
    
    SELECT iva,
        CASE
            WHEN iva not in (4,10,21) THEN
                 RAISE_APPLICATION_ERROR(-20002, 'El valor de IVA introducido no es válido');
    FROM productos;
    
    SELECT iva
        CASE
            WHEN iva is null THEN
                 RAISE_APPLICATION_ERROR(-20003, 'El valor de IVA nunca puede estar vacio');
    FROM productos;
    
    SELECT precioOferta, precio
        CASE
            WHEN precioOferta > precio THEN
                RAISE_APPLICATION_ERROR(-20004, 'El precio en oferta debe ser inferior al 
                precio original/previo');
    FROM productos;
    
    SELECT cod_categoria, precioOferta, iva
        CASE
            WHEN cod_categoria > 50 and precioOferta is not null and iva != 21 THEN 
                RAISE_APPLICATION_ERROR(-20005, 'El producto no puede tener un precio en 
                oferta y debe tener un IVA del 21');
                precioOferta := null;
                iva := 21;
    FROM productos;
    
    SELECT cod_categoria, precioOferta, peso, iva
        CASE
            WHEN cod_categoria <= 50 and precioOferta is null and peso > 30 and 
            (iva != 4 or iva != 10) THEN 
                 RAISE_APPLICATION_ERROR(-20006, 'El producto puede tener un precio en 
                oferta, a definir, su IVA puede ser del 4 o 10 porciento y su peso debe 
                ser inferior a 30');
    FROM productos;
    
    SELECT cod_categoría, precio
        CASE
            WHEN cod_categoria is null OR precio is null THEN
                 RAISE_APPLICATION_ERROR(-20007, 'Todos los productos deben pertenecer a una 
                categoría y también deben tener un precio de venta');    
    FROM productos;
    
END;
/