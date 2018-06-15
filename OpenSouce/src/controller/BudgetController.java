package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import model.GoalMoney;

public class BudgetController {
	private HomeController homeCon;
	private LoginController loginCon;
	private ObservableList<String> type = FXCollections.observableArrayList("교통","식비","생활","의료","유흥","기타");
	public static ObservableList<GoalMoney> monthGoalMoney = FXCollections.observableArrayList();
	@FXML private ComboBox typeCheck;
	@FXML private TextField txtMoney;
	@FXML private Label dateLabel;
	private boolean select;
	
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
		select=false;
	}
	@FXML
	private void setType() {
		typeCheck.setDisable(false);
		select=true;
	}
	@FXML
	private void addButton() {
		if(select == false) {
			int dateCheck = 0;
			for(int i=0;i<monthGoalMoney.size();i++) {
			if(monthGoalMoney.get(i).getDate().equals(homeCon.date.getMonth())) {
				monthGoalMoney.get(i).setTotal(Integer.parseInt(txtMoney.getText()));
				dateCheck=1;
			}
			}
			if(dateCheck==0) {
				monthGoalMoney.add(new GoalMoney(loginCon.users.get(loginCon.userNumber).getID(),homeCon.date.getMonth(),0,0,0,0,0,0,Integer.parseInt(txtMoney.getText())));
				System.out.println(monthGoalMoney.get(0).gettotal());
			}
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("설정 성공");
			alert.setHeaderText("목표금액이 설정되었습니다.");
			alert.setContentText(homeCon.date.getYear()+"년 "+homeCon.date.getMonthValue()+"월"+" 설정금액: "+monthGoalMoney.get(0).gettotal());
			alert.show();
		}else {
			
		}
	}

}
