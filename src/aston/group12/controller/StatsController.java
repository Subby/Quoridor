package aston.group12.controller;

import java.net.URL;
import java.util.ResourceBundle;

import aston.group12.model.GameSession;
import aston.group12.model.HumanPlayer;
import aston.group12.model.Player;
import aston.group12.model.Statistics;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Pair;

public class StatsController extends AbstractController implements Initializable {
	
	@FXML
	private Label winnerLabel;
	@FXML
	private TextArea statsArea;
	
	private GameSession gameSession;
	
	@FXML
	public void onMenuBtn(ActionEvent action) {
    	Stage stage = (Stage) winnerLabel.getScene().getWindow();
    	loadScreen(stage, "mainmenu.fxml");
	}
	
	public void setGameSession(GameSession gs) {
		this.gameSession = gs;
		winnerLabel.setText(gameSession.getWinner().getName() + " won!");
		for(Player p : gs.getPlayers()) {
			statsArea.appendText("---------- \n");	
			statsArea.appendText(p.getName() + "'s stats \n");
			statsArea.appendText("Walls used: " + p.getStatistics().getNumOfWallsUsed() + "\n");	
			statsArea.appendText("Total moves: " + p.getStatistics().getTotalMoves() + "\n");
			statsArea.appendText("---------- \n");				
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
}
