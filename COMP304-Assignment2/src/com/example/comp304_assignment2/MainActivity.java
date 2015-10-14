package com.example.comp304_assignment2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends Activity {

	ImageView image;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        changePicture();
    }

    public void changePicture() {
    	image = (ImageView) findViewById(R.id.imageView1);
    	Button btn1 = (Button) findViewById(R.id.button1);
    	Button btn2 = (Button) findViewById(R.id.button2);
    	Button btn3 = (Button) findViewById(R.id.button3);
    	Button btn4 = (Button) findViewById(R.id.button4);
    	Button btn5 = (Button) findViewById(R.id.button5);

    	btn1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				image.setImageResource(R.drawable.stephen);
			}
		});
    	
    	btn2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				image.setImageResource(R.drawable.wendall);
			}
		});
    	
    	btn3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				image.setImageResource(R.drawable.jake);
			}
		});
    	
    	btn4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				image.setImageResource(R.drawable.nikita);
			}
		});
    	
    	btn5.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				image.setImageResource(R.drawable.robert);
			}
		});
    	
    	
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
