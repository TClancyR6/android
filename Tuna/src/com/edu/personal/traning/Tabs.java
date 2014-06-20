package com.edu.personal.traning;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class Tabs extends Activity implements OnClickListener {

	private static final int tabs = R.layout.tabs;
	private TabHost tabhost;

	private Button btAddTab, btStartWatch, btStopWatch;

	private TextView tvShowResults;
	private long start, stop;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(tabs);

		initComponent();
	}

	private void initComponent() {

		tabhost = (TabHost) findViewById(R.id.tabhost);

		btAddTab = (Button) findViewById(R.id.btAddTab);
		btStartWatch = (Button) findViewById(R.id.btStartWatch);
		btStopWatch = (Button) findViewById(R.id.btStopWatch);
		tvShowResults = (TextView) findViewById(R.id.tvShowResults);

		btAddTab.setOnClickListener(this);
		btStartWatch.setOnClickListener(this);
		btStopWatch.setOnClickListener(this);

		// setup tabhost
		tabhost.setup();

		// add tabs
		TabSpec tabSpec = tabhost.newTabSpec("tag1");
		tabSpec.setContent(R.id.tab1);
		tabSpec.setIndicator("StopWatch");

		tabhost.addTab(tabSpec);

		// add tabs
		tabSpec = tabhost.newTabSpec("tag2");
		tabSpec.setContent(R.id.tab2);
		tabSpec.setIndicator("Tab 2");
		tabhost.addTab(tabSpec);

		// add tabs
		tabSpec = tabhost.newTabSpec("tag3");
		tabSpec.setContent(R.id.tab3);
		tabSpec.setIndicator("Add a Tab");
		tabhost.addTab(tabSpec);

		// add tabs
		tabSpec = tabhost.newTabSpec("tag4");
		tabSpec.setContent(R.id.tab4);
		tabSpec.setIndicator("Tab 4");
		tabhost.addTab(tabSpec);

		// add tabs
		tabSpec = tabhost.newTabSpec("tag5");
		tabSpec.setContent(R.id.tab5);
		tabSpec.setIndicator("Tab 5");
		tabhost.addTab(tabSpec);

		// add tabs
		tabSpec = tabhost.newTabSpec("tag6");
		tabSpec.setContent(R.id.tab6);
		tabSpec.setIndicator("Tab 6");
		tabhost.addTab(tabSpec);
		
		start = 0;
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.btAddTab:
			// 1. TabSpec
			TabSpec spec = tabhost.newTabSpec("Added Tab1");
			// 2. setContent
			spec.setContent(new TabHost.TabContentFactory() {
				// 3. createTabContent
				@Override
				public View createTabContent(String tag) {
					TextView text = new TextView(null);
					text.setText("You've created a new Tab!! [ " + tag + " ]");
					return text;
				}
			});
			// 4. setIndicator
			spec.setIndicator("New");
			// 5. addTab
			tabhost.addTab(spec);

			break;

		case R.id.btStartWatch:
			start = System.currentTimeMillis();

			break;
		case R.id.btStopWatch:
			stop = System.currentTimeMillis();
			if (0 != start) {
				long ret = stop - start; // how long it took
				
				int mills = (int) ret;
				mills = mills % 100; // 
				int second = (int) ret / 1000;
				int minutes = second / 60;
				
				tvShowResults.setText("how long it took : " + String.format("%d : %02d : %02d", minutes, second, mills));
			} else {
				tvShowResults.setText("how long it took : " + "0");
			}
			break;
		}

	}

}
