import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class Intro {
	
	Scene intro;
	Stage window;
	
	public Intro(Stage window) {
		this.window = window;
	}
	
	public Scene getScene(Scene setup) {
		
		//Set background image
		BackgroundImage backGround= new BackgroundImage(new Image("/Images/City.jpg",1500,750,false,true),
		        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		          BackgroundSize.DEFAULT);
		
		
		VBox introLayout = new VBox();
		Label title = new Label("Tomas' City Builder");
		title.setFont(Font.font("Ariel", FontWeight.BOLD, 40));
		
		title.setTextFill(Color.WHITE);
		Button start = new Button("Start");
		introLayout.getChildren().addAll(title, start);
		start.setOnAction(e -> window.setScene(setup));
		introLayout.setAlignment(Pos.CENTER);
		introLayout.setBackground(new Background(backGround));
		intro = new Scene(introLayout, 1500, 750);
		intro.getStylesheets().add("Intro.css");
		return intro;
	}
}
