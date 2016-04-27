package aston.group12.controller;

import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
/**
 * Handles Main Menu actions.
 *
 */
public class MainMenuController extends AbstractController {
	
	@FXML
	private Button exitButton;
	
	/**
	 * Handles action triggered by the play button being pressed.
	 * @param event the action
	 */
    @FXML 
    private void onPlayBtnPress(ActionEvent event) {
    	Stage stage = (Stage) exitButton.getScene().getWindow();
    	loadScreen(stage, "setup.fxml");
    }
    
    /**
	 * Handles action triggered by the help button being pressed.
	 * @param event the action
     */
    @FXML 
    private void onHelpBtnPress(ActionEvent event) {
    	Stage stage = (Stage) exitButton.getScene().getWindow();
    	loadScreen(stage, "help.fxml");
    }  
    
    /**
	 * Handles action triggered by the settings button being pressed.
	 * @param event the action
     */    
    @FXML 
    private void onSettingBtnPress(ActionEvent event) {
    	Stage stage = (Stage) exitButton.getScene().getWindow();
    	loadScreen(stage, "options.fxml");
    }
    
    /**
	 * Handles action triggered by the exit button being pressed.
	 * @param event the action
     */    
    @FXML 
    private void onExitBtnPress(ActionEvent event) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Exit Confirmation");
        alert.setHeaderText("Exit Quoridor");
        alert.setContentText("Are you sure you want to exit the game?");  	
        
        Optional<ButtonType> result = alert.showAndWait();
        if(result.get() == ButtonType.OK) {
        	Stage stage = (Stage) exitButton.getScene().getWindow();
        	stage.close();
        	return;
        } else {
        	//empty to handle normal closing
        }

    }
}
