package aston.group12.model;

/**
 * Represents a wall in the game.
 * @author Denver Fernandes
 * @version 0.2
 */
public class Wall {
	
	private Position from;
	private Position to;
	private boolean isHorizontal;
	
	public Wall(Position from, Position to, boolean horizontal) {
		this.from = from;
		this.to = to;
		this.isHorizontal = horizontal;
	}
	
	/**
	 * Gets the starting position of the wall.
	 * @return the starting position
	 */
	public Position getFrom() {
		return from;
	}

	/**
	 * Gets the ending position of the wall.
	 * @return the ending position
	 */
	public Position getTo() {
		return to;
	}
	
	/**
	 * Whether the wall is horizontal or vertical.
	 * @return whether the wall is horizontal
	 */
	public boolean isHorizontal() {
		return isHorizontal;
	}
		
}
