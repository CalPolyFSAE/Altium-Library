import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RelayListPanel extends BaseListPanel {
    public RelayListPanel(){
        super("Relay");
        setupAddButtonListener();
    }

    protected void setupAddButtonListener(){
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addEditPanel = new RelayAddEditPanel(true);
                addEditFrame = new AddEditFrame("Relay", addEditPanel);
                closeAddEditFrameListener();
            }
        });
    }
}
