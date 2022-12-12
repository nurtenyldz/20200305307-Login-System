package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Inheritance
public class ForgotPassword extends IDandPassword implements ActionListener{
    JFrame frame = new JFrame();
    JLabel forgotLabel = new JLabel("Enter your User Name to see your password");
    JTextField userIDField = new JTextField();
    JLabel userIDLabel = new JLabel("User Name:");
    JButton showButton = new JButton("Show Password");
    JButton backButton = new JButton("Back");
    JLabel messageLabel = new JLabel();



    ForgotPassword(){
        forgotLabel.setBounds(0,0,300,35);
        forgotLabel.setFont(new Font(null,Font.PLAIN,15));

        messageLabel.setBounds(125,250,250,35);
        messageLabel.setFont(new Font(null,Font.ITALIC,15));

        userIDField.setBounds(125,100,200,25);
        userIDLabel.setBounds(50,100,75,25);

        showButton.setBounds(125,150,200,25);
        showButton.setFocusable(false);
        showButton.addActionListener(this);
        showButton.setBackground(Color.decode("#D5D8DC"));

        backButton.setBounds(125,200,200,25);
        backButton.setFocusable(false);
        backButton.addActionListener(this);
        backButton.setBackground(Color.decode("#D5D8DC"));


        frame.add(forgotLabel);
        frame.add(messageLabel);
        frame.add(userIDField);
        frame.add(userIDLabel);
        frame.add(showButton);
        frame.add(backButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.decode("#FBFCFC"));
        frame.setLocation(550,150);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == showButton) {
            String userID = userIDField.getText();

            if (logininfo.containsKey(userID)) {
                if (logininfo.containsKey(userID)) {
                    messageLabel.setText("Your Password: " + logininfo.get(userID));
                }
            }else {
                messageLabel.setText("        Wrong User Name");
            }
        }

        if (e.getSource() == backButton){
            frame.dispose();
            LoginPage loginPage = new LoginPage(logininfo);
        }
    }
}
