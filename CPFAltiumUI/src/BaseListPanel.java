import com.sun.xml.internal.messaging.saaj.soap.JpegDataContentHandler;
import org.omg.CORBA.WStringSeqHelper;

import javax.swing.*;
import javax.swing.event.EventListenerList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public abstract class BaseListPanel extends JPanel{
    protected EventListenerList bjtListenerList = new EventListenerList();
    protected JButton addBtn;
    protected AddEditFrame addEditFrame;
    protected BaseAddEditPanel addEditPanel;

    public BaseListPanel(String componentName){
        setupBasics(componentName);
        addBtn = new JButton("Add " +componentName );
        this.add(addBtn);

    }

    protected void setupBasics(String componentName){
        this.setVisible(true);
        setBorder(BorderFactory.createTitledBorder(componentName+" List Page"));
    }

    protected void closeAddEditFrameListener(){
        addEditPanel.addAddEditPanelListener(new BasicListener() {
            @Override
            public void basicEventOccured() {
                addEditFrame.setVisible(false); //making the frame visible
                addEditFrame.dispose();
            }
        });
    }

    protected abstract void setupAddButtonListener();
}
