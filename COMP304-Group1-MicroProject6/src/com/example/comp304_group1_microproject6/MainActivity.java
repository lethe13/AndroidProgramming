package com.example.comp304_group1_microproject6;

import com.example.comp304_group1_microproject5.R;

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
		Button b1 = (Button)findViewById(R.id.button1);
		Button b2 = (Button)findViewById(R.id.button2);
		Button b3 = (Button)findViewById(R.id.button3);
		Button b4 = (Button)findViewById(R.id.button4);
		
	}
	
	public void onClick(View clickedButton){
		switch(clickedButton.getId()){
		case R.id.button1:
			 // Play Game 1
			Intent i = new Intent(getApplicationContext(), GraphicalGuessingGame.class);
			startActivity(i);
			break;
		case R.id.button2:
			Intent i2 = new Intent(getApplicationContext(), MainGraphicalGuessingGame.class);
			startActivity(i2);
			break;
		case R.id.button3:
			Intent i3 = new Intent(getApplicationContext(), ScoreScreen.class);
			startActivity(i3);
			break;
		case R.id.button4:
			// logout
			System.exit(0);
			break;
		}
	}
}
