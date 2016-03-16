package aston.group12.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HumanPlayerTest {

	private Position position;
	private Tile tile;
	private Pawn pawn;
	private HumanPlayer player;
	
	/**
	 * Initiates new Player instance.
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		position = new Position(2,1);
		tile = new Tile(position);
		pawn = new Pawn();		
		pawn.setTile(tile);
		
		player = new HumanPlayer("TestPlayer", pawn);
	}
	
	/**
	 * Tests getName method.
	 */
	@Test
	public void TestGetName() {
		assertEquals("TestPlayer", player.getName());
	}
	
	/**
	 * Tests getPawn method.
	 */
	@Test
	public void TestGetPawn() {
		assertEquals(2, player.getPawn().getTile().getPosition().getX());
		assertEquals(1, player.getPawn().getTile().getPosition().getY());
	}
	
}
