package com.geekz.pos.ui.controllers;

import com.jfoenix.controls.JFXButton;
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
    void clickClose(ActionEvent event)
    {
        System.exit(0);
    }
}
