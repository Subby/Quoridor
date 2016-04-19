package aston.group12.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a board filled with tiles.
 * @author Denver Fernandes
 * @version 0.5
 */
public class Board {
	
	private Tile[][] tiles;
	private Wall[][] horizontalWalls;
	private Wall[][] verticalWalls;
	private int height;
	private int width;

	public Board() {
		this(9,9);
	}
	
	public Board(int height, int width) {
		if((height % 2 == 0) || (width % 2 == 0)) {
			throw new IllegalStateException("Height or width of the board cannot be even.");
		}		
		this.tiles = new Tile[height][width];
		this.height = height;
		this.width = width;
		this.height = height;
		this.width = width;
		setTilePositions();
	}

	/**
	 * Assigns coordinates to the {@link Tiles tiles}.
	 */
	public void setTilePositions() {

	}
	
	/**
	 * Gets a tile with a given coordinate.
	 * @param x the x coordinate
	 * @param y the y coordinate
	 * @return the tile
	 */
	public Tile getTile(int x, int y) {
		return tiles[x][y];
	}
	
	
	/**
	 * Checks whether the position on the {@link Board} contains a {@link Wall}.
	 * @param position the position
	 * @return the wall
	 */
    public boolean containsWall(int x, int y, boolean isHorizontal) {
    	if(isHorizontal) {
    		if(horizontalWalls[x][y] != null) {
    			return true;
    		}
    	} else {
    		if(verticalWalls[x][y] != null) {
    			return true;
    		}    		
    	}
    	return false;
    }

    /**
     * Places a new {@link Wall} on to the {@link Board}.
     * @param x the x position
     * @param y the y position
     * @param isHorizontal whether the wall is horizontal or not
     * @param isFirst whether the wall is the first part or not
     * @param placedBy who owns the wall
     */
    public void setWall(int x, int y, boolean isHorizontal, boolean isFirst, Player placedBy) {
        if(isHorizontal) {
        	horizontalWalls[x][y] = new Wall(x, y, isFirst, placedBy);
        } else {
        	verticalWalls[x][y] = new Wall(x, y, isFirst, placedBy);
        }
    }
    
    /**
     * Returns a {@link Wall} given the x and y coordinate.
     * @param x the x coordinate
     * @param y the y coordinate
     * @param isHorizontal whether the wall is horizontal
     * @return the wall
     */
    public Wall getWall(int x, int y, boolean isHorizontal) {
    	if(isHorizontal) {
    		return horizontalWalls[x][y];
    	} else {
    		return verticalWalls[x][y];
    	}
    }
    
    public void removeWall(int x, int y, boolean isHorizontal) {
    	if(isHorizontal) {
    		horizontalWalls[x][y] = null;
    	} else {
    		verticalWalls[x][y] = null;
    	}
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
