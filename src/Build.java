import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.stage.*;
public class Build {

	private static int selection;
	
	public static int[] display() {
		Stage window = new Stage();
		
		//app view setup
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Build");
		window.setMinWidth(250);
		window.initStyle(StageStyle.UTILITY);
		window.setResizable(false);
		
		Label label1 = new Label("Enter plot you want to build on: ");
		
		Label rowLab = new Label("Row: ");
		
		Label colLab = new Label("Col:  ");
		ChoiceBox<String> rowVal = new ChoiceBox<>();
		rowVal.getItems().setAll("1", "2","3","4","5","6");
		
		ChoiceBox<String> colVal = new ChoiceBox<>();
		colVal.getItems().setAll("1", "2","3","4","5","6","7","8","9");
		
		Label label2 = new Label("What district would you like to build?");
		
		//button setup
		Button residential = new Button("Residential");
		Button commercial = new Button("Commercial");
		Button industrial = new Button("Industrial");
		Button demolish = new Button("Demolish");
		
		
		//all button options
		residential.setOnAction(e -> {
			selection = 7;
			window.close();
		});
		commercial.setOnAction(e -> {
			selection = 8;
			window.close();
		});
		industrial.setOnAction(e -> {
			selection = 9;
			window.close();
		});
		demolish.setOnAction(e -> {
			selection = 0;
			window.close();
		});
		HBox rowInput = new HBox();
		rowInput.getChildren().addAll(rowLab, rowVal);
		
		
		HBox colInput = new HBox();
		colInput.getChildren().addAll(colLab, colVal);
		
		HBox buttonLayout = new HBox();
		buttonLayout.getChildren().addAll(residential,commercial,industrial,demolish);
		
		VBox layout = new VBox();
		layout.getChildren().addAll(label1, rowInput, colInput, label2,buttonLayout);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
		
		int[] output = {(Integer.valueOf(rowVal.getValue()))-1, (Integer.valueOf(colVal.getValue()))-1, selection};
		return output;
	}
}
