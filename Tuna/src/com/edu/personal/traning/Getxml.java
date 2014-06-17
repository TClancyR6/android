package com.edu.personal.traning;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.edu.personal.traning.constants.Const;

public class Getxml extends Activity implements OnClickListener {

	private EditText etSend;
	private Button btStartActivity, btStartActivityForResult;
	private TextView tvGotAnswer;

	@Override
	protected void onCreate(Bundle bundle) {

		super.onCreate(bundle);
		setContentView(R.layout.getxml);

		// init component
		initComponent();
	}

	private void initComponent() {

		etSend = (EditText) findViewById(R.id.etSend);
		btStartActivity = (Button) findViewById(R.id.btStartActivity);
		btStartActivityForResult = (Button) findViewById(R.id.btStartActivityForResult);
		tvGotAnswer = (TextView) findViewById(R.id.tvGotAnswer);

		btStartActivity.setOnClickListener(this);
		btStartActivityForResult.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		case R.id.btStartActivity:
			// input string
			String value = etSend.getText().toString();
			// add input string with key
			Bundle bundle = new Bundle();
			bundle.putString(Const.STR_FIRST_KEY, value);
			// set intent
			Intent intenti = new Intent(Getxml.this, Send.class);
			// set bundle
			intenti.putExtras(bundle); //
			// start activity
			startActivity(intenti);
			break;
		case R.id.btStartActivityForResult:
			Intent intentj = new Intent(Getxml.this, Send.class);
			startActivityForResult(intentj, Const.INT_0); // Const.INT_0 : default setting
			break;
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		
		// operation OK
		if (RESULT_OK == resultCode) {
			// get basket
			Bundle extraBundle = data.getExtras();
			String answer = extraBundle.getString(Const.STR_ANSWER);
			tvGotAnswer.setText(answer);
		}
	}
}
