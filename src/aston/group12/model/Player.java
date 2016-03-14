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
	
	/**
	 * Creates a new Player by initialising its name and pawn
	 * Generates UUID 
	 * @param name
	 * @param pawn
	 */
	public Player(String name, Pawn pawn){
		//Generate UUID
		playerID = UUID.randomUUID().toString();
		
		//Initialise values.
		this.name = name;
		this.pawn = pawn;
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
}
