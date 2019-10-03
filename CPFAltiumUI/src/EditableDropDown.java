import javax.swing.*;

public class EditableDropDown extends JComboBox{

    public EditableDropDown(String[] options){
        super(new DefaultComboBoxModel(options));
        this.setEditable(true);
        this.setSelectedIndex(-1);
    }
}
