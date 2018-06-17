package controller;

import java.time.LocalDate;
import java.time.YearMonth;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Differentiate;
import model.DifferentiateDAO;
import model.Expense;
import model.ExpenseDAO;
import model.Income;
import model.IncomeDAO;
import model.Management;
import model.Schedule;
import model.ScheduleDAO;

public class InputButtonController {
private LayoutController layoutCon;
private LoginController loginCon;
private HomeController homeCon;
private Stage dialogStage;
private ObservableList<String> type = FXCollections.observableArrayList("교통","식비","생활","의료","유흥","기타");
@FXML private ComboBox typeCheck; 
@FXML private TextArea txtContent;
@FXML private TextField txtName;
@FXML private TextField txtMoney;
@FXML private DatePicker datePicker;
private String select = "expense";
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
	@FXML 
	public void initialize() {
		typeCheck.setItems(type);
		if(homeCon.date == null) {
		datePicker.setValue(LocalDate.now());
		}
		else {
			datePicker.setValue(homeCon.date);
		}
	}
	@FXML
	public void confirmButton() {
		boolean input = false;
		if(select == "expense") {
			if(typeCheck.getValue() == null) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("유형 오류");
				alert.setHeaderText("유형이 선택되지 않았습니다.");
				alert.setContentText("유형을 선택해주세요.");
				alert.show();
			}else {
				if(txtName.getText() == null || txtName.getText().equals("")) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("제목 오류");
					alert.setHeaderText("제목이 입력되지 않았습니다.");
					alert.setContentText("제목을 입력해주세요.");
					alert.show();
				}else {
					if(txtMoney.getText() == null || txtMoney.getText().equals("")) {
						Alert alert = new Alert(AlertType.ERROR);
						alert.setTitle("금액 오류");
						alert.setHeaderText("금액이 입력되지 않았습니다.");
						alert.setContentText("금액을 입력해주세요.");
						alert.show();
					}else {
						ExpenseDAO expenseDAO = new ExpenseDAO();
						int result = expenseDAO.saveExpense(new Expense(loginCon.users.get(loginCon.userNumber).getID(),datePicker.getValue(),(String)typeCheck.getValue(),txtName.getText(),Integer.parseInt(txtMoney.getText()),txtContent.getText()));
						layoutCon.expenses.add(new Expense(loginCon.users.get(loginCon.userNumber).getID(),datePicker.getValue(),(String)typeCheck.getValue(),txtName.getText(),Integer.parseInt(txtMoney.getText()),txtContent.getText()));
						if(result==0)
						{
							System.out.println("성공");
						}
						else {
							System.out.println("실패");
						}
						//layoutCon.expenses.add(new Expense(loginCon.users.get(loginCon.userNumber).getID(),datePicker.getValue(),(String)typeCheck.getValue(),txtName.getText(),Integer.parseInt(txtMoney.getText()),txtContent.getText()));
						int differentiateCheck = 0;
						if(homeCon.differentiate.isEmpty()) {
							homeCon.differentiate.add(new Differentiate(loginCon.users.get(loginCon.userNumber).getID(),datePicker.getValue(),Integer.parseInt(txtMoney.getText())));
							DifferentiateDAO differentiateDAO = new DifferentiateDAO();
							differentiateDAO.saveDifferentiate(new Differentiate(loginCon.users.get(loginCon.userNumber).getID(),datePicker.getValue(),Integer.parseInt(txtMoney.getText())));
							
						}else {
							for(int i=0;i<homeCon.differentiate.size();i++) {
								if(datePicker.getValue().equals(homeCon.differentiate.get(i).getDate())) {
									homeCon.differentiate.get(i).plusDayExpense(Integer.parseInt(txtMoney.getText()));
									//판별 수정
									differentiateCheck = 1;
									break;
								}
							}
							if(differentiateCheck == 0) {
								homeCon.differentiate.add(new Differentiate(loginCon.users.get(loginCon.userNumber).getID(),datePicker.getValue(),Integer.parseInt(txtMoney.getText())));
								DifferentiateDAO differentiateDAO = new DifferentiateDAO();
								differentiateDAO.saveDifferentiate(new Differentiate(loginCon.users.get(loginCon.userNumber).getID(),datePicker.getValue(),Integer.parseInt(txtMoney.getText())));
								
							}
						}
						int managementCheck =0;
						if(layoutCon.management.isEmpty()) {
							layoutCon.management.add(new Management(loginCon.users.get(loginCon.userNumber).getID(),YearMonth.from(datePicker.getValue()),Integer.parseInt(txtMoney.getText()),0));
							DifferentiateDAO differentiateDAO = new DifferentiateDAO();
							differentiateDAO.saveDifferentiate(new Differentiate(loginCon.users.get(loginCon.userNumber).getID(),datePicker.getValue(),Integer.parseInt(txtMoney.getText())));
							
						}else {
							for(int j=0;j<layoutCon.management.size();j++) {
								if(YearMonth.from(datePicker.getValue()).equals(layoutCon.management.get(j).getDate())) {
									layoutCon.management.get(j).plusMonthExpense(Integer.parseInt(txtMoney.getText()));
									//관리 수정
									managementCheck=1;
									break;
								}
							}
							if(managementCheck==0) {
								layoutCon.management.add(new Management(loginCon.users.get(loginCon.userNumber).getID(), YearMonth.from(datePicker.getValue()),Integer.parseInt(txtMoney.getText()),0));
								DifferentiateDAO differentiateDAO = new DifferentiateDAO();
								differentiateDAO.saveDifferentiate(new Differentiate(loginCon.users.get(loginCon.userNumber).getID(),datePicker.getValue(),Integer.parseInt(txtMoney.getText())));
								
							}
						}
						
						homeCon.calendar.getChildren().clear();
						homeCon.calendar.getChildren().add(new CalendarController(YearMonth.now()).getView());
						/*if(result==0)
						{
							System.out.println("성공");
						}
						else {
							System.out.println("실패");
						}*/
						//layoutCon.expenses.add(new Expense(loginCon.users.get(loginCon.userNumber).getID(),datePicker.getValue(),(String)typeCheck.getValue(),txtName.getText(),Integer.parseInt(txtMoney.getText()),txtContent.getText()));
						
			      input = true;
					}
			      }
			}
			}else {
			if(select == "income") {
				if(txtName.getText() == null || txtName.getText().equals("")) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("제목 오류");
					alert.setHeaderText("제목이 입력되지 않았습니다.");
					alert.setContentText("제목을 입력해주세요.");
					alert.show();
				}else {
					if(txtMoney.getText() == null || txtMoney.getText().equals("")) {
						Alert alert = new Alert(AlertType.ERROR);
						alert.setTitle("금액 오류");
						alert.setHeaderText("금액이 입력되지 않았습니다.");
						alert.setContentText("금액을 입력해주세요.");
						alert.show();
					}else {
						IncomeDAO incomeDAO = new IncomeDAO();
						int result = incomeDAO.saveIncome(new Income(loginCon.users.get(loginCon.userNumber).getID(),datePicker.getValue(),txtName.getText(),Integer.parseInt(txtMoney.getText())));
						layoutCon.incomes.add(new Income(loginCon.users.get(loginCon.userNumber).getID(),datePicker.getValue(),txtName.getText(),Integer.parseInt(txtMoney.getText())));
						if(result==0)
						{
							System.out.println("성공");
						}
						else {
							System.out.println("실패");
						}
						
						
						int managementCheck =0;
						if(layoutCon.management.isEmpty()) {
							layoutCon.management.add(new Management(loginCon.users.get(loginCon.userNumber).getID(),YearMonth.from(datePicker.getValue()),0,Integer.parseInt(txtMoney.getText())));
						}else {
							for(int j=0;j<layoutCon.management.size();j++) {
								if(YearMonth.from(datePicker.getValue()).equals(layoutCon.management.get(j).getDate())) {
									layoutCon.management.get(j).plusMonthIncome(Integer.parseInt(txtMoney.getText()));
									managementCheck=1;
									break;
								}
							}
							if(managementCheck==0) {
								layoutCon.management.add(new Management(loginCon.users.get(loginCon.userNumber).getID(), YearMonth.from(datePicker.getValue()),0,Integer.parseInt(txtMoney.getText())));
							}
							
						}
				input = true;
					}
				}
			}else {
				if(txtName.getText() == null || txtName.getText().equals("")) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("제목 오류");
					alert.setHeaderText("제목이 입력되지 않았습니다.");
					alert.setContentText("제목을 입력해주세요.");
					alert.show();
				}else {
					ScheduleDAO scheduleDAO = new ScheduleDAO();
					int result = scheduleDAO.saveSchedule(new Schedule(loginCon.users.get(loginCon.userNumber).getID(),datePicker.getValue(),txtName.getText(),txtMoney.getText()));
					layoutCon.schedules.add(new Schedule(loginCon.users.get(loginCon.userNumber).getID(),datePicker.getValue(),txtName.getText(),txtMoney.getText()));
					if(result==0)
					{
						System.out.println("성공");
					}
					else {
						System.out.println("실패");
					}
				input = true;
			}
			}
		}	
		if(input == true) {
		dialogStage.close();
		}
	}
	@FXML
	public void cancleButton() {
		dialogStage.close();
	}
	@FXML
	public void setIncome() {
		txtContent.setText(null);
		txtContent.setDisable(true);
		txtMoney.setDisable(false);
		typeCheck.setDisable(true);
		select = "income";
	}
	@FXML
	public void setSchedule() {
		txtMoney.setText(null);
		txtMoney.setDisable(true);
		txtContent.setDisable(false);
		typeCheck.setDisable(true);
		select = "schedule";
	}
	@FXML
	public void setExpense() {
		typeCheck.setDisable(false);
		txtMoney.setDisable(false);
		txtContent.setDisable(false);
		select = "expense";
	}
	public void setInput(HomeController homeCon) {
		this.homeCon = homeCon;
	}
}
