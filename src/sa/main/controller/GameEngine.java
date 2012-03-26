package sa.main.controller;

import sa.main.MainThread;
import sa.main.R;
import sa.main.model.Player;
import sa.main.model.Obstacle;
import sa.main.model.Player;
import sa.main.model.World;
import sa.main.view.Renderer;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameEngine extends SurfaceView implements
		SurfaceHolder.Callback {

	private Renderer renderer;
	private Player player;
	private Obstacle obstacle;
	private GameController gameController;
	private MainThread mainThread;
	
	private World world;
	
	private Paint paint;

	public GameEngine(Context context) {
		super(context);
		//intercept events from the surfaceview
		getHolder().addCallback(this);
	
		obstacle = new Obstacle(BitmapFactory.decodeResource(getResources(), R.drawable.obstacle), 400, 220);
		player = new Player(BitmapFactory.decodeResource(getResources(), R.drawable.obs),40, 220);
		
		paint = new Paint();
		
		// create the game loop thread
		mainThread = new MainThread(getHolder(), this);
		gameController = new GameController(player, obstacle);
		renderer = new Renderer(player, obstacle);
		
		setFocusable(true);
	}

	//@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
	}

	//@Override
	public void surfaceCreated(SurfaceHolder holder) {
	
		mainThread.setRunning(true);
		mainThread.start();
	}

	//@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
				
		
		
		return true;
	}


	public void update(Canvas canvas){
		gameController.update();
		renderer.draw(canvas);
	}


}
