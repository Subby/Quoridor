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

	private Position p;
	private Tile t;

	@Before
	public void setUp() throws Exception {
		p = new Position(0,1);
		t = new Tile(p);
	}

	@Test
	public void testGetPosition() {
		assertEquals(0, t.getPosition().getX());
		assertEquals(1, t.getPosition().getY());
	}

	@Test
	public void testSetPosition() {
		Position dest = new Position(-1,10);		
		t.setPosition(dest);
		assertEquals(-1, t.getPosition().getX());
		assertEquals(10, t.getPosition().getY());
	}

}