package com.geekz.pos.ui.controllers;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class grindItemController {

    @FXML
    private ImageView imgTellerImage;

    @FXML
    private Label lblTellersName;

    @FXML
    private JFXButton btnClose;

    @FXML
    private JFXButton btnMinimize;

    @FXML
    private JFXTextField txtQuickLaunch;

    @FXML
    private JFXTextField txtAmount;

    @FXML
    private JFXComboBox<?> cmbItemID;

    @FXML
    private JFXComboBox<?> cmbItemName;

    @FXML
    private Label lblUnitPrice;

    @FXML
    private Label lblTotalPrice;

    @FXML
    private JFXTextField txtDiscount;

    @FXML
    private JFXButton btnSubmit;

    @FXML
    private JFXButton btnProceed;

    @FXML
    void QuickLaunchSearch(ActionEvent event) 
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
    void clickProceed(ActionEvent event) throws IOException
    {
    	Parent grindItemParent = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/transactionSummary.fxml"));
		Scene grindItemScene = new Scene(grindItemParent);
	
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(grindItemScene);
		window.show();
    }

    @FXML
    void clickSubmit(ActionEvent event) 
    {

    }

}
