package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	
	public static Stage parentWindow;
	@Override
	public void start(Stage primaryStage) throws Exception{
			parentWindow = primaryStage;
			Parent login = FXMLLoader.load(getClass().getResource("/view/Login.fxml"));
			Scene loginscene = new Scene(login);
			primaryStage.setScene(loginscene);
			primaryStage.setTitle("��ȣ�� �����");
			primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
