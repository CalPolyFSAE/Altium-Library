import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InductorListPanel extends BaseListPanel {
    public InductorListPanel(){
        super("Inductor");
        setupAddButtonListener();
    }

    protected void setupAddButtonListener(){
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addEditPanel = new InductorAddEditPanel(true);
                addEditFrame = new AddEditFrame("Inductor", addEditPanel);
                closeAddEditFrameListener();
            }
        });
    }
}
