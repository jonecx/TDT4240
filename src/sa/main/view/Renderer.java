package sa.main.view;



import sa.main.R;
import sa.main.model.Obstacle;
import sa.main.model.Player;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Renderer {
	
	private Obstacle obstacle;
	private Player player;
	private Paint paint;
	private Bitmap backButton;
	
	public Renderer(Player player, Obstacle obstacle) {
		paint = new Paint();
		this.player = player;
		this.obstacle = obstacle;
		

	}
	
	
	public void draw(Canvas canvas){
		
		
		canvas.drawRGB(255, 210, 100);
		paint.setColor(Color.BLACK);
		canvas.drawRect(0, 250, canvas.getWidth(), 340, paint);
		
		obstacle.draw(canvas);
		player.draw(canvas);
		
	}

	
	
}