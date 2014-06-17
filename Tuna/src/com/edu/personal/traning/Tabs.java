package com.edu.personal.traning;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class Tabs extends Activity {

	private static final int tabs = R.layout.tabs;
	private TabHost tabhost;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(tabs);
		
		initComponent();
	}

	private void initComponent() {

		tabhost = (TabHost) findViewById(R.id.tabhost);
		// setup tabhost
		tabhost.setup();
		
		// add tabs
		TabSpec tabSpec  = tabhost.newTabSpec("tag1");
		tabSpec.setContent(R.id.tab1);
		tabSpec.setIndicator("StopWatch");

		tabhost.addTab(tabSpec);
		
		// add tabs
		tabSpec  = tabhost.newTabSpec("tag2");
		tabSpec.setContent(R.id.tab2);
		tabSpec.setIndicator("Tab 2");
		tabhost.addTab(tabSpec);
		
		// add tabs
		tabSpec  = tabhost.newTabSpec("tag3");
		tabSpec.setContent(R.id.tab3);
		tabSpec.setIndicator("Add a Tab");
		tabhost.addTab(tabSpec);
		
		// add tabs
		tabSpec  = tabhost.newTabSpec("tag4");
		tabSpec.setContent(R.id.tab4);
		tabSpec.setIndicator("Tab 4");
		tabhost.addTab(tabSpec);
		
		// add tabs
		tabSpec  = tabhost.newTabSpec("tag5");
		tabSpec.setContent(R.id.tab5);
		tabSpec.setIndicator("Tab 5");
		tabhost.addTab(tabSpec);
		
		// add tabs
		tabSpec  = tabhost.newTabSpec("tag6");
		tabSpec.setContent(R.id.tab6);
		tabSpec.setIndicator("Tab 6");
		tabhost.addTab(tabSpec);
	}

}
