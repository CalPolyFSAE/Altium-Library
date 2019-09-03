import javax.swing.*;

public class FuseAddEditPanel extends BaseAddEditPanel{
    protected BaseAddEditPanel.LabelAndInput iTrip  = new BaseAddEditPanel.LabelAndInput(new JLabel("I Trip (A)*:"), new JTextArea(1, 15));
    protected BaseAddEditPanel.LabelAndInput iInterupt = new BaseAddEditPanel.LabelAndInput(new JLabel("I Interupt (A)*:"), new JTextArea(1, 15));
    protected BaseAddEditPanel.LabelAndInput vMax = new BaseAddEditPanel.LabelAndInput(new JLabel("V Max (V)*:"), new JTextArea(1, 15));

    public FuseAddEditPanel(boolean isadd){
        super("Fuse");
        setupLabelsAndInputs();
    }

    public void setupLabelsAndInputs()
    {
        addBasicInput();

        addLabelAndInput(iTrip);
        addLabelAndInput(iInterupt);

        addLabelAndInput(vMax);

        addLibraryFootprintInput();
    }

    @Override
    protected int addPartToDatabase() {
        FuseDao fuseDao = new DaoManager().getFuseDao();
        return fuseDao.insert(new Fuse(this));
    }
}
