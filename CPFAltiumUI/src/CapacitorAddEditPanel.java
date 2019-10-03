import javax.swing.*;

public class CapacitorAddEditPanel extends BaseAddEditPanel{
    protected BaseAddEditPanel.LabelAndInput capacitance  = new BaseAddEditPanel.LabelAndInput(new JLabel("Capacitance*:"), new JTextArea(1, 15));
    protected BaseAddEditPanel.LabelAndInput voltage = new BaseAddEditPanel.LabelAndInput(new JLabel("Voltage(V)*:"), new JTextArea(1, 15));
    protected BaseAddEditPanel.LabelAndInput dielectric = new BaseAddEditPanel.LabelAndInput(new JLabel("Dielectric*:"), new JComboBox(new String[]{"Ceramic", "Air Gap", "Film", "Aluminum", "Polymer", "Other"}));
    protected BaseAddEditPanel.LabelAndInput percentTolerance = new BaseAddEditPanel.LabelAndInput(new JLabel("Percent Tolerance(%)*:"), new JTextArea(1, 15));
    protected BaseAddEditPanel.LabelAndInput esr = new BaseAddEditPanel.LabelAndInput(new JLabel("ESR*:"), new JTextArea(1, 15));
    protected BaseAddEditPanel.LabelAndInput packages = new BaseAddEditPanel.LabelAndInput(new JLabel("Package:"), new JTextArea(1, 15));

    public CapacitorAddEditPanel(boolean isadd){
        super("Capacitor");
        setupLabelsAndInputs();
    }

    public void setupLabelsAndInputs()
    {
        addBasicInput();

        addLabelAndInput(capacitance);
        addLabelAndInput(voltage);
        addLabelAndInput(dielectric);
        addLabelAndInput(percentTolerance);
        addLabelAndInput(esr);
        addLabelAndInput(packages);

        addLibraryFootprintInput();
    }

    @Override
    protected int addPartToDatabase() {
        CapacitorDao capacitorDao = new DaoManager().getCapacitorDao();
        return capacitorDao.insert(new Capacitor(this));
    }
}
