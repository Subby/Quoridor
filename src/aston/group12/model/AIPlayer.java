package aston.group12.model;
/**
 *
 * Interface all AIPlayer classes must implement.
 *
 */
public interface AIPlayer {
	
	/**
	 * Determines the tile that the AI player should move to.
	 * @param tile the tile
	 * @param board the board
	 * @return the tile
	 */
	public Tile determineMove(Tile tile, Board board);
	
}
