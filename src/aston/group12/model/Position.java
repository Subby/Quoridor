package aston.group12.model;

/**
 * Represents a Position in the game.
 * @author Denver Fernandes
 * @version 0.1
 */

public class Position {
	
	private int x;
	private int y;
	
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Gets the X coordinate.
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * Sets the X coordinate.
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Gets the Y coordinate.
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * Sets the Y coordinate.
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	public boolean equals(Position other) {
		if ((getY() == other.getY()) && (getX() == other.getX())) {
			return true;
		}
		return false;
		 
	}
}
