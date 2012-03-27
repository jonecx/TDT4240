package sa.main.model;


import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Player {
	
	private Bitmap bitmap;
	private int x;
	private int y;
	private boolean jump;
	private int yDirection;
	int time1 = (int) (System.currentTimeMillis()/1000);
	
	private Rect sourceRectangle; // the rectangle to be drawn from the animation bitmap 
	private int frameNr; // number of frames in animation
	private int currentFrame; //the current frame
	private long frameTicker; //the time of the last frame update
	private int framePeriod; //milliseconds between each frame (1000/fps)

	private int playerWidth;
	private int playerHeight;
		
	public Player(Bitmap bitmap, int x, int y,int fps, int frameCount){
		this.bitmap = bitmap;
		this.x = x;
		this.y = y;
		this.yDirection = -1;
		this.jump= false;
		
		this.currentFrame=currentFrame;
		this.frameNr = frameCount;
		this.playerWidth = bitmap.getWidth();
		this.playerHeight = bitmap.getHeight();
		this.sourceRectangle = new Rect(0,0,playerWidth, playerHeight);
		this.framePeriod = 1000/fps;
		this.frameTicker = 0L;
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
		Rect destRect = new Rect(getX(), getY(), getX() + playerWidth, getY() + playerHeight);
		canvas.drawBitmap(bitmap, sourceRectangle, destRect,null);
		//canvas.drawBitmap(bitmap, x - (bitmap.getWidth()/2), y - (bitmap.getHeight()/2),null);
	}
	
	public void update(long gameTime){
		if(this.getJump() == true){
			y += getyDirection()*5;
		}else{
			y+=0;
		}
		if(gameTime > frameTicker + framePeriod){
			frameTicker = gameTime;
			currentFrame++;
			if(currentFrame >= frameNr){
				currentFrame = 0;
			}
		}
		
		this.sourceRectangle.left = currentFrame* playerWidth;
		this.sourceRectangle.right = this.sourceRectangle.left + playerWidth;
		
	}

}
