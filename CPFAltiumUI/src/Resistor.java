import javax.swing.*;

public class Resistor extends BasePart{
    private String resistance ;
    private float percentTolerance;
    private String power;
    private String packageString;

    public String getResistance() {
        return resistance;
    }

    public float getPercentTolerance() {
        return percentTolerance;
    }

    public String getPower() {
        return power;
    }

    public String getPackageString() {
        return packageString;
    }

    public Resistor(ResistorAddEditPanel panel){
        super(panel);

        this.resistance = ((JTextArea)panel.resistance.getInput()).getText();
        this.percentTolerance = Float.parseFloat(((JTextArea)panel.percentTolerance.getInput()).getText());
        this.power = ((JTextArea)panel.power.getInput()).getText();
        this.packageString = ((JTextArea)panel.packages.getInput()).getText();
    }
}
