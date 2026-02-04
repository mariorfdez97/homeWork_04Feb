package giis.demo.tkrun;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

/**
 * View for Athlete Registration in a competition.
 */
public class InscripcionView {

	private JFrame frame;
	private JTextField txtDni;
	private JTextField txtFecha;
	private JComboBox<Object> comboCarreras;
	private JButton btnRegistrar;
	private JLabel lblCuota;

	public InscripcionView() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Registro de Atleta");
		frame.setName("InscripcionView");
		frame.setBounds(100, 100, 400, 300);
		frame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[][grow]", "[][][][][][grow]"));

		frame.getContentPane().add(new JLabel("Fecha Hoy (ISO):"), "cell 0 0,alignx trailing");
		txtFecha = new JTextField();
		frame.getContentPane().add(txtFecha, "cell 1 0,growx");

		frame.getContentPane().add(new JLabel("Seleccione Carrera:"), "cell 0 1,alignx trailing");
		comboCarreras = new JComboBox<>();
		frame.getContentPane().add(comboCarreras, "cell 1 1,growx");

		frame.getContentPane().add(new JLabel("DNI Atleta:"), "cell 0 2,alignx trailing");
		txtDni = new JTextField();
		frame.getContentPane().add(txtDni, "cell 1 2,growx");

		btnRegistrar = new JButton("Registrar Inscripción");
		frame.getContentPane().add(btnRegistrar, "cell 1 4");

		frame.getContentPane().add(new JLabel("Cuota a pagar:"), "cell 0 5");
		lblCuota = new JLabel("-");
		frame.getContentPane().add(lblCuota, "cell 1 5");
	}

	// Getters and setters for controller access
	public JFrame getFrame() { return frame; }
	public String getDni() { return txtDni.getText(); }
	public String getFecha() { return txtFecha.getText(); }
	public void setFecha(String fecha) { txtFecha.setText(fecha); }
	public JComboBox<Object> getComboCarreras() { return comboCarreras; }
	public JButton getBtnRegistrar() { return btnRegistrar; }
	public void setCuota(String cuota) { lblCuota.setText(cuota); }
}
