package aston.group12.model;

/**
 * Represents a Player in the game.
 * @author Xenia Vanikaki
 * @author Denver Fernandes
 * @version 0.1
 */
public abstract class Player {
	private String name;
	private int walls;
	private Statistics stats;
	private String pawnColour;
	
	/**
	 * Creates a new Player by initialising its name and pawn
	 * Generates UUID 
	 * @param name
	 * @param pawn
	 */
	public Player(String name, String pawnColour){
		//Generate UUID
		
		//Initialise values.
		this.name = name;
		walls = Settings.getSingleton().getWalls();
		this.stats = new Statistics();
		this.pawnColour = pawnColour;
	}


	/**
	 * Gets the name of the player.
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the amount of walls that the player has.
	 * @return the number of walls
	 */
	public int getWalls() {
		return walls;
	}
	
	/**
	 * Decrements the number of walls that the player has by one.
	 * @throws IllegalStateException if the number of walls is below 0
	 */
	public void decrementWalls() {
		if(walls == 0) {
			throw new IllegalStateException("The number of walls cannot be decremented below 0.");
		}
		System.out.println(name + ": " + walls + " walls left ");
		walls--;
	}	
	
	/**
	 * Increments the number of walls that a player has by one.
	 * @throws IllegalStateException if the number of walls are at maximum
	 */
	public void incrementWalls() {
		if(walls == Settings.getSingleton().getWalls()) {
			throw new IllegalStateException("The number of walls are already at maximum.");
		}
		walls++;
	}	
	
	/**
	 * Get this player's {@link Statistics}
	 * @return the statistics
	 */
	public Statistics getStatistics() {
		return stats;
	}
	
	/**
	 * Gets this player's Pawn {@Colour}
	 * @return the colour
	 */
	public String getPawnColour() {
		return pawnColour;
	}


}
