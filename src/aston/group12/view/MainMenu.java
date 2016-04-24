package aston.group12.view;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainMenu extends Application implements GameScreen {
	
	
	private Stage primaryStage;
	private Scene scene;
	
	@Override
	public void start(Stage primaryStage){
		try {
			Parent root = FXMLLoader.load(getClass().getResource("layouts/mainmenu.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("Quoridor");
			primaryStage.getIcons().add(new Image("resources/icons/favicon.png"));
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Scene getScene() {
		return scene;
	}
	
	public static void main(String... args) {
		launch(args);
	}
	
	
	
}