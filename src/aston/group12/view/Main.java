package aston.group12.view;


import java.util.ArrayList;
import java.util.List;

import aston.group12.model.Board;
import aston.group12.model.GameSession;
import aston.group12.model.HumanPlayer;
import aston.group12.model.RuleType;
import aston.group12.model.Tile;
import aston.group12.view.components.PawnComponent;
import aston.group12.view.components.PawnComponent.PawnType;
import aston.group12.view.components.TileComponent;
import aston.group12.view.components.VerticalWallComponent;
import aston.group12.view.components.HorizontalWallComponent;
import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Main extends Application {
	public static final int TILE_SIZE = 50;

    private List<PawnComponent> pawnComponentList = new ArrayList<PawnComponent>(GameSession.MAX_PLAYERS);
    private GameSession gameSession;
    private int height;
    private int width;
    private PawnType[] pawnTypes = {PawnType.RED, PawnType.WHITE, PawnType.GREEN, PawnType.BLUE}; //Could possibly loop through the pawnTypes enums instead of storing in an array
    private int turnIndex;
    
    private TileComponent[][] tileBoard;
    private HorizontalWallComponent[][] horizontalWalls;
    private VerticalWallComponent[][] verticalWalls;
    private Group tileGroup = new Group();
    private Group pawnGroup = new Group();
    private Group horizontalWallGroup = new Group();
    private Group verticalWallGroup = new Group();
    private Label currentTurnLabel;
    private Label wallsLabel;
    @Override
    public void start(Stage primaryStage) throws Exception {
    	setupModel();
        Scene scene = new Scene(createContent());
        primaryStage.getIcons().add(new Image("resources/icons/favicon.png"));
        primaryStage.setTitle("Quoridor");
        primaryStage.setScene(scene);
        primaryStage.show();        
    }
    
    private void setupModel() {
        Board board = new Board(9, 9);
        height = board.getHeight();
        width = board.getWidth();
        gameSession = new GameSession(board, RuleType.CHALLENGE);
        tileBoard = new TileComponent[board.getWidth()][board.getHeight()];
        horizontalWalls = new HorizontalWallComponent[board.getWidth()][board.getHeight()];
        verticalWalls = new VerticalWallComponent[board.getWidth()][board.getHeight()];
        currentTurnLabel = new Label();
        wallsLabel = new Label();
        HumanPlayer player1 = new HumanPlayer("Levi");
        HumanPlayer player2 = new HumanPlayer("Stevie");
        HumanPlayer player3 = new HumanPlayer("Outre");
        HumanPlayer player4 = new HumanPlayer("Lance");
        gameSession.addPlayer(player1);
        gameSession.addPlayer(player2);
        gameSession.addPlayer(player3);
        gameSession.addPlayer(player4);
        setupPawns();
        turnIndex = 0;
    }
    private Pane infoPanel() {
    	Pane panel = new Pane();
    	currentTurnLabel.setText(gameSession.getPlayer(turnIndex).getName() + "'s turn");
    	currentTurnLabel.setTextFill(Color.valueOf(pawnTypes[turnIndex].getColour()));
    	currentTurnLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
    	wallsLabel.textProperty().bind(new SimpleIntegerProperty(gameSession.getPlayer(0).getWalls()).asString());
    	wallsLabel.setTranslateY(50);
    	panel.getChildren().addAll(currentTurnLabel, wallsLabel);
    	panel.setTranslateX(450);
    	return panel; 
    }
    private Parent createContent() {
        Pane root = new Pane();
        root.setPrefSize((width * TILE_SIZE) + 75, height * TILE_SIZE);
        root.getChildren().addAll(tileGroup, pawnGroup, horizontalWallGroup, verticalWallGroup, infoPanel());

        //Add tiles to the board
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                TileComponent tile = new TileComponent(x, y);
                tileBoard[x][y] = tile;
                tileGroup.getChildren().add(tile);
            }
        }
        //Add vertical walls to the board
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
            	if(x == (width - 1)) {
            		continue;
            	}
                VerticalWallComponent wall = new VerticalWallComponent(x, y);
                verticalWalls[x][y] = wall;
                verticalWallGroup.getChildren().add(wall);  
                final int thisX = x;
                final int thisY = y;
                final int nextWallX = x;
                final int nextWallY = y + 1;
                wall.setOnMouseEntered(e -> {
                	if(nextWallX == (width - 1)) {
                		return;
                	}
                	if(nextWallY > 0 && nextWallY < height) {
                    	if(!gameSession.getBoard().containsWall(thisX, thisY, false) && !gameSession.getBoard().containsWall(nextWallX, nextWallY, false)) {
                        	wall.setFill(Color.valueOf("bbbbbb")); 
                        	verticalWalls[nextWallX][nextWallY].setFill(Color.valueOf("bbbbbb")); 
                    	}
                	}
                });
                wall.setOnMouseExited(e -> {
                   	if(nextWallX == (width - 1)) {
                		return;
                	}
                	if(nextWallY > 0 && nextWallY < height) {
                		
                		if(!gameSession.getBoard().containsWall(thisX, thisY, false) && !gameSession.getBoard().containsWall(nextWallX, nextWallY, false)) {
                        	wall.setFill(Color.rgb(153, 217, 234, 0.8));
                        	verticalWalls[nextWallX][nextWallY].setFill(Color.rgb(153, 217, 234, 0.8));
                    	}
                	}                	
                });
                
                wall.setOnMousePressed(e -> {	
                	if(nextWallX == width || nextWallY == height) { //A vertical wall cannot be placed at the very top of the board
                		return;
                	}
                	
                	if(thisX == width) { //A vertical wall cannot be placed at the very edge of the board
                		System.out.println("You cannot place a wall here.");
                		return;
                	}                	
                	if(e.isPrimaryButtonDown()) {
                		if(gameSession.getBoard().containsWall(thisX, thisY, false) ||
                				gameSession.getBoard().containsWall(nextWallX, nextWallY, false)) {
                    		System.out.println("You cannot place a wall here.");
                    		return;                			
                		}
                    	if(gameSession.getPlayer(turnIndex).getWalls() == 0) {
                    		System.out.println("You do not have any walls left.");
                    		return;
                    	}      
                    	gameSession.getBoard().setWall(thisX, thisY, false, true, gameSession.getPlayer(turnIndex));
        				wall.setFill(pawnTypes[turnIndex].getWallColour());
        				System.out.println("1. Wall placed at X: " + thisX + " Y: " + thisY);
        				if(nextWallX < width) {
                        	gameSession.getBoard().setWall(nextWallX, nextWallY, false, false, gameSession.getPlayer(turnIndex));
        					verticalWalls[nextWallX][nextWallY].setFill(pawnTypes[turnIndex].getWallColour());
                        	System.out.println("2. Wall placed at: X" + nextWallX + " " + nextWallY);
        				}
        				updateTurn();
                	} else if(e.isSecondaryButtonDown()) {
        				if(gameSession.getRuleType() == RuleType.CHALLENGE) {
        					if(!gameSession.getBoard().containsWall(thisX, thisY, false)) {
        						System.out.println("No wall here");
        						return;        						
        					}
        					if(gameSession.getBoard().getWall(thisX, thisY, false).getPlacedBy() == gameSession.getPlayer(turnIndex)) {
        						System.out.println("You cannot remove your own walls.");
        						return;        						
        					}
        					if(gameSession.getBoard().getWall(thisX, thisY, false).getIsFirst()) {
        						if(nextWallX < width) {
                					verticalWalls[nextWallX][nextWallY].setFill(Color.rgb(153, 217, 234, 0.8));	
                					gameSession.getBoard().removeWall(nextWallX, nextWallY, false);
        						}
        					} else {
            					int previousWallY = nextWallY - 2;
            					if(previousWallY > -1 && previousWallY < height) {
                					verticalWalls[nextWallX][previousWallY].setFill(Color.rgb(153, 217, 234, 0.8));
                					gameSession.getBoard().removeWall(nextWallX, previousWallY, false);
            					}        						
        					}
        					gameSession.getBoard().getWall(thisX, thisY, false).getPlacedBy().decrementWalls();
        					gameSession.getBoard().removeWall(thisX, thisY, false);
            				wall.setFill(Color.rgb(153, 217, 234, 0.8));
            				updateTurn();
        				} else {
        					System.out.println("You can only remove walls in a game with " + RuleType.CHALLENGE + " rules.");
        				}
                	}
        		});
            }
        }
        //Add horizontal walls to the board
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
            	if(y == 0) {
            		continue;
            	}
                HorizontalWallComponent wall = new HorizontalWallComponent(x, y);
                horizontalWalls[x][y] = wall;
                final int thisX = x;
                final int thisY = y;
                int nextWallX = x + 1;
                int nextWallY = y;
                
                wall.setOnMouseEntered(e -> {
                	if(nextWallY == 0) {
                		return;
                	}
                	if(nextWallX > 0 && nextWallX < width) {
                    	if(!gameSession.getBoard().containsWall(thisX, thisY, true) && !gameSession.getBoard().containsWall(nextWallX, nextWallY, true)) {
                        	wall.setFill(Color.valueOf("bbbbbb"));     
                        	horizontalWalls[nextWallX][nextWallY].setFill(Color.valueOf("bbbbbb")); 
                    	}
                	}
                	
                });
                wall.setOnMouseExited(e -> {
                	if(nextWallY == 0) { //A horizontal wall cannot be placed at the very top of the board
                		return;
                	}

                	if(nextWallX > 0 && nextWallX < width) {
                		if(!gameSession.getBoard().containsWall(thisX, thisY, true) && !gameSession.getBoard().containsWall(nextWallX, nextWallY, true)) {
                			wall.setFill(Color.rgb(153, 217, 234, 0.8));		
                			horizontalWalls[nextWallX][nextWallY].setFill(Color.rgb(153, 217, 234, 0.8));	
                		}
                	}
                });                
                wall.setOnMousePressed(e -> {
                	if(nextWallY == 0 || nextWallX > width) { //A horizontal wall cannot be placed at the very top of the board
                		return;
                	}
                	
                	if(thisX == width) { //A horizontal wall cannot be placed at the very edge of the board
                		System.out.println("You cannot place a wall here.");
                		return;
                	}

        			if(e.isPrimaryButtonDown()) {
                		if(gameSession.getBoard().containsWall(thisX, thisY, true) ||
                				gameSession.getBoard().containsWall(nextWallX, nextWallY, true)) {
                    		System.out.println("You cannot place a wall here.");
                    		return;                			
                		}
                    	if(gameSession.getPlayer(turnIndex).getWalls() == 0) {
                    		System.out.println("You do not have any walls left.");
                    		return;
                    	}
                    	gameSession.getBoard().setWall(thisX, thisY, true, true, gameSession.getPlayer(turnIndex));
        				wall.setFill(pawnTypes[turnIndex].getWallColour());
        				System.out.println("1. Wall placed at X: " + thisX + " Y: " + thisY);
        				if(nextWallX > 0 && nextWallX < width) {
        					gameSession.getBoard().setWall(nextWallX, nextWallY, true, false, gameSession.getPlayer(turnIndex));
        					horizontalWalls[nextWallX][nextWallY].setFill(pawnTypes[turnIndex].getWallColour());
                        	System.out.println("2. Wall placed at: X" + nextWallX + " " + nextWallY);
        				}
        				gameSession.getPlayer(turnIndex).decrementWalls();
        				updateTurn();        				
        			} else if(e.isSecondaryButtonDown()) {
        				if(gameSession.getRuleType() == RuleType.CHALLENGE) {
        					if(!gameSession.getBoard().containsWall(thisX, thisY, true)) {
        						System.out.println("No wall here");
        						return;        						
        					}
        					if(gameSession.getBoard().getWall(thisX, thisY, false).getPlacedBy() == gameSession.getPlayer(turnIndex)) {
        						System.out.println("You cannot remove your own walls.");
        						return;
        					}        					
        					if(gameSession.getBoard().getWall(thisX, thisY, true).getIsFirst()) {
                				if(nextWallX >= 0 && nextWallX <= width) {
                    				horizontalWalls[nextWallX][nextWallY].setFill(Color.rgb(153, 217, 234, 0.8));
                    				gameSession.getBoard().removeWall(nextWallX, nextWallY, true);
                				}
        					} else {
        						int previousWallX = nextWallX - 2;
        						if(previousWallX >= 0 && nextWallX <= width) {
                    				horizontalWalls[previousWallX][nextWallY].setFill(Color.rgb(153, 217, 234, 0.8));
                    				gameSession.getBoard().removeWall(previousWallX, nextWallY, true);
        						}
        					}
        					gameSession.getBoard().getWall(thisX, thisY, true).getPlacedBy().incrementWalls();
        					gameSession.getBoard().removeWall(thisX, thisY, true);
            				wall.setFill(Color.rgb(153, 217, 234, 0.8));
            				updateTurn();
        				} else {
        					System.out.println("You can only remove walls in a game with " + RuleType.CHALLENGE + " rules.");
        				}
                	}
        			
        		});
                horizontalWallGroup.getChildren().add(wall);
            }
        }        
        pawnGroup.getChildren().addAll(pawnComponentList);
        return root;
    }

    private int toBoard(double pixel) {
        return (int)(pixel + TILE_SIZE / 2) / TILE_SIZE;
    }
    
    private PawnComponent makePawn(PawnType type, int x, int y, String name) {
    	PawnComponent pawn = new PawnComponent(type, x, y, name);
    	
    	pawn.setOnMouseReleased(e -> { 
    		int newX = toBoard(pawn.getLayoutX());
    		int newY = toBoard(pawn.getLayoutY());
    		Tile currentTile = new Tile(toBoard(pawn.getOldX()), toBoard(pawn.getOldY()));
    		Tile nextTile = new Tile(newX, newY);
    		if(gameSession.isValidMove(currentTile, nextTile)) {
    			System.out.println(type + " x:" + newX + " y:" + newY);
        		pawn.move(newX, newY);
            	//update whose turn it is
        		updateTurn();
        		//Check if the pawn is in a winning position on the board
        		switch(type) {
        		case RED:
        			if(gameSession.getRuleType() == RuleType.CHALLENGE) {
            			if(newX == (width - 1) && newY == (height - height)) {
            				System.out.println("Red won");
            			}
        			} else if(gameSession.getRuleType() == RuleType.STANDARD) {
        				if(newY == 0) {
        					System.out.println("Red won");
        				}
        			}
        			break;
        		case WHITE:
        			if(gameSession.getRuleType() == RuleType.CHALLENGE) {
            			if(newX == (width - width) && newY == (height - 1)) {
            				System.out.println("White won");
            			}  	
        			} else if(gameSession.getRuleType() == RuleType.STANDARD) {
        				if(newY == (height - 1)) {
        					System.out.println("White won");
        				}
        			}    			
        			break;
        		case BLUE:
        			if(gameSession.getRuleType() == RuleType.CHALLENGE) {
            			if(newX == (width - 1) && newY == (height - 1)) {
            				System.out.println("Blue won");
            			}  	
        			} else if(gameSession.getRuleType() == RuleType.STANDARD) {
        				if(newX == 0) {
        					System.out.println("White won");
        				}
        			}  
        			break;
        		case GREEN:
        			if(gameSession.getRuleType() == RuleType.CHALLENGE) {
            			if(newX == 0 && newY == 0) {
            				System.out.println("Green won");
            			}  	
        			} else if(gameSession.getRuleType() == RuleType.STANDARD) {
        				if(newX == (width - 1)) {
        					System.out.println("White won");
        				}
        			}    
        			break;
        		}
    		} else {
    			pawn.reverseMove();
    		}
    	});
    	return pawn;
    }
    
    public void setupPawns() {
        int currentIndex = 0;
        int xStartingPositions[] = null;
        int yStartingPositions[] = null;
        //Starting positions for player 1, player 2, player 3, player 4 based on game type

        if(gameSession.getRuleType() == RuleType.CHALLENGE) {
            xStartingPositions = new int[]{(width - width), (width - 1), (width - 1), 0};
            yStartingPositions = new int[]{(height - 1), (height - height), (width - 1), 0};        	
        } else if(gameSession.getRuleType() == RuleType.STANDARD) {
            xStartingPositions = new int[]{(width / 2), (width / 2), (0), (width - 1)};
            yStartingPositions = new int[]{(height - 1), (0), (height / 2), (height / 2)};        	
        }
        for(int i=0; i < gameSession.getPlayers().size(); i++) {
        	//Loop through hardcoded starting positions and pawn types to assign to each player's pawn
        	PawnComponent pawn = makePawn(pawnTypes[currentIndex], xStartingPositions[currentIndex], yStartingPositions[currentIndex], gameSession.getPlayer(i).getName());
        	pawnComponentList.add(pawn);
        	currentIndex++;
        	
        }
    }
    
    private void updateTurn() {
		if(turnIndex < gameSession.getPlayers().size() - 1) {
			turnIndex++;
			System.out.println("Next turn: " + pawnTypes[turnIndex]);
		} else if(turnIndex == gameSession.getPlayers().size() - 1) {
			turnIndex = 0;
			System.out.println("Next turn: " + pawnTypes[turnIndex]);
		}
		currentTurnLabel.setText(gameSession.getPlayer(turnIndex).getName() + "'s turn");
		currentTurnLabel.setTextFill(Color.valueOf(pawnTypes[turnIndex].getColour()));
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
}
