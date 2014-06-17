package com.edu.personal.traning;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.edu.personal.traning.constants.*;

public class Main extends Activity implements View.OnClickListener {

	private int counter;
	private TextView tvTotal;
	private Button btAdd, btSubstract;

	@Override
	protected void onCreate(Bundle bundle) {

		super.onCreate(bundle);
		setContentView(R.layout.main);

		// init counter
		counter = Const.INT_0;

		// init component
		initComponent();
	}

	/**
	 * init Component.
	 */
	private void initComponent() {

		// text view
		tvTotal = (TextView) findViewById(R.id.tvTotal);

		// button
		btAdd = (Button) findViewById(R.id.btAdd);
		btSubstract = (Button) findViewById(R.id.btSubstract);

		// set Event
		btAdd.setOnClickListener(this);
		btSubstract.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {

		case R.id.btAdd:
			counter++;
			setResult();
			break;

		case R.id.btSubstract:
			counter--;
			setResult();
			break;
		}
	}

	/**
	 * set result.
	 */
	private void setResult() {
		tvTotal.setText("Your total is " + counter);
	}

}
