import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IcMiscListPanel extends BaseListPanel {
    public IcMiscListPanel(){
        super("IC-Misc");
        setupAddButtonListener();
    }

    protected void setupAddButtonListener(){
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addEditPanel = new IcMiscAddEditPanel(true);
                addEditFrame = new AddEditFrame("IC-Misc", addEditPanel);
                closeAddEditFrameListener();
            }
        });
    }
}
