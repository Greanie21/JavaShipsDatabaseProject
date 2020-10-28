DROP DATABASE IF EXISTS navios;
CREATE DATABASE navios;
use navios;


CREATE TABLE cruzador(
    idNavioCruzador     INT AUTO_INCREMENT NOT NULL,
    numCanhoes          INT,

    PRIMARY KEY (idNavioCruzador)
);

CREATE TABLE portaAvioes(
    idNavioPortaAvioes  INT AUTO_INCREMENT NOT NULL,
    numAvioes           INT,

    PRIMARY KEY (idNavioPortaAvioes)
);
    
CREATE TABLE navioMercante(
    idNavioMercante     INT AUTO_INCREMENT NOT NULL,
    capacidadeDeCarga   DECIMAL(10,2),
    carga               DECIMAL(10,2),

    PRIMARY KEY (idNavioMercante)
);


CREATE TABLE navioDeGuerra(
    idNavioDeGuerra     INT AUTO_INCREMENT NOT NULL,
    blindagem           DECIMAL(10,2),
    ataque              DECIMAL(10,2),
    idNavioCruzador     INT,
    idNavioPortaAvioes  INT,

    PRIMARY KEY (idNavioDeGuerra),
    FOREIGN KEY (idNavioCruzador) REFERENCES cruzador (idNavioCruzador),
    FOREIGN KEY (idNavioPortaAvioes) REFERENCES portaAvioes (idNavioPortaAvioes)
);

CREATE TABLE navio(
    id           INT AUTO_INCREMENT NOT NULL,
    nome         VARCHAR(30),
    tripulantes  INT,
    idNavioDeGuerra  INT,
    idNavioMercante  INT,

    PRIMARY KEY (id),
    FOREIGN KEY (idNavioDeGuerra) REFERENCES navioDeGuerra (idNavioDeGuerra),
    FOREIGN KEY (idNavioMercante) REFERENCES navioMercante (idNavioMercante)
);