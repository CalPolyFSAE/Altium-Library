import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CapacitorListPanel extends BaseListPanel {
    public CapacitorListPanel(){
        super("Capacitor");
        setupAddButtonListener();
    }

    protected void setupAddButtonListener(){
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addEditPanel = new CapacitorAddEditPanel(true);
                addEditFrame = new AddEditFrame("Capacitor", addEditPanel);
                closeAddEditFrameListener();
            }
        });
    }
}
