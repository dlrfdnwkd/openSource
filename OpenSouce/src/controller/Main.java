package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Main extends Application {
	
	private Stage primaryStage;
	//private BorderPane rootLayout;
	
	@Override
	public void start(Stage primaryStage) {
		try {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("신호등 가계부");
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("../view/Login.fxml"));
		AnchorPane login =(AnchorPane) loader.load();
		Scene scene = new Scene(login);
		primaryStage.setScene(scene);
		primaryStage.show();
		//setRootLayout();
		//setHome();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
	
	/* public void setRootLayout() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();
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
			//controller.setMain(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	} */  
	
	public Stage getPrimaryStage() {
		return primaryStage;
	}
	/*public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage =primaryStage;
	}*/
	
	public static void main(String[] args) {
		launch(args);
	}
}
