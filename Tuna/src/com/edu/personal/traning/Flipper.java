package com.edu.personal.traning;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ViewFlipper;

public class Flipper extends Activity implements OnClickListener {

	ViewFlipper flipper;
	private static final int layout = R.layout.flipper;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(layout);
		
		initialize();
	}

	private void initialize() {
		flipper = (ViewFlipper) findViewById(R.id.viewFlipper1);	
		flipper.setOnClickListener(this);
		
		// auto flipping
		flipper.setFlipInterval(500);
		flipper.startFlipping();
	}

	@Override
	public void onClick(View v) {
		flipper.showNext();		
	}

}
