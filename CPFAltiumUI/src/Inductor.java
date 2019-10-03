import javax.swing.*;

public class Inductor extends BasePart{
    private String inductance ;
    private float iMax;
    private float  tolerance;
    private String resistance;
    private String packageString;

    public String getInductance() {
        return inductance;
    }

    public float getiMax() {
        return iMax;
    }

    public float getTolerance() {
        return tolerance;
    }

    public String getResistance() {
        return resistance;
    }

    public String getPackageString() {
        return packageString;
    }

    public Inductor(InductorAddEditPanel panel){
        super(panel);

        this.inductance = ((JTextArea)panel.inductance.getInput()).getText();
        this.iMax = Float.parseFloat(((JTextArea)panel.iMax.getInput()).getText());
        this.tolerance = Float.parseFloat(((JTextArea)panel.tolerance.getInput()).getText());
        this.resistance = ((JTextArea)panel.resistance.getInput()).getText();
        this.packageString = ((JTextArea)panel.packages.getInput()).getText();
    }
}
