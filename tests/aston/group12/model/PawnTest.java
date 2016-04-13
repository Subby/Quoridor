package aston.group12.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PawnTest {
	
	private Position position;
	private Tile tile;
	private Pawn pawn;

	/**
	 * Initiates new Pawn instance.
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		position = new Position(2,1);
		tile = new Tile(position);
		pawn = new Pawn();
		
		pawn.setTile(tile);
	}
	
	/**
	 * Tests getTile method.
	 */
	@Test
	public void testGetTile() {
		assertEquals(2, pawn.getTile().getPosition().getX());
		assertEquals(1, pawn.getTile().getPosition().getY());
	}
	
	/**
	 * Tests setTile method.
	 */
	@Test
	public void testSetTile() {
		position.setX(4);
		position.setY(2);
		tile.setPosition(position);
		
		pawn.setTile(tile);
		
		assertEquals(4, pawn.getTile().getPosition().getX());
		assertEquals(2, pawn.getTile().getPosition().getY());
	}
}