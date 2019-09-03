import javax.swing.*;

public class PmicAddEditPanel extends BaseAddEditPanel{
    protected BaseAddEditPanel.LabelAndInput iMax  = new BaseAddEditPanel.LabelAndInput(new JLabel("I Max (A)*:"), new JTextArea(1, 15));
   protected BaseAddEditPanel.LabelAndInput packages = new BaseAddEditPanel.LabelAndInput(new JLabel("Package:"), new JTextArea(1, 15));

    public PmicAddEditPanel(boolean isadd){
        super("Capacitor");
        setupLabelsAndInputs();
    }

    public void setupLabelsAndInputs()
    {
        addBasicInput();

        addLabelAndInput(iMax);
        addLabelAndInput(packages);

        addLibraryFootprintInput();
    }

    @Override
    protected int addPartToDatabase() {
        PmicDao pmicDao = new DaoManager().getPmicDao();
        return pmicDao.insert(new Pmic(this));
    }
}
