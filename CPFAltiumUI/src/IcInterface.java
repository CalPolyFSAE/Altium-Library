import javax.swing.*;

public class IcInterface extends BasePart{
    private String type;
    private String vcc;
    private String packageString;

    public String getType() {
        return type;
    }

    public String getVcc() {
        return vcc;
    }

    public String getPackageString() {
        return packageString;
    }

    public IcInterface(IcInterfaceAddEditPanel panel){
        super(panel);

        this.type = ((JTextArea)panel.type.getInput()).getText();
        this.vcc = ((JTextArea)panel.vcc.getInput()).getText();
        this.packageString = ((JTextArea)panel.packages.getInput()).getText();
    }
}
