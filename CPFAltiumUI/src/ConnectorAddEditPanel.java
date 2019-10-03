import javax.swing.*;

public class ConnectorAddEditPanel extends BaseAddEditPanel{
    protected BaseAddEditPanel.LabelAndInput numContacts  = new BaseAddEditPanel.LabelAndInput(new JLabel("Number Contacts*:"), new JTextArea(1, 15));
    protected BaseAddEditPanel.LabelAndInput numRows = new BaseAddEditPanel.LabelAndInput(new JLabel("Number Rows:"), new JTextArea(1, 15));
    protected BaseAddEditPanel.LabelAndInput pitch = new BaseAddEditPanel.LabelAndInput(new JLabel("Pitch:"), new JTextArea(1, 15));
    protected BaseAddEditPanel.LabelAndInput packages = new BaseAddEditPanel.LabelAndInput(new JLabel("Package:"), new JTextArea(1, 15));

    public ConnectorAddEditPanel(boolean isadd){
        super("Connector");
        setupLabelsAndInputs();
    }

    public void setupLabelsAndInputs()
    {
        addBasicInput();

        addLabelAndInput(numContacts);
        addLabelAndInput(numRows);
        addLabelAndInput(pitch);
        addLabelAndInput(packages);

        addLibraryFootprintInput();
    }

    @Override
    protected int addPartToDatabase() {
        ConnectorDao connectorDao = new DaoManager().getConnectorDao();
        return connectorDao.insert(new Connector(this));
    }
}
