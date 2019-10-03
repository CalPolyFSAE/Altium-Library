import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResistorListPanel  extends BaseListPanel {
    public ResistorListPanel(){
        super("Resistor");
        setupAddButtonListener();
    }

    protected void setupAddButtonListener(){
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addEditPanel = new ResistorAddEditPanel(true);
                addEditFrame = new AddEditFrame("Resistor", addEditPanel);
                closeAddEditFrameListener();
            }
        });
    }
}
