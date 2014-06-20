package com.edu.personal.traning;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class ExternalData extends Activity implements OnClickListener {

	private static final int layout = R.layout.externaldata;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(layout);
	}

	@Override
	public void onClick(View v) {

	}

}
