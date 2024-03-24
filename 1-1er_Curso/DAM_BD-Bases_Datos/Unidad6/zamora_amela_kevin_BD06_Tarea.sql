CREATE OR REPLACE PROCEDURE CambiarCategoria
( id_CategoriaOrigen categoria.cod_categoria%type, 
id_CategoriaDestino categoria.cod_categoria%type )
AS
    categorias_iguales exception;
    categoria_origen_no_existe exception;
    categoria_destino_no_existe exception;
    numCategoriaOrigen number(8);
    numCategoriaDestino number(8);
    nombreCategoriaOrigen categorias.nombre%type;
    nombreCategoríaDestino categorias.nombre%type;
    numProductos number(8);
BEGIN

    IF id_CategoriaOrigen = id_CategoriaDestino THEN
        RAISE categorias_iguales;
    END IF;
    
    SELECT COUNT(*) INTO numCategoriaOrigen 
        FROM productos 
        WHERE identificador = id_CategoriaOrigen;
        
    IF numCategoriaOrigen = 0 THEN 
        RAISE categoria_origen_no_existe;
    END IF;
    
    SELECT COUNT(*) INTO numCategoriaDestino
        FROM productos 
        WHERE identificador = id_CategoriaDestino;
        
    IF numCategoriaDestino = 0 THEN 
        RAISE categoria_destino_no_existe;
    END IF;
    
    SELECT nombre INTO nombreCategoriaOrigen
        FROM categorias
        WHERE identificador = id_CategoriaOrigen;
        
    SELECT nombre INTO nombreCategoriaDestino
        FROM categorias
        WHERE identificador = id_CategoriaDestino;
        
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
    WHEN countCategoriaOrigen THEN
    DBMS_OUTPUT.PUT_LINE('La categoria origen no existe');
    WHEN countCategoriaDestino THEN
    DBMS_OUTPUT.PUT_LINE('La categoria destino no existe');
END;
/

BEGIN
    CambiarCategoria(11111,11111);
END;
/