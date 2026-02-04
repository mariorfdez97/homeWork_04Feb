--Datos para carga inicial de la base de datos

--Para giis.demo.tkrun:
delete from carreras;
insert into carreras(id,inicio,fin,fecha,cuota,descr) values 
	(100,'2016-10-05','2016-10-25','2016-11-09',10,'finalizada'),
	(101,'2016-10-05','2016-10-25','2016-11-10',15,'en fase 3'),
	(102,'2016-11-05','2016-11-09','2016-11-20',20,'en fase 2'),
	(103,'2016-11-10','2016-11-15','2016-11-21',25,'en fase 1'),
	(104,'2016-11-11','2016-11-15','2016-11-22',30,'antes inscripcion');

delete from atletas;
insert into atletas(dni,nombre,apellidos,email,fechaNacimiento) values
	('12345678A','Juan','Perez','juan@perez.com','1990-01-01'),
	('87654321B','Maria','Garcia','maria@garcia.com','1995-05-05');
