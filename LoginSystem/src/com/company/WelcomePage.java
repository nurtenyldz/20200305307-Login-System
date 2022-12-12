package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

//Inheritance
public class WelcomePage extends Logout implements IDatabase,ActionListener {

    HashMap<String,String> logininfo = new HashMap<String,String>();

    JFrame frame = new JFrame();
    JLabel welcomeLabel = new JLabel();
    JButton logoutButton = new JButton("Log out");

    WelcomePage() {

        welcomeLabel.setBounds(0, 0, 200, 35);
        welcomeLabel.setFont(new Font(null, Font.PLAIN, 25));

        logoutButton.setBounds(110, 250, 200, 25);
        logoutButton.setFocusable(false);
        logoutButton.setBackground(Color.decode("#D5D8DC"));


        frame.add(welcomeLabel);
        frame.add(logoutButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocation(550,150);

        // Generic collection - list
        ArrayList<String> list = new ArrayList<>();

        list.add("Nurten");
        list.add("Yıldız");
        list.add("Username");

        //list
        System.out.println("Users registered in the system : ");
        for (String s:list) {
            System.out.println(s);
        }

        logoutButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == logoutButton) {
                    frame.dispose();
                    LoginPage loginPage = new LoginPage(logininfo);
                    //polymorphism
                    executeAction();
                }
            }
        });
    }

    @Override
    public void log(String userID) {

        welcomeLabel.setText("Hello " + userID);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}