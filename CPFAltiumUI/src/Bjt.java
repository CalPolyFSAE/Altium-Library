import javax.swing.*;

public class Bjt extends BasePart {
    private float current;
    private String  type;
    private float power;
    private float hfe;
    private float ic;
    private float vcemax;
    private String packageString;

    public float getCurrent() {
        return current;
    }

    public String getType() {
        return type;
    }

    public float getPower() {
        return power;
    }

    public float getHfe() {
        return hfe;
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

    public Bjt(BjtAddEditPanel panel){
        super(panel);

        this.current = Float.parseFloat(((JTextArea)panel.current.getInput()).getText());
        this.type = ((JComboBox)panel.type.getInput()).getSelectedItem().toString();
        this.power = Float.parseFloat(((JTextArea)panel.power.getInput()).getText());
        this.hfe = Float.parseFloat(((JTextArea)panel.hfe.getInput()).getText());
        this.ic = Float.parseFloat(((JTextArea)panel.ic.getInput()).getText());
        this.vcemax = Float.parseFloat(((JTextArea)panel.vceMax.getInput()).getText());
        this.packageString = ((JTextArea)panel.name.getInput()).getText();
    }

}

