INSERT INTO clientes(cod_cliente, cod_provincia, nombre, apellidos, cif, direccion,
        cp, poblacion, email, telefono, activado) 
        VALUES (1,1,'Kevin', 'Zamora Amela', 'A1234', 'C/ Falsa SN',
        '12500', 'Vinaròs', 'a@b.es', '123456789', 1);
INSERT INTO clientes(cod_cliente, cod_provincia, nombre, apellidos, cif, direccion,
        cp, poblacion, email, telefono, activado) 
        VALUES (2,1,'Carlos', 'Zamora Amela', 'B1234', 'C/ Falsa SN',
        '12500', 'Benicarló', 'ba@ab.es', '123456789', 1);
INSERT INTO clientes(cod_cliente, cod_provincia, nombre, apellidos, cif, direccion,
        cp, poblacion, email, telefono, activado) 
        VALUES (3,1,'Luis', 'Torres Muñoz', 'A1234', 'C/ Falsa SN',
        '12500', 'Valencia', 'ab@ba.es', '123456789', 1);
INSERT INTO clientes(cod_cliente, cod_provincia, nombre, apellidos, cif, direccion,
        cp, poblacion, email, telefono, activado) 
        VALUES (4,1,'Isidro', 'Zaragoza', 'B1234', 'C/ Falsa SN',
        '12500', 'Teruel', 'ba@ab.es', '123456789', 1);
INSERT INTO clientes(cod_cliente, cod_provincia, nombre, apellidos, cif, direccion,
        cp, poblacion, email, telefono, activado) 
        VALUES (5,1,'Luis', 'Torres Muñoz', 'A1234', 'C/ Falsa SN',
        '12500', 'Zaragoza', 'ab@ba.es', '123456789', 1);
        
INSERT INTO productos(cod_producto, cod_categoria, alta, nombre, descripcion, precio, 
        activado, peso, iva) VALUES (1, 1, '1-1-2024', 'Gorro', 'Gorro hecho de lana', 
        5.2, 1, 50, 21);

INSERT INTO productos(cod_producto, cod_categoria, alta, nombre, descripcion, precio, 
        activado, peso, iva) VALUES (2, 1, '1-1-2023', 'Bolsa', 'Bolsa hecha de lana', 
        5.2, 1, 50, 21);
        
INSERT INTO productos(cod_producto, cod_categoria, alta, nombre, descripcion, precio, 
        activado, peso, iva) VALUES (3, 1, '1-1-2022', 'Estuche', 'Estuche hecho de lana', 
        5.2, 1, 50, 21);
 
INSERT INTO productos(cod_producto, cod_categoria, alta, nombre, descripcion, precio, 
        activado, peso, iva) VALUES (4, 1, '1-1-2021', 'Mochila', 'Mochila hecha de lana', 
        5.2, 1, 50, 21);
        
INSERT INTO productos(cod_producto, cod_categoria, alta, nombre, descripcion, precio, 
        activado, peso, iva) VALUES (5, 1, '1-1-2020', 'Bufanda', 'Bufanda hecha de lana', 
        5.2, 1, 50, 21);
        
UPDATE productos
SET iva = 4;



