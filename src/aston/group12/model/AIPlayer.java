package aston.group12.model;
/**
 *
 * Interface all AIPlayer classes must implement.
 *
 */
public interface AIPlayer {
	
	public Tile determineMove(Tile tile, Board board);
	
}
