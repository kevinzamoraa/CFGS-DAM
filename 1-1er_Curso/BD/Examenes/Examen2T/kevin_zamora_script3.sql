SELECT nombre, cod_categoria FROM productos;
CREATE OR REPLACE PROCEDURE modificarCategoria(productos.nombre, productos.categoria) IS
BEGIN
        IF cod_categoria = 1 THEN 
            UPDATE productos SET
                cod_categoria = 2
            WHERE cod_categoria IS NOT NULL;
        END IF;
        IF cod_categoria != 1 THEN
            UPDATE productos SET
                cod_categoria = 1
            WHERE cod_categoria IS NOT NULL;
        END IF;
END;
/

CREATE OR REPLACE FUNCTION aplicarDescuento(cod_categoria_introducida, fecha_inicio, fecha_fin)
    IF fecha_inicio IS NOT NULL AND fecha_fin IS NOT NULL THEN 
        SELECT precio FROM productos WHERE cod_categoria = cod_categoria_introducida;
        precio = precio * 0.80;
    END IF;
END;
/

CREATE OR REPLACE FUNCTION borrarProductosEnDesuso
    DROP * FROM productos WHERE cod_producto NOT IN (SELECT * FROM pedidos_detalle);
END;
/

CREATE OR REPLACE FUNCTION facturacionTotalCategoria(nom_categoria)
    SELECT SUM(precio) WHERE cod_categoria = (SELECT cod_categoria FROM categorias 
    WHERE nombre = nom_categoria;    
END;
/

CREATE OR REPLACE FUNCTION pedidos(parametro1, parametro2)
    DECLARE cliente_introducido NUMBER(10);
    cliente_introducido = 1;
    RETURNS DECIMAL(10,3)
    CASE
        WHEN parametro1 = 'provincias' THEN
            SELECT SUM(precio) FROM pedidos_detalle WHERE cod_pedido IS pedidos.cod_pedido;
        WHEN parametro1 = 'clientes' THEN
            SELECT COUNT(cod_pedido) WHERE cod_cliente IS cliente_introducido;
        WHEN parametro1 = 'categorías' THEN
            SELECT SUM(precio) FROM pedidos_detalle WHERE cod_pedido IS pedidos.cod_pedido;
        ELSE 
            parametro1 = 0;
    END;
END

