package controller;


import javafx.collections.ObservableList;

import javafx.collections.FXCollections;
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
import model.User;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController  {
	@FXML
	private TextField txtID;
	@FXML
	private PasswordField txtPassword;
	private Stage primaryStage;
	private LayoutController layoutController =new LayoutController();
	public ObservableList<User> users = FXCollections.observableArrayList();
	public int userNumber;
	public int usersNumber;
	public LoginController() {
		users.add(new User("�̱��","951212","1179717","dlrfdnwkd","123","dlrfdnwkd","01050606887"));
	}

	public void LoginButton(ActionEvent event) throws Exception {
		boolean UserFind =false;
		UserFind = userFind();
		if(UserFind==true) {
	    layoutController.setRootLayout();
		layoutController.setHome();
		} else {
			Alert alert = new Alert(AlertType.WARNING);
			//alert.initOwner(main.getPrimaryStage());
			alert.setTitle("�α��� ����");
			alert.setHeaderText("���̵� �� ��й�ȣ ����");
			alert.setContentText("Ȯ���� �� �ٽ� �Է����ֽÿ�.");
			alert.showAndWait();	
			txtPassword.setText(null);
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
		dialogStage.setTitle("ȸ������");
	    dialogStage.initModality(Modality.WINDOW_MODAL);
	    dialogStage.initOwner(primaryStage);
	    Scene scene = new Scene(signUP);
	    dialogStage.setScene(scene);
	    SignUpController controller = loader.getController();
	    controller.setLogin(this);
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
			dialogStage.setTitle("���̵�/��й�ȣ ã��");
		    dialogStage.initModality(Modality.WINDOW_MODAL);
		    dialogStage.initOwner(primaryStage);
		    Scene scene = new Scene(find);
		    dialogStage.setScene(scene);
		    FindController controller = loader.getController();
		    controller.setLogin(this);
		    controller.setDialogStage(dialogStage);
		    dialogStage.showAndWait();
		    dialogStage.setResizable(false);
			}catch(Exception e) {
				e.printStackTrace();
			}
	}
	public boolean userFind() {
		boolean userFind = false;
		for(int i=0;i<users.size();i++) {
			if(txtID.getText().equals(users.get(i).getID()) && txtPassword.getText().equals(users.get(i).getPassword())){
					userFind=true;
					userNumber = i;
		}
	}
		return userFind;
}
}
