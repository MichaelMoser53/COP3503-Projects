// Assignment 7
// I know the video is sideways, it adds artistic touch

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;
import javafx.scene.control.Slider;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.animation.KeyFrame;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.layout.Region;
import javafx.scene.control.Label;


// class contains main method for JavaFX
public class Project7 extends RectangleBounceSlider{


  public static void main(String[] args) {
    launch(args);
  }
  
}

// class contains name buttons and media player
class NameAndMedia extends Application {

  protected Text text = new Text(100, 200, "Michael Moser");
  
  protected BorderPane getPane() {
    HBox paneForButtons = new HBox(20);
    Button btUp = new Button("Up");
    Button btDown = new Button("Down");   
    paneForButtons.getChildren().addAll(btUp, btDown);
    paneForButtons.setAlignment(Pos.CENTER);
    paneForButtons.setStyle("-fx-border-color: red");

    BorderPane pane = new BorderPane();
    pane.setBottom(paneForButtons);
    
    Pane paneForText = new Pane();
    paneForText.getChildren().add(text);
    pane.setCenter(paneForText);
    
    btUp.setOnAction(e -> text.setY(text.getY() - 10));
    btDown.setOnAction(e -> text.setY(text.getY() + 10));
    
    final String MEDIA_URL = "http://www.unf.edu/~n00976174/Project_7_Video.mp4";   
    Media media = new Media(MEDIA_URL);
    MediaPlayer mediaPlayer = new MediaPlayer(media);
    MediaView mediaView = new MediaView(mediaPlayer);
    mediaView.setFitWidth(450);
    mediaView.setFitHeight(350);
    mediaView.setPreserveRatio(false);

    Button playButton = new Button(">");
      playButton.setOnAction(e -> {
        if (playButton.getText().equals(">")) {
         mediaPlayer.play();
         playButton.setText("||");
        } else {
         mediaPlayer.pause();
         playButton.setText(">");
        }
      });

    Button rewindButton = new Button("<<");
    rewindButton.setOnAction(e -> mediaPlayer.seek(Duration.ZERO));
    
    Slider slVolume = new Slider();
    slVolume.setPrefWidth(150);
    slVolume.setMaxWidth(Region.USE_PREF_SIZE);
    slVolume.setMinWidth(30);
    slVolume.setValue(50);
    mediaPlayer.volumeProperty().bind(slVolume.valueProperty().divide(100));

    HBox hBox = new HBox(10);
    hBox.setAlignment(Pos.CENTER);
    hBox.getChildren().addAll(playButton, rewindButton,new Label("Volume"), slVolume);

    BorderPane videoPane = new BorderPane();
    videoPane.setCenter(mediaView);
    videoPane.setBottom(hBox);
      
    // adds the name and video pane's in one GridPane to be displayed in the center
    GridPane twoPanes = new GridPane();
    twoPanes.setHgap(20);
    twoPanes.setVgap(20);
    twoPanes.setPadding(new Insets(0, 10 , 0, 10));
    pane.setCenter(twoPanes);
      

    twoPanes.add(paneForText, 0, 0); 
      
    twoPanes.add(videoPane, 1, 0);
    
    return pane;
  }
  
   
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    // Create a scene and place it in the stage
    Scene scene = new Scene(getPane(), 1000, 800);
    primaryStage.setTitle("Assignment 7");
    primaryStage.setScene(scene);
    primaryStage.show();
  }


}

// class handles check boxes for handling event of click to change font to bold or italic on left side of pane
class CheckBoxDemo extends NameAndMedia {
  @Override // Override the getPane() method in the super class
  protected BorderPane getPane() {
    BorderPane pane = super.getPane();

    Font fontBoldItalic = Font.font("Courier New", FontWeight.BOLD, FontPosture.ITALIC, 20);
    Font fontBold = Font.font("Courier New", FontWeight.BOLD, FontPosture.REGULAR, 20);
    Font fontItalic = Font.font("Courier New", FontWeight.NORMAL, FontPosture.ITALIC, 20);
    Font fontNormal = Font.font("Courier New", FontWeight.NORMAL, FontPosture.REGULAR, 20);
    
    text.setFont(fontNormal);
    
    VBox paneForCheckBoxes = new VBox(20);
    paneForCheckBoxes.setPadding(new Insets(5, 5, 5, 5)); 
    paneForCheckBoxes.setStyle("-fx-border-color: red");
    CheckBox chkBold = new CheckBox("Bold");
    CheckBox chkItalic = new CheckBox("Italic");
    paneForCheckBoxes.getChildren().addAll(chkBold, chkItalic);
    pane.setLeft(paneForCheckBoxes);

   // Event handler of changing name text for each check box
    EventHandler<ActionEvent> handler = e -> { 
      if (chkBold.isSelected() && chkItalic.isSelected()) {
        text.setFont(fontBoldItalic); // Both check boxes checked
      }
      else if (chkBold.isSelected()) {
        text.setFont(fontBold); // The Bold check box checked
      }
      else if (chkItalic.isSelected()) {
        text.setFont(fontItalic); // The Italic check box checked
      }      
      else {
        text.setFont(fontNormal); // Both check boxes unchecked
      }
    };
    
    chkBold.setOnAction(handler);
    chkItalic.setOnAction(handler);
    
    return pane; // Return a new pane
  }
  
}

