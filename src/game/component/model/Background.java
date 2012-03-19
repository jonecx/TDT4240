package game.component.model;

import android.graphics.Bitmap;

public class Background {
	
	private int x;
	private int y;
	private Bitmap bitmap;
	
	public Background(Bitmap bitmap, int x , int y){
		this.bitmap= bitmap;
		this.x = x;
		this.y = y;
	}
	
	public void draw(){
		
	}

}
