--Primero se deben borrar todas las tablas (de detalle a maestro) y lugo anyadirlas (de maestro a detalle)
--(en este caso en cada aplicacion se usa solo una tabla, por lo que no hace falta)

--Para giis.demo.tkrun:
drop table Carreras;
create table Carreras (id int primary key not null, inicio date not null, fin date not null, fecha date not null, cuota int not null, descr varchar(32), check(inicio<=fin), check(fin<fecha));

drop table Atletas;
create table Atletas (dni varchar(10) primary key not null, nombre varchar(32) not null, apellidos varchar(32) not null, email varchar(32) not null, fechaNacimiento date);

drop table Inscripciones;
create table Inscripciones (idCarrera int not null, dniAtleta varchar(10) not null, fechaInscripcion date not null, cuota int not null, estado varchar(16) not null, 
	primary key (idCarrera, dniAtleta),
	foreign key (idCarrera) references Carreras(id),
	foreign key (dniAtleta) references Atletas(dni));

