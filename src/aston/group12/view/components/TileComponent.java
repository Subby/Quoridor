package aston.group12.view.components;

import aston.group12.view.Main;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * 
 * Represents a tile component.
 *
 */
public class TileComponent extends Rectangle {
    
	private PawnComponent pawn;

    public boolean hasPawn() {
        return pawn != null;
    }

    public PawnComponent getPawn() {
        return pawn;
    }

    public void setPawn(PawnComponent piece) {
        this.pawn = piece;
    }
    
	public TileComponent(int x, int y) {
		setWidth(Main.TILE_SIZE);
		setHeight(Main.TILE_SIZE);
		relocate(x * Main.TILE_SIZE, y * Main.TILE_SIZE);
		setFill(Color.valueOf("#ffffff"));
	}
	
}
