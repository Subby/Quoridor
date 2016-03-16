package aston.group12.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PositionTest {
	
	private Position p;

	@Before
	public void setUp() throws Exception {
		p = new Position(2,1);
	}

	@Test
	public void testGetX() {
		assertEquals(2, p.getX());
	}

	@Test
	public void testSetX() {
		p.setX(3);
		assertEquals(3, p.getX());
	}

	@Test
	public void testGetY() {
		assertEquals(1, p.getY());
	}

	@Test
	public void testSetY() {
		p.setY(4);
		assertEquals(4, p.getY());
	}

	@Test
	public void testEqualsPosition() {
		Position p2 = new Position(0,1);
		assertTrue(p.equals(p2));
	}

}
