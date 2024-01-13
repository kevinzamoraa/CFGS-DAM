CREATE TABLE Familia 
(   Codfamilia number(3) PRIMARY KEY,
    Nomfamilia char(50) UNIQUE NOT NULL
);

CREATE TABLE Producto
(
    Codproducto NUMBER(5) PRIMARY KEY NOT NULL,
    Nomproducto CHAR(20) NOT NULL,
    Descripcion CHAR(100),
    PrecioBase  NUMBER(8) NOT NULL, 
    PorcReposición NUMBER(3),
    UnidadesMínimo NUMBER(4) NOT NULL,
    Codfamilia NUMBER(3) NOT NULL,
    
    CONSTRAINT checkValues CHECK (PrecioBase > 0 AND PorcReposición > 0 AND UnidadesMínimo > 0),
    
    CONSTRAINT fk_Codfamilia
        FOREIGN KEY(Codfamilia)
        REFERENCES Familia(Codfamilia)
);

CREATE TABLE Tienda
(
    Codtienda NUMBER(3) PRIMARY KEY NOT NULL,
    Nomtienda CHAR(20) NOT NULL,
    Telefono CHAR(11),
    CodigoPostal CHAR(5) NOT NULL,
    Provincia CHAR(5) NOT NULL
);

CREATE TABLE Stock
(
    CodtiendaI NUMBER(3),
    CodproductoI NUMBER(5),
    Unidades NUMBER(6) NOT NULL,
    
    CONSTRAINT fk_Codtienda2
        FOREIGN KEY(CodtiendaI)
        REFERENCES Tienda(Codtienda),
    
    CONSTRAINT fk_Codproducto2
        FOREIGN KEY(CodproductoI)
        REFERENCES Producto(Codproducto),
    
    CONSTRAINT checkValues2 CHECK (Unidades > 0)
);

