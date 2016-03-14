package aston.group12.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a board filled with tiles.
 * @author Denver Fernandes
 * @version 0.4
 */
public class Board {
	
	private Tile[][] tiles;
	private List<Wall> walls;
	private int height;
	private int width;

	public Board() {
		this(9,9);
	}
	
	public Board(int height, int width) {
		this.tiles = new Tile[height][width];
		this.walls = new ArrayList<Wall>();
		this.height = height;
		this.width = width;
		setTilePositions();
	}

	/**
	 * Assigns {@link Position}s to the tiles.
	 */
	public void setTilePositions() {

	}
	
	/**
	 * Gets all the {@link Tile}s.
	 * @return the tiles
	 */
	public Tile[][] getTiles() {
		return tiles;
	}
	
	
	/**
	 * Checks whether the position on the obard contains a {@link Wall}
	 * @param position the position
	 * @return the wall
	 */
    public boolean containsWall(Position position) {
        for(Wall wall : walls) {
        	if(position.equals(wall.getFrom())) {
        		return true;
        	}
        }
    	return false;
    }

    /**
     * Places a wall on the board.
     * @param position the position
     * @param wall the wall
     */
    public void setWall(Wall wall) {
        walls.add(wall);
    }
	/**
	 * Gets the height of the board. Used to draw the board.
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * Gets the width of the board. Used to draw the board.
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}
}
