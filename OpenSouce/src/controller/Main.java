package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class Main extends Application {
	
	private Stage primaryStage;
	private BorderPane rootLayout;
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Smart 가계부");
		setRootLayout();
		setHome();
    }
	
	public void setRootLayout() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
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
			controller.setMain(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
    public void setInputData() {
    	try {
    		FXMLLoader loader = new FXMLLoader();
    		loader.setLocation(Main.class.getResource("../view/Input.fxml"));
    		AnchorPane page= (AnchorPane) loader.load();
    		
    		Stage dialogStage = new Stage();
    		dialogStage.setTitle("입력하기");
    	    dialogStage.initModality(Modality.WINDOW_MODAL);
    	    dialogStage.initOwner(primaryStage);
    	    Scene scene = new Scene(page);
    	    dialogStage.setScene(scene);
    	    
    	    HomeButtonController controller = loader.getController();
    	    controller.setDialogStage(dialogStage);
    	    
    	    dialogStage.showAndWait();
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    }
	
	public Stage getPrimaryStage() {
		return primaryStage;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
