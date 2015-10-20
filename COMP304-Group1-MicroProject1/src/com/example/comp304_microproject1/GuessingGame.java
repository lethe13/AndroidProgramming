package com.example.comp304_microproject1;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class GuessingGame extends Activity {

	final Context context = this;
	
	Random randNum = new Random();
	int num = randNum.nextInt(100) + 1;
	
	int score = 100;
	int chance = 10;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_guessing_game);
		
//		TextView test = (TextView) findViewById(R.id.textView2);
//		test.setText("" + num);
		
		Button btnGo = (Button) findViewById(R.id.btnGo);
        btnGo.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				TextView lblMessage = (TextView) findViewById(R.id.lblMessage);
				EditText txtInput = (EditText) findViewById(R.id.txtInput);
		        int guess = Integer.parseInt(txtInput.getText().toString());
		        
		        if (guess < 0 || guess > 100){
		        	lblMessage.setText("Please guess a number between 0 and 100!");
		        }
		        else {
		        	if (guess == num) {
			        	showWinMessageBox();
			        }
			        else {     	
			        	score -= 10;
			        	chance--;
			        	
			        	if (guess > num) {
			        		lblMessage.setText("The number you entered is greater than the number chosen by the program. Try again!");
			        	}
			        	else {
			        		lblMessage.setText("The number you entered is less than the number chosen by the program. Try again!");
			        	}
			        	
			        	TextView lblScore = (TextView) findViewById(R.id.lblScore);
			        	lblScore.setText("Score: " + score + "%");
			        	TextView lblChance = (TextView) findViewById(R.id.lblChance);
			        	lblChance.setText("Chances Left: " + chance);
			        }
		        }
		        
		        if (chance == 0) {
		        	showLoseMessageBox();
		        }
			
			}
        });
		
		        
	}

	private void showWinMessageBox() {
    	AlertDialog.Builder builder = new AlertDialog.Builder(context);
    	builder.setTitle("Guessing Game");
    	builder.setMessage("Congratulations! You won with a score of " + score + "%!");
    	builder.setCancelable(false);
    	
    	builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(GuessingGame.this, MainTestGuessingGame.class);
				startActivity(intent);
	        	
			}
		});
    	
    	AlertDialog dialog = builder.create();
    	dialog.show();
    	
    }

	private void showLoseMessageBox() {
    	AlertDialog.Builder builder = new AlertDialog.Builder(context);
    	builder.setTitle("Guessing Game");
    	builder.setMessage("Game Over!");
    	builder.setCancelable(false);
    	
    	builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(GuessingGame.this, MainTestGuessingGame.class);
				startActivity(intent);
	        	
			}
		});
    	
    	AlertDialog dialog = builder.create();
    	dialog.show();
    	
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
