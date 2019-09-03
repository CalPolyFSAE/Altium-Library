import javax.swing.*;

public class Relay extends BasePart{
    private String type ;
    private String contactForm;
    private float  current;
    private float voltage;
    private String flyback;
    private String mounting;
    private String packageString;

    public String getType() {
        return type;
    }

    public String getContactForm() {
        return contactForm;
    }

    public float getCurrent() {
        return current;
    }

    public float getVoltage() {
        return voltage;
    }

    public String getFlyback() {
        return flyback;
    }

    public String getMounting() {
        return mounting;
    }

    public String getPackageString() {
        return packageString;
    }

    public Relay(RelayAddEditPanel panel){
        super(panel);

        this.type = ((JTextArea)panel.type.getInput()).getText();
        this.contactForm = ((JTextArea)panel.contactForm.getInput()).getText();
        this.current = Float.parseFloat(((JTextArea)panel.current.getInput()).getText());
        this.voltage = Float.parseFloat(((JTextArea)panel.voltage.getInput()).getText());
        this.flyback = ((JTextArea)panel.flyback.getInput()).getText();
        this.mounting = ((JTextArea)panel.mounting.getInput()).getText();
        this.packageString = ((JTextArea)panel.packages.getInput()).getText();
    }
}
