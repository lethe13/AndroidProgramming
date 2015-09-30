package com.school.comp304_assign1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.view.View;

public class FlagView extends View {
	Paint paint, paint1;
	
	public FlagView(Context context) {
		super(context);
		paint = new Paint();
		paint.setColor(Color.RED);
		paint.setStrokeWidth(1);
		paint1 = new Paint();
		paint1.setColor(Color.RED);
		paint1.setStyle(Paint.Style.FILL_AND_STROKE);
		paint1.setStrokeWidth(2);
	}

	@Override
	public void onDraw(Canvas canvas)
	{
		// FLAG
		//canvas.drawRect(LEFT, TOP, RIGHT, BOTTOM, PAINT)
		canvas.drawRect(0,0,50,125, paint);
		canvas.drawRect(200, 0, 250, 125, paint);
		
		//canvas.drawLine(X1,Y1, X2,Y2, paint)
		canvas.drawLine(50, 0, 200, 0, paint);
		canvas.drawLine(50, 124, 200, 124, paint);
		
		
		// MAPLE LEAF
		canvas.drawRect(120, 50, 130, 115, paint);
		
		Path path = new Path();
		path.setFillType(Path.FillType.EVEN_ODD);
		path.moveTo(120, 100);
		path.lineTo(95, 105);
		path.lineTo(100, 100);
		path.lineTo(65, 70);
		path.lineTo(75, 65);
		path.lineTo(70, 50);
		
		path.lineTo(90, 55);
		path.lineTo(95, 45);
		path.lineTo(110, 65);
		path.lineTo(105, 25);
		path.lineTo(115, 30);
		
		path.lineTo(125, 10);
		
		path.lineTo(135, 30);
		path.lineTo(145, 25);
		path.lineTo(140, 65);
		path.lineTo(155, 45);
		path.lineTo(160, 55);
		
		path.lineTo(180, 50);
		path.lineTo(175, 65);
		path.lineTo(185, 70);
		path.lineTo(150, 100);
		path.lineTo(155, 105);
		path.lineTo(130, 100);

		path.close();
		canvas.drawPath(path, paint1);
		
		
	}
}
