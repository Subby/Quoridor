package aston.group12.view;

import aston.group12.model.Board;
import aston.group12.model.GameSession;
import aston.group12.model.HumanPlayer;
import aston.group12.model.Pawn;
import aston.group12.model.Player;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
 
public class MainGame extends Application implements GameScreen {
 
	private GameSession gameSession;
	
    public static void main(String[] args) {
        launch(args);
    }
 
    private void initialSetup() {
    	Player playerName1 = new HumanPlayer("Dolph", new Pawn());
    	Player playerName2 = new HumanPlayer("Ziggler", new Pawn());
    	Board board = new Board();
    	gameSession = new GameSession(board);
    	gameSession.addPlayer(playerName1);
    	gameSession.addPlayer(playerName2);
    }
    @Override
    public void start(Stage stage) {
    	initialSetup();
        stage.setTitle("Quoridor");
        Group root = new Group();
        //TODO: base the canvas size on the size of the board!
        //Canvas canvas = new Canvas(365, 400);
        int boardWidth = gameSession.getBoard().getWidth();
        int boardHeight = gameSession.getBoard().getHeight();
        Canvas canvas = new Canvas(boardWidth * 41, boardHeight * 45);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        drawComplete(gc);
        root.getChildren().add(canvas);
        root.autosize();
        stage.setScene(new Scene(root));
        stage.show();
    }

    private void drawComplete(GraphicsContext gc) {
    	//Temporary graphics code.
        gc.setStroke(Color.BLACK);
        drawBoard(gc, 9);
        gc.setFill(Color.CYAN);
        drawPawn(gc, 177, 15);
        gc.setFill(Color.CRIMSON);
        drawPawn(gc, 177, 340);
        gc.fillText(gameSession.getPlayer(1).getName(), 10, 375);
        gc.fillText("Walls Left: 10", 10, 390);
        gc.fillText(gameSession.getPlayer(2).getName(), 290, 375);
        gc.fillText("Walls Left: 12", 290, 390);     
        //Temporary hardcoded wall, was just checking how to do this
        gc.strokeLine(5, 20, 5, 70);
    }
    
    private void drawBoard(GraphicsContext gc, int numOfRows) {
    	int counter = 10; 
    	for(int i=0; i < numOfRows; i++) {
    		drawRow(gc, counter, 9);
    		counter = counter + 40;
    	}
    }
    private void drawRow(GraphicsContext gc, int y, int numOfCols) {
    	int counter = 10;
    	for(int i=0; i < numOfCols; i++) {
    		gc.strokeRoundRect(counter, y, 30, 30, 10, 10);
    		counter = counter + 40;
    	}
    }
    
    private void drawPawn(GraphicsContext gc, int x, int y) {
    	gc.fillOval(x, y, 15, 15);
    }
    
    @SuppressWarnings("unused")
	private void drawWall(GraphicsContext gc, int x, int y) {
    	gc.strokeLine(x, y, y, x);
    }
   
}
