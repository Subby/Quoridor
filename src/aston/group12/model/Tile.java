package aston.group12.model;

/**
 * Represents a Tile on the {@link Board}
 * @author Denver Fernandes
 * @author Anas Khan
 * @version 0.3
 */
public class Tile {
	
	private int x;
	private int y;
	private boolean containsPawn;

	public Tile(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Gets the x position of this tile
	 * @return the x position of the tile
	 */
	public int getX() {
		return x;
	}

	/**
	 * Gets the y position of this tile
	 * @return the y position of the tile
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Sets whether this tile contains a pawn.
	 * @param contains whether the tile contains a pawn
	 */
	public void setContainsPawn(boolean contains) {
		this.containsPawn = contains;
	}
	
	/**
	 * Whether this this contains a pawn
	 * @return
	 */
	public boolean containsPawn() {
		return containsPawn;
	}	
}
