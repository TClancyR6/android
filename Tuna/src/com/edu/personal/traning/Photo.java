package com.edu.personal.traning;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.edu.personal.traning.constants.Const;

public class Photo extends Activity implements View.OnClickListener {

	private Button btSetWall;
	private ImageButton ibTakePic;
	private ImageView ivReturnedPic;
	private Intent intent;
	private final static int cameraData = Const.INT_0; // 왜 0을 세팅하는가?
	private Bitmap bm;

	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.photo);

		initComponent();

		InputStream is = getResources().openRawResource(R.drawable.ic_launcher);
		// decode inputstream
		bm = BitmapFactory.decodeStream(is);
		
	}

	private void initComponent() {

		ivReturnedPic = (ImageView) findViewById(R.id.ivReturnedPic);
		ibTakePic = (ImageButton) findViewById(R.id.ibTakePic);
		btSetWall = (Button) findViewById(R.id.btSetWall);

		ibTakePic.setOnClickListener(this);
		btSetWall.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btSetWall:
			setWallPaper();
			break;
		case R.id.ibTakePic:
			takePicture();
			break;
		}
	}

	private void setWallPaper() {

		// Manifest 파일에서 android.permission.SET_WALLPAPER permission을 설정 해야함.

		WallpaperManager wallpaperManager = WallpaperManager
				.getInstance(getApplicationContext());
		try {
			wallpaperManager.setBitmap(bm);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void takePicture() {
		intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
		startActivityForResult(intent, cameraData); // ★★★★★
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode,
			Intent intentData) { // ★★★★★
		super.onActivityResult(requestCode, resultCode, intentData);
		// check result code
		if (RESULT_OK == resultCode) {
			Bundle extraBundle = intentData.getExtras();
			bm = (Bitmap) extraBundle.get(Const.STR_DATA); // ★★★★★
			ivReturnedPic.setImageBitmap(bm);
		}
	}
}
