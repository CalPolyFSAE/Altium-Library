import javax.swing.*;

public class Fuse extends BasePart{
    private float iTrip;
    private float iInterupt;
    private float vMax;

    public float getiTrip() {
        return iTrip;
    }

    public float getiInterupt() {
        return iInterupt;
    }

    public float getvMax() {
        return vMax;
    }

    public Fuse(FuseAddEditPanel panel){
        super(panel);

        this.iTrip = Float.parseFloat(((JTextArea)panel.iTrip.getInput()).getText());
        this.iInterupt = Float.parseFloat(((JTextArea)panel.iInterupt.getInput()).getText());
        this.vMax = Float.parseFloat(((JTextArea)panel.vMax.getInput()).getText());
    }
}
