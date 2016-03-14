package aston.group12.view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainMenu extends Application implements GameScreen {

	public static void main(String args[]) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage){
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root);
        //scene.getStylesheets().add("resources/style.css");
        HBox hBox = addTopBox();
        HBox buttonHBox = addButtonHBox();
        root.setTop(hBox);
        root.setCenter(buttonHBox);
        addStackPane(buttonHBox);
        addStackPane(hBox);
        stage.setTitle("Launcher");
        stage.setScene(scene);
        stage.sizeToScene(); 
        stage.show();		
	}
	
	/**
	 * Adds a horizontal box in the stack pane.
	 * @param hb the horizontal box to add
	 */
	private void addStackPane(HBox hb) {    
		StackPane stack = new StackPane();
		hb.getChildren().add(stack);
	}
	
	/**
	 * Adds a horizontal box for the logo
	 * @return hBox the horizontal box
	 */
    public HBox addTopBox() {
    	HBox hBox = new HBox();
    	hBox.setPadding(new Insets(0, 0, 0, 200));
    	ImageView logo = new ImageView(new Image("resources/logo.png"));
    	hBox.getChildren().add(logo);
    	return hBox;
    }
    
    /**
     * Adds a horizontal box with buttons.
     * @return haxBox the horizontal box
     */
	private HBox addButtonHBox() {
		HBox haxBox = new HBox();
		haxBox.setPadding(new Insets(0, 0, 20, 55));
		haxBox.setSpacing(30.0);
        Button playBtn = new Button("Play");
        playBtn.getStyleClass().add("button");

        Button helpBtn = new Button("Help");
        helpBtn.getStyleClass().add("button");

        Button statsBtn = new Button("Statistics");
        statsBtn.getStyleClass().add("button");

        Button optionsBtn = new Button("Options");
        optionsBtn.getStyleClass().add("button");
        
        haxBox.getChildren().addAll(playBtn, helpBtn, statsBtn, optionsBtn);
		return haxBox;
	}    

}
