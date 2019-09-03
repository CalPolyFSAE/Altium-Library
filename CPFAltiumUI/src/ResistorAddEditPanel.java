import javax.swing.*;

public class ResistorAddEditPanel extends BaseAddEditPanel{
    protected BaseAddEditPanel.LabelAndInput resistance  = new BaseAddEditPanel.LabelAndInput(new JLabel("Resistance*:"), new JTextArea(1, 15));
    protected BaseAddEditPanel.LabelAndInput percentTolerance = new BaseAddEditPanel.LabelAndInput(new JLabel("Percent Tolerance(V)*:"), new JTextArea(1, 15));
    protected BaseAddEditPanel.LabelAndInput power = new BaseAddEditPanel.LabelAndInput(new JLabel("Power*:"), new JTextArea(1, 15));
   protected BaseAddEditPanel.LabelAndInput packages = new BaseAddEditPanel.LabelAndInput(new JLabel("Package:"), new JTextArea(1, 15));

    public ResistorAddEditPanel(boolean isadd){
        super("PMIC");
        setupLabelsAndInputs();
    }

    public void setupLabelsAndInputs()
    {
        addBasicInput();

        addLabelAndInput(resistance);
        addLabelAndInput(percentTolerance);
        addLabelAndInput(power);
        addLabelAndInput(packages);

        addLibraryFootprintInput();
    }

    @Override
    protected int addPartToDatabase() {
        ResistorDao resistorDao = new DaoManager().getResistorDao();
        return resistorDao.insert(new Resistor(this));
    }
}
