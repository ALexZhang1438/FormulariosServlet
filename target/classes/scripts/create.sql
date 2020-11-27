create table IF NOT EXISTS TITULACION(
	id bigint auto_increment,
    titulo varchar(25)
);

create table IF NOT EXISTS ALUMNO(
	id bigint auto_increment,
    nombre varchar(25),
    edad bigint,
    titulacion INT,
    FOREIGN KEY (titulacion) REFERENCES TITULACION(id)
);
