package aston.group12.view.components;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import static aston.group12.view.Main.TILE_SIZE;

/**
 * 
 * Creates a {@link StackPane} representation of a Pawn.
 *
 */
public class PawnComponent extends StackPane {
	
	private PawnType type;
	
	private double mouseX, mouseY;
	private double oldX, oldY;
	
	/**
	 * Gets the {@link PawnType}.
	 * @return the pawn type.
	 */
	public PawnType getType() {
		return type;
	}
	
	/**
	 * Gets the old x coordinate.
	 * @return the old x coordinate
	 */
	public double getOldX() {
		return oldX;
	}
	
	/**
	 * Gets the old y coordinate.
	 * @return the old y coordinate
	 */
	public double getOldY() {
		return oldY;
	}
	
	public PawnComponent(PawnType type, int x, int y, String name) {
		this.type = type;
		
		move(x, y);
		      
        Ellipse ellipse = new Ellipse(TILE_SIZE * 0.3215, TILE_SIZE * 0.26);
        ellipse.setFill(Color.valueOf(type.getColour()));
        ellipse.setStroke(Color.BLACK);
        ellipse.setStrokeWidth(TILE_SIZE * 0.03);
        
        ellipse.setTranslateX((TILE_SIZE - TILE_SIZE * 0.3125 * 2) / 2);
        ellipse.setTranslateY((TILE_SIZE - TILE_SIZE * 0.26 * 2) / 2);
        
        Text text = new Text(name);
        
        text.setTranslateX(8);
        text.setTranslateY(-10);
        text.setFont(Font.font("Verdana", FontWeight.BOLD, 10));
        getChildren().addAll(ellipse, text);

        setOnMousePressed(e -> {
            mouseX = e.getSceneX();
            mouseY = e.getSceneY();
        });

        setOnMouseDragged(e -> {
            relocate(e.getSceneX() - mouseX + oldX, e.getSceneY() - mouseY + oldY);
        });
	}
	
	/**
	 * Moves a pawn to a new location
	 * @param x the x coordinate
	 * @param y the y coodinate
	 */
	public void move(int x, int y) {
		oldX = x * TILE_SIZE;
		oldY = y * TILE_SIZE;
		relocate(oldX, oldY);
	}
	
	/**
	 * Reverses a move. Used when the attempted move is not valid.
	 */
	public void reverseMove() {
		relocate(oldX, oldY);
	}
	
	public enum PawnType {
	    RED("#FF0000", Color.rgb(255, 0, 0, 0.4)), WHITE("#fff9f4", Color.rgb(255, 221, 0, 0.4)), GREEN("#4E9600", Color.rgb(78, 150, 0, 0.4)), BLUE("#002FFF", Color.rgb(0, 47, 255, 0.4));

	    final String colour;
	    final Color wallColour;
	    
	    PawnType(String colour, Color wallColour) {
	        this.colour = colour;
	        this.wallColour = wallColour;

	    }
	    
	    /**
	     * Gets the {@link Color}.
	     * @return the colour
	     */
	    public String getColour() {
	    	return colour;
	    }
	    
	    /**
	     * Gets the wall {@link Color}.
	     * @return the wall colour
	     */
	    public Color getWallColour() {
	    	return wallColour;
	    }
	}

}
