package aston.group12.model;

import java.util.UUID;

/**
 * Represents a Player in the game.
 * @author Xenia Vanikaki
 * @author Denver Fernandes
 * @version 0.1
 */
public abstract class Player {
	private String playerID;
	private String name;
	private Pawn pawn;
	private Statistics stats;
	private int walls;
	
	/**
	 * Creates a new Player by initialising its name and pawn
	 * Generates UUID 
	 * @param name
	 * @param pawn
	 */
	public Player(String name, Pawn pawn){
		//Generate UUID
		playerID = UUID.randomUUID().toString();
		walls = GameSession.STARTING_WALLS_NUM;
		//Initialise values.
		this.name = name;
		this.pawn = pawn;
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
	 * Gets the {@link Pawn} associated with the player.
	 * @return the pawn
	 */
	public Pawn getPawn() {
		return pawn;
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
	 * Gets the {@link Statistics} of this player.
	 * @return the statistics
	 */
	public Statistics getStats() {
		return stats;
	}
}
