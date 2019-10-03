import javax.swing.*;

public class Diode extends BasePart{
    private float current;
    private float voltage;
    private String  type;
    private int numcircuits;
    private float ic;
    private float power;
    private String packageString;

    public float getCurrent() {
        return current;
    }

    public float getVoltage() {
        return voltage;
    }

    public String getType() {
        return type;
    }

    public int getNumcircuits() {
        return numcircuits;
    }

    public float getIc() {
        return ic;
    }

    public float getPower() {
        return power;
    }

    public String getPackageString() {
        return packageString;
    }

    public Diode(DiodeAddEditPanel panel){
            super(panel);

            this.current = Float.parseFloat(((JTextArea)panel.current.getInput()).getText());
            this.voltage = Float.parseFloat(((JTextArea)panel.voltage.getInput()).getText());
            this.type = ((JComboBox)panel.type.getInput()).getSelectedItem().toString();
            this.numcircuits = Integer.parseInt(((JTextArea)panel.numcircuits.getInput()).getText());
            this.ic = Float.parseFloat(((JTextArea)panel.ic.getInput()).getText());
            this.packageString = ((JTextArea)panel.name.getInput()).getText();
        }
}
