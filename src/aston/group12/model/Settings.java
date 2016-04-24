package aston.group12.model;

/**
 * 
 * A class to handle all the Settings in the game.
 *
 */
public class Settings {
	
	private static Settings instance = null;
	
	private RuleType ruleType;
	private int walls;
	private boolean showLabels;
	private boolean showTrail;
	private int boardWidth;
	private int boardHeight;
	private int tileSize;
	
	
	private Settings() {
		reset();
	}
	
	/**
	 * Gets the {@link Settings} singleton.
	 * @return the instance
	 */
	public static Settings getSingleton() {
		if(instance == null) {
			instance = new Settings();
		}
		return instance;
	}

	/**
	 * Gets the {@link RuleType}.
	 * @return the rule type
	 */
	public RuleType getRuleType() {
		return ruleType;
	}
	
	/**
	 * Resets all the {@link Setting settings} to default.
	 */
	public void reset() {
		setRuleType(RuleType.STANDARD);
		//Set number of walls setting
		setWalls(10);
		//Set show label
		setShowLabels(true);
		//Set show ghost trails
		setShowTrail(true);
		//Set board size
		setBoardHeight(9);
		setBoardWidth(9);
		//Set tile size
		setTileSize(50);			
	}
	
	/**
	 * Sets the {@link RuleType}.
	 * @param ruleType the rule type
	 */
	public void setRuleType(RuleType ruleType) {
		this.ruleType = ruleType;
	}

	/**
	 * Gets the number of {@link Wall walls}.
	 * @return the number of walls.
	 */
	public int getWalls() {
		return walls;
	}

	/**
	 * Sets the number of {@link Wall walls}.
	 * @param walls the number of walls
	 */
	public void setWalls(int walls) {
		this.walls = walls;
	}

	/**
	 * Whether the labels should show.
	 * @return whether the labels should show
	 */
	public boolean isShowLabels() {
		return showLabels;
	}

	/**
	 * Sets whether to show label above pawns.
	 * @param showLabels whether to show labels
	 */
	public void setShowLabels(boolean showLabels) {
		this.showLabels = showLabels;
	}

	/**
	 * Gets the width of the {@link Board}.
	 * @return the width
	 */
	public int getBoardWidth() {
		return boardWidth;
	}

	/**
	 * Sets the width of the {@link Board}.
	 * @param boardWidth the width
	 */
	public void setBoardWidth(int boardWidth) {
		this.boardWidth = boardWidth;
	}

	/**
	 * Whether the trail should show or not.
	 * @return whether the trail should show
	 */
	public boolean isShowTrail() {
		return showTrail;
	}

	/**
	 * Sets whether to show the ghost trail.
	 * @param showTrail whether to show the trail or not
	 */
	public void setShowTrail(boolean showTrail) {
		this.showTrail = showTrail;
	}

	/**
	 * Gets the height of the {@link Board}.
	 * @return the height
	 */
	public int getBoardHeight() {
		return boardHeight;
	}

	/**
	 * Sets the height of the {@link Board}
	 * @param boardHeight the height
	 */
	public void setBoardHeight(int boardHeight) {
		this.boardHeight = boardHeight;
	}

	/**
	 * Gets the size of the {@link Tile}.
	 * @return the size
	 */
	public int getTileSize() {
		return tileSize;
	}

	/**
	 * Sets the {@link Tile} size setting.
	 * @param tileSize the size
	 */
	public void setTileSize(int tileSize) {
		this.tileSize = tileSize;
	}
}
