package controller;

import java.util.ArrayList;

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
	private TextField txtUserID;
	@FXML
	private PasswordField txtPassword;
	private Stage primaryStage;
	private LayoutController layoutController =new LayoutController();
	public ArrayList<User> users = new ArrayList<>();
	public LoginController() {
		users.add(new User());
		users.get(0).setName("�̱��");
		users.get(0).setID("dlrfdnwkd");
		users.get(0).setPassword("1212");
		users.get(0).setEmail("dlrfdnwkd@naver.com");
		users.get(0).setPhoneNumber("01050606887");
		users.add(new User());
		users.get(1).setName("������");
		users.get(1).setID("������");
		users.get(1).setPassword("123");
		users.get(1).setEmail("dlrfdnwkd@naver.com");
		users.get(1).setPhoneNumber("01050606887");
		users.add(new User());
		users.get(2).setName("������");
		users.get(2).setID("������");
		users.get(2).setPassword("123");
		users.get(2).setEmail("dlrfdnwkd@naver.com");
		users.get(2).setPhoneNumber("01050606887");
		users.add(new User());
		users.get(3).setName("���ϱ�");
		users.get(3).setID("���ϱ�");
		users.get(3).setPassword("123");
		users.get(3).setEmail("dlrfdnwkd@naver.com");
		users.get(3).setPhoneNumber("01050606887");
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
			alert.setTitle("���� �޽���");
			alert.setHeaderText("���̵� �� ��й�ȣ ����");
			alert.setContentText("�ٽ� �Է����ֽÿ�.");
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
		dialogStage.setTitle("ȸ������");
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
			dialogStage.setTitle("���̵�/��й�ȣ ã��");
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
	public boolean userFind() {
		boolean userFind = false;
		for(int i=0;i<users.size();i++) {
			if(txtUserID.getText().equals(users.get(i).getName()) && txtPassword.getText().equals(users.get(i).getPassword())){
					userFind=true;			
		}
	}
		return userFind;
}
}
