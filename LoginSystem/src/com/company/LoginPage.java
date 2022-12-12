package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.HashMap;

public class LoginPage implements ActionListener {

    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JButton forgotButton = new JButton("Forgot Password");
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIDLabel = new JLabel("User Name:");
    JLabel userPasswordLabel = new JLabel("Password:");
    JLabel messageLabel = new JLabel();
    JLabel loginLabel = new JLabel("Login System");


    HashMap<String,String> logininfo = new HashMap<String,String>();


    LoginPage(HashMap<String,String> loginInfoOriginal){
        logininfo = loginInfoOriginal;

        userIDLabel.setBounds(50,100,75,25);
        userPasswordLabel.setBounds(50,150,75,25);

        messageLabel.setBounds(125,300,250,35);
        messageLabel.setFont(new Font(null,Font.ITALIC, 15));

        loginLabel.setBounds(100,2, 500,70);
        loginLabel.setFont(new Font(null,Font.BOLD,35));

        userIDField.setBounds(125,100,200,25);
        userPasswordField.setBounds(125,150,200,25);

        loginButton.setBounds(125,200,100,25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);
        loginButton.setBackground(Color.decode("#D5D8DC"));


        resetButton.setBounds(225,200,100,25);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);
        resetButton.setBackground(Color.decode("#D5D8DC"));


        forgotButton.setBounds(125,250,200,25);
        forgotButton.setFocusable(false);
        forgotButton.addActionListener(this);
        forgotButton.setBackground(Color.decode("#D5D8DC"));



        frame.add(userIDLabel);
        frame.add(userPasswordLabel);
        frame.add(messageLabel);
        frame.add(loginLabel);
        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(loginButton);
        frame.add(resetButton);
        frame.add(forgotButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.decode("#FBFCFC"));
        frame.setLocation(550,150);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==forgotButton) {
            frame.dispose();
            ForgotPassword forgotPassword = new ForgotPassword();

        }
        if(e.getSource()==resetButton){
            userIDField.setText("");
            userPasswordField.setText("");
        }
        LocalDateTime localDateTime = LocalDateTime.now();
        //lambda
        resetButton.addActionListener(e1 -> System.out.println("Reset Successful at: " + localDateTime));


        if(e.getSource()==loginButton){
            String userID = userIDField.getText();
            String password = String.valueOf(userPasswordField.getPassword());

            if(logininfo.containsKey(userID)){
                if(logininfo.get(userID).equals(password)){
                    frame.dispose();
                    WelcomePage welcomePage = new WelcomePage();
                    welcomePage.log(userID);

                } else{
                    messageLabel.setForeground(Color.red);
                    messageLabel.setText("Wrong Username or Password");
                    //lambda
                    loginButton.addActionListener(e1 -> System.out.println("Login Unsuccessful at: " + localDateTime));
                }

            }
            else {
                messageLabel.setForeground(Color.red);
                messageLabel.setText("Wrong Username or Password");
                //lambda
                loginButton.addActionListener(e1 -> System.out.println("Login Unsuccessful at: " + localDateTime));
            }
        }
    }
}