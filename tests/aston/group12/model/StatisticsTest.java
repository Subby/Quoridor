package aston.group12.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StatisticsTest {

	private Statistics stats;
	@Before
	public void setUp() throws Exception {
		stats = new Statistics();
	}

	@Test
	public void testIncrementTotalMoves() {
		stats.incrementTotalMoves();
		assertEquals(1, stats.getTotalMoves());
	}

	@Test
	public void testGetTotalMoves() {
		assertEquals(0, stats.getTotalMoves());
	}

	@Test
	public void testGetNumOfWallsUsed() {
		assertEquals(0, stats.getNumOfWallsUsed());
	}

	@Test
	public void testIncrementWallsUsed() {
		stats.incrementWallsUsed();
		assertEquals(1, stats.getNumOfWallsUsed());
	}

}
