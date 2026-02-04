package giis.demo.tkrun;

import java.util.Date;
import java.util.List;
import giis.demo.util.Database;
import giis.demo.util.Util;
import giis.demo.util.ApplicationException;

/**
 * Model for managing registrations (Inscripciones) of athletes in competitions.
 */
public class InscripcionModel {
	private Database db = new Database();
	private CarrerasModel carrerasModel = new CarrerasModel();

	/**
	 * Registers an athlete in a competition.
	 * Calculates the final cuota based on the registration date and current competition phases.
	 * 
	 * @param dniAtleta DNI of the athlete
	 * @param idCarrera ID of the competition
	 * @param fechaInscripcion Date of the registration
	 */
	public void registerAtleta(String dniAtleta, int idCarrera, Date fechaInscripcion) {
		// 1. Semantic validation: Check if athlete exists
		validateAtletaExists(dniAtleta);
		
		// 2. Semantic validation: Check if already registered
		validateNotRegistered(dniAtleta, idCarrera);
		
		// 3. Get competition data and calculate cuota
		CarreraEntity carrera = carrerasModel.getCarrera(idCarrera);
		int baseCuota = carrera.getCuota();
		int percentage = carrerasModel.getDescuentoRecargo(idCarrera, fechaInscripcion);
		
		int finalCuota = baseCuota + (baseCuota * percentage / 100);
		
		// 4. Save registration
		String sql = "INSERT INTO Inscripciones(idCarrera, dniAtleta, fechaInscripcion, cuota, estado) VALUES (?,?,?,?,?)";
		db.executeUpdate(sql, idCarrera, dniAtleta, Util.dateToIsoString(fechaInscripcion), finalCuota, "Inscrito");
	}

	private void validateAtletaExists(String dniAtleta) {
		String sql = "SELECT dni FROM Atletas WHERE dni = ?";
		List<Object[]> rows = db.executeQueryArray(sql, dniAtleta);
		if (rows.isEmpty()) {
			throw new ApplicationException("Athlete with DNI " + dniAtleta + " does not exist.");
		}
	}

	private void validateNotRegistered(String dniAtleta, int idCarrera) {
		String sql = "SELECT dniAtleta FROM Inscripciones WHERE dniAtleta = ? AND idCarrera = ?";
		List<Object[]> rows = db.executeQueryArray(sql, dniAtleta, idCarrera);
		if (!rows.isEmpty()) {
			throw new ApplicationException("Athlete is already registered in this competition.");
		}
	}
	
	/**
	 * Gets all registrations for a specific competition.
	 */
	public List<InscripcionEntity> getInscripciones(int idCarrera) {
		String sql = "SELECT idCarrera, dniAtleta, fechaInscripcion, cuota, estado FROM Inscripciones WHERE idCarrera = ?";
		return db.executeQueryPojo(InscripcionEntity.class, sql, idCarrera);
	}
}
