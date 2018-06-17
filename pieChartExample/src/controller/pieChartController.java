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
//import javafx.scene.chart.PieChart.Data;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Cell;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.Label;
import javafx.scene.text.*;
import model.Expense;
import model.Income;
import model.Management;
import model.GoalMoney;



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
	@FXML private TableColumn<Expense, String> typed;
	@FXML private TableView<Income> incomeTable;
    @FXML private Label Label1;
    @FXML private Label Label2;
    
    
    private LayoutController layoutCon;
    private HomeController homeCon;
    private LoginController loginCon;
   
    @FXML Label dateTitle;
    private ObservableList mo =FXCollections.observableArrayList();
    private ObservableList<Expense> monthExpenses =FXCollections.observableArrayList(); 
    private ObservableList<Income> monthIncomes = FXCollections.observableArrayList();
    ObservableList<PieChart.Data> piedata = FXCollections.observableArrayList(
			new PieChart.Data("위  험", 19),
			new PieChart.Data("경고",10),
			new PieChart.Data("양호",10));
	private ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList(
			new PieChart.Data("식비", 19),
			new PieChart.Data("교통",10),
			new PieChart.Data("유흥",10),
			new PieChart.Data("의료",10),
			new PieChart.Data("기타",10),
			new PieChart.Data("의료",10)
			);
	
	
	  
	XYChart.Series set1 = new XYChart.Series();
	
	
     @FXML
 	private void previousMonthButton() {
 		homeCon.date = homeCon.date.minusMonths(1);
 		dateTitle.setText(homeCon.date.getYear()+"년 "+homeCon.date.getMonthValue()+"월");
 		monthExpenses.clear();
 		SalaryChart.getData().clear();
 		mo.clear();
 	
 		for(int i=0;i<layoutCon.expenses.size();i++) {
 			if(layoutCon.expenses.get(i).getDate().getMonth().equals(homeCon.date.getMonth())) {
 				if(layoutCon.expenses.get(i).getDate().getYear()==(homeCon.date.getYear())) {
 					monthExpenses.add(layoutCon.expenses.get(i));
 			}
 				
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
			//	if(layoutCon.expenses.get(j).getDate().getYear()==(homeCon.date.getYear())) {
		 		//	}
				str1 = String.valueOf(layoutCon.management.get(j).getMonthIncome());
				}
		}
		Label1.setText(str1);
	
	/*	for(int z=0;z<layoutCon.expenses.size();z++) {
        	if(layoutCon.management.get(z).getDate().equals(YearMonth.from(homeCon.date))) {
        		Data da =new XYChart.Data(monthExpenses.get(z).getType(),monthExpenses.get(z).getExpense());
    			mo.add(da);
         		//	}      		
    			set1.setData(mo);
    			SalaryChart.getData().addAll(set1);
    			SalaryChart.getData().retainAll(set1);
    			
        }
        	else if(layoutCon.management.get(z).getDate().equals(YearMonth.from(homeCon.date))){
        		Data da =new XYChart.Data(monthExpenses.get(z).getType(),monthExpenses.get(z).getExpense());
    			mo.add(da);
        		
    			set1.setData(mo);
    			SalaryChart.getData().addAll(set1);
    			SalaryChart.getData().retainAll(set1);
    			//SalaryChart.getData().clear();
    			
        	}
        	
        	
}*/
	
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
 		mo.clear();
 		SalaryChart.getData().retainAll(pieData);
 		
 		for(int i=0;i<layoutCon.expenses.size();i++) {
 			if(layoutCon.expenses.get(i).getDate().getMonth().equals(homeCon.date.getMonth())) {
 				if(layoutCon.expenses.get(i).getDate().getYear()==(homeCon.date.getYear())) {
 			monthExpenses.add(layoutCon.expenses.get(i));
 			}
 			}
 			}
 		
 		String str ="";
 		
		for(int i=0; i<layoutCon.management.size();i++) {
			if(layoutCon.management.get(i).getDate().equals(YearMonth.from(homeCon.date))) {
			//	if(layoutCon.expenses.get(i).getDate().getYear()==(homeCon.date.getYear())) {
				str = String.valueOf(layoutCon.management.get(i).getMonthExpense());	
			//}			
		}
		}
		Label2.setText(str);
		String str1 ="";
		
		for(int j=0; j<layoutCon.management.size();j++) {
			if(layoutCon.management.get(j).getDate().equals(YearMonth.from(homeCon.date))) {
				//if(layoutCon.expenses.get(j).getDate().getYear()==(homeCon.date.getYear())) {
			//ㅉ}
				str1 = String.valueOf(layoutCon.management.get(j).getMonthIncome());
				}
		}
		Label1.setText(str1);
	
	/*	for(int z=0;z<layoutCon.expenses.size();z++) {
        	if(layoutCon.management.get(z).getDate().equals(YearMonth.from(homeCon.date))) {
        		//if(layoutCon.management.get(z).getDate().getYear()==(homeCon.date.getYear())) {
        		
        			Data da =new XYChart.Data(monthExpenses.get(z).getType(),monthExpenses.get(z).getExpense());
                	mo.add(da);
         		//	}      		
                	set1.setData(mo);
                	SalaryChart.getData().addAll(set1);
        			SalaryChart.getData().retainAll(set1);
        			//SalaryChart.getData().clear();
        			
        		
        }
        	else if(layoutCon.management.get(z).getDate().equals(YearMonth.from(homeCon.date))){
        		Data da =new XYChart.Data(monthExpenses.get(z).getType(),monthExpenses.get(z).getExpense());
    			mo.add(da);
        		
    			set1.setData(mo);
    			SalaryChart.getData().addAll(set1);
    			SalaryChart.getData().retainAll(set1);
    			//SalaryChart.getData().clear();
    			
        	}
        	
        	
		}*/
		
		
		
		
		
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

				
				homeCon.date = homeCon.date.minusMonths(1);
		 		dateTitle.setText(homeCon.date.getYear()+"년 "+homeCon.date.getMonthValue()+"월");
		 		monthExpenses.clear();
		 		SalaryChart.getData().clear();
		 	    mo.clear();
		 		
		 		for(int i=0;i<layoutCon.expenses.size();i++) {
		 			if(layoutCon.expenses.get(i).getDate().getMonth().equals(homeCon.date.getMonth())) {
		 				if(layoutCon.expenses.get(i).getDate().getYear()==(homeCon.date.getYear())) {
		 					monthExpenses.add(layoutCon.expenses.get(i));
		 			}
		 				
		 			}
		 		}
				String str ="";
				;
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
				
			/*	for(int z=0;z<layoutCon.expenses.size();z++) {
		        	if(layoutCon.management.get(z).getDate().equals(YearMonth.from(homeCon.date))) {
		        			Data data =new XYChart.Data(monthExpenses.get(z).getType(),monthExpenses.get(z).getExpense());
		                	mo.add(data);
		                	set1.setData(mo);
		                	SalaryChart.getData().addAll(set1);
			    			SalaryChart.getData().retainAll(set1);
			    			
		        }
		        	else if(layoutCon.management.get(z).getDate().equals(YearMonth.from(homeCon.date))){
		        		Data da =new XYChart.Data(monthExpenses.get(z).getType(),monthExpenses.get(z).getExpense());
		    			mo.add(da);
		        		
		    			set1.setData(mo);
		    			SalaryChart.getData().addAll(set1);
		    			SalaryChart.getData().retainAll(set1);
		    			
		        	}
		        
		        	
				}
				*/        
				expenseColumn.setSortType(TableColumn.SortType.DESCENDING);
				expenseTable.getSortOrder().add(expenseColumn);
				expenseColumn.setSortable(true);
				expenseTable.sort();
				expenseColumn.setSortable(false);
			}
	
				public ObservableList<Expense> getExpenses(){
				return monthExpenses;
			}
			
		public void setpieChart(LayoutController layoutCon) {
			this.layoutCon = layoutCon;
			
					pieChart.setData(pieData);
					//SalaryChart.getData().addAll(set1);
					//SalaryChart.getData().clear();
				      circle.setData(piedata);
				
			        expenseTable.setItems(getExpenses());
			       
			        expenseColumn.setSortType(TableColumn.SortType.DESCENDING);
					expenseTable.getSortOrder().add(expenseColumn);
					expenseColumn.setSortable(true);
					expenseTable.sort();
					expenseColumn.setSortable(false);
				
		}
			}

