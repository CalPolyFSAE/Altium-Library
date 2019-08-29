import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DiodeListPanel extends BaseListPanel {
    public DiodeListPanel(){
        super("Diode");
        setupAddButtonListener();
    }

    protected void setupAddButtonListener(){
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addEditPanel = new DiodeAddEditPanel(true);
                addEditFrame = new AddEditFrame("Diode", addEditPanel);
                closeAddEditFrameListener();
            }
        });
    }
}
