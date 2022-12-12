package com.company;

public class Main {

    public static void main(String[] args) {

        IDandPassword idandPassword = new IDandPassword();

        LoginPage loginPage = new LoginPage(idandPassword.getLoginInfo());

        genericClass<String> stringGeneric = new genericClass<String>("Welcome to Login System");

        System.out.println(stringGeneric.get());
    }
}