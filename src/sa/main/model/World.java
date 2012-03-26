package sa.main.model;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class World {
	
	//private Paint paint;	
	public World(){
		
	}
	public void draw(Canvas canvas){
		Paint paint =new Paint();
		paint.setColor(Color.BLACK);
		canvas.drawRGB(255, 210, 100);
		canvas.drawRect(0, 250, 400, 340, paint);
	}

}
