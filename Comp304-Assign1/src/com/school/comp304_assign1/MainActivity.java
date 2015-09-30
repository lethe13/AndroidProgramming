package com.school.comp304_assign1;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

	FlagView view;
	LinearLayout layout;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		layout = (LinearLayout)findViewById(R.id.FlagLayout);
		
		view = new FlagView(this);
		Bitmap result = Bitmap.createBitmap(100,40, Bitmap.Config.ARGB_8888);
		Canvas c = new Canvas(result);
		view.draw(c);
		view.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,200));
		layout.addView(view);
	

//		SurfaceView layout = (SurfaceView)findViewById(R.id.FlagLayout);
//		layout.getHolder().addCallback(new Callback() {
//			
//			@Override
//			public void surfaceCreated(SurfaceHolder holder)
//			{
//				
//				Canvas canvas = holder.lockCanvas();
//
//				Paint white = new Paint();
//				white.setColor(Color.WHITE);
//				Paint red = new Paint();
//				red.setColor(Color.RED);
//	            canvas.drawRect(new Rect(0,0,100,30), white);
//				canvas.drawRect(new Rect(0,0,20,30), red);
//	            canvas.drawRect(new Rect(70,0,20,30), red);
//	            holder.unlockCanvasAndPost(canvas);
//			}
//
//			@Override
//			public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void surfaceDestroyed(SurfaceHolder holder) {
//				// TODO Auto-generated method stub
//				
//			}
//		});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
