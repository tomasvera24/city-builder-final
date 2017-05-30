import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class GameOver {
	public static Scene getScene(City city) {
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Food");
		window.setMinWidth(250);
		window.initStyle(StageStyle.UTILITY);
		window.setResizable(false);
		
		
		Label label1 = new Label("Game Over");
		
		VBox layout = new VBox();
		Label label2 = new Label(city.getName() + " Status Info:");
		Label label3 = new Label(" Day: " + city.getDaysElapsed());
		Label label4 = new Label("Population: " + city.getPopulation() + " Food: " + city.getFood() + " Money: $" + city.getMoney() );
		Label label5 = new Label("Tax Rate: " + city.getTax() + "% Rating: " + city.getRating());
		
		layout.getChildren().addAll(label1,label2,label3, label4,label5);
		BackgroundImage backGround= new BackgroundImage(new Image("/Images/background.jpg",1500,750,false,true),
		        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		          BackgroundSize.DEFAULT);
		
		layout.setBackground(new Background(backGround));
		layout.setAlignment(Pos.CENTER);
		Scene scene = new Scene(layout, 1500, 750);;
		return scene;
		
	}
}
