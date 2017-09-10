package com.geekz.pos.ui.controllers;

import com.geekz.pos.operation.TellerOperation;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class loginController
{

    public void pressButton(ActionEvent event)
    {
        System.out.println("Hello World");
    }

    @FXML
    private JFXButton btnClose;
    
    @FXML 
    private JFXTextField txtUsername;
    
    @FXML 
    private JFXPasswordField txtPassword;

    @FXML
    void clickClose(ActionEvent event)
    {
        System.exit(0);
    }
    
    @FXML
    void clickLogin(ActionEvent event)
    {
    	String username = txtUsername.getText();
    	String password = txtPassword.getText();
    	System.out.println(username +" - " + password);
    	
    	TellerOperation teller = new TellerOperation();
    	boolean loginResult = teller.login(username, password);
    	
    	System.out.println("Login Effort - "+ loginResult);
    }
}
