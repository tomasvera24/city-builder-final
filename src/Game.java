import java.awt.GridLayout;

import javax.swing.JLabel;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Game {
	
	Scene game;
	Stage window;
	
	City city;
	BorderPane layout;
	
	public Game(Stage window, City city) {
		this.window = window;
		this.city = city;
	}
	

	public Scene getScene() {
		
		//Options
		VBox options = new VBox();
		Button button1 = new Button("Build District");
		Button button2 = new Button("Purchase Food");
		Button button3 = new Button("Adjust Taxes");
		Button button4 = new Button("Next Day");
		button1.setOnAction(e -> {	
			int[] buildResult = Build.display();
			city.setCityTile(buildResult[0], buildResult[1], buildResult[2]);
			button1.setDisable(true);
			button2.setDisable(true);
			button3.setDisable(true);
			
			
			
		});
		button2.setOnAction(e -> {
			int foodResult = Food.display();
			city.buyFood(foodResult);
			button1.setDisable(true);
			button2.setDisable(true);
			button3.setDisable(true);
		});
		button3.setOnAction(e -> {
			double taxResult = Taxes.display(city.getTaxNum());
			city.setTax(taxResult);
			button1.setDisable(true);
			button2.setDisable(true);
			button3.setDisable(true);
			
		});
		button4.setOnAction(e -> {
			window.setScene(this.getScene());
			city.nextDay();
			if (city.nextDay() == false) {
				window.setScene(GameOver.getScene(this.city));
			}
			button2.setDisable(false);
			button3.setDisable(false);
		});
		options.getChildren().addAll(button1, button2, button3, button4);
		options.setAlignment(Pos.CENTER);
		options.setSpacing(100);
		
		
		
		//Stats
		VBox stats = new VBox();
		Label label1 = new Label(city.getName() + " Status Info:");
		Label label2 = new Label(" Day: " + city.getDaysElapsed());
		Label label3 = new Label("Population: " + city.getPopulation() + " Food: " + city.getFood() + " Money: $" + city.getMoney() );
		Label label4 = new Label("Tax Rate: " + city.getTax() + "% Rating: " + city.getRating());
		
		
		ImageView dateImg = new ImageView(new Image("/Images/date.jpg",40,40,false,true));
	    Text dateText = new Text(city.getDaysElapsed());
	    StackPane date = new StackPane();

	    date.getChildren().add(dateImg);
	    date.getChildren().add(dateText);

	    date.setAlignment(Pos.CENTER);
	    
	    stats.getChildren().addAll(date,label1,label3, label4);
		stats.setAlignment(Pos.CENTER);
		
		//City Layout
		GridPane cityLayout = new GridPane();
		cityLayout.setPadding(new Insets(10,10,10,10));
		cityLayout.setVgap(0);
		cityLayout.setHgap(0);

		
		ImageView[] img = new ImageView[city.getCityLayout().length * city.getCityLayout()[0].length];
		
		int k = 0;
		for (int row = 0; row < city.getCityLayout().length; row++) {
			for (int col = 0; col < city.getCityLayout()[0].length; col++) {
				img[k++] = new ImageView(this.placeTile(city.getCityLayout()[row][col]));
			}
		}
		
		int c = 0;
		for (int row = 0; row < city.getCityLayout().length; row++) {
			for (int col = 0; col < city.getCityLayout()[0].length; col++) {
				GridPane.setConstraints(img[c], col, row);
				cityLayout.getChildren().add(img[c++]);
			}
		}
		
		//backround image
		
		
		
		cityLayout.setAlignment(Pos.CENTER);
		
		
		layout = new BorderPane();
		layout.setTop(stats);
		layout.setLeft(options);
		layout.setCenter(cityLayout);
		
		BackgroundImage backGround= new BackgroundImage(new Image("/Images/background.jpg",1500,750,false,true),
		        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		          BackgroundSize.DEFAULT);
		
		layout.setBackground(new Background(backGround));
		
		game = new Scene(layout, 1500, 750);
		game.getStylesheets().add("Game.css");
		return game;
		
	}
	
	public Image placeTile(int x) {
		/*
		code key:
		0 = grass
		1 = trees
		2 = water
		3 = top right corner
		4 = top left corner
		5 = bottom right corner
		6 = bottom left corner
		7 = housing district
		8 = commercial district
		9 = industrial district
		*/
		Image output = new Image("/Images/grass.png",100,100,false,true);
        
        if (x == 1) {
        	output = new Image("/Images/trees.png",100,100,false,true);
        }
        if (x == 2) {
        	output = new Image("/Images/water.png",100,100,false,true);
        }
        if (x == 3) {
        	output = new Image("/Images/top-right-water.png",100,100,false,true);
        }
        if (x == 4) {
        	output = new Image("/Images/top-left-water.png",100,100,false,true);
        }
        if (x == 5) {
        	output = new Image("/Images/bottom-right-water.png",100,100,false,true);
        }
        if (x == 6) {
        	output = new Image("/Images/bottom-left-water.png",100,100,false,true);
        }
        if (x == 7) {
        	output = new Image("/Images/house.png",100,100,false,true);
        }
        if (x == 8) {
        	output = new Image("/Images/commercial.png",100,100,false,true);
        }
        if (x == 9) {
        	output = new Image("/Images/industrial.png",100,100,false,true);
        }

        return output;
	}
}
