package com.geekz.pos.ui.controllers;

import java.io.IOException;

import com.geekz.pos.operation.TellerOperation;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
    void clickLogin(ActionEvent event) throws IOException
    {
    	String username = txtUsername.getText();
    	String password = txtPassword.getText();
    	System.out.println(username +" - " + password);
    	
    	TellerOperation teller = new TellerOperation();
    	boolean loginResult = teller.login(username, password);
    	
    	System.out.println("Login Effort - "+ loginResult);
    	if(loginResult)
    	{
    		Parent grindItemParent = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/customerSelection.fxml"));
    		Scene grindItemScene = new Scene(grindItemParent);
    	
    		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    		window.setScene(grindItemScene);
    		window.show();
    	}
    }
}