// class creates radio buttons to change color of text and placed on right side of the pane
class RadioButtonDemo extends CheckBoxDemo {
  @Override // Override the getPane() method in the super class
  protected BorderPane getPane() {
    BorderPane pane = super.getPane();
    
    VBox paneForRadioButtons = new VBox(20);
    paneForRadioButtons.setPadding(new Insets(5, 5, 5, 5)); 
    paneForRadioButtons.setStyle
      ("-fx-border-width: 2px; -fx-border-color: red");
    
    // creates new radio buttons for switching color of text to teal, orange, or purple
    RadioButton rbTeal = new RadioButton("Teal");
    RadioButton rbOrange = new RadioButton("Orange");
    RadioButton rbPurple = new RadioButton("Purple");
    paneForRadioButtons.getChildren().addAll(rbTeal, rbOrange, rbPurple);
    pane.setRight(paneForRadioButtons);

    ToggleGroup group = new ToggleGroup();
    rbTeal.setToggleGroup(group);
    rbOrange.setToggleGroup(group);
    rbPurple.setToggleGroup(group);
    
    rbTeal.setOnAction(e -> {
      if (rbTeal.isSelected()) {
        text.setFill(Color.TEAL);
      }
    });
    
    rbOrange.setOnAction(e -> {
      if (rbOrange.isSelected()) {
        text.setFill(Color.ORANGE);
      }
    });

    rbPurple.setOnAction(e -> {
      if (rbPurple.isSelected()) {
        text.setFill(Color.PURPLE);
      }
    });
    
    return pane; // returns a new pane
  }
  
  }
  
// class creates slider for the speed of the bouncing rectangle
class RectangleBounceSlider extends RadioButtonDemo {
  @Override // Override the start method in the Application class
  protected BorderPane getPane() {
    BorderPane pane = super.getPane();
    
    // creates a rectangle from "RectanglePane" class and allows adjustment of speed of bouncing
    RectanglePane rectanglePane = new RectanglePane();
    Slider slSpeed = new Slider();
    slSpeed.setMax(40);
    rectanglePane.rateProperty().bind(slSpeed.valueProperty());
    
    BorderPane recPane = new BorderPane();
    recPane.setCenter(rectanglePane);
    recPane.setBottom(slSpeed);
    recPane.setPrefSize(150,130);
    
    pane.setTop(recPane);
        
return pane; // returns a new pane
  }
  
 }

// class creates a red rectangle and bounds the movement of rectangle to size of the pane
class RectanglePane extends Pane {
  public final double width = 50;
  public final double height = 20;
  private double x = width, y = height;
  private double dx = 1, dy = 1;
  private Rectangle rectangle = new Rectangle(x, y);
  private Timeline animation;

  public RectanglePane() {
    rectangle.setFill(Color.RED); 
    getChildren().add(rectangle);

    // Create an animation for moving the ball
    animation = new Timeline(
      new KeyFrame(Duration.millis(50), e -> moveRectangle()));
    animation.setCycleCount(Timeline.INDEFINITE);
    animation.play(); // Start animation
  }

  public void play() {
    animation.play();
  }

  public void pause() {
    animation.pause();
  }

  public void increaseSpeed() {
    animation.setRate(animation.getRate() + 0.1);
  }

  public void decreaseSpeed() {
    animation.setRate(
      animation.getRate() > 0 ? animation.getRate() - 0.1 : 0);
  }

  public DoubleProperty rateProperty() {
    return animation.rateProperty();
  }
  
  protected void moveRectangle() {
    // Check boundaries
    if (x < width || x > getWidth() - width) {
      dx *= -1; // Change ball move direction
    }
    if (y < height || y > getHeight() - height) {
      dy *= -1; // Change ball move direction
    }

    // Adjust ball position
    x += dx;
    y += dy;
    rectangle.setX(x);
    rectangle.setY(y);
  }
}
