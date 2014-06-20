package com.edu.personal.traning;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class SimpleBrowser extends Activity implements OnClickListener {

	EditText etURL;
	Button btGo, btBack, btForward, btRefresh, btClear;
	WebView wbBrowser;
	private static final int layout = R.layout.simplebrowser;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(layout);
		
		initialize();
	}

	private void initialize() {
		// button
		btGo = (Button) findViewById(R.id.btGo);
		btBack = (Button) findViewById(R.id.btBack);
		btForward = (Button) findViewById(R.id.btForward);
		btClear = (Button) findViewById(R.id.btClear);
		// text
		etURL = (EditText) findViewById(R.id.etURL);
		// 1. webview
		wbBrowser = (WebView) findViewById(R.id.wbBrowser);
		// 2. Javascript Enable
		wbBrowser.getSettings().setJavaScriptEnabled(true);
		wbBrowser.getSettings().setLoadWithOverviewMode(true);
		wbBrowser.getSettings().setUseWideViewPort(true);
		// 3. set CustomViewClient
		wbBrowser.setWebViewClient(new CustomWebViewClient());
		// event
		btGo.setOnClickListener(this);
		btBack.setOnClickListener(this);
		btForward.setOnClickListener(this);
		btClear.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.btGo :
			String url = etURL.getText().toString();
			try {
				wbBrowser.loadUrl(url);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			// 키보드 보이거나 말거나 둘중 하나야!
			InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(etURL.getWindowToken(), 0);
			
			break;
		case R.id.btBack :
			if (wbBrowser.canGoBack())
				wbBrowser.goBack();	
			break;
			
		case R.id.btForward :
			if (wbBrowser.canGoForward())
				wbBrowser.goForward();
			break;
		case R.id.btRefresh :
			wbBrowser.reload();
			break;
		case R.id.btClear :
			wbBrowser.clearHistory();
			break;
		}
	}
	
}
