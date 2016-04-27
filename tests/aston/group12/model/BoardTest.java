package aston.group12.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class for Board.java.
 * @author Anas Khan
 * @version 0.1
 */

public class BoardTest {
	
	private Board board;
	private Tile[][] tiles;
	/*private Wall[][] horizontalWalls;
	private Wall[][] verticalWalls;
	private int height;
	private int width;*/

	@Before
	public void setUp() throws Exception {
		board = new Board();
	}

	@Test
	public void testGetTile() {
		assertEquals(tiles[3][4], board.getTile(3,4));
	}

	@Test
	public void testContainsWall() {
		
	}

	@Test
	public void testSetWall() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetWall() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveWall() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetHeight() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetWidth() {
		fail("Not yet implemented");
	}

}
