package controller;

import java.time.LocalDate;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Expense;
import model.Income;
import model.Schedule;


public class HomeController {
	
	private Stage primaryStage;
	private LoginController loginCon;
	public static LocalDate date;
	private LayoutController layoutCon;
	@FXML  Pane calendar;
	public HomeController() {
	//	layoutCon.expenses.add(new Expense(loginCon.users.get(loginCon.userNumber).getID(),LocalDate.of(2018,6,11),"교통","버스비",5000,"티머니 충전"));
		//layoutCon.incomes.add(new Income(loginCon.users.get(loginCon.userNumber).getID(),LocalDate.of(2018,6,6),"알바비",20000));
		//layoutCon.schedules.add(new Schedule(loginCon.users.get(loginCon.userNumber).getID(),LocalDate.of(2018,6,2),"축구","오메가배 풋살결승"));
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
	    		dialogStage.setTitle("입력하기");
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
	    		dialogStage.setTitle("내역확인");
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
}
