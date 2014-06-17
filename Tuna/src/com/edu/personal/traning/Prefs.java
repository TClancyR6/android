package com.edu.personal.traning;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceActivity;

public class Prefs extends PreferenceActivity {

	private static int prefs = R.xml.prefs;

	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);

		// �ڡڡڡڡ�
		if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
			onCreatePreferenceActivity();
		} else {
			onCreatePreferenceFragment();
		}
	}

	@SuppressWarnings("deprecation")
	private void onCreatePreferenceFragment() {
		addPreferencesFromResource(prefs);
	}

	private void onCreatePreferenceActivity() {
		getFragmentManager().beginTransaction()
				.replace(android.R.id.content, new Fragment()).commit();
	}

}
