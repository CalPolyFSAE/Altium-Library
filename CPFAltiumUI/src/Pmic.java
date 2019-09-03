import javax.swing.*;

public class Pmic extends BasePart{
    private Float iMax;
    private String packageString;

    public Float getiMax() {
        return iMax;
    }

    public String getPackageString() {
        return packageString;
    }

    public Pmic(PmicAddEditPanel panel){
        super(panel);

        this.iMax = Float.parseFloat(((JTextArea)panel.iMax.getInput()).getText());
        this.packageString = ((JTextArea)panel.packages.getInput()).getText();
    }

}
