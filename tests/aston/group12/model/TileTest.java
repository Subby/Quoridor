package aston.group12.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class for Tile.java.
 * @author Anas Khan
 * @version 0.1
 */

public class TileTest {

	private Tile t;

	@Before
	public void setUp() throws Exception {
		t = new Tile(2, 5);
	}

	@Test
	public void testGetX() {
		assertEquals(2, t.getX());
	}

	@Test
	public void testGetY() {
		assertEquals(5, t.getY());
	}

}