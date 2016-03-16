package aston.group12.model;

/**
 * Represents a Position in the game.
 * @author Denver Fernandes
 * @author Anas Khan
 * @version 0.1
 */

public class Position {
	
	private int x;
	private int y;
	
	
	public Position(int x, int y) {
		if (x < 0 || y < 0)
		{
			throw new IllegalArgumentException("Coordinates cannot be less than 0!");
		}
				
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
	 * @param x the x-coordinate to set
	 * @throws IllegalArgumentException if x coordinate is less than 0
	 */
	public void setX(int x) {
		if (x < 0)
		{
			throw new IllegalArgumentException("X-coordinate cannot be less than 0!");
		}
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
	 * @param y the y-coordinate to set
	 * @throws IllegalArgumentException if y coordinate is less than 0
	 */
	public void setY(int y) {
		if (y < 0)
		{
			throw new IllegalArgumentException("Y-coordinate cannot be less than 0!");
		}
		this.y = y;
	}
	
	
	/**
	 * Checks for equal position in other position object.	
	 * @param other the other position object
	 * @return true if positions are equal
	 */
	public boolean equals(Position other) {
		if ((getY() == other.getY()) && (getX() == other.getX())) {
			return true;
		}
		return false;
		 
	}
}
