package aston.group12.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WallTest {
	
	private Wall w;
	private Position from;
	private Position to;
	private boolean isHorizontal;

	@Before
	public void setUp() throws Exception {
		from = new Position(0,2);
		to = new Position(2,2);
		isHorizontal = true;
		w = new Wall(from, to, isHorizontal);
	}

	@Test
	public void testGetFrom() {
		assertEquals(0,from.getX());
		assertEquals(2,from.getY());
	}

	@Test
	public void testGetTo() {
		assertEquals(2,to.getX());
		assertEquals(2,to.getY());
	}

	@Test
	public void testIsHorizontal() {
		assertTrue(w.isHorizontal());
		Wall w2 = new Wall(from, to, false);
		assertFalse(w2.isHorizontal());
	}

}
