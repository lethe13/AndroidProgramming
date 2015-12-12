package com.example.comp304_group1_microproject6;

import com.example.comp304_group1_microproject5.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ScoreScreen extends Activity {
	Context CTX = this;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.score_screen);
		TextView score1 = (TextView)findViewById(R.id.Score1);
		TextView score2 = (TextView)findViewById(R.id.Score2);
		TextView totalscore = (TextView)findViewById(R.id.totalScore);
		
		//Connect to Database and retrive Scores
		DatabaseOperations DOP = new DatabaseOperations(CTX);
		Cursor CR = DOP.getInformayion(DOP);
		CR.moveToFirst();
		String Score1 = "";
		do {
			if (LoginActivity.username.equals(CR.getString(0)))
			{
				Score1 = CR.getString(3);
			}
		} while (CR.moveToNext());
		String Score2 = "";
		do {
			if (LoginActivity.username.equals(CR.getString(0)))
			{
				Score2 = CR.getString(4);
			}
		} while (CR.moveToNext());
		//float TotalScore = Score1+Score2;
	
		//Change to String and Display in the textviews
		score1.setText(Score1);
		score2.setText(Score2);
		
		float TotalScore = Float.valueOf(Score1) +  Float.valueOf(Score2);
		String TotalScoreText = Float.toString(TotalScore);
		totalscore.setText(TotalScoreText);
	}

}
