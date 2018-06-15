package controller;

import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.Expense;
import model.ExpenseDAO;
import model.Income;
import model.IncomeDAO;
import model.Schedule;
import model.ScheduleDAO;

public class InputButtonController {
private LayoutController layoutCon;
private LoginController loginCon;
private HomeController homeCon;
private Stage dialogStage;
private ObservableList<String> type = FXCollections.observableArrayList("����","�ĺ�","��Ȱ","�Ƿ�","����","��Ÿ");
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
				alert.setTitle("���� ����");
				alert.setHeaderText("������ ���õ��� �ʾҽ��ϴ�.");
				alert.setContentText("������ �������ּ���.");
				alert.show();
			}else {
				if(txtName.getText() == null || txtName.getText().equals("")) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("���� ����");
					alert.setHeaderText("������ �Էµ��� �ʾҽ��ϴ�.");
					alert.setContentText("������ �Է����ּ���.");
					alert.show();
				}else {
					if(txtMoney.getText() == null || txtMoney.getText().equals("")) {
						Alert alert = new Alert(AlertType.ERROR);
						alert.setTitle("�ݾ� ����");
						alert.setHeaderText("�ݾ��� �Էµ��� �ʾҽ��ϴ�.");
						alert.setContentText("�ݾ��� �Է����ּ���.");
						alert.show();
					}else {
						ExpenseDAO expenseDAO = new ExpenseDAO();
						int result = expenseDAO.saveExpense(new Expense(loginCon.users.get(loginCon.userNumber).getID(),datePicker.getValue(),(String)typeCheck.getValue(),txtName.getText(),Integer.parseInt(txtMoney.getText()),txtContent.getText()));
						layoutCon.expenses.add(new Expense(loginCon.users.get(loginCon.userNumber).getID(),datePicker.getValue(),(String)typeCheck.getValue(),txtName.getText(),Integer.parseInt(txtMoney.getText()),txtContent.getText()));
						if(result==0)
						{
							System.out.println("����");
						}
						else {
							System.out.println("����");
						}
						//layoutCon.expenses.add(new Expense(loginCon.users.get(loginCon.userNumber).getID(),datePicker.getValue(),(String)typeCheck.getValue(),txtName.getText(),Integer.parseInt(txtMoney.getText()),txtContent.getText()));
			      input = true;
					}
			      }
			}
			}else {
			if(select == "income") {
				if(txtName.getText() == null || txtName.getText().equals("")) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("���� ����");
					alert.setHeaderText("������ �Էµ��� �ʾҽ��ϴ�.");
					alert.setContentText("������ �Է����ּ���.");
					alert.show();
				}else {
					if(txtMoney.getText() == null || txtMoney.getText().equals("")) {
						Alert alert = new Alert(AlertType.ERROR);
						alert.setTitle("�ݾ� ����");
						alert.setHeaderText("�ݾ��� �Էµ��� �ʾҽ��ϴ�.");
						alert.setContentText("�ݾ��� �Է����ּ���.");
						alert.show();
					}else {
						IncomeDAO incomeDAO = new IncomeDAO();
						int result = incomeDAO.saveIncome(new Income(loginCon.users.get(loginCon.userNumber).getID(),datePicker.getValue(),txtName.getText(),Integer.parseInt(txtMoney.getText())));
						layoutCon.incomes.add(new Income(loginCon.users.get(loginCon.userNumber).getID(),datePicker.getValue(),txtName.getText(),Integer.parseInt(txtMoney.getText())));
						if(result==0)
						{
							System.out.println("����");
						}
						else {
							System.out.println("����");
						}
				input = true;
					}
				}
			}else {
				if(txtName.getText() == null || txtName.getText().equals("")) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("���� ����");
					alert.setHeaderText("������ �Էµ��� �ʾҽ��ϴ�.");
					alert.setContentText("������ �Է����ּ���.");
					alert.show();
				}else {
					ScheduleDAO scheduleDAO = new ScheduleDAO();
					int result = scheduleDAO.saveSchedule(new Schedule(loginCon.users.get(loginCon.userNumber).getID(),datePicker.getValue(),txtName.getText(),txtMoney.getText()));
					layoutCon.schedules.add(new Schedule(loginCon.users.get(loginCon.userNumber).getID(),datePicker.getValue(),txtName.getText(),txtMoney.getText()));
					if(result==0)
					{
						System.out.println("����");
					}
					else {
						System.out.println("����");
					}
					//layoutCon.schedules.add(new Schedule(loginCon.users.get(loginCon.userNumber).getID(),datePicker.getValue(),txtName.getText(),txtContent.getText()));
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
}
