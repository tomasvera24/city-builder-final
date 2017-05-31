import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class GameOver {
	public static Scene getScene(City city) {
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Game Over");
		
		
		
		//game over information
		VBox layout = new VBox();
		VBox text = new VBox();
		Label main = new Label("Game Over");
		Label label2 = new Label(city.getName() + " Status Info:");
		Label label3 = new Label(" Days Survived: " + city.getDaysElapsed());
		Label label4 = new Label("Population: " + city.getPopulation() + " Food: " + city.getFood() + " Money: $" + city.getMoney() );
		Label label5 = new Label("Tax Rate: " + city.getTax() + "% Rating: " + city.getRating());
		Label label6 = new Label("Your Score: " + city.getScore());
		main.getStyleClass().add("main");
		label2.getStyleClass().add("label");
		label3.getStyleClass().add("label");
		label4.getStyleClass().add("label");
		label5.getStyleClass().add("label");
		label6.getStyleClass().add("score");
		
		
		text.getChildren().addAll(main,label2,label3, label4,label5, label6);
		text.getStyleClass().add("text");
		layout.getChildren().add(text);
		BackgroundImage backGround= new BackgroundImage(new Image("/Images/background.jpg",1500,750,false,true),
		        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		          BackgroundSize.DEFAULT);
		
		text.setAlignment(Pos.CENTER);
		layout.setBackground(new Background(backGround));
		layout.setAlignment(Pos.CENTER);
		Scene scene = new Scene(layout, 1500, 750);;
		scene.getStylesheets().add("Gameover.css");
		return scene;
		
	}
}
