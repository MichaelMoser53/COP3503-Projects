// Michael Moser
// Assignment 6

import java.util.Calendar; 
import java.util.GregorianCalendar;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;


public class n00976174 extends Application {

  @Override 
  public void start(Stage primaryStage) {
  
    // Create a clock and a label with random hours and minutes - Figure 14.52b
    int hour = (int)(Math.random() * 12);
    int minute = (int)(Math.random() * 60);
    int second = 0;
    
    ClockPane clock = new ClockPane(hour, minute, 0);
    Pane pane = new Pane(clock);
    
    String timeString = clock.getHour() + ":" + clock.getMinute() + ":" + clock.getSecond();
    Label timeLabel = new Label(timeString);
    
    
    // Figure 14.48a - Hangman Figure
    Pane pane2 = new Pane();
    
      
    // line attached to top of head
    Line line = new Line();
    line.setStartX(150);
    line.setStartY(20);
    line.setEndX(150);
    line.setEndY(35);
    pane2.getChildren().add(line);
      
    // line attached to rope and stand
    Line line2 = new Line();
    line2.setStartX(50);
    line2.setStartY(20);
    line2.setEndX(150);
    line2.setEndY(20);
    pane2.getChildren().add(line2);
      
    // line attached to arc
    Line line3 = new Line();
    line3.setStartX(50);
    line3.setStartY(20);
    line3.setEndX(50);
    line3.setEndY(185);
    pane2.getChildren().add(line3);
    
    // Head attached to body
    Circle head = new Circle(25);
    head.setCenterX(150);
    head.setCenterY(60);
    head.setStroke(Color.BLACK);
    head.setFill(Color.WHITE);
    pane2.getChildren().add(head);
      
    // line of body
    Line line4 = new Line();
    line4.setStartX(150);
    line4.setStartY(85);
    line4.setEndX(150);
    line4.setEndY(135);
    pane2.getChildren().add(line4);
      
    // line of left facing arm
    Line line5 = new Line();
    line5.setStartX(135);
    line5.setStartY(80);
    line5.setEndX(100);
    line5.setEndY(120);
    pane2.getChildren().add(line5);
      
    // line of right facing arm
    Line line6 = new Line();
    line6.setStartX(165);
    line6.setStartY(80);
    line6.setEndX(200);
    line6.setEndY(120);
    pane2.getChildren().add(line6);
      
    // line of left facing leg
    Line line7 = new Line();
    line7.setStartX(150);
    line7.setStartY(134);
    line7.setEndX(125);
    line7.setEndY(175);
    pane2.getChildren().add(line7);
      
    // line of right facing leg
    Line line8 = new Line();
    line8.setStartX(150);
    line8.setStartY(134);
    line8.setEndX(175);
    line8.setEndY(175);
    pane2.getChildren().add(line8);
    
    // base of line stand
    Arc baseStand = new Arc();
    baseStand.setCenterX(50);
    baseStand.setCenterY(190);
    baseStand.setRadiusX(35);
    baseStand.setRadiusY(20);
    baseStand.setStartAngle(0);
    baseStand.setLength(180);
    baseStand.setType(ArcType.OPEN);
    baseStand.setFill(Color.GREY);
    baseStand.setStroke(Color.BLACK);
    pane2.getChildren().add(baseStand);
    
      
    // Figure 14.45b - 4 Fans
    Pane pane3 = new Pane();
      
    int x = 60;
    int y = 60;

    for (int i = 0; i < 2; i++) {

         
       for (int j = 0; j < 2; j++) {
            
          Circle circle = new Circle(50);
          circle.setCenterX(x);
          circle.setCenterY(y);
          circle.setStroke(Color.BLACK);
          circle.setFill(Color.WHITE);
          pane3.getChildren().add(circle);

            
            for (int z = 30; z < 360; z += 90) {
               Arc arc = new Arc(x, y, 35, 35, z, 50);
               arc.setFill(Color.GREY);
               arc.setType(ArcType.ROUND);
               pane3.getChildren().add(arc);
            }
            
            x += 120;
         }
         
         x = 60;
         y += 120;
      }
      
      
    // All 3 figures in one pane to display all at once
    GridPane gridPane = new GridPane();
    gridPane.setHgap(5);
    gridPane.setVgap(5);
    gridPane.setPadding(new Insets(10));
      
    gridPane.add(pane, 0, 0);
    gridPane.add(timeLabel, 18, 1);
    gridPane.add(pane2, 31, 0);
    gridPane.add(pane3, 32, 0);
      
    // Displays scene with all 3 figures in a GridPane
    Scene scene = new Scene(gridPane, 700, 350);
    primaryStage.setTitle("DisplayFigures");
    primaryStage.setScene(scene);
    primaryStage.show();
      

  }


