import javafx.scene.control.ButtonType;

import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;
import javax.swing.event.EventListenerList;
import javax.swing.tree.ExpandVetoException;
import java.lang.Object.*;
import java.util.HashMap;

public class TopMenu extends JMenuBar {
    JMenu helpMenuDropdown = new JMenu("Help");;
    JMenu componentMenuDropdown = new JMenu("Components");;
    JMenu sellManMenuDropdown = new JMenu("Sellers/Manufacturers");;

    private EventListenerList bjtListenerList = new EventListenerList();

    public enum buttonTypes
    {
        Exit,

        BJT,
        ButtonsSwitches,
        Capacitors,
        Connectors,
        Crystals,
        Diodes,
        Fets,
        Fuses,
        IcInterfaces,
        IcMicrocontollers,
        IcMisc,
        Indcuctors,
        OpAmps,
        Pmic,
        Relays,
        Resistors,
        Shunts,
        Transformers,

        Sellers,
        Manfacturers
    }

    public HashMap<buttonTypes, String> buttonTypesDict = new HashMap<buttonTypes, String>(){{
        put(buttonTypes.Exit, "Exit");

        put(buttonTypes.BJT, "BJT");
        put(buttonTypes.ButtonsSwitches,  "Buttons and Switches");
        put(buttonTypes.Capacitors, "Capacitors");
        put(buttonTypes.Connectors, "Connectors");
        put(buttonTypes.Crystals, "Crystals");
        put(buttonTypes.Diodes, "Diodes");
        put(buttonTypes.Fets, "Fets");
        put(buttonTypes.Fuses, "Fuses");
        put(buttonTypes.IcInterfaces, "IC-Interfaces");
        put(buttonTypes.IcMicrocontollers, "IC-Microcontollers");
        put(buttonTypes.IcMisc, "IC-Misc");
        put(buttonTypes.Indcuctors, "Inductors");
        put(buttonTypes.OpAmps, "OpAmps");
        put(buttonTypes.Pmic, "PMIC");
        put(buttonTypes.Relays, "Relays");
        put(buttonTypes.Resistors, "Resistors");
        put(buttonTypes.Shunts, "Shunts");
        put(buttonTypes.Transformers, "Transformers");

        put(buttonTypes.Sellers, "Sellers");
        put(buttonTypes.Manfacturers, "Manfacturers");
    }};

    public TopMenu(){
        //Add Help Menu Sections
        addMenuItem(helpMenuDropdown, buttonTypes.Exit);

        addMenuItem(componentMenuDropdown, buttonTypes.BJT);
        addMenuItem(componentMenuDropdown, buttonTypes.ButtonsSwitches);
        addMenuItem(componentMenuDropdown, buttonTypes.Capacitors);
        addMenuItem(componentMenuDropdown, buttonTypes.Connectors);
        addMenuItem(componentMenuDropdown, buttonTypes.Crystals);
        addMenuItem(componentMenuDropdown, buttonTypes.Diodes);
        addMenuItem(componentMenuDropdown, buttonTypes.Fets);
        addMenuItem(componentMenuDropdown, buttonTypes.Fuses);
        addMenuItem(componentMenuDropdown, buttonTypes.IcInterfaces);
        addMenuItem(componentMenuDropdown, buttonTypes.IcMicrocontollers);
        addMenuItem(componentMenuDropdown, buttonTypes.IcMisc);
        addMenuItem(componentMenuDropdown, buttonTypes.Indcuctors);
        addMenuItem(componentMenuDropdown, buttonTypes.OpAmps);
        addMenuItem(componentMenuDropdown, buttonTypes.Pmic);
        addMenuItem(componentMenuDropdown, buttonTypes.Relays);
        addMenuItem(componentMenuDropdown, buttonTypes.Resistors);
        addMenuItem(componentMenuDropdown, buttonTypes.Shunts);
        addMenuItem(componentMenuDropdown, buttonTypes.Transformers);

        addMenuItem(sellManMenuDropdown, buttonTypes.Sellers);
        addMenuItem(sellManMenuDropdown, buttonTypes.Manfacturers);

        this.add(helpMenuDropdown);
        this.add(componentMenuDropdown);
        this.add(sellManMenuDropdown);
    }

    private void addMenuItem(JMenu menu, buttonTypes type){
        JMenuItem item = new JMenuItem(buttonTypesDict.get(type));
        menu.add(item);
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] listeners = bjtListenerList.getListenerList();
                for(int i=0; i < listeners.length; i=+2){
                    ((TopMenuListener)listeners[i+1]).topMenuEventOccured(new TopMenuEvent(this, type));
                }
            }
        });
    }

    public void addTopMenuButtonListener(TopMenuListener eventListener){
        bjtListenerList.add(TopMenuListener.class, eventListener);
    }



}
