import javax.swing.*;

public class IcMisc extends BasePart{
    private String vcc;
    private Float  voltageInMax;
    private String packageString;

    public String getVcc() {
        return vcc;
    }

    public Float getVoltageInMax() {
        return voltageInMax;
    }

    public String getPackageString() {
        return packageString;
    }

    public IcMisc(IcMiscAddEditPanel panel){
        super(panel);

        this.vcc = ((JTextArea)panel.vcc.getInput()).getText();
        this.voltageInMax = Float.parseFloat(((JTextArea)panel.voltageInMax.getInput()).getText());
        this.packageString = ((JTextArea)panel.packages.getInput()).getText();
    }
}
