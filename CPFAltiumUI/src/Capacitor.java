import javax.swing.*;

public class Capacitor extends BasePart{
    private String capacitance ;
    private float voltage;
    private String  dielectric;
    private float percentTolerance;
    private String esr;
    private String packageString;

    public String getCapacitance() {
        return capacitance;
    }

    public float getVoltage() {
        return voltage;
    }

    public String getDielectric() {
        return dielectric;
    }

    public float getPercentTolerance() {
        return percentTolerance;
    }

    public String getEsr() {
        return esr;
    }

    public String getPackageString() {
        return packageString;
    }

    public Capacitor(CapacitorAddEditPanel panel){
        super(panel);

        this.capacitance = ((JTextArea)panel.capacitance.getInput()).getText();
        this.voltage = Float.parseFloat(((JTextArea)panel.voltage.getInput()).getText());
        this.dielectric = ((JComboBox)panel.dielectric.getInput()).getSelectedItem().toString();
        this.percentTolerance = Float.parseFloat(((JTextArea)panel.percentTolerance.getInput()).getText());
        this.esr = ((JTextArea)panel.esr.getInput()).getText();
        this.packageString = ((JTextArea)panel.name.getInput()).getText();
    }
}
