package controller;

import java.net.URL;
import java.util.ResourceBundle;

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

public class pieChartController implements Initializable{
	
	@FXML
	private ProgressBar barProgress;

    @FXML
    private BarChart<?, ?> SalaryChart;

    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;

    @FXML
    private PieChart pieChart;
		@Override
	
			public void initialize(URL url, ResourceBundle rd) {
				ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList(
						new PieChart.Data("�ĺ�", 20),
						new PieChart.Data("����",15),
						new PieChart.Data("����",30));
						pieChart.setData(pieData);
						
						
						XYChart.Series set1 = new XYChart.Series<>();
						set1.setName ("���� �ݾ�");
						
						set1.getData().add(new XYChart.Data("�����",35000));
						set1.getData().add(new XYChart.Data("�����",70000));
						set1.getData().add(new XYChart.Data("�ĺ�",80000));
						
						XYChart.Series set2 = new XYChart.Series<>();
						set2.setName ("��ǥ �ݾ�");
						
						set2.getData().add(new XYChart.Data("�����",60000));
						set2.getData().add(new XYChart.Data("�����",110000));
						set2.getData().add(new XYChart.Data("�ĺ�",130000));
						
						SalaryChart.getData().addAll(set1,set2);
						
						
						
					}
			}

