package com.geekz.pos.ui.controllers;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class customerSelectionController {

    @FXML
    private Pane NewCustomerPane;

    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXButton btnCancel;

    @FXML
    private JFXButton btnClear;

    @FXML
    private JFXButton btnNewCustomer;

    @FXML
    private JFXButton btnRegisterCustomer;

    @FXML
    private JFXButton btnSkip;

    @FXML
    private ImageView imgTellerImage;

    @FXML
    private Label btnTellersName;

    @FXML
    private JFXButton btnClose;

    @FXML
    private JFXButton btnMinimize;

    @FXML
    private JFXTextField txtQuickLaunch;

    @FXML
    void QuickLaunchSearch(ActionEvent event) 
    {

    }

    @FXML
    void clickCancel(ActionEvent event) 
    {

    }

    @FXML
    void clickClear(ActionEvent event) 
    {

    }

    @FXML
    void clickClose(ActionEvent event) 
    {
    	System.exit(0);
    }

    @FXML
    void clickMinimize(ActionEvent event) 
    {

    }

    @FXML
    void clickNewCustomer(ActionEvent event) 
    {

    }

    @FXML
    void clickRegisterCustomer(ActionEvent event) 
    {

    }

    @FXML
    void clickSave(ActionEvent event) 
    {

    }

    @FXML
    void clickSkip(MouseEvent event) throws IOException 
    {
    	Parent grindItemParent = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/grindItem.fxml"));
		Scene grindItemScene = new Scene(grindItemParent);
	
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(grindItemScene);
		window.show();
    }

}
