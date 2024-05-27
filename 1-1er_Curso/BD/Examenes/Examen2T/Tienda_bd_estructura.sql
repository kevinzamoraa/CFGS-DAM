/************** SCRIPT CREACION NUEVO TABLESPACE DE ORACLE ***********************/
alter session set "_oracle_script"=true;

CREATE TABLESPACE BD_EX DATAFILE 'bdex_data.dbf' SIZE 10m;
ALTER DATABASE DATAFILE 'bdex_data.dbf' RESIZE 15m;

CREATE USER "BDEX" IDENTIFIED BY "BDEX" DEFAULT TABLESPACE "BD_EX" TEMPORARY TABLESPACE "TEMP";
GRANT ALL PRIVILEGES TO "BDEX" WITH ADMIN OPTION;

/****************** CREACION DE LAS ESTRUCTURAS DE BASE DE DATOS *****/
drop TABLE pedidos_detalle;
drop TABLE pedidos;
drop TABLE fotos;
drop TABLE videos;
drop TABLE productos;
drop TABLE clientes;
drop TABLE provincias;
drop TABLE categorias;


CREATE TABLE provincias (
	cod_provincia INTEGER PRIMARY Key,
	nombre varchar(100) not null
);
CREATE TABLE clientes(
	cod_cliente INTEGER PRIMARY Key,
	cod_provincia INTEGER not null,
	nombre varchar2(100) not null,
	apellidos varchar2(300) not null,
	cif varchar2(12) not null,
	direccion varchar2(300) not null,
	cp varchar2(5) not null,
	poblacion varchar2(300) not null,
	email varchar2(300),
	telefono varchar2(30),
	activado INTEGER not null,
	CONSTRAINT fk_cliprov FOREIGN KEY (cod_provincia) REFERENCES provincias(cod_provincia)
);
CREATE TABLE pedidos(
	cod_pedido INTEGER PRIMARY Key,
	cod_cliente INTEGER not null,
	fecha DATE not null,
	pagado INTEGER,
	servido INTEGER,
	portes DECIMAL(5,2),
	CONSTRAINT fk_cliente FOREIGN KEY (cod_cliente) REFERENCES clientes(cod_cliente)
);
CREATE TABLE categorias(
	cod_categoria INTEGER PRIMARY Key,
	nombre varchar2(100) not null,
	descripcion varchar2(500) not null,
	activado INTEGER 
);
CREATE TABLE productos(
	cod_producto INTEGER PRIMARY Key,
	cod_categoria INTEGER not null,
	alta DATE,
	nombre varchar2(100) not null,
	descripcion varchar2(500),
	precio DECIMAL(5,2) not null,
	activado INTEGER,
	peso DECIMAL(5,2),
	iva DECIMAL(5,2) not null,
	CONSTRAINT fk_categoria FOREIGN KEY (cod_categoria) REFERENCES categorias(cod_categoria)
);
CREATE TABLE pedidos_detalle(
	cod_detalle INTEGER PRIMARY Key,
	cod_pedido INTEGER not null,
	cod_producto INTEGER not null,
	unidades INTEGER not null,
	precio DECIMAL(5,2) not null,
	iva DECIMAL(5,2) not null,
	CONSTRAINT fk_pedidos FOREIGN KEY (cod_pedido) REFERENCES pedidos(cod_pedido),
	CONSTRAINT fk_productos FOREIGN KEY (cod_producto) REFERENCES productos(cod_producto)	
);

CREATE TABLE fotos(
	cod_foto INTEGER PRIMARY Key,
	fecha DATE,
	imagen varchar2(300) not null,
	titulo varchar2(300) not null,
	cod_producto INTEGER not null,
	CONSTRAINT fk_productos1 FOREIGN KEY (cod_producto) REFERENCES productos(cod_producto)
);
CREATE TABLE videos(
	cod_video INTEGER PRIMARY Key,
	fecha DATE,
	video varchar2(300) not null,
	titulo varchar2(300) not null,
	cod_producto INTEGER not null,
	CONSTRAINT fk_productos2 FOREIGN KEY (cod_producto) REFERENCES productos(cod_producto)
);
