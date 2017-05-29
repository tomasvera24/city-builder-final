import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.stage.*;
public class Build {

	private static int selection;
	
	public static int[] display() {
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Build");
		window.setMinWidth(250);
		window.initStyle(StageStyle.UTILITY);
		window.setResizable(false);
		
		Label label1 = new Label("Enter plot you want to build on (row,col)(number)");
		TextField rowVal = new TextField();
		rowVal.setPromptText("Row");
		
		TextField colVal = new TextField();
		colVal.setPromptText("Col");
		
		Label label2 = new Label("What district would you like to build?");
		
		Button residential = new Button("Residential");
		Button commercial = new Button("Commercial");
		Button industrial = new Button("Industrial");
		
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
		HBox buttonLayout = new HBox();
		buttonLayout.getChildren().addAll(residential,commercial,industrial);
		
		VBox layout = new VBox();
		layout.getChildren().addAll(label1, rowVal, colVal, label2,buttonLayout);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
		
		int[] output = {Integer.valueOf(rowVal.getText()), Integer.valueOf(colVal.getText()), selection};
		return output;
	}
}
