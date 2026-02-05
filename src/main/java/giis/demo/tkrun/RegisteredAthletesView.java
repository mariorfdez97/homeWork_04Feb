package giis.demo.tkrun;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import giis.demo.util.SwingUtil;

import java.awt.*;
import java.util.List;

public class RegisteredAthletesView extends JFrame {

    private JFrame frame;
    private JTable registeredAthletesTable;
    private JButton refreshButton;

    /**
     * Create the application.
     */
    public RegisteredAthletesView() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Lista de Atletas Registrados");
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        // Table for displaying registered athletes
        registeredAthletesTable = new JTable();
        registeredAthletesTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        JScrollPane scrollPane = new JScrollPane(registeredAthletesTable);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Panel for buttons
        JPanel buttonPanel = new JPanel();
        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        refreshButton = new JButton("Actualizar Lista");
        buttonPanel.add(refreshButton);
    }

    public JFrame getFrame() {
        return frame;
    }

    public JTable getRegisteredAthletesTable() {
        return registeredAthletesTable;
    }

    public JButton getRefreshButton() {
        return refreshButton;
    }

    // Method to set the table model directly from a list of DTOs
    public void setRegisteredAthletesTable(List<RegisteredAthleteDisplayDTO> athletes) {
        String[] columnNames = {"ID Carrera", "Nombre Carrera", "DNI Atleta", "Nombre Atleta", "Apellidos Atleta", "Fecha Inscripción", "Cuota", "Estado Inscripción"};
        DefaultTableModel model = (DefaultTableModel) registeredAthletesTable.getModel();
        model.setColumnIdentifiers(columnNames);

        // Clear existing data
        model.setRowCount(0);

        for (RegisteredAthleteDisplayDTO athlete : athletes) {
            Object[] row = new Object[8];
            row[0] = athlete.getIdCarrera();
            row[1] = athlete.getNombreCarrera();
            row[2] = athlete.getDniAtleta();
            row[3] = athlete.getNombreAtleta();
            row[4] = athlete.getApellidosAtleta(); // Corrected field access
            row[5] = athlete.getFechaInscripcion();
            row[6] = athlete.getCuota();
            row[7] = athlete.getEstadoInscripcion();
            model.addRow(row);
        }
        SwingUtil.autoAdjustColumns(registeredAthletesTable);
    }
}
