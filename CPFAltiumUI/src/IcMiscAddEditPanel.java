import javax.swing.*;

public class IcMiscAddEditPanel extends BaseAddEditPanel{
    protected BaseAddEditPanel.LabelAndInput vcc  = new BaseAddEditPanel.LabelAndInput(new JLabel("VCC:"), new JTextArea(1, 15));
    protected BaseAddEditPanel.LabelAndInput voltageInMax = new BaseAddEditPanel.LabelAndInput(new JLabel("Voltage In Max(V):"), new JTextArea(1, 15));
    protected BaseAddEditPanel.LabelAndInput packages = new BaseAddEditPanel.LabelAndInput(new JLabel("Package:"), new JTextArea(1, 15));

    public IcMiscAddEditPanel(boolean isadd){
        super("IC-Misc");
        setupLabelsAndInputs();
    }

    public void setupLabelsAndInputs()
    {
        addBasicInput();

        addLabelAndInput(vcc);
        addLabelAndInput(voltageInMax);
        addLabelAndInput(packages);

        addLibraryFootprintInput();
    }

    @Override
    protected int addPartToDatabase() {
        IcMiscDao icMiscDao = new DaoManager().getIcMiscDao();
        return icMiscDao.insert(new IcMisc(this));
    }
}
