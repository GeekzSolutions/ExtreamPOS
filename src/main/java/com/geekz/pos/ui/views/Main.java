package com.geekz.pos.ui.views;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;

import com.geekz.orm.GeekzORM;
import com.geekz.orm.ORMFactory;
import com.geekz.pos.controller.*;
import com.geekz.pos.model.Client;
import com.geekz.pos.model.ClientOrder;
import com.geekz.pos.model.ItemRepo;
import com.geekz.pos.model.Teller;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
	private double xOffset = 0;
	private double yOffset = 0;

	@Override
	public void start(final Stage primaryStage) throws Exception {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getClassLoader().getResource("fxml/login.fxml"));
			Parent root = loader.load();
			/* Parent root = FXMLLoader.load(); */
			// remove window borders
			primaryStage.initStyle(StageStyle.UNDECORATED);
			// make window movable
			root.setOnMousePressed(new EventHandler<MouseEvent>() {
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

			// create a scene
			Scene scene = new Scene(root);
			scene.setFill(Color.TRANSPARENT);

			primaryStage.initStyle(StageStyle.TRANSPARENT);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public static void main(String[] args) {
		launch(args);
		
		//  GeekzORM orm = ORMFactory.getORM("hibernate");
		  
		//  TellerController teller = new TellerController();
		//  teller.addNewTeller("msb","Milinda", "123123", "0713264601");
		 /*
		 * Teller dbTeller = teller.readTeller("sss");
		 * System.out.println();
		 * ClientController client = new ClientController();
		 * client.addNewClient("Ama", "13/B 3rd lane", "21212", "2013/12/31");
		 * Client dbclient = client.readTeller(1);
		 * 
		 * ClientOrderController order = new ClientOrderController();
		 * order.addNewOrder("2014/1/11", "", "pending", dbTeller, dbclient);
		 * ClientOrder orderdb = order.readClientOrder(1);
		 * 
		 * ItemRepoController item = new ItemRepoController();
		 * item.addNewItem("Chili", "kg", "kg", "23.50", "2014/12/12"); ItemRepo
		 * itemDb = item.readRepoItem(1);
		 * 
		 * ItemOrderController itemOrder = new ItemOrderController();
		 * itemOrder.addNewItemOrder(10.00, 7.00, orderdb, itemDb);
		 * System.out.println();
		 */
	}
}