  public static void main(String[] args) {
    launch(args);
  }
}


// ClockPane class used to create clock and time label
class ClockPane extends Pane {
  private int hour;
  private int minute;
  private int second;
  
  /** Construct a default clock with the current time*/
  public ClockPane() {
    setCurrentTime();
  }

  /** Construct a clock with specified hour, minute, and second */
  public ClockPane(int hour, int minute, int second) {
    this.hour = hour;
    this.minute = minute;
    this.second = second;
  }

  /** Return hour */
  public int getHour() {
    return hour;
  }

  /** Set a new hour */
  public void setHour(int hour) {
    this.hour = hour;
    paintClock();
  }

  /** Return minute */
  public int getMinute() {
    return minute;
  }

  /** Set a new minute */
  public void setMinute(int minute) {
    this.minute = minute;
    paintClock();
  }

  /** Return second */
  public int getSecond() {
    return second;
  }

  /** Set a new second */
  public void setSecond(int second) {
    this.second = second;
    paintClock();
  }
  
  /* Set the current time for the clock */
  public void setCurrentTime() {
    // Construct a calendar for the current date and time
    Calendar calendar = new GregorianCalendar();

    // Set current hour, minute and second
    this.hour = calendar.get(Calendar.HOUR_OF_DAY);
    this.minute = calendar.get(Calendar.MINUTE);
    this.second = calendar.get(Calendar.SECOND);
    
    paintClock(); // Repaint the clock
  }
  
  /** Paint the clock */
  private void paintClock() {
    // Initialize clock parameters
    double clockRadius = 
      Math.min(220, 220) * 0.8 * 0.5;
    double centerX = 220 / 2;
    double centerY = 220 / 2;

    // Draw circle
    Circle circle = new Circle(centerX, centerY, clockRadius);
    circle.setFill(Color.WHITE);
    circle.setStroke(Color.BLACK);
    Text t1 = new Text(centerX - 5, centerY - clockRadius + 12, "12");
    Text t2 = new Text(centerX - clockRadius + 3, centerY + 5, "9");
    Text t3 = new Text(centerX + clockRadius - 10, centerY + 3, "3");
    Text t4 = new Text(centerX - 3, centerY + clockRadius - 3, "6");
    
    // Adds name in center of clock
    Text name = new Text(centerX-45, centerY, "Michael Moser");
    name.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
    name.setStroke(Color.BROWN);
    name.setFill(Color.BROWN);
    
    // Draw second hand
    double sLength = clockRadius * 0.8;
    double secondX = centerX + sLength * 
      Math.sin(second * (2 * Math.PI / 60));
    double secondY = centerY - sLength * 
      Math.cos(second * (2 * Math.PI / 60));
    Line sLine = new Line(centerX, centerY, secondX, secondY);
    sLine.setStroke(Color.RED);

    // Draw minute hand
    double mLength = clockRadius * 0.65;
    double xMinute = centerX + mLength * 
      Math.sin(minute * (2 * Math.PI / 60));
    double minuteY = centerY - mLength * 
      Math.cos(minute * (2 * Math.PI / 60));
    Line mLine = new Line(centerX, centerY, xMinute, minuteY);
    mLine.setStroke(Color.BLUE);
    
    // Draw hour hand
    double hLength = clockRadius * 0.5;
    double hourX = centerX + hLength * 
      Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
    double hourY = centerY - hLength *
      Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
    Line hLine = new Line(centerX, centerY, hourX, hourY);
    hLine.setStroke(Color.GREEN);
    
    getChildren().clear();  
    getChildren().addAll(circle, t1, t2, t3, t4,name, sLine, mLine, hLine);
  }
  
  @Override
  public void setWidth(double width) {
    super.setWidth(width);
    paintClock();
  }
  
  @Override
  public void setHeight(double height) {
    super.setHeight(height);
    paintClock();
  }
}