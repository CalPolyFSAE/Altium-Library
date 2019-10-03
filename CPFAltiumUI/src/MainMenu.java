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
        mainPanel.add(new FetListPanel(), "FetListPanel");
        mainPanel.add(new PmicListPanel(), "PmicListPanel");
        mainPanel.add(new FuseListPanel(), "FuseListPanel");
        mainPanel.add(new IcMiscListPanel(), "IcMiscListPanel");
        mainPanel.add(new ConnectorListPanel(), "ConnectorListPanel");
        mainPanel.add(new IcInterfaceListPanel(), "IcInterfaceListPanel");
        mainPanel.add(new InductorListPanel(), "InductorListPanel");
        mainPanel.add(new RelayListPanel(), "RelayListPanel");

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
                        cardLayout.show(mainPanel, "ConnectorListPanel");
                        break;
                    case Crystals:
                        break;
                    case Diodes:
                        cardLayout.show(mainPanel, "DiodeListPanel");
                        break;
                    case Fets:
                        cardLayout.show(mainPanel, "FetListPanel");
                        break;
                    case Fuses:
                        cardLayout.show(mainPanel, "FuseListPanel");
                        break;
                    case IcInterfaces:
                        cardLayout.show(mainPanel, "IcInterfaceListPanel");
                        break;
                    case IcMicrocontollers:
                        break;
                    case IcMisc:
                        cardLayout.show(mainPanel, "IcMiscListPanel");
                        break;
                    case Indcuctors:
                        cardLayout.show(mainPanel, "InductorListPanel");
                        break;
                    case OpAmps:
                        break;
                    case Pmic:
                        cardLayout.show(mainPanel, "PmicListPanel");
                        break;
                    case Relays:
                        cardLayout.show(mainPanel, "RelayListPanel");
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
