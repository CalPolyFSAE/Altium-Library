import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConnectorListPanel extends BaseListPanel {
    public ConnectorListPanel(){
        super("Connector");
        setupAddButtonListener();
    }

    protected void setupAddButtonListener(){
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addEditPanel = new ConnectorAddEditPanel(true);
                addEditFrame = new AddEditFrame("Connector", addEditPanel);
                closeAddEditFrameListener();
            }
        });
    }
}
