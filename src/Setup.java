import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;


public class Setup {
	
	Scene setup;
	Stage window;
	String nameField;
	City city;
	
	public Setup(Stage window) {
		this.window = window;
	}
	
	public Scene getScene(Scene game) {
		VBox setupLayout = new VBox();
		
		Label cityNameLabel = new Label("Enter name for city:");
		TextField cityNameField = new TextField ();
		Button submit = new Button("Submit");
		setupLayout.getChildren().addAll(cityNameLabel, cityNameField, submit);
		submit.setOnAction(e -> {
			window.setScene(game);
			city = new City(cityNameField.getText());
		});
		
		setupLayout.setAlignment(Pos.CENTER);
		setup = new Scene(setupLayout, 1500, 750);
		
		return setup;
		
	}
	public City getCity() {
		return this.city;
	}
}
