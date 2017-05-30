import javafx.application.*;
import javafx.stage.Stage;
import javafx.scene.Scene;



public class Main extends Application{

	Scene intro;
	Scene setup;
	Scene game;
	
	
	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage window) throws Exception {
		window.setTitle("City Builder");
		
		City city = new City("City");
		
		//define intro scene
		Intro intro = new Intro(window);
		
		//define setup scene
		Setup setup = new Setup(window);
		
		//define city class
		
		//define game scene
		Game game = new Game(window, city);
		
		
		window.setScene(intro.getScene(setup.getScene(game.getScene())));
		window.show();
		
		
	}
}
