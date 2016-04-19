package aston.group12.model;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

/**
 * Represents a single game session. A game session comprises of 1, 2 or 4 players.
 * @author Xenia Vanikaki
 * @author Denver Fernandes
 * @version 0.6
 */
public class GameSession {
	
	public static int MAX_PLAYERS = 4;
	public static int STARTING_WALLS_NUM = 15;
	private Board board;
	private List<Player> players;
	private RuleType ruleType;
	/**
	 * A {@link Stack} was chosen to store all the moves as an undo function can be 
	 * implemented in the practise mode. 
	 */
	private Deque<Move> moves;
	
	public GameSession(Board board, RuleType rule) {
		this.board = board;
		this.players = new ArrayList<Player>();
		this.moves = new ArrayDeque<Move>();
		this.ruleType = rule;
	}
	
	/**
	 * Gets the {@link Board} used in this session.
	 * @return the board
	 */
	public Board getBoard() {
		return board;
	}	
	
	/**
	 * Adds a player to the session.
	 * @param player the player to add
	 * @throws IllegalStateException when more players than the limit are added
	 */
	public void addPlayer(Player player) {
		if(players.size() > MAX_PLAYERS) {
			throw new IllegalStateException("There can only be a maximum of " + MAX_PLAYERS + " players");
		}
		players.add(player);
	}
	
	/**
	 * Gets all the players in this session.
	 * @return the players in this session
	 */
	public List<Player> getPlayers() {
		return players;
	}
	
	/**
	 * Gets a player with the specified id.
	 * @param id the player to get
	 * @return the player
	 */
	public Player getPlayer(int id) {
		return players.get(id);
	}
	
	/**
	 * Adds a {@link Move} to the move list.
	 * @param move
	 * @return true if the move was successful
	 */
	public boolean addMove(Move move) {
		moves.push(move);
		//TODO: Check for collisions etc.
		return true;
	}
	
	/**
	 * Gets a history of moves that have taken place.
	 * @return the history of moves
	 */
	public Deque<Move> getMoves() {
		return moves;
	}
	
	/**
	 * Gets the rule type for this particular session.
	 * @return the rule type
	 */
	public RuleType getRuleType() {
		return ruleType;
	}	
	
	/**
	 * Checks whether a move is valid.
	 * @param current the current {@link Tile} the {@link Player} is at.
	 * @param movingTo the {@link Tile} the {@link Player} wants to move to. 
	 * @return whether the move is valid
	 */
	public boolean isValidMove(Tile current, Tile movingTo) {
		int currentX = current.getX();
		int currentY = current.getY();
		int nextX = movingTo.getX();
		int nextY = movingTo.getY();
    	if(nextX >= board.getWidth() || nextY >= board.getHeight() || nextX < 0 || nextY < 0) { //Check if the new position is off the board
    		return false;
    	}		
    	if(nextX == currentX) {
    		if(nextY == currentY - 1) { //going upwards
    			if(board.containsWall(currentX, currentY, true)) {
    				return false;
    			}
    			return true;
    		}
    		if(nextY == currentY + 1) { //going downwards
    			if(board.containsWall(currentX, currentY+1, true)) {
    				return false;
    			}
    			return true;    			
    		}
    	}
    	if(nextY == currentY) {
    		if(nextX == currentX - 1) { //going left
    			if(board.containsWall(currentX-1, currentY, false)) {
    				return false;
    			}  		
    			return true;
    		}
    		if(nextX == currentX + 1) { //going right
    			if(board.containsWall(currentX, currentY, false)) {
    				return false;
    			}
    			return true;
    		}
    	}
    	return false;
	}	

}
