package com.edu.personal.traning;

import com.edu.personal.traning.constants.Const;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class Splash extends Activity {

	private MediaPlayer mediaPlayer;
	
	@Override
	protected void onCreate(Bundle bundle) {

		super.onCreate(bundle);
		setContentView(R.layout.splash);

		initcomponent();

	}

	private void initcomponent() {

		setIntent();
		setMediaplayer();

	}

	private void setIntent() {

		Thread thread = new Thread() {
			public void run() {
				try {
					sleep(Const.INT_5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					Intent intent = new Intent("com.edu.personal.traning.MENU");
					startActivity(new Intent(intent));
				}
			}
		};
		thread.start();
	}

	private void setMediaplayer() {
		mediaPlayer = MediaPlayer.create(Splash.this,
				R.raw.splashsound);
		mediaPlayer.start();
	}

	@Override
	protected void onPause() {

		super.onPause();
		mediaPlayer.release(); // not stop() method
		finish();
	}
}
