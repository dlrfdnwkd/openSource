package controller;
import javafx.fxml.FXML;

public class HomeController {
	
	private Main main;

	public void setMain(Main main) {
		this.main = main;
	}
	@FXML
	private void inputButton() {
		main.setInputData();
	}

}
