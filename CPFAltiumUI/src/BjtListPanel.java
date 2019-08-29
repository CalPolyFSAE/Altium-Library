import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BjtListPanel extends BaseListPanel {

    public BjtListPanel(){
        super("BJT");
        setupAddButtonListener();
    }

    protected void setupAddButtonListener(){
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addEditPanel = new BjtAddEditPanel(true);
                addEditFrame = new AddEditFrame("BJT", addEditPanel);
                closeAddEditFrameListener();
            }
        });
    }
}
