package giis.demo.tkrun;

import lombok.Getter;
import lombok.Setter;

/**
 * Domain model data for Athletes.
 */
@Getter
@Setter
public class AtletaEntity {
	private String dni;
	private String nombre;
	private String apellidos;
	private String email;
	private String fechaNacimiento;
}
