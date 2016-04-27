package aston.group12.view.components;

import aston.group12.view.Main;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * 
 * Represents a tile component.
 * Adapted from <a href="https://github.com/AlmasB/FXTutorials/blob/master/src/com/almasb/checkers/Piece.java">AlmasB</a>.
 *
 */
public class TileComponent extends Rectangle {
        
	public TileComponent(int x, int y) {
		setWidth(Main.TILE_SIZE);
		setHeight(Main.TILE_SIZE);
		relocate(x * Main.TILE_SIZE, y * Main.TILE_SIZE);
		setFill(Color.valueOf("#ffffff"));
	}
	
}
