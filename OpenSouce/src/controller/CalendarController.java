package controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.AnchorPaneNode;
import model.Expense;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;


public class CalendarController {

    public static ArrayList<AnchorPaneNode> allCalendarDays = new ArrayList<>(35);
    private VBox view;
    private Text calendarTitle;
    private YearMonth currentYearMonth;
    private ObservableList<Expense> expenses = FXCollections.observableArrayList();
    private static HomeController homeCon;

    /**
     * Create a calendar view
     * @param yearMonth year month to create the calendar of
     * @throws FileNotFoundException 
     */
    public CalendarController(YearMonth yearMonth) {
    	expenses.add(new Expense("길우",LocalDate.of(2018, 6, 12),"유흥","점심",2000,"컵라면"));
    	expenses.add(new Expense("길우",LocalDate.of(2018, 5, 4),"교통","저녁",30000,"음료수"));
    	currentYearMonth = yearMonth;
    	allCalendarDays.clear();
    	//homeCon.yearMonth = yearMonth;
        // Create the calendar grid pane
        GridPane calendar = new GridPane();
        calendar.setPrefSize(1000, 650);
        calendar.setGridLinesVisible(true);
        // Create rows and columns with anchor panes for the calendar
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                AnchorPaneNode ap = new AnchorPaneNode();
                ap.setPrefSize(300,100);
                calendar.add(ap,j,i);
                allCalendarDays.add(ap);
            }
        }
        // Days of the week labels
        Text[] dayNames = new Text[]{ new Text("Sun"), new Text("Mon"), new Text("Tue"),
                                        new Text("Wed"), new Text("Thu"), new Text("Fri"),
                                        new Text("Sat") };
        GridPane dayLabels = new GridPane();
        dayLabels.setPrefWidth(600);
        dayLabels.setGridLinesVisible(true);
        
        Integer col = 0;
        for (Text txt : dayNames) {
            AnchorPane ap = new AnchorPane();
            ap.setPrefSize(400, 40);
            ap.setBottomAnchor(txt, 10.0);
            ap.setLeftAnchor(txt, 60.0);
            ap.setCenterShape(false);
            txt.setStyle("-fx-font-size : 15;-fx-fill: white;");
            ap.getChildren().add(txt);
            ap.setStyle("-fx-background-color : royalblue;-fx-border-color: white;");
            dayLabels.add(ap, col++, 0);
        }
        // Create calendarTitle and buttons to change current month
        calendarTitle = new Text();
        calendarTitle.setStyle("-fx-fill: blue;-fx-font-size: 18");
        //Image image = new Image("file:image/a.png");
        //ImageView imageView = new ImageView();
        //imageView.setImage(image);
        //imageView.setPreserveRatio(true);
        //imageView.setFitWidth(1);
        //Image image = new Image(getClass().getResourceAsStream("@../image/a.png"));
        //ImageView imageView = new ImageView(image);
        Button previousMonth = new Button("<");
        previousMonth.setStyle("-fx-border-color: blue; -fx-border-radius: 10;-fx-background-color: white");
        //previousMonth.setGraphic(imageView);
        //previousMonth.setGraphic(new ImageView(image));
        //Image image = new Image(getClass().getResourceAsStream("/immage/a.png"));
       // previousMonth.setStyle("-fx-background-image: url('image/a.png')");       
        previousMonth.setOnAction(e -> previousMonth());
        Button nextMonth = new Button(">");
        nextMonth.setStyle("-fx-border-color: blue; -fx-border-radius: 10;-fx-background-color: white");
        nextMonth.setOnAction(e -> nextMonth());
        HBox titleBar = new HBox(previousMonth,calendarTitle,nextMonth);
        titleBar.setPrefSize(1000, 40);
        titleBar.setAlignment(Pos.BASELINE_CENTER);

        //titleBar.set(Pos.BASELINE_CENTER);
        //homeCon.previousMonthButton.setOnAction(e -> previousMonth());
        //homeCon.nextMonthButton.setOnAction(e -> nextMonth());
        // Populate calendar with the appropriate day numbers
        populateCalendar(yearMonth);
        // Create the calendar view
        view = new VBox(titleBar,dayLabels, calendar);
    }

    /**
     * Set the days of the calendar to correspond to the appropriate date
     * @param yearMonth year and month of month to render
     */
    public void populateCalendar(YearMonth yearMonth) {
        // Get the date we want to start with on the calendar
        LocalDate calendarDate = LocalDate.of(yearMonth.getYear(), yearMonth.getMonthValue(), 1);
       // currentYearMonth = (YearMonth)calendarDate.getMonth();
        // Dial back the day until it is SUNDAY (unless the month starts on a sunday)
        while (!calendarDate.getDayOfWeek().toString().equals("SUNDAY") ) {
            calendarDate = calendarDate.minusDays(1);
        }
        // Populate the calendar with day numbers
        for (AnchorPaneNode ap : allCalendarDays) {
            if (ap.getChildren().size() != 0) {
                ap.getChildren().clear();
                ap.setStyle("-fx-border-color: white;");
            }
            ap.setDate(calendarDate);
            for(int a=0;a<expenses.size();a++) {
                if(ap.getDate().equals((expenses.get(a).getDate())))
                {
                Text expense = new Text(Integer.toString(expenses.get(a).getExpense()));
                ap.setRightAnchor(expense, 30.0);
                ap.setBottomAnchor(expense, 30.0);
                ap.getChildren().add(expense);
                ap.setStyle("-fx-background-color: deepskyblue;-fx-border-color: white;");
                }
                }
            if(!calendarDate.getMonth().equals(yearMonth.getMonth()))
            {
            	ap.setStyle("-fx-background-color: gray;-fx-border-color: white;");
            	ap.getChildren().clear();
            }
           // ap.setStyle("-fx-border-color: white;");
            Text txt = new Text(String.valueOf(calendarDate.getDayOfMonth()));
          //  ap.setDate(calendarDate);
            ap.setTopAnchor(txt, 5.0);
            ap.setLeftAnchor(txt, 5.0);
            ap.getChildren().add(txt);
            calendarDate = calendarDate.plusDays(1);
        }
        calendarTitle.setText(String.valueOf(yearMonth.getYear() + "년   " + yearMonth.getMonth().getValue()+"월"));
    }

    /**
     * Move the month back by one. Repopulate the calendar with the correct dates.
     */
    private void previousMonth() {
        currentYearMonth = currentYearMonth.minusMonths(1);
        populateCalendar(currentYearMonth);
    }

    /**
     * Move the month forward by one. Repopulate the calendar with the correct dates.
     */
    private void nextMonth() {
        currentYearMonth = currentYearMonth.plusMonths(1);
        populateCalendar(currentYearMonth);
    }

    public VBox getView() {
        return view;
    }

    public ArrayList<AnchorPaneNode> getAllCalendarDays() {
        return allCalendarDays;
    }

    public void setAllCalendarDays(ArrayList<AnchorPaneNode> allCalendarDays) {
        this.allCalendarDays = allCalendarDays;
    }
}

