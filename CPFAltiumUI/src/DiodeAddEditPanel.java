import javax.swing.*;

public class DiodeAddEditPanel extends BaseAddEditPanel{
    protected BaseAddEditPanel.LabelAndInput current  = new BaseAddEditPanel.LabelAndInput(new JLabel("Current(A)*:"), new JTextArea(1, 15));
    protected BaseAddEditPanel.LabelAndInput voltage = new BaseAddEditPanel.LabelAndInput(new JLabel("Voltage(V)*:"), new JTextArea(1, 15));
    protected BaseAddEditPanel.LabelAndInput type = new BaseAddEditPanel.LabelAndInput(new JLabel("Type*:"), new JComboBox(new String[]{"Gunn", "Laser", "Varactor", "Schottky", "Zener", "Tunnel", "PIN", "Photo", "Step Recovery"}));
    protected BaseAddEditPanel.LabelAndInput numcircuits = new BaseAddEditPanel.LabelAndInput(new JLabel("Number Circuits*:"), new JTextArea(1, 15));
    protected BaseAddEditPanel.LabelAndInput ic = new BaseAddEditPanel.LabelAndInput(new JLabel("IC(A)*:"), new JTextArea(1, 15));
    protected BaseAddEditPanel.LabelAndInput power = new BaseAddEditPanel.LabelAndInput(new JLabel("Power(W)*:"), new JTextArea(1, 15));
    protected BaseAddEditPanel.LabelAndInput packages = new BaseAddEditPanel.LabelAndInput(new JLabel("Package:"), new JTextArea(1, 15));

    public DiodeAddEditPanel(boolean isadd){
        super("Diode");
        setupLabelsAndInputs();
    }

    public void setupLabelsAndInputs()
    {
        addBasicInput();

        addLabelAndInput(current);
        addLabelAndInput(voltage);
        addLabelAndInput(type);
        addLabelAndInput(numcircuits);
        addLabelAndInput(ic);
        addLabelAndInput(power);
        addLabelAndInput(packages);

        addLibraryFootprintInput();
    }

    @Override
    protected int addPartToDatabase() {
        DiodeDao diodeDao = new DaoManager().getDiodeDao();
        return diodeDao.insert(new Diode(this));
    }
}
