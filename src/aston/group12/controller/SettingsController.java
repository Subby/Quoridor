package aston.group12.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
/**
 * 
 * Handles setting actions.
 *
 */
public class SettingsController extends AbstractController implements Initializable {
	
	
	@FXML
	private GridPane mainPane;
	@FXML
	private ChoiceBox<String> ruleBox;
	@FXML
	private ChoiceBox<Integer> wallBox;	
	@FXML
	private ChoiceBox<String> boardBox;	
	@FXML
	private ChoiceBox<Integer> tileBox;		
	@FXML
	private CheckBox indicateLabel;
	@FXML
	private CheckBox ghostTrail;	
	
	/**
	 * Handles action triggered by pressing the back button.
	 * @param event the action
	 */
    @FXML
    private void onBackBtn(ActionEvent event) {
    	Stage stage = (Stage) mainPane.getScene().getWindow();
    	loadScreen(stage, "mainmenu.fxml");
    }
    
    /**
     * Handles action triggered by pressing the reset button.
     */
	@FXML
	private void onResetBtn() {
		ruleBox.setValue("Standard");
		wallBox.setValue(10);
		boardBox.setValue("9x9");
		tileBox.setValue(50);
		indicateLabel.setSelected(true);
		//ghostTrail.setSelected(false);
	}   
	
	/**
	 * Handles the action triggered by pressing the save button.
	 */
	@FXML
	private void onSaveBtn() {

	}	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ObservableList<String> ruleList = FXCollections.observableArrayList("Standard", "Challenge");
		ruleBox.setValue("Standard");
		ruleBox.setItems(ruleList);	
		
		ObservableList<Integer> wallList = FXCollections.observableArrayList(8, 9, 10, 11, 12, 13, 14);
		wallBox.setValue(10);
		wallBox.setItems(wallList);
		
		ObservableList<String> boardList = FXCollections.observableArrayList("7x7", "9x9", "11x11");
		boardBox.setValue("9x9");
		boardBox.setItems(boardList);
		
		ObservableList<Integer> tileList = FXCollections.observableArrayList(50, 60, 70, 80);
		tileBox.setValue(50);
		tileBox.setItems(tileList);				
	}	
   
}
