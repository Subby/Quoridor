package aston.group12.model;

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
		this.horizontalWalls = new Wall[height][width];
		this.verticalWalls = new Wall[height][width];
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
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Tile tile = new Tile(x, y);
                tiles[x][y] = tile;
            }
        }
	}	
	
	/**
	 * Gets a tile with a given coordinate.
	 * @param x the x coordinate
	 * @param y the y coordinate
	 * @throws IllegalArgumentException if x or y is below 0
	 * @return the tile
	 */
	public Tile getTile(int x, int y) {
		if(x < 0 || y < 0) {
			throw new IllegalArgumentException("The coordinate cannot be below 0.");
		}
		return tiles[x][y];
	}
	
	
	/**
	 * Checks whether the position on the {@link Board} contains a {@link Wall}.
	 * @param position the position
	 * @throws IllegalArgumentException if x or y is below 0
	 * @return whether the wall is in the given position
	 */
    public boolean containsWall(int x, int y, boolean isHorizontal) {
    	if(x < 0 || y < 0) {
    		throw new IllegalArgumentException("The corodinate cannot be below 0.");
    	}
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
     * @throws IllegalArgumentException if x or y is below 0
     * @throws IllegalArgumentException if the player is null
     */
    public void setWall(int x, int y, boolean isHorizontal, boolean isFirst, Player placedBy) {
    	if(x < 0 || y < 0) {
    		throw new IllegalArgumentException("The corodinate cannot be below 0.");
    	}
    	if(placedBy == null) {
    		throw new IllegalArgumentException("The player cannot be null.");
    	}
    	
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
     * @throws IllegalArgumentException if x or y is below 0
     * @return the wall
     */
    public Wall getWall(int x, int y, boolean isHorizontal) {
    	if(x < 0 || y < 0) {
    		throw new IllegalArgumentException("The corodinate cannot be below 0.");
    	}    	
    	if(isHorizontal) {
    		return horizontalWalls[x][y];
    	} else {
    		return verticalWalls[x][y];
    	}
    }
    
    /**
     * Removes a {@link Wall} given the x and y coordinate.
     * @param x the x coordinate
     * @param y the y coordinate
     * @param isHorizontal whether the wall is horizontal
     * @throws IllegalArgumentException if x or y is below 0
     */
    public void removeWall(int x, int y, boolean isHorizontal) {
    	if(x < 0 || y < 0) {
    		throw new IllegalArgumentException("The corodinate cannot be below 0.");
    	}        	
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
