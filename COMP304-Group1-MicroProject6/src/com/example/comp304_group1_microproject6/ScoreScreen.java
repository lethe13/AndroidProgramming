package com.example.comp304_group1_microproject6;

import com.example.comp304_group1_microproject6.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ScoreScreen extends Activity {
	Context CTX = this;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.score_screen);
		TextView score1 = (TextView)findViewById(R.id.Score1);
		//TextView score2 = (TextView)findViewById(R.id.Score2);
		TextView totalscore = (TextView)findViewById(R.id.totalScore);
		Button backBtn = (Button)findViewById(R.id.backmenu);
		backBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(ScoreScreen.this, MainActivity.class);
				startActivity(i);
			}
		});
		
		String Score1 = "0";
		String Score2 = "0";
		
		//Connect to Database and retrive Scores
		DatabaseOperations DOP = new DatabaseOperations(CTX);
		Cursor CR = DOP.getInformation(DOP);
		CR.moveToFirst();
		while (CR.moveToNext())
		{
			if (CR.getString(0).equals(LoginActivity.username))
			{
				Score1 = String.valueOf(CR.getInt(2));
				Score2 = String.valueOf(CR.getInt(3));
			}
		}
		
		score1.setText(Score1);
		totalscore.setText(Score2);
	}

}
