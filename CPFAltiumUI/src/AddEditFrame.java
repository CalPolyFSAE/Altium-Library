import javax.swing.*;
import java.awt.*;

public class AddEditFrame extends JFrame{

    public AddEditFrame(String title, BaseAddEditPanel panel){
        super(title);
        setupBasics(panel);
    }

    private void setupBasics(JPanel panel){
        setLayout(new BorderLayout());
        Container c = new Container();
        JScrollPane jScrollPane = new JScrollPane(panel);
        jScrollPane.getVerticalScrollBar().setUnitIncrement(16);
        add(jScrollPane, BorderLayout.CENTER);
        pack();

        this.setSize(650,600);//400 width and 500 height
        this.setVisible(true);//making the frame visible
    }
}
