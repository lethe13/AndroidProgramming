package com.example.comp304_lab3;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
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
//        can.drawRect(60, 115, 240, 150, paint);
//        can.drawCircle(100, 150, 20, paint);
//        can.drawCircle(200, 150, 20, paint);
//        
//        Paint wallpaint = new Paint();
//        wallpaint.setColor(Color.BLACK);
//        wallpaint.setStyle(Style.FILL);
//        
//        Path wallpath = new Path();
//        wallpath.reset();
//        wallpath.moveTo(60, 115);
//        wallpath.lineTo(100, 90);
//        wallpath.lineTo(180, 90);
//        wallpath.lineTo(205, 115);
//        
//        can.drawPath(wallpath, wallpaint);
//        

       
        // HEAD
        paint.setStyle(Style.FILL);
        paint.setColor(Color.BLACK);
        can.drawOval(new RectF(90, 20, 210, 160), paint);
        paint.setColor(Color.WHITE);
        can.drawOval(new RectF(110, 60, 140, 75), paint);
        can.drawOval(new RectF(160, 60, 190, 75), paint);
        can.drawOval(new RectF(143, 85, 157, 105), paint);
        can.drawOval(new RectF(125, 115, 175, 135), paint);	
        
        // EARS
        paint.setStyle(Style.FILL);
        paint.setColor(Color.BLACK);
        can.drawOval(new RectF(70, 65, 100, 115), paint);
        can.drawOval(new RectF(200, 65, 230, 115), paint);
        
        // NECK
        paint.setStyle(Style.FILL);
        paint.setColor(Color.BLACK);
        can.drawRect(140, 150, 160, 190, paint);
        
        // BODY
        paint.setStyle(Style.FILL);
        paint.setColor(Color.BLACK);
        can.drawRect(120, 180, 180, 370, paint);
        
        // ARMS
        paint.setStyle(Style.FILL);
        paint.setColor(Color.BLACK);
        
        Path path1 = new Path();
        path1.reset();
        path1.moveTo(120, 180);
        path1.lineTo(15, 320);
        path1.lineTo(25, 330);
        path1.lineTo(130, 190);
        
        can.drawPath(path1, paint);
        
        Path path2 = new Path();
        path2.reset();
        path2.moveTo(180, 180);
        path2.lineTo(285, 320);
        path2.lineTo(275, 330);
        path2.lineTo(170, 190);
        
        can.drawPath(path2, paint);
        
        // LEGS
        paint.setStyle(Style.FILL);
        paint.setColor(Color.BLACK);
        
        Path path3 = new Path();
        path3.reset();
        path3.moveTo(120, 370);
        path3.lineTo(85, 540);
        path3.lineTo(100, 540);
        path3.lineTo(140, 360);
        
        can.drawPath(path3, paint);
        
        Path path4 = new Path();
        path4.reset();
        path4.moveTo(180, 370);
        path4.lineTo(215, 540);
        path4.lineTo(200, 540);
        path4.lineTo(160, 360);
        
        can.drawPath(path4, paint);
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
