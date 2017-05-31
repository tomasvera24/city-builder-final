import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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


public class Setup {
	
	//instance variables
	Scene setup;
	Stage window;
	String nameField;
	City city;
	
	public Setup(Stage window) {
		this.window = window;
	}
	
	public Scene getScene(Scene game) {
		VBox setupLayout = new VBox();
		
		//label and display setup
		Label cityNameLabel = new Label("Enter name for city:");
		cityNameLabel.setFont(Font.font("Ariel", FontWeight.BOLD, 40));
		cityNameLabel.setTextFill(Color.WHITE);
		TextField cityNameField = new TextField ();
		cityNameField.setId("field");
		Label empty = new Label("");
		Button submit = new Button("Submit");
		setupLayout.getChildren().addAll(cityNameLabel, cityNameField, empty, submit);
		submit.setOnAction(e -> {
			window.setScene(game);
			city = new City(cityNameField.getText());
		});
		
		//image setup
		BackgroundImage backGround= new BackgroundImage(new Image("/Images/Landscape.jpg",1500,750,false,true),
		        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		          BackgroundSize.DEFAULT);
		
		setupLayout.setAlignment(Pos.CENTER);
		setupLayout.setBackground(new Background(backGround));
		setup = new Scene(setupLayout, 1500, 750);
		setup.getStylesheets().add("Setup.css");
		return setup;
		
	}
	public City getCity() {
		return this.city;
	}
}
