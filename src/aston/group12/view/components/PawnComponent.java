package aston.group12.view.components;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import static aston.group12.view.Main.TILE_SIZE;

import aston.group12.model.Settings;


public class PawnComponent extends StackPane {
	
	private PawnType type;
	
	private double mouseX, mouseY;
	private double oldX, oldY;
	
	public PawnType getType() {
		return type;
	}
	
	public double getOldX() {
		return oldX;
	}
	
	public double getOldY() {
		return oldY;
	}
	
	public PawnComponent(PawnType type, int x, int y, String name, String colour) {
		this.type = type;
		
		move(x, y);
		
        /*Ellipse bg = new Ellipse(TILE_SIZE * 0.3125, TILE_SIZE * 0.26);
        bg.setFill(Color.BLACK);
        bg.setStrokeWidth(TILE_SIZE * 0.03);
        
        bg.setTranslateX((TILE_SIZE - TILE_SIZE * 0.3125) / 2);
        bg.setTranslateY((TILE_SIZE - TILE_SIZE * 0.26 * 2) / 2 + TILE_SIZE * 0.07);*/        
        
        Circle ellipse = new Circle(TILE_SIZE * 0.3215);
        ellipse.setFill(Color.web(colour));
        ellipse.setStroke(Color.BLACK);
        ellipse.setStrokeWidth(TILE_SIZE * 0.03);
        
        ellipse.setTranslateX((TILE_SIZE - TILE_SIZE * 0.3125 * 2) / 2);
        ellipse.setTranslateY((TILE_SIZE - TILE_SIZE * 0.26 * 2) / 2);
        
        if(Settings.getSingleton().isShowLabels()) {
        	Text text = new Text(name);
        	text.setTranslateX(8);
        	text.setTranslateY(-10);
        	text.setFont(Font.font("Verdana", FontWeight.BOLD, 10));
        	getChildren().add(text);
        }
        
        getChildren().addAll(ellipse);

        setOnMousePressed(e -> {
            mouseX = e.getSceneX();
            mouseY = e.getSceneY();
        });

        setOnMouseDragged(e -> {
            relocate(e.getSceneX() - mouseX + oldX, e.getSceneY() - mouseY + oldY);
        });
	}
	
	public void move(int x, int y) {
		oldX = x * TILE_SIZE;
		oldY = y * TILE_SIZE;
		relocate(oldX, oldY);
	}
	
	public void reverseMove() {
		relocate(oldX, oldY);
	}
	
	public enum PawnType {
	    RED("#FF0000", Color.valueOf("#FF0000")), WHITE("#E6C700", Color.valueOf("#E6C700")), GREEN("#4E9600", Color.valueOf("#4E9600")), BLUE("#002FFF", Color.valueOf("#002FFF"));

	    final String colour;
	    final Color wallColour;
	    
	    PawnType(String colour, Color wallColour) {
	        this.colour = colour;
	        this.wallColour = wallColour;

	    }
	    
	    public String getColour() {
	    	return colour;
	    }
	    
	    public Color getWallColour() {
	    	return wallColour;
	    }
	}

}
