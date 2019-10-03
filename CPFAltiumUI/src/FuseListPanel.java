import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FuseListPanel extends BaseListPanel {
    public FuseListPanel(){
        super("Fuse");
        setupAddButtonListener();
    }

    protected void setupAddButtonListener(){
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addEditPanel = new FuseAddEditPanel(true);
                addEditFrame = new AddEditFrame("Fuse", addEditPanel);
                closeAddEditFrameListener();
            }
        });
    }
}
