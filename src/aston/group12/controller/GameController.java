package aston.group12.controller;

import aston.group12.model.GameSession;
import aston.group12.view.MainGame;

public class GameController {
	
	private GameSession gameModel;
	private MainGame gameView;
	
	public GameController(GameSession gameSession, MainGame gameView) {
		this.gameModel = gameSession;
		this.gameView = gameView;
	}
	
}
