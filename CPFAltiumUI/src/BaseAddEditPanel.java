import com.sun.crypto.provider.JceKeyStore;

import javax.swing.*;
import javax.swing.event.EventListenerList;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public abstract class BaseAddEditPanel extends JPanel  {
    GridBagConstraints gc;
    int x = 0;
    int y = 1;

    protected JLabel title;

    protected LabelAndInput name = new LabelAndInput(new JLabel("Name*:"), new JTextArea(1, 15));

    protected LabelAndInput quantity = new LabelAndInput(new JLabel("Quantity*:"), new JTextArea(1, 15));
    protected LabelAndInput description = new LabelAndInput(new JLabel("Desciption*:"), new JTextArea(1, 15));
    protected LabelAndInput libraryRef = new LabelAndInput(new JLabel("Library Ref*:"), new JTextArea(1, 15));
    protected LabelAndInput libraryPath = new LabelAndInput(new JLabel("Library Path*:"), new JFileChooser());
    protected LabelAndInput footprintRef = new LabelAndInput(new JLabel("Footprint Ref*:"), new JTextArea(1, 15));
    protected LabelAndInput footprintPath = new LabelAndInput(new JLabel("Foorprint Path*:"), new JFileChooser());
    protected LabelAndInput link = new LabelAndInput(new JLabel("Link:"), new JTextArea(1, 30));

    protected EventListenerList listenerList = new EventListenerList();
    JButton addBtn;

    public BaseAddEditPanel(String partname){
        super();
        setupBasics(partname);
        setupAddBtnListener();
    }

    public void addAddEditPanelListener(BasicListener eventListener){
        listenerList.add(BasicListener.class, eventListener);
    }

    public void addLabelAndInput(LabelAndInput labelAndInput){
        gc.anchor = GridBagConstraints.LINE_END;
        add(labelAndInput.getLabel(), gc);
        gc.anchor = GridBagConstraints.LINE_START;
        gc.gridx  +=1;
        add(labelAndInput.getInput(), gc);
        gc.gridx -=1;
        gc.gridy +=1 ;
    }

    protected void setupBasics(String partName)
    {
        this.setVisible(true);
        setLayout(new GridBagLayout());
        gc = new GridBagConstraints();
        gc.gridwidth = 1;
        gc.gridx = 0;
        gc.gridy = 0;
        gc.insets = new Insets(3,3,3,3);

        addBtn = new JButton("Add " + partName);
        addBtn.setPreferredSize(new Dimension(400,30));
        title = new JLabel("New " + partName);
    }

    class LabelAndInput{
        private JLabel label;
        private JComponent input;

        protected LabelAndInput(JLabel label, JComponent input){
            this.label = label;
            this.input = input;
        }

        public JLabel getLabel(){
            return this.label;
        }

        public JComponent getInput() {
           return input;
       }
    }

    protected void addBasicInput(){
        gc.gridx +=1;
        add(title, gc);
        gc.gridy +=1;
        addLabelAndInput(name);
    }

    protected void addLibraryFootprintInput(){
        addLabelAndInput(quantity);
        addLabelAndInput(description);
        addLabelAndInput(libraryRef);
        addLabelAndInput(libraryPath);
        addLabelAndInput(footprintRef);
        addLabelAndInput(footprintPath);
        addLabelAndInput(link);
        gc.gridx +=1;
        add(addBtn, gc);
    }

    private void setupAddBtnListener(){
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ret = addPartToDatabase();

                if(ret >0){
                    Object[] listeners = listenerList.getListenerList();

                    for (int i = 0; i < listeners.length; i = +2) {
                        if (listeners[i] == BasicListener.class) {
                            ((BasicListener) listeners[i + 1]).basicEventOccured();
                        }
                    }
                }
            }
        });
    }

    protected abstract int addPartToDatabase();
    protected abstract void setupLabelsAndInputs();


}
