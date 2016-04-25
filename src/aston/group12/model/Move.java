package aston.group12.model;

/**
 * Represents a move that has taken place during the game.
 * @author Denver Fernandes
 * @version 0.1
 */

public class Move {
	private Tile from;
	private Tile to;
	private Player player;
	
	public Move(Tile from, Tile to, Player player) {
		if(from == null || to == null) {
			throw new IllegalArgumentException("The tile cannot be null");
		}
		if(player == null) {
			throw new IllegalArgumentException("The player cannot be null");
		}		
		this.from = from;
		this.to = to;
		this.player = player;
	}
	
	/**
	 * Gets the {@link Tile} the player moved from.
	 * @return the position the player moved from
	 */
	public Tile getFrom() {
		return this.from;
	}
	
	/**
	 * Gets the {@link Tile} the player moved to.
	 * @return the position the player moved to
	 */
	public Tile getTo() {
		return this.to;
	}
	
	/**
	 * Gets the {@link Player} who made the move.
	 * @return the player that made the move
	 */
	public Player getPlayer() {
		return player;
	}
	
	
}
