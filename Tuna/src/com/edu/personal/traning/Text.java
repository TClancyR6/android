package com.edu.personal.traning;

import java.util.Random;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.edu.personal.traning.constants.Const;

public class Text extends Activity implements View.OnClickListener {

	private EditText etInput;
	private Button btTryCommand;
	private ToggleButton tbtOnOff;
	private TextView tvMovingText;

	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.text);

		initComponent();
	}

	private void initComponent() {
		etInput = (EditText) findViewById(R.id.etCommands);
		btTryCommand = (Button) findViewById(R.id.btResults);
		tbtOnOff = (ToggleButton) findViewById(R.id.tbtPassword);
		tvMovingText = (TextView) findViewById(R.id.tvMovingText);
		
		btTryCommand.setOnClickListener(this);
		tbtOnOff.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.tbtPassword:
			if (tbtOnOff.isChecked()) {
				etInput.setInputType(InputType.TYPE_CLASS_TEXT
						| InputType.TYPE_TEXT_VARIATION_PASSWORD);
			} else {
				etInput.setInputType(InputType.TYPE_CLASS_TEXT);
			}
			break;
		case R.id.btResults:
			String command = etInput.getText().toString();

			if ("left".contentEquals(command)) {
				tvMovingText.setGravity(Gravity.LEFT);
			} else if ("center".contentEquals(command)) {
				tvMovingText.setGravity(Gravity.CENTER);
			} else if ("right".contentEquals(command)) {
				tvMovingText.setGravity(Gravity.RIGHT);
			} else if ("WTF".contentEquals(command)) {
				Random random = new Random();
				tvMovingText.setText("WTF!");
				tvMovingText.setTextSize(random.nextInt(75));
				tvMovingText.setTextColor(Color.rgb(random.nextInt(265),
						random.nextInt(265), random.nextInt(265)));
				switch (random.nextInt(Const.INT_3)) {

				case Const.INT_0:
					tvMovingText.setGravity(Gravity.LEFT);
					break;
				case Const.INT_1:
					tvMovingText.setGravity(Gravity.CENTER);
					break;
				case Const.INT_2:
					tvMovingText.setGravity(Gravity.RIGHT);
					break;
				}
			} else {
				tvMovingText.setGravity(Gravity.CENTER);
				tvMovingText.setText("Usage : Left , Center, Right");
				tvMovingText.setTextColor(Color.RED);
			}
			break;
		}
	}

}
