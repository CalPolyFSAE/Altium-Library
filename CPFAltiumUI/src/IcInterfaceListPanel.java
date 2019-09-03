import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IcInterfaceListPanel extends BaseListPanel {
    public IcInterfaceListPanel(){
        super("IC-Interface");
        setupAddButtonListener();
    }

    protected void setupAddButtonListener(){
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addEditPanel = new IcInterfaceAddEditPanel(true);
                addEditFrame = new AddEditFrame("IC-Interface", addEditPanel);
                closeAddEditFrameListener();
            }
        });
    }

}
