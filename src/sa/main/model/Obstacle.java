package sa.main.model;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Obstacle {
	
	private Bitmap bitmap;
	private int x;
	private int y;
	
	public Obstacle(Bitmap bitmap, int x, int y){
		this.bitmap = bitmap;
		this.x = x;
		this.y = y;
	}
	
	public Bitmap getBitmap(){
		return bitmap;
	}
	
	public void setBitmap(Bitmap bitmap){
		this.bitmap = bitmap;
	}
	
	public int getX(){
		return x;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void draw(Canvas canvas){
		canvas.drawBitmap(bitmap, x - (bitmap.getWidth()/2),y- (bitmap.getHeight()/2),null);
	}
		
	public void update(){
		x-= 2;
	}

}
