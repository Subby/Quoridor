package aston.group12.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HumanPlayerTest {

	private Position position;
	private Tile tile;
	private HumanPlayer player;
	
	/**
	 * Initiates new Player instance.
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		position = new Position(2,1);
		tile = new Tile(position);		
		player = new HumanPlayer("TestPlayer");
	}
	
	/**
	 * Tests getName method.
	 */
	@Test
	public void TestGetName() {
		assertEquals("TestPlayer", player.getName());
	}
	
	
}
