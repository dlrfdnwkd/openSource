package controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class HomeController {
	
	private Main main;
	private Button previousMonthButton;
	private Stage primaryStage;

	public void setMain(Main main) {
		this.main = main;
	}
	@FXML
	private void inputButton() {
		setInputData();
	}
	/*@FXML
	private void previousMonthButton() {
		previousMonthButton.setOnAction(e-> previousMonth());
	} */
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
	    	    InputButtonController controller = loader.getController();
	    	    controller.setDialogStage(dialogStage);
	    	    dialogStage.showAndWait();
	    	} catch(Exception e) {
	    		e.printStackTrace();
	    	}
	    } 

}
