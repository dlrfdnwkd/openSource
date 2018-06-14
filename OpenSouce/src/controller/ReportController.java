package controller;

import java.time.LocalDate;
import java.time.YearMonth;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Cell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Expense;
import model.Income;
import model.Schedule;

public class ReportController {
	@FXML private TableView<Expense> expenseTable;
	@FXML private TableColumn<Expense, LocalDate> expenseDateColumn;
	@FXML private TableColumn<Expense, String> typeColumn;
	@FXML private TableColumn<Expense, String> expenseNameColumn;
	@FXML private TableColumn<Expense, Integer> expenseColumn;
	@FXML private TableColumn<Expense, String> expenseContentColumn;
	@FXML private TableView<Income> incomeTable;
	@FXML private TableColumn<Income, LocalDate> incomeDateColumn;
	@FXML private TableColumn<Income, String> incomeNameColumn;
	@FXML private TableColumn<Income, Integer> incomeColumn;
	@FXML private TableView<Schedule> scheduleTable;
	@FXML private TableColumn<Schedule, LocalDate> scheduleDateColumn;
	@FXML private TableColumn<Schedule, String> scheduleNameColumn;
	@FXML private TableColumn<Schedule, String> scheduleContentColumn;
	//public static ObservableList<Expense> expenses = FXCollections.observableArrayList();
	public ObservableList<Expense> monthExpenses =FXCollections.observableArrayList();
	//public static ObservableList<Income> incomes = FXCollections.observableArrayList();
	public ObservableList<Income> monthIncomes = FXCollections.observableArrayList();
	//public static ObservableList<Schedule> schedules = FXCollections.observableArrayList();
	public ObservableList<Schedule> monthSchedules = FXCollections.observableArrayList();
	private LayoutController layoutCon;
	private LoginController loginCon;

	public ReportController() {
		
		for(int i=0;i<layoutCon.expenses.size();i++) {
			if(loginCon.users.get(loginCon.userNumber).getID().equals(layoutCon.expenses.get(i).getID())) {
			if(layoutCon.expenses.get(i).getDate().getMonth().equals(LocalDate.now().getMonth())) {
			monthExpenses.add(layoutCon.expenses.get(i));
			}
			}
		}
		for(int j=0;j<layoutCon.incomes.size();j++) {
			if(loginCon.users.get(loginCon.userNumber).getID().equals(layoutCon.incomes.get(j).getID())) {
			if(layoutCon.incomes.get(j).getDate().getMonth().equals(LocalDate.now().getMonth())) {
				monthIncomes.add(layoutCon.incomes.get(j));
			}
			}
		}
		for(int a=0;a<layoutCon.schedules.size();a++) {
			if(loginCon.users.get(loginCon.userNumber).getID().equals(layoutCon.schedules.get(a).getID())) {
			if(layoutCon.schedules.get(a).getDate().getMonth().equals(LocalDate.now().getMonth())) {
				monthSchedules.add(layoutCon.schedules.get(a));
			}
			}
		}
		//expenses.add(new Expense(loginCon.users.get(loginCon.userNumber).getID(),LocalDate.of(2018,6,11),"교통","버스비",5000,"티머니 충전"));
		//incomes.add(new Income(loginCon.users.get(loginCon.userNumber).getID(),LocalDate.of(2018,6,6),"알바비",20000));
		//schedules.add(new Schedule(loginCon.users.get(loginCon.userNumber).getID(),LocalDate.of(2018,6,2),"축구","오메가배 풋살결승"));
	}
	@FXML
	private void initialize() {	
		expenseDateColumn.setCellValueFactory(cellData -> cellData.getValue().getDateProperty());
		typeColumn.setCellValueFactory(cellData -> cellData.getValue().getTypeProperty());
		expenseNameColumn.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
		expenseColumn.setCellValueFactory(cellData -> cellData.getValue().getExpenseProperty().asObject());
		expenseContentColumn.setCellValueFactory(cellData -> cellData.getValue().getContentProperty());
		incomeDateColumn.setCellValueFactory(cellData -> cellData.getValue().getDateProperty());
		incomeNameColumn.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
		incomeColumn.setCellValueFactory(cellData -> cellData.getValue().getIncomeProperty().asObject());
		scheduleDateColumn.setCellValueFactory(cellData -> cellData.getValue().getDateProperty());
		scheduleNameColumn.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
		scheduleContentColumn.setCellValueFactory(cellData -> cellData.getValue().getContentProperty());
	}
	public ObservableList<Expense> getExpenses(){
		return monthExpenses;
	}
	public ObservableList<Income> getIncome(){
		return monthIncomes;
	}
	public ObservableList<Schedule> getSchedule(){
		return monthSchedules;
	}
	public void setReprot(LayoutController layoutCon) {
		this.layoutCon = layoutCon;
		expenseTable.setItems(getExpenses());
		incomeTable.setItems(getIncome());
		scheduleTable.setItems(getSchedule());
	}

}

