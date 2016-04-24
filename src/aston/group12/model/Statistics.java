package aston.group12.model;

/**
 * 
 * Represents various statistics within the game.
 *
 */
public class Statistics {
	
	private int numOfTotalMoves;
	
	public Statistics() {
	}
	
	/**
	 * Increments the total moves.
	 */
	public void incrementTotalMoves() {
		numOfTotalMoves++;
	}
	
	/**
	 * Returns the total moves. 
	 * @return the total moves
	 */
	public int getTotalMoves() {
		return numOfTotalMoves;
	}
	
}
