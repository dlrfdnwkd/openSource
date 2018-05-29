package controller;

import javafx.fxml.FXML;
import javafx.stage.Stage;

public class InputButtonController {
private Stage dialogStage;
	
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
	@FXML
	public void confirmButton() {
		dialogStage.close();
	}
	@FXML
	public void cancleButton() {
		dialogStage.close();
	}
}
