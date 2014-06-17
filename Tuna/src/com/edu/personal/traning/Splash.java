package com.edu.personal.traning;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;

import com.edu.personal.traning.constants.Const;

public class Splash extends Activity {

	private MediaPlayer mediaPlayer;

	@Override
	protected void onCreate(Bundle bundle) {

		super.onCreate(bundle);
		setContentView(R.layout.splash);

		initcomponent();

	}

	private void initcomponent() {

		// get preference info
		SharedPreferences sharedPreferences = PreferenceManager
				.getDefaultSharedPreferences(getBaseContext());
		boolean isMusicChecked = sharedPreferences.getBoolean(
				Const.STR_MUSIC_ON_OFF_CHECKBOX_KEY, true);
		
		if (isMusicChecked) {
			setMediaplayer();
		}

		setIntent();
	}

	private void setIntent() {

		Thread thread = new Thread() {
			public void run() {
				try {
					sleep(Const.INT_2000);
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
		mediaPlayer = MediaPlayer.create(Splash.this, R.raw.splashsound);
		mediaPlayer.start();
	}

	@Override
	protected void onPause() {

		super.onPause();
		mediaPlayer.release(); // not stop() method
		finish();
	}
}
