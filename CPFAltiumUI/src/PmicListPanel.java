import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PmicListPanel extends BaseListPanel {
    public PmicListPanel(){
        super("PMIC");
        setupAddButtonListener();
    }

    protected void setupAddButtonListener(){
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addEditPanel = new PmicAddEditPanel(true);
                addEditFrame = new AddEditFrame("PMIC", addEditPanel);
                closeAddEditFrameListener();
            }
        });
    }
}
