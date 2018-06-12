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
	public static ObservableList<Expense> expenses = FXCollections.observableArrayList();
	public static ObservableList<Income> incomes = FXCollections.observableArrayList();
	public static ObservableList<Schedule> schedules = FXCollections.observableArrayList();
	private LoginController loginCon;
	private LayoutController layoutCon;

	public ReportController() {
		//expenses.add(new Expense(loginCon.users.get(loginCon.userNumber).getID(),LocalDate.of(2018,6,11),"교통","버스비",5000,"티머니 충전"));
		//incomes.add(new Income(loginCon.users.get(loginCon.userNumber).getID(),LocalDate.of(2018,6,6),"알바비",20000));
		//schedules.add(new Schedule(loginCon.users.get(loginCon.userNumber).getID(),LocalDate.of(2018,6,2),"축구","오메가배 풋살결승"));
	}
	@FXML
	private void initialize() {
		for(int i=0;i<expenses.size();i++) {
			if(expenses.get(i).getDate().getMonth().equals(LocalDate.now().getMonth())) {
				expenseDateColumn.setCellValueFactory(cellData -> cellData.getValue().getDateProperty());
				typeColumn.setCellValueFactory(cellData -> cellData.getValue().getTypeProperty());
				expenseNameColumn.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
				expenseColumn.setCellValueFactory(cellData -> cellData.getValue().getExpenseProperty().asObject());
				expenseContentColumn.setCellValueFactory(cellData -> cellData.getValue().getContentProperty());
			}
		}
		/*expenseDateColumn.setCellValueFactory(cellData -> cellData.getValue().getDateProperty());
		typeColumn.setCellValueFactory(cellData -> cellData.getValue().getTypeProperty());
		expenseNameColumn.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
		expenseColumn.setCellValueFactory(cellData -> cellData.getValue().getExpenseProperty().asObject());
		expenseContentColumn.setCellValueFactory(cellData -> cellData.getValue().getContentProperty());*/
		incomeDateColumn.setCellValueFactory(cellData -> cellData.getValue().getDateProperty());
		incomeNameColumn.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
		incomeColumn.setCellValueFactory(cellData -> cellData.getValue().getIncomeProperty().asObject());
		scheduleDateColumn.setCellValueFactory(cellData -> cellData.getValue().getDateProperty());
		scheduleNameColumn.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
		scheduleContentColumn.setCellValueFactory(cellData -> cellData.getValue().getContentProperty());
	}
	public ObservableList<Expense> getExpenses(){
		return expenses;
	}
	public ObservableList<Income> getIncome(){
		return incomes;
	}
	public ObservableList<Schedule> getSchedule(){
		return schedules;
	}
	public void setReprot(LayoutController layoutCon) {
		this.layoutCon = layoutCon;
		expenseTable.setItems(getExpenses());
		incomeTable.setItems(getIncome());
		scheduleTable.setItems(getSchedule());
	}

}

