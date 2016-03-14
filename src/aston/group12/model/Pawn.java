package aston.group12.model;

import java.awt.Color;

/**
 * This class creates a new Pawn object.
 * @author Xenia Vanikaki
 * @author Denver Fernandes
 * @version 0.2
 * Last implemented: 19/11/2015
 */

public class Pawn {

	private Color color;
	private Tile tile;
	
	/**
	 * Constructor
	 * Creates new Pawn object.
	 * @param player the pawn to create the player for
	 */
    public Pawn() {
    	assignRandomColour();
    }
    
    /**
     * Assigns a random colour to the pawn.
     */
    public void assignRandomColour() {
    	int randomRed = (int) Math.random();
    	float randomGreen = (int) Math.random();;
    	float randomBlue = (int) Math.random();;
    	color = new Color(randomRed, randomGreen, randomBlue);
    }
    
    /**
     * Gets the {@link Color} of the pawn.
     * @return the colour
     */
    public Color getColor() {
    	return color;
    }
    
    /**
     * Gets the {@link Tile} of the pawn.
     * @return the position
     */
    public Tile getTile() {
    	return tile;
    	
    }
    
    /** 
     * Assigns {@link Tile} to tile
     * @param tile
     */
    public void setTile(Tile tile) {
    	this.tile = tile;
    }
}
