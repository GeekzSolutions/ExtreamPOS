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
import javafx.stage.Stage;

public class transactionSummaryController {

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
    private JFXButton btnPrintBill;

    @FXML
    private JFXButton btnPrintBarCode;

    @FXML
    private Label lblTransactionID;

    @FXML
    private Label lblAmount;

    @FXML
    private Label lblTotalCharge;

    @FXML
    private Label lblNoofItems;

    @FXML
    void QuickLaunchSearch(ActionEvent event) 
    {
    	
    }

    @FXML
    void clickClose(ActionEvent event) throws IOException
    {
    	Parent grindItemParent = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/grindItem.fxml"));
		Scene grindItemScene = new Scene(grindItemParent);
	
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(grindItemScene);
		window.show();
    }

    @FXML
    void clickMinimize(ActionEvent event) 
    {
    	
    }

    @FXML
    void clickPrintBarCode(ActionEvent event) 
    {
    	
    }

    @FXML
    void clickPrintBill(ActionEvent event) 
    {
    	
    }

}
