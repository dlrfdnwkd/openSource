package controller;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class InputButtonController {
private Stage dialogStage;
private ObservableList<String> type = FXCollections.observableArrayList("교통","식비","생활","의료","유흥","기타");
@FXML private ComboBox typeCheck; 
@FXML private RadioButton expenseButton;
@FXML private RadioButton incomeButton;
@FXML private RadioButton scheduleButton;
@FXML private ToggleGroup group;
@FXML private TextArea txtContend;
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
	@FXML 
	public void initialize() {
		typeCheck.setItems(type);
		group.selectedToggleProperty().addListener((ObservableValue<? extends Toggle>observ, Toggle oldVal, Toggle newVal) -> {
			String newStr = (String)newVal.getUserData();
			if(newStr=="income") {
			typeCheck.setDisable(true);
			txtContend.setEditable(false);
			}else {
				if(newStr=="schedule") {
					typeCheck.setDisable(false);
					txtContend.setEditable(true);
				}else {
					
				}
			}
		});
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
