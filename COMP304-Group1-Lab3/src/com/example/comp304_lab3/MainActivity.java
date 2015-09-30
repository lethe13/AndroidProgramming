package com.example.comp304_lab3;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        Bitmap bg = Bitmap.createBitmap(480, 800, Bitmap.Config.ARGB_8888);
        Canvas can = new Canvas(bg);
        //can.drawLine(20, 20, 300, 300, paint);
        can.drawRect(60, 115, 240, 150, paint);
        can.drawCircle(100, 150, 20, paint);
        can.drawCircle(200, 150, 20, paint);
        
        Paint wallpaint = new Paint();
        wallpaint.setColor(Color.BLACK);
        wallpaint.setStyle(Style.FILL);
        
        Path wallpath = new Path();
        wallpath.reset();
        wallpath.moveTo(60, 115);
        wallpath.lineTo(100, 90);
        wallpath.lineTo(180, 90);
        wallpath.lineTo(205, 115);
        
        can.drawPath(wallpath, wallpaint);
        
        LinearLayout l = (LinearLayout) findViewById(com.example.comp304_lab3.R.id.drawarea);
        l.setBackgroundDrawable(new BitmapDrawable(bg));
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
