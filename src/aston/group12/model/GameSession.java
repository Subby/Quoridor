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
	
	private static int MAX_PLAYERS = 4;
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
		return players.get(id - 1);
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

}
