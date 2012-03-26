package sa.main.controller;

import android.graphics.BitmapFactory;
import sa.main.R;
import sa.main.model.Obstacle;
import sa.main.model.Player;



public class GameController {
	
	private Player player;
	private Obstacle obstacle;
	
	public GameController(Player player, Obstacle obstacle){
		this.player = player;
		this.obstacle = obstacle;
	}
	
	
	public void update() {
		
		if(player.getY() <= 0){
			player.setyDirection(1);
		}
		if(player.getY() >= 220){
			player.setyDirection(-1);
		}
		// Update the lone droid
		player.update();
		obstacle.update();

	}

}
