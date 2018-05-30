package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LoginController  {
	private Stage primaryStage;
	private BorderPane rootLayout;
	public Main main;
	public int x;
	public int loginButton() {
		return x=1;

	}

/*	public void setRootLayout() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();
			main.setPrimaryStage(primaryStage);
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setResizable(false);
		} catch(Exception e) {
			e.printStackTrace();
		}
	} 
	
	public void setHome() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../view/Home.fxml"));
			AnchorPane home = (AnchorPane) loader.load();
			rootLayout.setCenter(home);
			HomeController controller = loader.getController();
			//controller.setMain(null);;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}   */ 
}
