package sa.main.model;


import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Player {
	
	private Bitmap bitmap;
	private int x;
	private int y;
	private boolean jump;
	private int yDirection;
	
	public Player(Bitmap bitmap, int x, int y){
		this.bitmap = bitmap;
		this.x = x;
		this.y = y;
		this.yDirection = -1;
		this.jump= false;
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
	
	public int getY(){
		return y;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	public boolean getJump(){
		return jump;
	}
	
	public void setJump(boolean jump){
		this.jump = jump;
	}

	public int getyDirection(){
		return yDirection;
	}
	
	public void setyDirection(int yDirection){
		this.yDirection = yDirection;
	}
	
	public void draw(Canvas canvas){
		canvas.drawBitmap(bitmap, x - (bitmap.getWidth()/2), y - (bitmap.getHeight()/2),null);
	}
	
	public void update(){
		if(this.getJump() == true){
			y += getyDirection();
		}
			
	}

}
