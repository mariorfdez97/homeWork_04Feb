package giis.demo.tkrun;

import lombok.Getter;
import lombok.Setter;

/**
 * Domain model data for Registrations (Inscripciones).
 */
@Getter
@Setter
public class InscripcionEntity {
	private int idCarrera;
	private String dniAtleta;
	private String fechaInscripcion;
	private int cuota;
	private String estado;
}
