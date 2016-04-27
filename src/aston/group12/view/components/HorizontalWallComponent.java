package aston.group12.view.components;

import aston.group12.view.MainGame;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Represents a horizontal wall component within the board using the {@link Rectangle} shape.
 */
public class HorizontalWallComponent extends Rectangle {
	

	public HorizontalWallComponent(int x, int y) {
		setWidth((MainGame.TILE_SIZE / 5) + 40);
		setHeight(MainGame.TILE_SIZE / 10);
		relocate(x * MainGame.TILE_SIZE, y * MainGame.TILE_SIZE);
		setFill(Color.rgb(153, 217, 234, 0.8));		
	}
	
}
