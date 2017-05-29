import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Taxes {
	private static double taxRate;
	public static double display(double tax) {
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Taxes");
		window.setMinWidth(250);
		window.initStyle(StageStyle.UTILITY);
		window.setResizable(false);
		
		taxRate = tax;
		Label label1 = new Label("Enter new tax rate");
		TextField taxVal = new TextField();
		taxVal.setPromptText("%");
		
		Button submit = new Button("Accept");
		Button cancel = new Button("Cancel");
		
		submit.setOnAction(e -> {
			taxRate = Double.valueOf(taxVal.getText());
			window.close();
		});
		submit.setOnAction(e -> {
			window.close();
		});
		HBox buttonLayout = new HBox();
		buttonLayout.getChildren().addAll(submit,cancel);
		
		VBox layout = new VBox();
		layout.getChildren().addAll(label1, taxVal,buttonLayout);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
		
		return taxRate;
	}
}
