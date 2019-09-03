import javax.swing.*;

public class InductorAddEditPanel extends BaseAddEditPanel {
    protected BaseAddEditPanel.LabelAndInput inductance = new BaseAddEditPanel.LabelAndInput(new JLabel("Inductance*:"), new JTextArea(1, 15));
    protected BaseAddEditPanel.LabelAndInput iMax = new BaseAddEditPanel.LabelAndInput(new JLabel("I Max(A)*:"), new JTextArea(1, 15));
    protected BaseAddEditPanel.LabelAndInput tolerance = new BaseAddEditPanel.LabelAndInput(new JLabel("Tolerence(%)*:"), new JTextArea(1, 15));
    protected BaseAddEditPanel.LabelAndInput resistance = new BaseAddEditPanel.LabelAndInput(new JLabel("Resistance:"), new JTextArea(1, 15));
    protected BaseAddEditPanel.LabelAndInput packages = new BaseAddEditPanel.LabelAndInput(new JLabel("Package:"), new JTextArea(1, 15));

    public InductorAddEditPanel(boolean isadd) {
        super("Capacitor");
        setupLabelsAndInputs();
    }

    public void setupLabelsAndInputs() {
        addBasicInput();

        addLabelAndInput(inductance);
        addLabelAndInput(iMax);
        addLabelAndInput(tolerance);
        addLabelAndInput(resistance);
        addLabelAndInput(packages);

        addLibraryFootprintInput();
    }

    @Override
    protected int addPartToDatabase() {
        InductorDao inductorDao = new DaoManager().getInductorDao();
        return inductorDao.insert(new Inductor(this));
    }

}
