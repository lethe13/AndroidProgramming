package com.example.comp304_group1_microproject6;

import com.example.comp304_group1_microproject6.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button b1 = (Button)findViewById(R.id.backmenu);
		b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(MainActivity.this, GraphicalGuessingGame.class);
				startActivity(i);
			}
		});
		Button b3 = (Button)findViewById(R.id.button3);
		b3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(MainActivity.this, ScoreScreen.class);
				startActivity(i);
			}
		});
		Button b4 = (Button)findViewById(R.id.button4);
		b4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v)
			{
				Intent i = new Intent(MainActivity.this, FirstPageActivity.class);
				startActivity(i);
			}
		});
		
	}
}
