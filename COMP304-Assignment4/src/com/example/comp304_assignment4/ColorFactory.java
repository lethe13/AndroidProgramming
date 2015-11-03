package com.example.comp304_assignment4;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class ColorFactory implements OnClickListener {
	
	private int regionColor;
	private MainActivity main;

	public ColorFactory(int regionColor, MainActivity main) {
		this.regionColor = regionColor;
		this.main = main;
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		main.setRegionColor(regionColor);
	}

}
