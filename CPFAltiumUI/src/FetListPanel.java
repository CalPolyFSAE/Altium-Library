import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FetListPanel extends BaseListPanel {
    public FetListPanel(){
        super("FET");
        setupAddButtonListener();
    }

    protected void setupAddButtonListener(){
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addEditPanel = new FetAddEditPanel(true);
                addEditFrame = new AddEditFrame("FET", addEditPanel);
                closeAddEditFrameListener();
            }
        });
    }
}
