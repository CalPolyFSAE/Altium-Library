import javax.swing.*;

public class FetAddEditPanel extends BaseAddEditPanel{
    protected BaseAddEditPanel.LabelAndInput type = new BaseAddEditPanel.LabelAndInput(new JLabel("Type*:"), new JComboBox(new String[]{"N_Channel", "V_Channel", "Other", "NA"}));
    protected BaseAddEditPanel.LabelAndInput vdsmax  = new BaseAddEditPanel.LabelAndInput(new JLabel("VDS Max (V)*:"), new JTextArea(1, 15));
    protected BaseAddEditPanel.LabelAndInput numcircuits = new BaseAddEditPanel.LabelAndInput(new JLabel("Number Circuits*:"), new JTextArea(1, 15));
    protected BaseAddEditPanel.LabelAndInput current = new BaseAddEditPanel.LabelAndInput(new JLabel("Current(A)*:"), new JTextArea(1, 15));
    protected BaseAddEditPanel.LabelAndInput rdson = new BaseAddEditPanel.LabelAndInput(new JLabel("RDS On"), new JTextArea(1, 15));
    protected BaseAddEditPanel.LabelAndInput vt = new BaseAddEditPanel.LabelAndInput(new JLabel("VT (V)*:"), new JTextArea(1, 15));
    protected BaseAddEditPanel.LabelAndInput vgsmax = new BaseAddEditPanel.LabelAndInput(new JLabel("VGS Max*:"), new JTextArea(1, 15));
    protected BaseAddEditPanel.LabelAndInput packages = new BaseAddEditPanel.LabelAndInput(new JLabel("Package:"), new JTextArea(1, 15));

    public FetAddEditPanel(boolean isadd){
        super("FET");
        setupLabelsAndInputs();
    }

    public void setupLabelsAndInputs()
    {
        addBasicInput();

        addLabelAndInput(type);
        addLabelAndInput(vdsmax);
        addLabelAndInput(numcircuits);
        addLabelAndInput(current);
        addLabelAndInput(rdson);
        addLabelAndInput(vt);
        addLabelAndInput(vgsmax);
        addLabelAndInput(packages);

        addLibraryFootprintInput();
    }
    @Override
    protected int addPartToDatabase() {
        FetDao fetDao = new DaoManager().getFetDao();
        return fetDao.insert(new Fet(this));

    }
}
