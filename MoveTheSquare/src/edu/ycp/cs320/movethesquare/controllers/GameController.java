package edu.ycp.cs320.movethesquare.controllers;

import edu.ycp.cs320.movethesquare.model.Game;
import edu.ycp.cs320.movethesquare.model.Square;

public class GameController {
	public void computeSquareMoveDirection(Game game, Square square, double mouseX, double mouseY) {
		if (mouseX >= 0 && mouseX < game.getWidth() && mouseY >= 0 && mouseY < game.getHeight()) {
			double dx = mouseX - (square.getX() + square.getWidth()/2);
			double dy = mouseY - (square.getY() + square.getHeight()/2);
			
			double moveX = 0, moveY = 0;
			if (dx > 1) {
				moveX = Game.MOVE_DIST + dx/5;
			} 
			else if(dx < -1){
				moveX = -Game.MOVE_DIST + dx/5;
			}
			else {
				moveX = 0;
			}
			
			if (dy > 1) {
				moveY = Game.MOVE_DIST + dy/5;
			} else if (dy < -1){
				moveY = -Game.MOVE_DIST + dy/5;
			}
			else {
				moveY = 0;
			}
			
			game.setSquareDx(moveX);
			game.setSquareDy(moveY);
		}
	}

	public void moveSquare(Game model, Square square) {
		square.setX(square.getX() + model.getSquareDx());
		square.setY(square.getY() + model.getSquareDy());
	}
}
