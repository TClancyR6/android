package com.edu.personal.traning;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Email extends Activity implements View.OnClickListener {

	private TextView textView1, textView2, textView3, textView4, textView5,
			textView6;
	private EditText editText1, editText2, editText3, editText4, editText5,
			editText6;
	private Button sendEmail;
	private Intent emailIntent;

	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.email);

		initComponent();

		sendEmail.setOnClickListener(this);
	}

	private void initComponent() {
		textView1 = (TextView) findViewById(R.id.textView1);
		textView2 = (TextView) findViewById(R.id.textView2);
		textView3 = (TextView) findViewById(R.id.textView3);
		textView4 = (TextView) findViewById(R.id.textView4);
		textView5 = (TextView) findViewById(R.id.textView5);
		textView6 = (TextView) findViewById(R.id.textView6);
		editText1 = (EditText) findViewById(R.id.editText1);
		editText2 = (EditText) findViewById(R.id.editText2);
		editText3 = (EditText) findViewById(R.id.editText3);
		editText4 = (EditText) findViewById(R.id.editText4);
		editText5 = (EditText) findViewById(R.id.editText5);
		editText6 = (EditText) findViewById(R.id.editText6);
		sendEmail = (Button) findViewById(R.id.sendEmail);
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.sendEmail:
			StringBuilder sb = new StringBuilder();
			sb.append(editText1.getText().toString());
			sb.append(", ");
			sb.append(editText2.getText().toString());
			sb.append(", ");
			sb.append(editText3.getText().toString());
			sb.append(", ");
			sb.append(editText4.getText().toString());
			sb.append(", ");
			sb.append(editText5.getText().toString());
			sb.append(", ");
			sb.append(editText6.getText().toString());

			setEmailContent(sb.toString());
			break;
		}
	}

	private void setEmailContent(String message) {
		emailIntent = new Intent(android.content.Intent.ACTION_SEND);
		emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{editText1.getText().toString()});
		emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "I hate you!");
		emailIntent.setType("plain/text");
		emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, message);
		startActivity(emailIntent);
	}

	@Override
	protected void onPause() {
		super.onPause();
		finish();
	}

}
