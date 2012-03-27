package sa.main.controller;

import sa.main.MainThread;
import sa.main.R;
import sa.main.model.Player;
import sa.main.model.Obstacle;

import sa.main.view.Renderer;
import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
public class GameEngine extends SurfaceView implements
		SurfaceHolder.Callback {

	private Renderer renderer;
	private Player player;
	private Obstacle obstacle;
	private GameController gameController;
	private MainThread mainThread;
	@SuppressWarnings("unused")
	private Paint paint;
	
	public GameEngine(Context context) {
		super(context);
		//intercept events from the surface view
		getHolder().addCallback(this);
	
		obstacle = new Obstacle(BitmapFactory.decodeResource(getResources(), R.drawable.woodbox), 400, 220);
		player = new Player(BitmapFactory.decodeResource(getResources(), R.drawable.minecart1),40, 220);
		paint = new Paint();
		
		// create the game loop thread
		mainThread = new MainThread(getHolder(), this);
		gameController = new GameController(player, obstacle);
		renderer = new Renderer(player, obstacle);
		
//		final Button button = (Button) findViewById(R.drawable.backbutton);
//		button.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//            	mainThread.setRunning(false);
//				((Activity)getContext()).finish();
//            }
//        });
		
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
<<<<<<< HEAD
	
		
		
=======
				
		if (event.getAction()==MotionEvent.ACTION_DOWN){
			gameController.setTouched(true);
		}
>>>>>>> b3ce35cf8abb8f982f4ea04320c3f69a8fdb8dad
		return true;
	}


	public void update(Canvas canvas){
		gameController.update();
		renderer.draw(canvas);
	}


}
