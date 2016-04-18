package aston.group12.model;

import java.util.UUID;

/**
 * Represents a Player in the game.
 * @author Xenia Vanikaki
 * @author Denver Fernandes
 * @version 0.2
 */
public abstract class Player {
	private String playerID;
	private String name;
	private Statistics stats;
	private int walls;
	
	/**
	 * Creates a new Player by initialising its name and pawn
	 * Generates UUID 
	 * @param name
	 * @param pawn
	 */
	public Player(String name){
		//Generate UUID
		playerID = UUID.randomUUID().toString();
		walls = GameSession.STARTING_WALLS_NUM;
		//Initialise values.
		this.name = name;
		this.stats = new Statistics();
	}

	/**
	 * Gets the ID of the player.
	 * @return the playerID
	 */
	public String getPlayerID() {
		return playerID;
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
	 */
	public void decrementWalls() {
		if(walls == 0) {
			throw new IllegalStateException("The number of walls cannot be decremented below 0");
		}
		walls--;
	}
	
	
	/**
	 * Increments the number of walls that a player has by one.
	 */
	public void incrementWalls() {
		if(walls == GameSession.STARTING_WALLS_NUM) {
			throw new IllegalStateException("The number of walls are already at maximum.");
		}
		walls++;
	}
	
	/**
	 * Gets the {@link Statistics} of this player.
	 * @return the statistics
	 */
	public Statistics getStats() {
		return stats;
	}
}
