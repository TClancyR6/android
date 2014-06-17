package com.edu.personal.traning;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;

public class GFX extends Activity {

	private MyBringBack view;
	private WakeLock wakeLock;
	
	
	@Override
	protected void onCreate(Bundle bundle) {
		// TODO wake-lock
		PowerManager powerManager = (PowerManager) getSystemService(Context.POWER_SERVICE);
		wakeLock = powerManager.newWakeLock(PowerManager.FULL_WAKE_LOCK, "whatever");
		

		super.onCreate(bundle); // onCreate
		wakeLock.acquire(); // acquire
		
		
		view = new MyBringBack(this);
		setContentView(view);
	}


	@Override
	protected void onPause() {

		super.onPause();
		wakeLock.release();
	}

}
