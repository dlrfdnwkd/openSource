package controller;

import java.time.LocalDate;
import java.util.Calendar;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import javafx.stage.Modality;
import javafx.stage.Stage;



public class HomeController {
	
	private Stage primaryStage;
	private LoginController loginCon;
	public static LocalDate date ;
	private LayoutController layoutCon;
	private BudgetController budgetCon;
	public int i;
	public ObservableList<Integer> dayExpense = FXCollections.observableArrayList();
	@FXML  Pane calendar;
	public HomeController() {
	//	layoutCon.expenses.add(new Expense(loginCon.users.get(loginCon.userNumber).getID(),LocalDate.of(2018,6,11),"����","������",5000,"Ƽ�Ӵ� ����"));
		//layoutCon.incomes.add(new Income(loginCon.users.get(loginCon.userNumber).getID(),LocalDate.of(2018,6,6),"�˹ٺ�",20000));
		//layoutCon.schedules.add(new Schedule(loginCon.users.get(loginCon.userNumber).getID(),LocalDate.of(2018,6,2),"�౸","���ް��� ǲ����"));
		date = date.now();
	}
	
	public void setMain(LayoutController layoutCon) {
		this.layoutCon = layoutCon;
	}
	@FXML
	private void inputButton() {
		setInputData();
	}
	@FXML
	private void outputButton() {
		setOutputData();
	}
	 public void setInputData() {
	    	try {
	    		FXMLLoader loader = new FXMLLoader();
	    		loader.setLocation(Main.class.getResource("../view/Input.fxml"));
	    		AnchorPane page= (AnchorPane) loader.load();	
	    		Stage dialogStage = new Stage();
	    		dialogStage.setTitle("�Է��ϱ�");
	    	    dialogStage.initModality(Modality.WINDOW_MODAL);
	    	    dialogStage.initOwner(primaryStage);
	    	    Scene scene = new Scene(page);
	    	    dialogStage.setScene(scene);  
	    	    InputButtonController controller = loader.getController();
	    	    controller.setDialogStage(dialogStage);
	    	    dialogStage.showAndWait();
	    	    dialogStage.setResizable(false);
	    	} catch(Exception e) {
	    		e.printStackTrace();
	    	}
	    }
	 public void setOutputData() {
	    	try {
	    		FXMLLoader loader = new FXMLLoader();
	    		loader.setLocation(Main.class.getResource("../view/Output.fxml"));
	    		SplitPane page= (SplitPane) loader.load();	
	    		Stage dialogStage = new Stage();
	    		dialogStage.setTitle("����ȯ��");
	    	    dialogStage.initModality(Modality.WINDOW_MODAL);
	    	    dialogStage.initOwner(primaryStage);
	    	    Scene scene = new Scene(page);
	    	    dialogStage.setScene(scene);  
	    	    OutputButtonController controller = loader.getController();
	    	    controller.setOutput(this);
	    	    controller.setDialogStage(dialogStage);
	    	    dialogStage.showAndWait();
	    	    dialogStage.setResizable(false);
	    	} catch(Exception e) {
	    		e.printStackTrace();
	    	}
	    }
	 /*public void setDatExpense() {
		 //layoutCon.expenses.get(0).getExpense()
		 Calendar cal = Calendar.getInstance();
		 cal.set(Calendar.YEAR,date.getYear());
		 cal.set(Calendar.MONTH,date.getMonthValue());
		 for(int i=0;i<budgetCon.monthGoalMoney.size();i++)
		 int datExepense = budgetCon.monthGoalMoney.get(0).getTotal() / cal.DAY_OF_MONTH;
		 layoutCon.expenses.get
	 }*/
	 }
