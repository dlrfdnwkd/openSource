package controller;
	
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {
	@Override
	/*public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../view//pieChart.fxml"));
			AnchorPane root = (AnchorPane) loader.load();
			Scene scene = new Scene(root);	
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}*/

	public void start(Stage primaryStage) {
		
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../view/pieChart.fxml"));
			AnchorPane root =(AnchorPane)loader.load();
			Stage stage = new Stage();
			stage.initModality(Modality.WINDOW_MODAL);
			stage.initOwner(primaryStage);
			stage.setTitle("ÃÑ¾× ¹× ºÐ¼®");
			Scene scene = new Scene(root);
			stage.setScene(scene);
			pieChartController controller = loader.getController();
			stage.show();
		}catch(Exception e) {
			e.printStackTrace();
		}
		    double sliderwidth = 200;
		    
		    final Slider slider = new Slider();
		    slider.setMin(0);
		    slider.setMinWidth(sliderwidth);
		    slider.setMaxWidth(sliderwidth);
		    
		    final ProgressBar pb = new ProgressBar(0);
		    pb.setMinWidth(sliderwidth);
		    pb.setMaxWidth(sliderwidth);
		    
		    final ProgressIndicator pi =new ProgressIndicator(0);
		    
		    slider.valueProperty().addListener(new ChangeListener<Number>(){

				@Override
				public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
					pb.setProgress(new_val.doubleValue() / 50);
					pi.setProgress(new_val.doubleValue() / 50);
				}});
			
		    
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	}

