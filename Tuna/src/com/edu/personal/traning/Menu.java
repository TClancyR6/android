package com.edu.personal.traning;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity {

	private String menus[] = { "Main", "Text", "Email", "example3",
			"example4", "example5", "example6" };

	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);

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

}
