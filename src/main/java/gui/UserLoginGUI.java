package gui;

import dao.Sql2oUserDao;
import models.User;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import constants.Constants;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserLoginGUI extends JFrame{
    private JPanel mainPanel;
    private JTextField textUsername;
    private JPasswordField passwordField;
    private JButton loginButton;
    private String username,password;
    private Connection conn;

    public UserLoginGUI(String title){
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                username = textUsername.getText().trim();
                password = passwordField.getText().trim();
                logIn();
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new UserLoginGUI("Log In");
        frame.setVisible(true);

    }

    public void logIn(){
        Sql2o sql2o = new Sql2o(Constants.CONNECTION_URL, "louis", "23ARMIN23");
        conn = sql2o.open();

        Sql2oUserDao userDao = new Sql2oUserDao(sql2o);

        User loggedInUser = userDao.logIn(username,password);

        if(loggedInUser!=null) {
            //this.setVisible(false);
            this.dispose();
            System.out.println("logged in!");
            new TransactionGUI("Shopping Cart").setVisible(true);
        }else {
            System.out.println("NOT logged in!");
        }
    }



}
