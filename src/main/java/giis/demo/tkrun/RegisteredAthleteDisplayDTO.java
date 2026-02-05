package giis.demo.tkrun;

import lombok.Getter;
import lombok.Setter;

/**
 * Data Transfer Object to display information about a registered athlete
 * for a specific competition.
 */
@Getter
@Setter
public class RegisteredAthleteDisplayDTO {
    private int idCarrera;
    private String nombreCarrera;
    private String dniAtleta;
    private String nombreAtleta;
    private String apellidosAtleta;
    private String fechaInscripcion;
    private int cuota;
    private String estadoInscripcion;

    // Add a default constructor for DbUtils
    public RegisteredAthleteDisplayDTO() {
    }

    public RegisteredAthleteDisplayDTO(int idCarrera, String nombreCarrera, String dniAtleta,
                                       String nombreAtleta, String apellidosAtleta,
                                       String fechaInscripcion, int cuota, String estadoInscripcion) {
        this.idCarrera = idCarrera;
        this.nombreCarrera = nombreCarrera;
        this.dniAtleta = dniAtleta;
        this.nombreAtleta = nombreAtleta;
        this.apellidosAtleta = apellidosAtleta;
        this.fechaInscripcion = fechaInscripcion;
        this.cuota = cuota;
        this.estadoInscripcion = estadoInscripcion;
    }

	public int getIdCarrera() {
		return idCarrera;
	}

	public void setIdCarrera(int idCarrera) {
		this.idCarrera = idCarrera;
	}

	public String getNombreCarrera() {
		return nombreCarrera;
	}

	public void setNombreCarrera(String nombreCarrera) {
		this.nombreCarrera = nombreCarrera;
	}

	public String getDniAtleta() {
		return dniAtleta;
	}

	public void setDniAtleta(String dniAtleta) {
		this.dniAtleta = dniAtleta;
	}

	public String getNombreAtleta() {
		return nombreAtleta;
	}

	public void setNombreAtleta(String nombreAtleta) {
		this.nombreAtleta = nombreAtleta;
	}

	public String getApellidosAtleta() {
		return apellidosAtleta;
	}

	public void setApellidosAtleta(String apellidosAtleta) {
		this.apellidosAtleta = apellidosAtleta;
	}

	public String getFechaInscripcion() {
		return fechaInscripcion;
	}

	public void setFechaInscripcion(String fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}

	public int getCuota() {
		return cuota;
	}

	public void setCuota(int cuota) {
		this.cuota = cuota;
	}

	public String getEstadoInscripcion() {
		return estadoInscripcion;
	}

	public void setEstadoInscripcion(String estadoInscripcion) {
		this.estadoInscripcion = estadoInscripcion;
	}

    // Lombok will generate getters and setters
}
