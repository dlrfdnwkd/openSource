package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class InputButtonController {
private Stage dialogStage;
private ObservableList<String> type = FXCollections.observableArrayList("����","�ĺ�","��Ȱ","�Ƿ�","����","��Ÿ");
@FXML private ComboBox typeCheck; 
	
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
	@FXML 
	public void initialize() {
		typeCheck.setItems(type);
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
