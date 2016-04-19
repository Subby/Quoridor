package aston.group12.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WallTest {
	
	private Wall wall;
	private Wall otherWall;
	private Player p1;
	private Player p2;

	@Before
	public void setUp() throws Exception {
		p1 = new HumanPlayer("Steve");
		p2 = new HumanPlayer("Austin");
		wall = new Wall(4, 5, true, p1);
		otherWall = new Wall(8, 9, false, p2);
	}

	@Test
	public void testGetX() {
		assertEquals(4, wall.getX());
		assertEquals(8, otherWall.getX());
	}

	@Test
	public void testGetY() {
		assertEquals(5, wall.getY());
		assertEquals(9, otherWall.getY());
	}

	@Test
	public void testGetIsFirst() {
		assertTrue(wall.getIsFirst());
		assertFalse(otherWall.getIsFirst());
	}
	
	@Test
	public void getPlacedBy() {
		assertEquals(p1.getName(), wall.getPlacedBy().getName());
		assertEquals(p2.getName(), otherWall.getPlacedBy().getName());
	}	

}
