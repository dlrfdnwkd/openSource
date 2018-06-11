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

public class ReportController {
	@FXML private TableView<Expense> expenseTable;
	@FXML private TableColumn<Expense, LocalDate> dateColumn;
	@FXML private TableColumn<Expense, String> typeColumn;
	@FXML private TableColumn<Expense, String> nameColumn;
	@FXML private TableColumn<Expense, Integer> expenseColumn;
	@FXML private TableColumn<Expense, String> contendColumn;
	public ObservableList<Expense> expenses = FXCollections.observableArrayList();
	private LoginController loginCon;
	private LayoutController layoutCon;

	public ReportController() {
		expenses.add(new Expense(loginCon.users.get(loginCon.userNumber).getID(),LocalDate.of(2018,6,11),"교통","버스비",5000,"티머니 충전"));
	}
	@FXML
	private void initialize() {
		dateColumn.setCellValueFactory(cellData -> cellData.getValue().getDateProperty());
		typeColumn.setCellValueFactory(cellData -> cellData.getValue().getTypeProperty());
		nameColumn.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
		expenseColumn.setCellValueFactory(cellData -> cellData.getValue().getExpenseProperty().asObject());
		contendColumn.setCellValueFactory(cellData -> cellData.getValue().getContendProperty());
	}
	public ObservableList<Expense> getExpenses(){
		return expenses;
	}
	public void setReprot(LayoutController layoutCon) {
		this.layoutCon = layoutCon;
		expenseTable.setItems(getExpenses());
	}

}

