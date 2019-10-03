import javax.lang.model.type.IntersectionType;
import javax.swing.*;

public class Fet extends BasePart{
 private String type;
    private float vdsmax;
    private int  numcircuits;
    private float current;
    private String rdson;
    private float vt;
    private float vgsmax;
    private String packageString;

    public String getType() {
        return type;
    }

    public float getVdsmax() {
        return vdsmax;
    }

    public int getNumcircuits() {
        return numcircuits;
    }

    public float getCurrent() {
        return current;
    }

    public String getRdson() {
        return rdson;
    }

    public float getVt() {
        return vt;
    }

    public float getVgsmax() {
        return vgsmax;
    }

    public String getPackageString() {
        return packageString;
    }

    public Fet(FetAddEditPanel panel){
        super(panel);

        this.type = ((JComboBox)panel.type.getInput()).getSelectedItem().toString();
        this.vdsmax = Float.parseFloat(((JTextArea)panel.vdsmax.getInput()).getText());
        this.numcircuits = Integer.parseInt(((JTextArea)panel.numcircuits.getInput()).getText());
        this.current = Integer.parseInt(((JTextArea)panel.current.getInput()).getText());
        this.rdson = ((JTextArea)panel.rdson.getInput()).getText();
        this.vt = Integer.parseInt(((JTextArea)panel.vt.getInput()).getText());
        this.vgsmax = Integer.parseInt(((JTextArea)panel.vgsmax.getInput()).getText());
        this.packageString = ((JTextArea)panel.packages.getInput()).getText();
    }

}
