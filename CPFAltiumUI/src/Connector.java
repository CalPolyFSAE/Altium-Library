import javax.swing.*;

public class Connector extends BasePart{
    private int numContacts ;
    private int numRows;
    private String  pitch;
    private String packageString;

    public int getNumContacts() {
        return numContacts;
    }

    public int getNumRows() {
        return numRows;
    }

    public String getPitch() {
        return pitch;
    }

    public String getPackageString() {
        return packageString;
    }

    public Connector(ConnectorAddEditPanel panel){
        super(panel);

        this.numContacts = Integer.parseInt(((JTextArea)panel.numContacts.getInput()).getText());
        this.numRows = Integer.parseInt(((JTextArea)panel.numRows.getInput()).getText());
        this.pitch = ((JTextArea)panel.pitch.getInput()).getText();
        this.packageString = ((JTextArea)panel.packages.getInput()).getText();
    }
}
