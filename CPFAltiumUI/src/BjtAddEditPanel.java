import javax.swing.*;

public class BjtAddEditPanel extends BaseAddEditPanel {
    protected LabelAndInput current  = new LabelAndInput(new JLabel("Current(A)*:"), new JTextArea(1, 15));
    protected LabelAndInput type = new LabelAndInput(new JLabel("Type*:"), new JComboBox(new String[]{"PNP", "NPN"}));
    protected LabelAndInput power = new LabelAndInput(new JLabel("Power(W)*:"), new JTextArea(1, 15));
    protected LabelAndInput hfe = new LabelAndInput(new JLabel("HFE*:"), new JTextArea(1, 15));
    protected LabelAndInput ic = new LabelAndInput(new JLabel("IC(A)*:"), new JTextArea(1, 15));
    protected LabelAndInput vceMax = new LabelAndInput(new JLabel("VCE Max(V)*:"), new JTextArea(1, 15));
    protected LabelAndInput packages = new LabelAndInput(new JLabel("Package:"), new JTextArea(1, 15));

    public BjtAddEditPanel(boolean isadd){
        super("BJT");
        setupLabelsAndInputs();
    }

    public void setupLabelsAndInputs()
    {
        addBasicInput();

        addLabelAndInput(current);
        addLabelAndInput(type);
        addLabelAndInput(power);
        addLabelAndInput(hfe);
        addLabelAndInput(ic);
        addLabelAndInput(vceMax);
        addLabelAndInput(packages);

        addLibraryFootprintInput();
    }

    @Override
    protected int addPartToDatabase() {
        BjtDao bjtDao = new DaoManager().getBjtDao();
        return bjtDao.insert(new Bjt(this));
    }

}
