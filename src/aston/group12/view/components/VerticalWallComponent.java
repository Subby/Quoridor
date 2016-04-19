package aston.group12.view.components;

import aston.group12.view.Main;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class VerticalWallComponent extends Rectangle {
		
	public VerticalWallComponent(int x, int y) {	
		setWidth((Main.TILE_SIZE / 10));
		setHeight((Main.TILE_SIZE / 5) + 40);
		relocate((x * Main.TILE_SIZE) + 45, y * Main.TILE_SIZE);
		setFill(Color.rgb(153, 217, 234, 0.8));
	}	
}

