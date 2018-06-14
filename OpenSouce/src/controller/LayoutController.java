package controller;

import java.time.YearMonth;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Expense;
import model.ExpenseDAO;
import model.Income;
import model.IncomeDAO;
import model.Schedule;

public  class LayoutController {
	private static BorderPane root;
	private LoginController loginCon;
	private ReportController reportCon;
	public static ObservableList<Expense> expenses = FXCollections.observableArrayList();
	public static ObservableList<Income> incomes = FXCollections.observableArrayList();
	public static ObservableList<Schedule> schedules = FXCollections.observableArrayList();
	
	public void setRootLayout() {
		try {
		root = FXMLLoader.load(getClass().getResource("/view/RootLayout.fxml"));
		Stage rootStage;
		Scene scene = new Scene(root);
		rootStage = Main.parentWindow;
		rootStage.setScene(scene);
		rootStage.centerOnScreen();
		ExpenseDAO expenseDAO = new ExpenseDAO();
		ObservableList<Expense> tempList = expenseDAO.getExpense();
		for(int i = 0; i<tempList.size();i++){
		expenses.add(tempList.get(i));
		}
		IncomeDAO incomeDAO = new IncomeDAO();
		ObservableList<Income> tempList1 = incomeDAO.getIncome();
		for(int j = 0; j<tempList1.size();j++){
		incomes.add(tempList1.get(j));
	    }
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void setHome() {	
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../view/Home.fxml"));
			AnchorPane home = (AnchorPane) loader.load();
			HomeController controller = loader.getController();
			controller.calendar.getChildren().add(new CalendarController(YearMonth.now()).getView());
			root.setCenter(home);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void setReport() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../view/Report.fxml"));
			VBox report = (VBox) loader.load();
			root.setCenter(report);
			ReportController controller = loader.getController();
			controller.setReprot(this);
			
			/*ExpenseDAO expenseDAO = new ExpenseDAO();
			ObservableList<Expense> tempList = expenseDAO.getExpense();
			for(int i = 0; i<tempList.size();i++){
			expenses.add(tempList.get(i));
			}
			IncomeDAO incomeDAO = new IncomeDAO();
			ObservableList<Income> tempList1 = incomeDAO.getIncome();
			for(int j = 0; j<tempList1.size();j++){
			incomes.add(tempList1.get(j));
		    }*/
			}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void setBudget() {	
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../view/Budget.fxml"));
			AnchorPane budget = (AnchorPane) loader.load();
			root.setCenter(budget);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void setUser() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../view/User.fxml"));
			VBox User = (VBox) loader.load();
			root.setCenter(User);
			UserController controller = loader.getController();
			controller.setUser(loginCon.userNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@FXML
	private void handleMouseClickHome(MouseEvent event) {
		setHome();
	}
	@FXML
	private void handleMouseClickReport(MouseEvent event) {
		setReport();
	}
	@FXML
	private void handleMouseClickBudget(MouseEvent event) {
		setBudget();
	}
	@FXML
	private void handleMouseClickUser(MouseEvent event) {
		setUser();
		UserController controller = new UserController();
	}
}
