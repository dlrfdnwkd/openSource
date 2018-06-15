package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.GoalMoney;

public class BudgetController {
	private HomeController homeCon;
	private ObservableList<String> type = FXCollections.observableArrayList("교통","식비","생활","의료","유흥","기타");
	public static ObservableList<GoalMoney> monthGoalMoney = FXCollections.observableArrayList();
	@FXML private ComboBox typeCheck;
	@FXML private TextField txtMoney;
	@FXML private Label dateLabel;
	
	@FXML
	private void previousMonthButton() {
		homeCon.date = homeCon.date.minusMonths(1);
		dateLabel.setText(homeCon.date.getYear()+"년 "+homeCon.date.getMonthValue()+"월");
	}
	@FXML
	private void nextMonthButton() {
		homeCon.date = homeCon.date.plusMonths(1);
		dateLabel.setText(homeCon.date.getYear()+"년 "+homeCon.date.getMonthValue()+"월");
	}
	@FXML
	private void initialize() {
		typeCheck.setItems(type);
		typeCheck.setDisable(true);
		dateLabel.setText(homeCon.date.getYear()+"년 "+homeCon.date.getMonthValue()+"월");
	}
	@FXML
	private void setTotal() {
		typeCheck.setDisable(true);
	}
	@FXML
	private void setType() {
		typeCheck.setDisable(false);
	}

}
