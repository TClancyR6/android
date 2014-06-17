package com.edu.personal.traning;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

import com.edu.personal.traning.constants.Const;

public class Send extends Activity implements OnClickListener,
		OnCheckedChangeListener {

	private TextView tvQuestion;
	private RadioGroup rgAnswers;
	private Button btReturn;
	private TextView tvText;
	private String sendData;

	@Override
	protected void onCreate(Bundle bundle) {

		super.onCreate(bundle);
		setContentView(R.layout.send);

		// init component
		initComponent();

		// setPassedInData();

	}

	private void initComponent() {

		tvQuestion = (TextView) findViewById(R.id.tvQuestion);
		rgAnswers = (RadioGroup) findViewById(R.id.rgAnswers);
		btReturn = (Button) findViewById(R.id.btReturn);
		tvText = (TextView) findViewById(R.id.tvText);

		btReturn.setOnClickListener(this);
		rgAnswers.setOnCheckedChangeListener(this); // �ڡڡڡڡ�

		SharedPreferences getData = PreferenceManager
				.getDefaultSharedPreferences(getBaseContext());
		String et = getData.getString(Const.STR_NAME_KEY, "Travis is...");
		String values = getData.getString(Const.STR_LIST_KEY, Const.STR_4);
		if (values.contentEquals(Const.STR_1)) {
			tvQuestion.setText(et);
		}
	}

	private void setPassedInData() {

		Bundle bundle = getIntent().getExtras();
		String answer = bundle.getString(Const.STR_FIRST_KEY);
		tvQuestion.setText(answer);
	}

	@Override
	public void onClick(View v) {
		Intent intent = new Intent(Send.this, Getxml.class);
		Bundle bundle = new Bundle();
		bundle.putString(Const.STR_ANSWER, sendData);
		intent.putExtras(bundle);
		startActivityForResult(intent, RESULT_OK); // carry back to previous
													// activity
		// finish(); // finish itself
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		switch (checkedId) {
		case R.id.rClazy:
			sendData = "Probably right!";
			break;
		case R.id.rSmart:
			sendData = "Definitely right!";
			break;
		case R.id.rBoth:
			sendData = "Spot On!";
			break;
		}
		tvText.setText(sendData);
	}
}
