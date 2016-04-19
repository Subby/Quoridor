package aston.group12.model;

/**
 * Represents a wall in the game.
 * @author Denver Fernandes
 * @version 0.2
 */
public class Wall {
	
	private int x;
	private int y;
	private boolean isFirst;
	private Player placedBy;
	
	public Wall(int x, int y, boolean isFirst, Player placedBy) {
		this.x = x;
		this.y = y;
		this.isFirst = isFirst;
		this.placedBy = placedBy;
	}
	
	/**
	 * Gets the starting position of the {@link Wall}.
	 * @return the starting position
	 */
	public int getX() {
		return x;
	}

	/**
	 * Gets the ending position of the {@link Wall}.
	 * @return the ending position
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Gets whether this is the first part of the {@link Wall}.
	 * @return whether this is the first part
	 */
	public boolean getIsFirst() {
		return isFirst;
	}
	
	/**
	 * Gets the {@link Player} who placed the wall.
	 * @return the player who placed the wall
	 */
	public Player getPlacedBy() {
		return placedBy;
	}
		
}
