CREATE DATABASE naruto_KevinnHernandez;
USE naruto_KevinnHernandez;

CREATE TABLE Ninja(
    ninjaID INT  NOT NULL  PRIMARY KEY,
    nombreNinja VARCHAR(50) NOT NULL,
    rangoNinja VARCHAR(50) NOT NULL,
    aldeaNinja VARCHAR(50) NOT NULL
);

CREATE TABLE Habilidad(
    idNinja INT  NOT NULL,
    nombreHabilidad VARCHAR(80) NOT NULL,
    descripcionHabilidad VARCHAR(255) NOT NULL,
    foreign key (idNinja) references Ninja(ninjaID)
);
CREATE TABLE Mision(
    misionID INT  NOT NULL  PRIMARY KEY,
    descripcionMision VARCHAR(255) NOT NULL,
    rangoMision VARCHAR(50) NOT NULL,
    recompensaMision DOUBLE NOT NULL
);

CREATE TABLE MisionNinja(
    idNinja INT  NOT NULL,
    idMision INT NOT NULL,
    fechaInicio DATE NULL,
    fechaFin DATE NULL,
    foreign key (idNinja) references Ninja(ninjaID),
    foreign key (idMision) references Mision(misionID)
);
INSERT INTO Ninja ( ninjaID, nombreNinja, rangoNinja, aldeaNinja ) VALUES
(1, 'Naruto Uzumaki', 'Hokage', 'Hoja'),
(2, 'Sasuke Uchiha', 'Chunin', 'Hoja'),
(3, 'Sakura Haruno', 'Chunin', 'Hoja'),
(4, 'Gaara del Decierto', 'Kazekage', 'Arena'),
(5, 'Boruto Uzumaki', 'Genin', 'Hoja')
;

INSERT INTO Mision ( misionID, descripcionMision, rangoMision, recompensaMision ) VALUES
    (1, 'Salvar un gato', 'Genin', 2000),
    (2, 'Derrotar a un ninja de la arena', 'Genin', 5000),
    (3, 'Derrota a Madara', 'Anbu', 50000),
    (4, 'Ayuda a Rock Lee a entrenar', 'Chunin', 10000),
    (5, 'Lleva un encargo a la aldea del sonido', 'Chunin', 7000)
;

INSERT INTO Habilidad ( idNinja, nombreHabilidad, descripcionHabilidad ) VALUES
     (1, 'Rasengan', 'Esfera de aire compromido'),
     (2, 'Clones de sombra', 'Clonacion fisica de ti mismo'),
     (3, 'Rasen-shuriken', 'rasengan con forma de shuriken'),
     (4, 'Chidori', 'Ataque de tipo electrico'),
     (5, 'Yutsu regeneracion', 'Recupera puntos de vida'),
     (5, 'Karma', 'Habilidad especial')
;

INSERT INTO MisionNinja ( idNinja, idMision, fechaInicio, fechaFin ) VALUES
    (1, 1, '2020-10-20', '2020-10-30'),
    (2,2, '2020-07-01', '2020-07-20'),
    (3,3, '2021-01-01', '2024-12-31'),
    (4,4, '2022-11-15', '2022-11-20'),
    (5,5, '2023-02-10', NULL)    
;