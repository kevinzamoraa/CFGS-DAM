CREATE TABLE Familia 
(   Codfamilia number(3) PRIMARY KEY,
    Nomfamilia char(50) UNIQUE NOT NULL,
    IVA number(2) NOT NULL,
    
    CONSTRAINT checkIVA CHECK (IVA = 21 OR IVA = 10 OR IVA = 4)
);

CREATE TABLE Producto
(
    Codproducto NUMBER(5) PRIMARY KEY NOT NULL,
    Nomproducto CHAR(50) NOT NULL,
    DELETE Descripcion,
    Perecedero BOOLEAN,
    PrecioBase  NUMBER(8) NOT NULL, 
    PorcReposici�n NUMBER(3),
    UnidadesM�nimo NUMBER(4) NOT NULL,
    Codfamilia NUMBER(3) NOT NULL,
    
    CONSTRAINT checkValues CHECK (PrecioBase > 0 AND PorcReposici�n > 0 AND UnidadesM�nimo > 0),
    
    CONSTRAINT fk_Codfamilia
        FOREIGN KEY(Codfamilia)
        REFERENCES Familia(Codfamilia)
);

CREATE TABLE Tienda
(
    Codtienda NUMBER(3) PRIMARY KEY NOT NULL,
    Nomtienda CHAR(20) NOT NULL,
    Telefono CHAR(11),
    CodigoPostal CHAR(5) UNIQUE NOT NULL,
    Provincia CHAR(5) NOT NULL
);

CREATE TABLE Stock
(
    CodtiendaI NUMBER(3),
    CodproductoI NUMBER(5),
    Unidades NUMBER(6) NOT NULL,
    FechaUltimaEntrada DATE,
    Beneficio NUMBER(1) NOT NULL,
    
    CONSTRAINT fk_Codtienda2
        FOREIGN KEY(CodtiendaI)
        REFERENCES Tienda(Codtienda),
    
    CONSTRAINT fk_Codproducto2
        FOREIGN KEY(CodproductoI)
        REFERENCES Producto(Codproducto),
    
    CONSTRAINT checkValues2 CHECK (Unidades > 0),
    
    CONSTRAINT checkBenefit CHECK (Beneficio > 0 AND Beneficio < 6)
);

ALTER TABLE Stock RENAME TO Stock_Tiendas;

DROP TABLE Familia CASCADE CONSTRAINTS;

// NECESITAN M�S PERMISOS PARA EJECUTAR LOS COMANDOS SIGUIENTES Y QUE FUNCIONEN
// PE: PODEMOS INICIAR SESI�N CON EL USUARIO DE SISTEMA 'SYSTEM' Y HACIENDO 
// USO DE SU CONTRASE�A POR DEFECTO, LA CUAL HABR� SIDO DEFINIDA POR NOSOTRXS
// DURANTE LA INSTALACI�N
// OTRA OPCI�N CONSISTE EN A�ADIR Y OTORGAR M�S PERMISOS A NUESTRO USUARIO
CREATE USER C##INVITADO IDENTIFIED BY invitado;
GRANT CONNECT, RESOURCE TO C##INVITADO;

// LO SIGUIENTE ME DA ERROR Y POR ESO EST� COMENTADO, NO SOY CAPAZ DE VER EL FALLO, DISCULPA
// GRANT UPDATE TABLE, DELETE TABLE ON SCHEMA Producto TO C##INVITADO;
// REVOKE UPDATE TABLE, DELETE TABLE ON SCHEMA Producto FROM C##INVITADO;

// PD: NO SE NOS PERMITE BORRAR PERMISOS QUE A�N NO LE HEMOS BRINDADO AL USUARIO
// REVOKE UPDATE, ALTER, DELETE ON Producto FROM C##INVITADO;
// POR ENDE, LE PODEMOS QUITAR EL DE 'ROSOURCE'

