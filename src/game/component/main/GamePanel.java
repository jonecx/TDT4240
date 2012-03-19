package game.component.main;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GamePanel extends SurfaceView implements SurfaceHolder.Callback {
	
	private Renderer thread;

	public GamePanel(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		getHolder().addCallback(this);
		thread = new Renderer(getHolder(), this);
		setFocusable(true);
		
	}
	


	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub
		
	}

	public void surfaceCreated(SurfaceHolder holder) {
		// TODO on start up of our game panel, it will set off the renderer to update our screen continuously
		thread.setRunning(true);
		thread.start();
		
	}

	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		
	}
	
	protected void onDraw(Canvas canvas){
		//background color for our game
		//it never moves and it continuously painted by the renderer.
		canvas.drawRGB(255,210,100);
	}
}
