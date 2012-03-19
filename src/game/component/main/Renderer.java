package game.component.main;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class Renderer extends Thread {
	
	private boolean running;
	private SurfaceHolder surfaceHolder;
	private GamePanel gamePanel;
	private Canvas canvas;
	
	public Renderer(SurfaceHolder surfaceHolder, GamePanel gamePanel){
		super();
		this.surfaceHolder = surfaceHolder;
		this.gamePanel = gamePanel;
	}
	
	public void setRunning(boolean running){
		this.running = running;
	}
	
	public void run(){
		canvas = null;
		try{
			canvas = this.surfaceHolder.lockCanvas();
			synchronized(surfaceHolder){
				this.gamePanel.onDraw(canvas);
			}
		}finally{
			if(canvas != null){
				surfaceHolder.unlockCanvasAndPost(canvas);
			}
		}
	}

}
