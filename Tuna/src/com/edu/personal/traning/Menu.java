package com.edu.personal.traning;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity {

	private String menus[] = { "Main", "Text", "Email", "Photo", "Getxml",
			"GFX", "GFXSurface", "SoundStuff", "Sliding", "Tabs"};

	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);

		// TODO : Fullscreen
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		initComponent();

	}

	private void initComponent() {

		setListAdapter(new ArrayAdapter<String>(Menu.this,
				android.R.layout.simple_list_item_1, menus));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {

		super.onListItemClick(l, v, position, id);

		String menu = menus[position];

		Class obj = null;
		try {
			obj = Class.forName("com.edu.personal.traning." + menu);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Intent intent = new Intent(Menu.this, obj);
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		// return super.onCreateOptionsMenu(menu);

		MenuInflater menuInflater = getMenuInflater();
		menuInflater.inflate(R.menu.cool_menu, menu);

		return true;

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// return super.onOptionsItemSelected(item);

		switch (item.getItemId()) {

		case R.id.aboutUs:
			Intent intenti = new Intent("com.edu.personal.traning.ABOUTUS");
			startActivity(intenti);
			break;

		case R.id.Preferences:
			Intent intentj = new Intent("com.edu.personal.traning.PREFS");
			startActivity(intentj);
			break;

		case R.id.exit:
			finish();
			break;

		}

		return true;
	}

}
