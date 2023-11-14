CREATE TABLE Familia 
(   Codfamilia number(3) PRIMARY KEY,
    Nomfamilia char(50) UNIQUE NOT NULL
);

CREATE TABLE Producto
(
    codproducto NUMBER(5) PRIMARY KEY,
    nomproducto CHAR(20) NOT NULL,
    descripcion CHAR(100),
    preciobase  NUMBER(8) NOT NULL, 
    PorcReposición NUMBER(3),
    UnidadesMinimo NUMBER(4) NOT NULL,
    Codfamilia NUMBER(3) NOT NULL
);