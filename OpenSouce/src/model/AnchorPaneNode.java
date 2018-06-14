package model;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.time.LocalDate;

import controller.CalendarController;
import controller.HomeController;

/**
 * Create an anchor pane that can store additional data.
 */
public class AnchorPaneNode extends AnchorPane {

    // Date associated with this pane
    private LocalDate date;
    private HomeController homeCon;
    private CalendarController calendarCon;
    private boolean setClicked;

    /**
     * Create a anchor pane node. Date is not assigned in the constructor.
     * @param children children of the anchor pane
     */
    public AnchorPaneNode(Node... children) {
        super(children);
        // Add action handler for mouse clicked
        //this.setOnMouseClicked(e -> System.out.println("This pane's date is: " + date));
       // this.setOnMouseClicked(e -> homeCon.date = date );
       // this.setOnMouseClicked(e -> checkClicked());
       // this.setOnMouseClicked(e -> this.setStyle("-fx-background-color: yellow"));
        //this.setOnMouseClicked(e -> this.setStyle("-fx-border-color: black"));
       // this.setOnMouseClicked(e -> this.setClicked=true);
        this.setOnMouseClicked(new EventHandler<MouseEvent>() {
        	@Override
        	public void handle(MouseEvent ae) {
        		homeCon.date = date;
        		checkClicked();
        		setStyle("-fx-border-color: black;");
        		setClicked=true;
        	}
        });
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    public void checkClicked() {
    	for(int i=0;i<calendarCon.allCalendarDays.size();i++) {
    		if(calendarCon.allCalendarDays.get(i).setClicked) {
    			calendarCon.allCalendarDays.get(i).setStyle("-fx-border-color: white;");
    			calendarCon.allCalendarDays.get(i).setClicked = false;
    			break;
    		}
    	}
    }
}