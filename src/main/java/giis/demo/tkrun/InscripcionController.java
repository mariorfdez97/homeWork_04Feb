package giis.demo.tkrun;

import java.util.List;
import javax.swing.ComboBoxModel;
import giis.demo.util.SwingUtil;
import giis.demo.util.Util;

/**
 * Controller for the Athlete Registration screen.
 */
public class InscripcionController {
	private InscripcionModel model;
	private CarrerasModel carrerasModel;
	private InscripcionView view;

	public InscripcionController(InscripcionModel model, CarrerasModel carrerasModel, InscripcionView view) {
		this.model = model;
		this.carrerasModel = carrerasModel;
		this.view = view;
		// Ensure database and tables exist (per project convention in tests)
		new giis.demo.util.Database().createDatabase(true);
		this.initView();
	}

	public void initController() {
		// Action for the registration button
		view.getBtnRegistrar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> registrarInscripcion()));
	}

	private void initView() {
		// Default simulation date
		view.setFecha("2016-11-10");
		this.loadCarreras();
		view.getFrame().setVisible(true);
	}

	private void loadCarreras() {
		// Load only active competitions for the given date
		List<Object[]> carreras = carrerasModel.getListaCarrerasArray(Util.isoStringToDate(view.getFecha()));
		ComboBoxModel<Object> lmodel = SwingUtil.getComboModelFromList(carreras);
		view.getComboCarreras().setModel(lmodel);
	}

	private void registrarInscripcion() {
		String dni = view.getDni();
		String itemCarrera = (String) view.getComboCarreras().getSelectedItem();
		
		// Syntactic validation: check if DNI and Carrera are selected
		if (dni == null || dni.trim().isEmpty()) {
			throw new giis.demo.util.ApplicationException("El DNI no puede estar vacío.");
		}
		if (itemCarrera == null) {
			throw new giis.demo.util.ApplicationException("Debe seleccionar una carrera.");
		}
		
		// Parse ID from the selected combo item (format: "id-descr (Abierta)")
		int idCarrera = Integer.parseInt(itemCarrera.split("-")[0]);
		
		// Call model for business logic and persistence
		model.registerAtleta(dni, idCarrera, Util.isoStringToDate(view.getFecha()));
		
		// Success message
		javax.swing.JOptionPane.showMessageDialog(null, "Inscripción realizada con éxito.");
	}
}
