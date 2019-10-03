import javax.swing.*;

public class IcInterfaceAddEditPanel extends BaseAddEditPanel{
    protected BaseAddEditPanel.LabelAndInput type  = new BaseAddEditPanel.LabelAndInput(new JLabel("Type*:"), new JTextArea(1, 15));
    protected BaseAddEditPanel.LabelAndInput vcc = new BaseAddEditPanel.LabelAndInput(new JLabel("VCC*:"), new JTextArea(1, 15));
    protected BaseAddEditPanel.LabelAndInput packages = new BaseAddEditPanel.LabelAndInput(new JLabel("Package:"), new JTextArea(1, 15));

    public IcInterfaceAddEditPanel(boolean isadd){
        super("IC-Interface");
        setupLabelsAndInputs();
    }

    public void setupLabelsAndInputs()
    {
        addBasicInput();

        addLabelAndInput(type);
        addLabelAndInput(vcc);
        addLabelAndInput(packages);

        addLibraryFootprintInput();
    }

    @Override
    protected int addPartToDatabase() {
        IcInterfaceDao icInterfaceDao = new DaoManager().getIcInterfaceDao();
        return icInterfaceDao.insert(new IcInterface(this));
    }
}
