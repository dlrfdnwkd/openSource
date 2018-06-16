package controller;


import java.net.URL;
import java.time.LocalDate;
import java.time.YearMonth;

import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Cell;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.Label;
import javafx.scene.text.*;
import model.Expense;
import model.Income;
import model.Management;



public class pieChartController {
	
	@FXML private ProgressBar barProgress;
    @FXML private BarChart<?, ?> SalaryChart;
    @FXML private CategoryAxis x;
    @FXML private NumberAxis y;
    @FXML private PieChart pieChart;   
    @FXML private PieChart circle;    
    @FXML private TableView<Expense> expenseTable ;  
 	@FXML private TableColumn<Expense, LocalDate> expenseDateColumn;
	@FXML private TableColumn<Expense, Integer> expenseColumn;
	@FXML private TableColumn<Expense, String> expenseContentColumn;
	@FXML private TableView<Income> incomeTable;
    @FXML private Label Label1;
    @FXML private Label Label2;
    
    private LayoutController layoutCon;
    private HomeController homeCon;
    private LoginController loginCon;
   
    @FXML Label dateTitle;
    private ObservableList<Expense> monthExpenses =FXCollections.observableArrayList(); 
    private ObservableList<Income> monthIncomes = FXCollections.observableArrayList();
	private ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList(
			new PieChart.Data("으엉", 20),
			new PieChart.Data("교통",15),
			new PieChart.Data("유흥",30));
	
	
	

    
     @FXML
 	private void previousMonthButton() {
 		homeCon.date = homeCon.date.minusMonths(1);
 		dateTitle.setText(homeCon.date.getYear()+"년 "+homeCon.date.getMonthValue()+"월");
 		monthExpenses.clear();
 		for(int i=0;i<layoutCon.expenses.size();i++) {
 			//if(loginCon.users.get(loginCon.userNumber).getID().equals(layoutCon.expenses.get(i).getID())) {
 			if(layoutCon.expenses.get(i).getDate().getMonth().equals(homeCon.date.getMonth())) {
 			monthExpenses.add(layoutCon.expenses.get(i));
 			//}
 			}
 		}
     
 		
 		String str ="";
		for(int i=0; i<layoutCon.management.size();i++) {
			if(layoutCon.management.get(i).getDate().equals(YearMonth.from(homeCon.date))) {
				str = String.valueOf(layoutCon.management.get(i).getMonthExpense());
			}			
		}
		Label2.setText(str);
		String str1 ="";
		
		for(int j=0; j<layoutCon.management.size();j++) {
			if(layoutCon.management.get(j).getDate().equals(YearMonth.from(homeCon.date))) {
				str1 = String.valueOf(layoutCon.management.get(j).getMonthIncome());
				}
		}
		Label1.setText(str1);

 		
 		
 		expenseColumn.setSortType(TableColumn.SortType.DESCENDING); 		
		expenseTable.getSortOrder().add(expenseColumn);
		expenseColumn.setSortable(true);
		expenseTable.sort();
		expenseColumn.setSortable(false);
 	}
     @FXML
 	private void nextMonthButton() {
 		homeCon.date =homeCon.date.plusMonths(1);
 		dateTitle.setText(homeCon.date.getYear()+"년 "+homeCon.date.getMonthValue()+"월");
 		monthExpenses.clear();
 		for(int i=0;i<layoutCon.expenses.size();i++) {
 			if(layoutCon.expenses.get(i).getDate().getMonth().equals(homeCon.date.getMonth())) {
 			monthExpenses.add(layoutCon.expenses.get(i));
 			}
 			}
 		String str ="";
		for(int i=0; i<layoutCon.management.size();i++) {
			if(layoutCon.management.get(i).getDate().equals(YearMonth.from(homeCon.date))) {
				str = String.valueOf(layoutCon.management.get(i).getMonthExpense());
			}			
		}
		Label2.setText(str);
		String str1 ="";
		
		for(int j=0; j<layoutCon.management.size();j++) {
			if(layoutCon.management.get(j).getDate().equals(YearMonth.from(homeCon.date))) {
				str1 = String.valueOf(layoutCon.management.get(j).getMonthIncome());
				}
		}
		Label1.setText(str1);

 		
 		expenseColumn.setSortType(TableColumn.SortType.DESCENDING);
		expenseTable.getSortOrder().add(expenseColumn);
		expenseColumn.setSortable(true);
		expenseTable.sort();
		expenseColumn.setSortable(false);
 	}
     
 	public  pieChartController() {
		for(int i=0;i<layoutCon.expenses.size();i++) {
			if(layoutCon.expenses.get(i).getDate().getMonth().equals(homeCon.date.getMonth())) {
			monthExpenses.add(layoutCon.expenses.get(i));
			
			
			}
		}
		
	}
 	
			public void initialize() {
				
				expenseDateColumn.setCellValueFactory(cellData -> cellData.getValue().getDateProperty());
				expenseColumn.setCellValueFactory(cellData -> cellData.getValue().getExpenseProperty().asObject());
				expenseContentColumn.setCellValueFactory(cellData -> cellData.getValue().getContentProperty());		
				
				String str ="";
				for(int i=0; i<layoutCon.management.size();i++) {
					if(layoutCon.management.get(i).getDate().equals(YearMonth.from(homeCon.date))) {
						str = String.valueOf(layoutCon.management.get(i).getMonthExpense());
					}			
				}
				Label2.setText(str);
				String str1 ="";
				
				for(int j=0; j<layoutCon.management.size();j++) {
					if(layoutCon.management.get(j).getDate().equals(YearMonth.from(homeCon.date))) {
						str1 = String.valueOf(layoutCon.management.get(j).getMonthIncome());
						}
				}
				Label1.setText(str1);
	}
			public ObservableList<Expense> getExpenses(){
				return monthExpenses;
			}
		
			
		public void setpieChart(LayoutController layoutCon) {
			this.layoutCon = layoutCon;
			
					pieChart.setData(pieData);
					
					ObservableList<PieChart.Data> piedata = FXCollections.observableArrayList(
							new PieChart.Data("위험", 10),
							new PieChart.Data("경고",10),
							new PieChart.Data("양호",10));
							circle.setData(piedata);
			
					
					XYChart.Series set1 = new XYChart.Series<>();
					set1.setName ("지출 금액");
					
					set1.getData().add(new XYChart.Data("교통비",35000));
					set1.getData().add(new XYChart.Data("유흥비",70000));
					set1.getData().add(new XYChart.Data("식비",80000));
					
					XYChart.Series set2 = new XYChart.Series<>();
					set2.setName ("목표 금액");
					
					set2.getData().add(new XYChart.Data("교통비",60000));
					set2.getData().add(new XYChart.Data("유흥비",110000));
					set2.getData().add(new XYChart.Data("식비",130000));
					
					SalaryChart.getData().addAll(set1,set2);
			        expenseTable.setItems(getExpenses());
			       
			       
			        expenseColumn.setSortType(TableColumn.SortType.DESCENDING);
					expenseTable.getSortOrder().add(expenseColumn);
					expenseColumn.setSortable(true);
					expenseTable.sort();
					expenseColumn.setSortable(false);
				
		}
			}

