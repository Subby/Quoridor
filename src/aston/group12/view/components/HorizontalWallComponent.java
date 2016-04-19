package aston.group12.view.components;

import aston.group12.view.Main;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class HorizontalWallComponent extends Rectangle {
	

	public HorizontalWallComponent(int x, int y) {

		setWidth((Main.TILE_SIZE / 5) + 40);
		setHeight(Main.TILE_SIZE / 10);
		relocate(x * Main.TILE_SIZE, y * Main.TILE_SIZE);
		setFill(Color.rgb(153, 217, 234, 0.8));		
	}
	
}
