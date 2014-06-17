package com.edu.personal.traning;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;

import com.edu.personal.traning.constants.Const;

public class GFXSurface extends Activity implements OnTouchListener {

	private MyBringBackSurface view;
	private float x, y, sX, sY, fX, fY, dX, dY, aniX, aniY, scaledX, scaledY;
	private Bitmap bitmap;
	private Bitmap plus;

	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);

		view = new MyBringBackSurface(this);

		// set event on canvas
		view.setOnTouchListener(this);
		x = Const.INT_0;
		y = Const.INT_0;
		sX = Const.INT_0;
		sY = Const.INT_0;
		fX = Const.INT_0;
		fY = Const.INT_0;
		dX = dY = aniX = aniY = scaledX = scaledY = Const.INT_0;

		bitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.greenball);
		plus = BitmapFactory.decodeResource(getResources(), R.drawable.plus);

		setContentView(view);
	}

	@Override
	protected void onResume() {
		super.onResume();
		view.resume();
	}

	@Override
	protected void onPause() {
		super.onPause();
		view.pause();
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {

		// TODO create frame rate
		// ex) 60 frame per second -> 1000 / 60 = 16.6666666~
		try {
			Thread.sleep(50);// it will give us around 20 frames per second
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		
		// get click position every time the screen is touched
		x = event.getX();
		y = event.getY();

		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			sX = event.getX();
			sY = event.getY();
			
			// TODO 
			dX = dY = aniX = aniY = scaledX = scaledY = fX = fY = Const.INT_0;
			
			break;
		case MotionEvent.ACTION_UP:
			fX = event.getX();
			fY = event.getY();

			// change X direction
			dX = fX - sX; // final X - start X
			// change Y direction
			dY = fY - sY; // final X - start X

			scaledX = dX / 30;
			scaledY = dY / 30;
			
			// TODO 
			x = y = Const.INT_0;
			
			break;
		}

		return true;
	}

	// create own thread to handle the animation
	public class MyBringBackSurface extends SurfaceView implements Runnable {

		// SurfaceHolder manages surface
		private SurfaceHolder holder;

		private Thread thread = null;
		private boolean isRunning = false;

		public MyBringBackSurface(Context context) {
			super(context);
			holder = getHolder();
			thread = new Thread(this);
			thread.start();
		}

		public void pause() {
			isRunning = false;
			while (true) {
				try {
					thread.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;
			}
			thread = null;
		}

		public void resume() {
			isRunning = true;
			thread = new Thread(this); // create new thread
			thread.start(); // thread starts
		}

		@Override
		public void run() {

			while (isRunning) {
				if (!holder.getSurface().isValid())
					continue;

				// lock canvas [no other thread gets in]
				Canvas canvas = holder.lockCanvas();
				canvas.drawRGB(02, 02, 150);

				// set greeball's position
				if (x != Const.INT_0 && y != Const.INT_0) {
					// Bitmap bitmap =
					// BitmapFactory.decodeResource(getResources(),
					// R.drawable.greenball);
					// canvas.drawBitmap(bitmap, x, y, null);
					canvas.drawBitmap(bitmap, x - (bitmap.getWidth() / 2), y
							- (bitmap.getHeight() / 2), null);
				}

				// set greeball's position
				if (sX != Const.INT_0 && sY != Const.INT_0) {

					canvas.drawBitmap(plus, sX - (plus.getWidth() / 2), sY
							- (plus.getHeight() / 2), null);
				}

				// set greeball's position (shooting ball)
				if (fX != Const.INT_0 && fY != Const.INT_0) {
					
					// how much gonna change X 
					canvas.drawBitmap(bitmap, fX - (bitmap.getWidth() / 2) - aniX, fY
							- (bitmap.getHeight() / 2) - aniY, null);
					
					canvas.drawBitmap(plus, fX - (plus.getWidth() / 2), fY
							- (plus.getHeight() / 2), null);
				}
				
				aniX = aniX + scaledX;
				aniY = aniY + scaledY;

				holder.unlockCanvasAndPost(canvas);

			}
		}
	}
}
