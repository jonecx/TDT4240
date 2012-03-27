package sa.main.controller;


import sa.main.model.Obstacle;
import sa.main.model.Player;



public class GameController {
	
	private Player player;
	private Obstacle obstacle;
	private boolean touched;
	
		
	public GameController(Player player, Obstacle obstacle){
		this.player = player;
		this.obstacle = obstacle;
	}
	
	public boolean getTouched(){
		return touched;
	}
	
	public void setTouched(boolean touched){
		this.touched = true;
	}
		
	public void update() {
		
		if(player.getY() <= 0){
			player.setyDirection(1);
		}
		if(player.getY() >= 22){
			player.setyDirection(-1);
		}
		if(player.getY() == 220){
			player.setJump(false);
		}
		player.setJump(this.getTouched());
		player.update();
		obstacle.update();

	}

}
