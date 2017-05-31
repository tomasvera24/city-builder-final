package Images;

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
import javafx.stage.StageStyle;

public class Instructions {
	public static void display() {
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Instructions");
		window.setMinWidth(250);
		window.initStyle(StageStyle.UTILITY);
		window.setResizable(false);
		
		
		
		
		VBox layout = new VBox();
		VBox text = new VBox();
		Label main = new Label("Instructions");
		Label label2 = new Label("Goal: Develop your city as long as possible");
		Label label3 = new Label("Lose: go into $500 debt or rating 0");
		Label label4 = new Label("Population: keep population above 0 following day 10 or you will lose rating");
		Label label5 = new Label("	residential-> $100 and -$3 per turn, expands population limit by 5 people");
		Label label6 = new Label("	Commercial-> $300, produces $5 per turn");
		Label label7 = new Label("	Industrial-> $500 and -1 rating, produces $15 per turn");
		Label label8 = new Label("Food: food is used to increase population and maintain it, do not let it go to 0 or you will lose rating");
		Label label9 = new Label("Taxes: best source of money, based on population, do not set to high or you will lose rating");
		main.getStyleClass().add("main");
		label2.getStyleClass().add("label");
		label3.getStyleClass().add("label");
		label4.getStyleClass().add("label");
		label5.getStyleClass().add("label");
		label6.getStyleClass().add("label");
		label7.getStyleClass().add("label");
		label8.getStyleClass().add("label");
		label9.getStyleClass().add("label");
		
		
		text.getChildren().addAll(main,label2,label3, label4,label5, label6, label7, label8, label9);
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
		window.setScene(scene);
		window.showAndWait();
		
	}
}
