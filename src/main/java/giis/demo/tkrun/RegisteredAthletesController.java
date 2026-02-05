package giis.demo.tkrun;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import giis.demo.util.SwingUtil;

public class RegisteredAthletesController {

    private InscripcionModel model;
    private RegisteredAthletesView view;

    public RegisteredAthletesController(InscripcionModel m, RegisteredAthletesView v) {
        this.model = m;
        this.view = v;
        initView();
    }

    public void initView() {
        // Initial load of data
        refreshRegisteredAthletesTable();
        this.view.getFrame().setVisible(true);
    }

    public void initController() {
        view.getRefreshButton().addActionListener(e -> refreshRegisteredAthletesTable());
    }

    private void refreshRegisteredAthletesTable() {
        List<RegisteredAthleteDisplayDTO> athletes = model.getRegisteredAthletesForAllCompetitions();
        view.setRegisteredAthletesTable(athletes);
        SwingUtil.autoAdjustColumns(view.getRegisteredAthletesTable());
    }
}
