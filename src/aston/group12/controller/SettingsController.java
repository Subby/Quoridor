package aston.group12.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SettingsController extends AbstractController {
	
	
	@FXML
	private GridPane mainPane;
	
	/**
	 * Handles action triggered by pressing the back button.
	 * @param event the action
	 */
    @FXML
    private void onBackBtn(ActionEvent event) {
    	Stage stage = (Stage) mainPane.getScene().getWindow();
    	loadScreen(stage, "mainmenu.fxml");
    }
   
}
