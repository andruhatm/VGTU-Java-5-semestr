package com.company.client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Client extends Application {

	public static Stage window;

	@Override
	public void start(Stage stage) throws Exception {
		System.out.println("in clientInit");
		window = stage;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("ChatApp.fxml"));
		Parent root = loader.load();
		window.setTitle("Chat Room");
		Scene main = new Scene(root);
		window.setScene(main);
		window.show();
	}
}
