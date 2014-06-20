package com.edu.personal.traning;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class SharedPrefs extends Activity implements OnClickListener {

	private static final int layout = R.layout.sharedprefs;
	
	EditText et01;
	Button bt01, bt02;
	TextView tv01;
	
	public static final String filename = "sharedfilename";
	SharedPreferences sharedData;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(layout);
		
		init();
		
		// TODO SharedPreferences
		sharedData = getSharedPreferences(filename, 0);
		
		
	}

	private void init() {

		et01 = (EditText) findViewById(R.id.et01);
		bt01 = (Button) findViewById(R.id.bt01);
		bt02 = (Button) findViewById(R.id.bt02);
		tv01 = (TextView) findViewById(R.id.tv01);
		
		bt01.setOnClickListener(this);
		bt02.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.bt01 :
				String str = et01.getText().toString();
				
				// TODO edit shared Preferences
				SharedPreferences.Editor editor = sharedData.edit();
				editor.putString("key_sharedstring", str);
				editor.commit();

				break;
			case R.id.bt02 :

				sharedData = getSharedPreferences(filename, 0);
				String ret = sharedData.getString("key_sharedstring", "defValue");
				tv01.setText(ret);
				
				
				break;
		}
	}

}
