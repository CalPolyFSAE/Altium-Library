import javax.swing.*;

public class Bjt extends BasePart {
    private String  type;
    private float power;
    private float ic;
    private float beta;
    private float vcemax;
    private String packageString;

    public String getType() {
        return type;
    }

    public float getPower() {
        return power;
    }

    public float getIc() {
        return ic;
    }

    public float getVcemax() {
        return vcemax;
    }

    public String getPackageString() {
        return packageString;
    }

    public float getBeta() {
        return beta;
    }

    public Bjt(BjtAddEditPanel panel){
        super(panel);

        this.type = ((JComboBox)panel.type.getInput()).getSelectedItem().toString();
        this.power = Float.parseFloat(((JTextArea)panel.power.getInput()).getText());
        this.ic = Float.parseFloat(((JTextArea)panel.ic.getInput()).getText());
        this.beta = Float.parseFloat(((JTextArea)panel.beta.getInput()).getText());
        this.vcemax = Float.parseFloat(((JTextArea)panel.vceMax.getInput()).getText());
        this.packageString = ((JTextArea)panel.name.getInput()).getText();
    }

}

