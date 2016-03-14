package aston.group12.model;

public class Statistics {
	
	private int numOfTotalMoves;
	
	public Statistics() {
	}
	
	public void incrementTotalMoves() {
		numOfTotalMoves++;
	}
	
	public int getTotalMoves() {
		return numOfTotalMoves;
	}
	
}
