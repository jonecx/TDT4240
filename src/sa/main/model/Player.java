package sa.main.model;


import sa.main.R;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Player {
	
	private Bitmap bitmap;
	private Rect sourceRect; // the rectangle to be drawn from the animation bitmap 
	private int frameNr; // number of frames in animation
	private int currentFrame; //the current frame
	private long frameTicker; //the time of the last frame update
	private int framePeriod; //milliseconds between each frame (1000/fps)
	
	private int spriteWidth;
	private int spriteHeight;
	
	
	private int x;
	private int y;
	private int yDirection;
	
	
	int i = 1;
	
	public Player(Bitmap bitmap,  int x, int y, int fps, int frameCount){
		this.bitmap = bitmap;
		currentFrame = 0;
		frameNr = frameCount;
		spriteWidth = bitmap.getWidth() / frameCount;
		spriteHeight = bitmap.getHeight();
		sourceRect = new Rect(0, 0, spriteWidth, spriteHeight);
		framePeriod = 1000/ fps;
		frameTicker = 0L;
		
		this.x = x;
		this.y = y;
		this.yDirection = -1;
	
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

	public int getyDirection(){
		return yDirection;
	}
	
	public void setyDirection(int yDirection){
		this.yDirection = yDirection;
	}
	
	public void draw(Canvas canvas){
		Rect destRect = new Rect(getX(), getY(), getX() + spriteWidth, getY() + spriteHeight);
		canvas.drawBitmap(bitmap, sourceRect, destRect, null);
		//	canvas.drawBitmap(bitmap, x - (bitmap.getWidth()/2), y - (bitmap.getHeight()/2),null);

	}
	
	public void update(long gameTime){
		
		y += getyDirection();
		
		if( gameTime > frameTicker + framePeriod) {
			frameTicker = gameTime;
			//increment the frame
			currentFrame++;
			if(currentFrame >= frameNr) {
				currentFrame = 0;
			}
		}
		//define the rectangle to cut out sprite
		this.sourceRect.left = currentFrame * spriteWidth;
		this.sourceRect.right = this.sourceRect.left + spriteWidth;
			
	}

}
