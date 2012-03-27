package sa.main;

import sa.main.controller.GameEngine;
import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class MainThread extends Thread {

	private SurfaceHolder surfaceHolder;
	//actual view
	private GameEngine gameEngine;

	// to set off the renderer
	private boolean running;
	public void setRunning(boolean running) {
		this.running = running;
	}

	public MainThread(SurfaceHolder surfaceHolder, GameEngine gameEngine) {
		super();
		this.surfaceHolder = surfaceHolder;
		this.gameEngine = gameEngine;
	}

	@Override
	public void run() {
		Canvas canvas;
		
		while (running) {
			canvas = null;
			try {
				canvas = this.surfaceHolder.lockCanvas();
				synchronized (surfaceHolder) {
					gameEngine.update(canvas);
				}
			} finally {
				if (canvas != null) {
				surfaceHolder.unlockCanvasAndPost(canvas);
				}
			}	// end finally
		}
	}
	
}
