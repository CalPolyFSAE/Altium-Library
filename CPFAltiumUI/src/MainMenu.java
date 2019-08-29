import javax.swing.*;
import java.awt.*;

public class MainMenu extends JFrame{
    private JPanel mainPanel;
    private CardLayout cardLayout;
    private TopMenu topMenu;

    public MainMenu(String title){
        super(title);
        basicFrameSetup();
        setupTopMenu();
        setupMainPanel();
    }

    private void basicFrameSetup(){
        this.setSize(800,500);//400 width and 500 height
        this.setVisible(true);//making the frame visible
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void setupMainPanel(){
        cardLayout = new CardLayout();
        mainPanel = new JPanel();
        mainPanel.setLayout(cardLayout);

        mainPanel.add(new LoginPanel(), "LoginPanel");
        mainPanel.add(new BjtListPanel(), "BjtListPanel");
        mainPanel.add(new CapacitorListPanel(), "CapacitorListPanel");
        mainPanel.add(new ResistorListPanel(), "ResistorListPanel");
        mainPanel.add(new DiodeListPanel(), "DiodeListPanel");
        cardLayout.show(mainPanel,"LoginPage");
        this.add(mainPanel);

        setTopMenuListener();
    }

    private void setTopMenuListener(){
        topMenu.addTopMenuButtonListener(new TopMenuListener() {
            @Override
            public void topMenuEventOccured(TopMenuEvent e) {
                TopMenu.buttonTypes type  = e.getButtonType();
                if(DefaultData.name.equals("mysterio")){
                    return;
                }
                switch (type){
                    case Exit:
                        System.exit(1);
                    case BJT:
                        cardLayout.show(mainPanel, "BjtListPanel");
                        break;
                    case ButtonsSwitches:
                        break;
                    case Capacitors:
                        cardLayout.show(mainPanel, "CapacitorListPanel");
                        break;
                    case Connectors:
                        break;
                    case Crystals:
                        break;
                    case Diodes:
                        cardLayout.show(mainPanel, "DiodeListPanel");
                        break;
                    case Fets:
                        break;
                    case Fuses:
                        break;
                    case IcInterfaces:
                        break;
                    case IcMicrocontollers:
                        break;
                    case IcMisc:
                        break;
                    case Indcuctors:
                        break;
                    case LEDs:
                        break;
                    case OpAmps:
                        break;
                    case PmicLinear:
                        break;
                    case PmicSwitching:
                        break;
                    case Relays:
                        break;
                    case Resistors:
                        cardLayout.show(mainPanel, "ResistorListPanel");
                        break;
                    case Shunts:
                        break;
                    case Transformers:
                        break;
                    case Sellers:
                        break;
                    case Manfacturers:
                        break;
                }
            }
        });
    }

    private void setupTopMenu(){
        topMenu = new TopMenu();
        this.setJMenuBar(topMenu);
    }
}
