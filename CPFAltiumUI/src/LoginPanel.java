import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPanel extends JPanel {

    public LoginPanel(){
        this.setVisible(true);

        UserDao userDao = new DaoManager().getUserDao();

        String[] users = (String[])userDao.getUserNames().toArray(new String[0]);
        EditableDropDown userName = new EditableDropDown(users);

        JButton addButton = new JButton("Add User");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                UserDao userDao = new DaoManager().getUserDao();
                userDao.insert(userName.getSelectedItem().toString());
                DefaultData.name = userName.getSelectedItem().toString();
            }
        });

        JButton selectButton = new JButton("Select User");
        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                DefaultData.name = userName.getSelectedItem().toString();
            }
        });

        GridBagConstraints gc;
        this.setVisible(true);
        setLayout(new GridBagLayout());
        gc = new GridBagConstraints();
        gc.gridwidth = 1;
        gc.gridx = 0;
        gc.gridy = 0;
        gc.insets = new Insets(3,3,3,3);

        this.add(userName, gc);

        gc.gridy +=1;
        this.add(addButton, gc);
        gc.gridy +=1;

        this.add(selectButton, gc);



    }

}
