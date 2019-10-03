import javax.swing.*;
import java.util.EventObject;

public class TopMenuEvent extends EventObject {
    private TopMenu.buttonTypes type;
    public TopMenuEvent(Object source, TopMenu.buttonTypes type){
        super(source);

        this.type = type;
    }

    public TopMenu.buttonTypes getButtonType(){
        return type;
    }

}

