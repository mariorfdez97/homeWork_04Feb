package giis.demo.tkrun.ut;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import giis.demo.tkrun.InscripcionEntity;
import giis.demo.tkrun.InscripcionModel;
import giis.demo.util.ApplicationException;
import giis.demo.util.Database;
import giis.demo.util.Util;

public class TestInscripcionHomework {
	private Database db = new Database();
	private InscripcionModel model = new InscripcionModel();

	@BeforeEach
	public void setUp() {
		db.createDatabase(true);
		// Clean tables
		db.executeUpdate("DELETE FROM Inscripciones");
		db.executeUpdate("DELETE FROM Atletas");
		db.executeUpdate("DELETE FROM Carreras");
		
		// Insert sample data
		db.executeUpdate("INSERT INTO Carreras(id,inicio,fin,fecha,cuota,descr) values (101,'2016-10-05','2016-10-25','2016-11-10',100,'en fase 3')");
		db.executeUpdate("INSERT INTO Atletas(dni,nombre,apellidos,email,fechaNacimiento) values ('12345678A','Juan','Perez','juan@perez.com','1990-01-01')");
	}

	@Test
	public void testRegisterSuccessful() {
		// Competition 101, phase 3 (surcharge 50%) on 2016-11-10
		// Base cuota 100 + 50% = 150
		model.registerAtleta("12345678A", 101, Util.isoStringToDate("2016-11-10"));
		
		List<InscripcionEntity> ins = model.getInscripciones(101);
		assertEquals(1, ins.size());
		assertEquals("12345678A", ins.get(0).getDniAtleta());
		assertEquals(150, ins.get(0).getCuota());
	}

	@Test
	public void testRegisterAtletaNotFound() {
		ApplicationException exception = assertThrows(ApplicationException.class, () -> {
			model.registerAtleta("99999999Z", 101, Util.isoStringToDate("2016-11-10"));
		});
		assertEquals("Athlete with DNI 99999999Z does not exist.", exception.getMessage());
	}

	@Test
	public void testRegisterAlreadyRegistered() {
		model.registerAtleta("12345678A", 101, Util.isoStringToDate("2016-11-10"));
		
		ApplicationException exception = assertThrows(ApplicationException.class, () -> {
			model.registerAtleta("12345678A", 101, Util.isoStringToDate("2016-11-10"));
		});
		assertEquals("Athlete is already registered in this competition.", exception.getMessage());
	}
}
