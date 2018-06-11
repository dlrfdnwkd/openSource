package controller;

import java.sql.Date;
import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Cell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Expense;
import model.Income;

public class ReportController {
	@FXML private TableView<Expense> expenseTable;
	@FXML private TableColumn<Expense, LocalDate> expenseDateColumn;
	@FXML private TableColumn<Expense, String> typeColumn;
	@FXML private TableColumn<Expense, String> expenseNameColumn;
	@FXML private TableColumn<Expense, Integer> expenseColumn;
	@FXML private TableColumn<Expense, String> contendColumn;
	@FXML private TableView<Income> incomeTable;
	@FXML private TableColumn<Income, LocalDate> incomeDateColumn;
	@FXML private TableColumn<Income, String> incomeNameColumn;
	@FXML private TableColumn<Income, Integer> incomeColumn;
	public ObservableList<Expense> expenses = FXCollections.observableArrayList();
	public ObservableList<Income> incomes = FXCollections.observableArrayList();
	private LoginController loginCon;
	private LayoutController layoutCon;

	public ReportController() {
		expenses.add(new Expense(loginCon.users.get(loginCon.userNumber).getID(),LocalDate.of(2018,6,11),"교통","버스비",5000,"티머니 충전"));
		expenses.add(new Expense(loginCon.users.get(loginCon.userNumber).getID(),LocalDate.of(2018,6,4),"식비","점심",8000,"라멘"));
		expenses.add(new Expense(loginCon.users.get(loginCon.userNumber).getID(),LocalDate.of(2018,6,2),"유흥","술",30000,"이자카야"));
		incomes.add(new Income(loginCon.users.get(loginCon.userNumber).getID(),LocalDate.of(2018,6,6),"알바비",20000));
	}
	@FXML
	private void initialize() {
		expenseDateColumn.setCellValueFactory(cellData -> cellData.getValue().getDateProperty());
		typeColumn.setCellValueFactory(cellData -> cellData.getValue().getTypeProperty());
		expenseNameColumn.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
		expenseColumn.setCellValueFactory(cellData -> cellData.getValue().getExpenseProperty().asObject());
		contendColumn.setCellValueFactory(cellData -> cellData.getValue().getContendProperty());
		incomeDateColumn.setCellValueFactory(cellData -> cellData.getValue().getDateProperty());
		incomeNameColumn.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
		incomeColumn.setCellValueFactory(cellData -> cellData.getValue().getIncomeProperty().asObject());
	}
	public ObservableList<Expense> getExpenses(){
		return expenses;
	}
	public ObservableList<Income> getIncome(){
		return incomes;
	}
	public void setReprot(LayoutController layoutCon) {
		this.layoutCon = layoutCon;
		expenseTable.setItems(getExpenses());
		incomeTable.setItems(getIncome());
	}

}

