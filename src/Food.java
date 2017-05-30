import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Food {
	private static int foodVal;
	public static int display() {
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Food");
		window.setMinWidth(250);
		window.initStyle(StageStyle.UTILITY);
		window.setResizable(false);
		
		
		Label label1 = new Label("How much food would you like to buy (Max 5): ");
		ChoiceBox<String> foodField = new ChoiceBox<>();
		foodField.getItems().setAll("1", "2","3","4","5");
		
		Button submit = new Button("Accept");
		Button cancel = new Button("Cancel");
		
		submit.setOnAction(e -> {
			foodVal = Integer.valueOf(foodField.getValue());
			window.close();
		});
		cancel.setOnAction(e -> {
			window.close();
		});
		HBox buttonLayout = new HBox();
		buttonLayout.getChildren().addAll(submit,cancel);
		
		VBox layout = new VBox();
		layout.getChildren().addAll(label1, foodField,buttonLayout);
		
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
		
		
		return foodVal;
	}
}
