package aston.group12.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import aston.group12.model.Board;
import aston.group12.model.GameSession;
import aston.group12.model.HumanPlayer;
import aston.group12.model.Player;
import aston.group12.model.Settings;
import aston.group12.view.Main;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Pair;

/**
 * 
 * Handles setup actions
 *
 */
public class SetupController extends AbstractController implements Initializable {
	
	private ObservableList<Player> playerData = FXCollections.observableArrayList();
	@FXML
	private TableView<Player> multiPlayerTable;
	@FXML
	private TableColumn<Player, String> nameColumn;
	@FXML
	private TableColumn<Player, String> pawnColumn;	
	@FXML
	private AnchorPane multiPlayerPane;
	@FXML
	private Button addPlayerBtn;
	@FXML
	private Button playBtn;
	
	private Color[] defaultColours;
	private int colourIndex;	
	
	/**
	 * Action triggered by pressing the back button.
	 * @param event the action
	 */
    @FXML
    private void onBackBtn(ActionEvent event) {
    	Stage stage = (Stage) multiPlayerPane.getScene().getWindow();
    	loadScreen(stage, "mainmenu.fxml");
    }
    
    /**
     * Action triggered by pressing the play button.
     * @param event the action
     */
    @FXML
    private void onPlayBtn(ActionEvent event) {
    	setupGame(multiPlayerTable.getItems());
    }
    
    /**
     * Action triggered by pressing the add player button.
     * Adapted from <a href="http://code.makery.ch/blog/javafx-dialogs-official/">Makery</a>.
     * @param event the action
     */
    @FXML
    private void onAddPlayerBtn(ActionEvent event) {
    	Dialog<Pair<String, String>> popup = new Dialog<>();
    	popup.setTitle("Add a Player");
    	popup.setHeaderText("Add a player to this game session");
    	
    	ButtonType loginButtonType = new ButtonType("Add Player", ButtonData.OK_DONE);
    	popup.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

    	GridPane grid = new GridPane();
    	grid.setHgap(10);
    	grid.setVgap(10);
    	grid.setPadding(new Insets(20, 150, 10, 10));

    	TextField name = new TextField();
    	name.setPromptText("Name");
    	ColorPicker colorPicker = new ColorPicker(defaultColours[colourIndex]);
    	colorPicker.setPromptText("Pawn colour");

    	grid.add(new Label("Name:"), 0, 0);
    	grid.add(name, 1, 0);
    	grid.add(new Label("Pawn colour:"), 0, 1);
    	grid.add(colorPicker, 1, 1);

    	Node addButton = popup.getDialogPane().lookupButton(loginButtonType);
    	addButton.setDisable(true);

    	name.textProperty().addListener((observable, oldValue, newValue) -> {
    	    addButton.setDisable(newValue.trim().isEmpty());
    	});

    	popup.getDialogPane().setContent(grid);

    	Platform.runLater(() -> name.requestFocus());
    	Optional<Pair<String, String>> result = popup.showAndWait();
    	String hexColor = convertColour(colorPicker);
    	System.out.println(colorPicker.getValue().toString());
    	if(!name.getText().isEmpty() && !hexColor.isEmpty()) {
    		Player player = new HumanPlayer(name.getText(), hexColor);
    		System.out.println(hexColor);
    		multiPlayerTable.getItems().add(player);
    		colourIndex++;
    	}
    	if(multiPlayerTable.getItems().size() == GameSession.MAX_PLAYERS) {
    		addPlayerBtn.setDisable(true);
    	}
    	
    	if((multiPlayerTable.getItems().size() % 2 == 0) && (multiPlayerTable.getItems().size() != 0)) {
    		playBtn.setDisable(false);
    	} else {
    		playBtn.setDisable(true);
    	}
    	
    } 
    
    @FXML
    private void on2PlayerBtn(ActionEvent action) {
    	List<Player> players = new ArrayList<Player>(2);
    	Player player1 = new HumanPlayer("1" , "#663366");
    	Player player2 = new HumanPlayer("2" , "#b3e6b3");
    	players.add(player1);
    	players.add(player2);
    	setupGame(players);  	
    }
    
    @FXML
    private void on4PlayerBtn(ActionEvent action) {
    	List<Player> players = new ArrayList<Player>(2);
    	Player player1 = new HumanPlayer("1" , "#663366");
    	Player player2 = new HumanPlayer("2" , "#b3e6b3");
    	Player player3 = new HumanPlayer("3" , "#663366");
    	Player player4 = new HumanPlayer("4" , "#b3e6b3");
    	players.add(player1);
    	players.add(player2);
    	players.add(player3);
    	players.add(player4);
    	setupGame(players);  	   	
    } 
    
    /**
     * Sets up a game with {@link Player players}
     * @param players the players
     */
    private void setupGame(List<Player> players) {
    	Stage stage = (Stage) multiPlayerPane.getScene().getWindow();
    	Board board = new Board(Settings.getSingleton().getBoardHeight(), Settings.getSingleton().getBoardWidth());
    	GameSession gameSession = new GameSession(board, Settings.getSingleton().getRuleType());  
    	Main main = new Main(stage, gameSession, players);
    	stage.show();
    }
    
    /**
     * Converts a {@link ColorPicker} value to hex.
     * @param colourPicker the {@link ColorPicker}
     * @return the converted colour
     */
    private String convertColour(ColorPicker colourPicker) {
    	int green = (int) (colourPicker.getValue().getGreen() * 255);
    	int blue = (int) (colourPicker.getValue().getBlue() * 255);
    	int red = (int) (colourPicker.getValue().getRed() * 255);
    	return "#" + Integer.toHexString(red) 
    	+ Integer.toHexString(green)
    	+ Integer.toHexString(blue);
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		nameColumn.setCellValueFactory(new PropertyValueFactory<Player, String>("name"));
		pawnColumn.setCellValueFactory(new PropertyValueFactory<Player, String>("pawnColour"));
		pawnColumn.setCellFactory(column -> {
	        return new TableCell<Player, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    setText(empty ? null : getString());
                    setStyle("-fx-background-color:"+getString()+";");
                }

                private String getString() {
                    return getItem() == null ? "" : getItem().toString();
                }
            };
	    });
		multiPlayerTable.setPlaceholder(new Label("No players yet"));
		defaultColours = new Color[]{Color.valueOf("#663366"), Color.valueOf("#b3e6b3"), Color.valueOf("#334db3"), Color.valueOf("#ff6666")};
		colourIndex = 0;		
		
	}
}
