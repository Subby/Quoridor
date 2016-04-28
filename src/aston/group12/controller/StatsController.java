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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Pair;

public class StatsController extends AbstractController implements Initializable {
	
	@FXML
	private Label winnerLabel;
	@FXML
	private TableView<Statistics> statsTable;
	@FXML
	private TableColumn<Player, String> playerColumn;
	@FXML
	private TableColumn<Statistics, Integer> movesColumn;
	@FXML
	private TableColumn<Statistics, Integer> wallsColumn;	
	
	private GameSession gameSession;
	
	@FXML
	public void onMenuBtn(ActionEvent action) {
    	Stage stage = (Stage) winnerLabel.getScene().getWindow();
    	loadScreen(stage, "mainmenu.fxml");
	}
	
	public void setGameSession(GameSession gs) {
		this.gameSession = gs;
		winnerLabel.setText(gameSession.getWinner().getName() + " won!");
		statsTable.getItems().add(gs.getPlayer(0).getStatistics());
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//playerColumn.setCellValueFactory(new PropertyValueFactory<Player, String>("name"));
		movesColumn.setCellValueFactory(new PropertyValueFactory<Statistics, Integer>("numOfTotalMoves"));
		wallsColumn.setCellValueFactory(new PropertyValueFactory<Statistics, Integer>("wallsUsed"));
	}
	
}
