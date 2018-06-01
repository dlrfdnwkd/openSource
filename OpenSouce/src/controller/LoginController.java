package controller;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LoginController  {
	//private Stage primaryStage;
	private BorderPane rootLayout;
	@FXML
	private TextField txtUserID;
	@FXML
	private PasswordField txtPassword;
	private Main main;
	
	public void LoginButton(ActionEvent event) throws Exception {
		if(txtUserID.getText().equals("user") && txtPassword.getText().equals("1234")) {
		setRootLayout();
		setHome();
		} else {
			Alert alert = new Alert(AlertType.WARNING);
			//alert.initOwner(main.getPrimaryStage());
			alert.setTitle("오류 메시지");
			alert.setHeaderText("아이디 및 비밀번호 오류");
			alert.setContentText("다시 입력해주시오.");
			alert.showAndWait();		
		}
	}

	public void setRootLayout() {
		try {
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();
			//main.setPrimaryStage(primaryStage);
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
			//HomeController controller = loader.getController();
			//controller.setMain(null);;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}   
}
