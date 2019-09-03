import javax.swing.*;

public class RelayAddEditPanel extends BaseAddEditPanel{
    protected BaseAddEditPanel.LabelAndInput type  = new BaseAddEditPanel.LabelAndInput(new JLabel("Type*:"), new JTextArea(1, 15));
    protected BaseAddEditPanel.LabelAndInput contactForm = new BaseAddEditPanel.LabelAndInput(new JLabel("Contact Form*:"), new JTextArea(1, 15));
    protected BaseAddEditPanel.LabelAndInput current = new BaseAddEditPanel.LabelAndInput(new JLabel("Current (A)*:"), new JTextArea(1, 15));
    protected BaseAddEditPanel.LabelAndInput voltage = new BaseAddEditPanel.LabelAndInput(new JLabel("Voltage (V)*:"), new JTextArea(1, 15));
    protected BaseAddEditPanel.LabelAndInput flyback = new BaseAddEditPanel.LabelAndInput(new JLabel("Flyback*:"), new JTextArea(1, 15));
    protected BaseAddEditPanel.LabelAndInput mounting = new BaseAddEditPanel.LabelAndInput(new JLabel("Mounting*:"), new JTextArea(1, 15));
    protected BaseAddEditPanel.LabelAndInput packages = new BaseAddEditPanel.LabelAndInput(new JLabel("Package:"), new JTextArea(1, 15));

    public RelayAddEditPanel(boolean isadd){
        super("Relay");
        setupLabelsAndInputs();
    }

    public void setupLabelsAndInputs()
    {
        addBasicInput();

        addLabelAndInput(type);
        addLabelAndInput(contactForm);
        addLabelAndInput(current);
        addLabelAndInput(voltage);
        addLabelAndInput(flyback);
        addLabelAndInput(mounting);
        addLabelAndInput(packages);

        addLibraryFootprintInput();
    }

    @Override
    protected int addPartToDatabase() {
        RelayDao relayDao = new DaoManager().getRelayDao();
        return relayDao.insert(new Relay(this));
    }
}
