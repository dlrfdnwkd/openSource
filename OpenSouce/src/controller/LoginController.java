package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController  {
	@FXML
	private TextField txtUserID;
	@FXML
	private PasswordField txtPassword;
	private Stage primaryStage;
	private LayoutController layoutController =new LayoutController();
	public void LoginButton(ActionEvent event) throws Exception {
		if(txtUserID.getText().equals("user") && txtPassword.getText().equals("1234")) {
	    layoutController.setRootLayout();
		layoutController.setHome();
		} else {
			Alert alert = new Alert(AlertType.WARNING);
			//alert.initOwner(main.getPrimaryStage());
			alert.setTitle("오류 메시지");
			alert.setHeaderText("아이디 및 비밀번호 오류");
			alert.setContentText("다시 입력해주시오.");
			alert.showAndWait();		
		}
	}
	@FXML
	public void signUpButton() {
		setSignUpButton();
	}
	public void setSignUpButton() {
		try {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("../view/Signup.fxml"));
		AnchorPane signUP= (AnchorPane) loader.load();	
		Stage dialogStage = new Stage();
		dialogStage.setTitle("회원가입");
	    dialogStage.initModality(Modality.WINDOW_MODAL);
	    dialogStage.initOwner(primaryStage);
	    Scene scene = new Scene(signUP);
	    dialogStage.setScene(scene);
	    SignUpController controller = loader.getController();
	    controller.setDialogStage(dialogStage);
	    dialogStage.showAndWait();
	    dialogStage.setResizable(false);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	@FXML
	public void findButton() {
		setFindButton();
	}
	public void setFindButton() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../view/Find.fxml"));
			VBox find= (VBox) loader.load();	
			Stage dialogStage = new Stage();
			dialogStage.setTitle("아이디/비밀번호 찾기");
		    dialogStage.initModality(Modality.WINDOW_MODAL);
		    dialogStage.initOwner(primaryStage);
		    Scene scene = new Scene(find);
		    dialogStage.setScene(scene);
		    FindController controller = loader.getController();
		    controller.setDialogStage(dialogStage);
		    dialogStage.showAndWait();
		    dialogStage.setResizable(false);
			}catch(Exception e) {
				e.printStackTrace();
			}
	}
}
