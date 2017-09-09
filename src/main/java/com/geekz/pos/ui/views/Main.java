package com.geekz.pos.ui.views;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application
{
    private double xOffset = 0;
    private double yOffset = 0;

    @SuppressWarnings("restriction")
	@Override
    public void start(final Stage primaryStage) throws Exception
    {
        try
        {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/itemsCart.fxml"));
            //remove window borders
            primaryStage.initStyle(StageStyle.UNDECORATED);
            //make window movable
            root.setOnMousePressed(new EventHandler<MouseEvent>(){
                public void handle(MouseEvent event) {
                    xOffset = event.getSceneX();
                    yOffset = event.getSceneY();
                    primaryStage.setOpacity(0.5);
                }
            });
            root.setOnMouseDragged(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent event) {
                    primaryStage.setX(event.getScreenX() - xOffset);
                    primaryStage.setY(event.getScreenY() - yOffset);
                }
            });

            root.setOnMouseReleased(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent event) {
                    primaryStage.setOpacity(1.0);
                }
            });

            //create a scene
            Scene scene = new Scene(root);
            scene.setFill(Color.TRANSPARENT);

            primaryStage.initStyle(StageStyle.TRANSPARENT);
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        catch (Exception ex)
        {
            System.out.println(ex.toString());
        }

    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
