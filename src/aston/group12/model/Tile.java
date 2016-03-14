package aston.group12.model;

/**
 * Represents a tile.
 * @author Denver Fernandes
 * @version 0.1
 */
public class Tile {
	
	private Position position;

	public Tile(Position position) {
		this.position = position;
	}
	
	/**
	 * Gets the {@link Position} of this {@link Tile}
	 * @return the position
	 */
	public Position getPosition() {
		return position;
	}

	/**
	 * Sets the {@link Position} of this {@link Tile}
	 * @param position the {@link Position} to set
	 */
	public void setPosition(Position position) {
		this.position = position;
	}
}
