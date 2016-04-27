package aston.group12.view;

import java.io.IOException;

import aston.group12.model.Settings;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * 
 * The initial start point in the game.
 *
 */
public class MainMenu extends Application implements GameScreen {

	@Override
	public void start(Stage primaryStage){
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/resources/layouts/mainmenu.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("Quoridor");
			primaryStage.getIcons().add(new Image("resources/icons/favicon.png"));
			primaryStage.setScene(scene);
			primaryStage.show();
			//Setup the default settings
			Settings settings = Settings.getSingleton();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public static void main(String... args) {
		launch(args);
	}
	
	
	
}