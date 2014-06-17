package com.edu.personal.traning;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v4.widget.SlidingPaneLayout.PanelSlideListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SlidingDrawer;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.SlidingDrawer.OnDrawerOpenListener;

public class Slider extends Activity implements OnClickListener,
		OnCheckedChangeListener, OnDrawerOpenListener {

	private static final int sliding = R.layout.sliding;
	private Button handle1, handle2, handle3, handle4, sdhandle;
	private CheckBox cb;
	private SlidingDrawer sd;
	
	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(sliding);
		
		initComponent();
	}

	private void initComponent() {
		Button handle1 = (Button) findViewById(R.id.handle1);
		Button handle2 = (Button) findViewById(R.id.handle2);
		Button handle3 = (Button) findViewById(R.id.handle3);
		Button handle4 = (Button) findViewById(R.id.handle4);
		
		Button sdhandle = (Button) findViewById(R.id.sdhandle);
		CheckBox cb = (CheckBox) findViewById(R.id.cb);
		
		// TODO 
		sd = (SlidingDrawer) findViewById(R.id.sd);
		sd.setOnDrawerOpenListener(this);

		handle1.setOnClickListener(this);
		handle2.setOnClickListener(this);
		handle3.setOnClickListener(this);
		handle4.setOnClickListener(this);
		sdhandle.setOnClickListener(this);
		
		cb.setOnCheckedChangeListener(this);
		
	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

		if (buttonView.isChecked()) {
			sd.lock();
		} else {
			sd.unlock();
		}
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.handle1 :
			sd.open();
			break;
		case R.id.handle2 :
			sd.animateToggle();
			break;
		case R.id.handle3 :
			sd.toggle();
			break;
		case R.id.handle4 :
			sd.close();
			break;
		case R.id.sdhandle :
			break;
		}
	}

	@Override
	public void onDrawerOpened() {
		MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.explosion);
		mediaPlayer.start();
		
	}

}
