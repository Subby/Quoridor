package aston.group12.view.components;

import aston.group12.view.MainGame;
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
		setWidth(MainGame.TILE_SIZE);
		setHeight(MainGame.TILE_SIZE);
		relocate(x * MainGame.TILE_SIZE, y * MainGame.TILE_SIZE);
		setFill(Color.valueOf("#ffffff"));
	}
	
}
