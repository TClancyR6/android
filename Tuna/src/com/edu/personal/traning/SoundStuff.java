package com.edu.personal.traning;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;

import com.edu.personal.traning.constants.Const;

public class SoundStuff extends Activity implements OnClickListener, OnLongClickListener {

	private SoundPool soundpool;
	private MediaPlayer mediaPlayer;
	private int explosion;
	
	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		
		// create view
		View view = new View(this);
		view.setOnClickListener(this);
		view.setOnLongClickListener(this);

		// set contentview
		setContentView(view);
		
		// create soundpool
		soundpool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
		explosion = soundpool.load(this, R.raw.explosion, 1);
		
		// for OnLongClickListener
		mediaPlayer = MediaPlayer.create(this, R.raw.splashsound);
	}

	@Override
	public void onClick(View v) {

		if (Const.INT_0 != explosion) 
			soundpool.play(explosion, 1, 1, 0, 0, 1);
	}

	@Override
	public boolean onLongClick(View v) {
		
		mediaPlayer.start();
		
		return false;
	}

}
