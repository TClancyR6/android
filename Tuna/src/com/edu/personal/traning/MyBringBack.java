package com.edu.personal.traning;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.Layout.Alignment;
import android.util.AttributeSet;
import android.view.View;

import com.edu.personal.traning.constants.Const;

public class MyBringBack extends View {

	private Bitmap greenBall;
	private float changingY;
	Typeface font;
	
	public MyBringBack(Context context) {
		super(context);

		greenBall = BitmapFactory.decodeResource(getResources(),
				R.drawable.greenball);
		changingY = Const.INT_0;
		
		// setup font
		font = Typeface.createFromAsset(context.getAssets(), Const.STR_G_UNIT);
	}

	public MyBringBack(Context context, AttributeSet attrs) {
		super(context, attrs);

	}

	public MyBringBack(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);

	}

	// TODO override onDraw method
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		canvas.drawColor(Color.WHITE); // white backgroud
		
		// setup font
		Paint textPaint = new Paint();
		textPaint.setARGB(50, 254, 10, 50);
		textPaint.setTextAlign(Align.CENTER);
		textPaint.setTextSize(50);
		textPaint.setTypeface(font);
		
		// add text to the canvas
		canvas.drawText("mybringback", (canvas.getWidth()/2), 150, textPaint);
		
		canvas.drawBitmap(greenBall, (canvas.getWidth() / 2), changingY, null);
		if (changingY < canvas.getHeight()) {
			changingY += Const.INT_10;
		} else {
			changingY = Const.INT_0;
		}

		// add Rect
		Rect middleRect = new Rect();
		middleRect.set(Const.INT_0, Const.INT_200, canvas.getWidth(),
				Const.INT_300);

		// paint the Rect added
		Paint ourColor = new Paint();
		ourColor.setColor(Color.BLUE);

		// add blue Rect to the canvas
		canvas.drawRect(middleRect, ourColor);
		
		invalidate();
	}
}
