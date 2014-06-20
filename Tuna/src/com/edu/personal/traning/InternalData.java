package com.edu.personal.traning;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class InternalData extends Activity implements OnClickListener {

	private static final int layout = R.layout.internaldata;

	EditText et01;
	Button bt01, bt02;
	TextView tv01;

	FileOutputStream fos;
	public static final String FILE_NAME = "InternalString";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(layout);

		init();

	}

	private void init() {

		et01 = (EditText) findViewById(R.id.et01);
		bt01 = (Button) findViewById(R.id.bt01);
		bt02 = (Button) findViewById(R.id.bt02);
		tv01 = (TextView) findViewById(R.id.tv01);

		bt01.setOnClickListener(this);
		bt02.setOnClickListener(this);

		// openFileOutput
		setFos();
	}

	private void setFos() {

		try {
			// 1. openFileOutput
			fos = openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
			// 2. close
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bt01:
			String data = et01.getText().toString();

			// // TODO Save data
			// File file = new File(FILE_NAME);
			// try {
			// fos = new FileOutputStream(file);
			// fos.close();
			// } catch (FileNotFoundException e) {
			// e.printStackTrace();
			// } catch (IOException e) {
			// e.printStackTrace();
			// }

			try {

				fos = openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
				fos.write(data.getBytes());
				fos.close();

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			break;
		case R.id.bt02:
			// TODO Async Task
			new AsyncLoadStuff().execute(FILE_NAME);

			break;
		}
	}

	public class AsyncLoadStuff extends AsyncTask<String, Integer, String> {

		protected void onPreExcute(String str) {
			// example of setting up something
			str = "whatever!";
		}

		@Override
		protected String doInBackground(String... params) {

			String ret = null;
			FileInputStream fis = null;

			try {

				// 1. try to get a file
				fis = openFileInput(FILE_NAME);

				// 2. read the fis and get bytes
				byte[] dataArray = new byte[fis.available()];

				// 3.
				while (fis.read(dataArray) != -1) {
					// 4.
					ret = new String(dataArray);
				}

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					// 5.
					fis.close();

					// 6.
					return ret;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return null;
		}

		protected void onProgressUpdated(Integer[] integers) {
			
		}
		
		protected void onPostExcute(String ret) {
			
		}

	}
}
