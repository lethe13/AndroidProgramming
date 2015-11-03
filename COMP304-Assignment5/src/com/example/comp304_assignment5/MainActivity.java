package com.example.comp304_assignment5;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;


public class MainActivity extends Activity {

	private View colorArea;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        colorArea = findViewById(R.id.color_region);
        Button b1 = (Button) findViewById(R.id.button1);
        Button b2 = (Button) findViewById(R.id.button2);
        Button b3 = (Button) findViewById(R.id.button3);
        Button b4 = (Button) findViewById(R.id.button4);
        RadioButton r1 = (RadioButton) findViewById(R.id.radio_button1);
        RadioButton r2 = (RadioButton) findViewById(R.id.radio_button2);
        RadioButton r3 = (RadioButton) findViewById(R.id.radio_button3);
        RadioButton r4 = (RadioButton) findViewById(R.id.radio_button4);
        
        b1.setOnClickListener(new ColorFactory(Color.RED, this));
        b2.setOnClickListener(new ColorFactory(Color.BLUE, this));
        b3.setOnClickListener(new ColorFactory(Color.GREEN, this));
        b4.setOnClickListener(new ColorFactory(Color.YELLOW, this));
        r1.setOnClickListener(new ColorFactory(Color.RED, this));
        r2.setOnClickListener(new ColorFactory(Color.BLUE, this));
        r3.setOnClickListener(new ColorFactory(Color.GREEN, this));
        r4.setOnClickListener(new ColorFactory(Color.YELLOW, this));

    }

    public void setRegionColor(int color) {
    	colorArea.setBackgroundColor(color);
    	if (color == Color.RED) {
    		Toast msg = Toast.makeText(MainActivity.this, getString(R.string.message) + "\nThis color is indeed " + getString(R.string.red_prompt), Toast.LENGTH_LONG);
        	msg.show();
    	}
    	else if (color == Color.BLUE) {
    		Toast msg = Toast.makeText(MainActivity.this, getString(R.string.message) + "\nThis color is indeed " + getString(R.string.blue_prompt), Toast.LENGTH_LONG);
        	msg.show();
    	}
    	else if (color == Color.GREEN) {
    		Toast msg = Toast.makeText(MainActivity.this, getString(R.string.message) + "\nThis color is indeed " + getString(R.string.green_prompt), Toast.LENGTH_LONG);
        	msg.show();
    	}
    	else {
        		Toast msg = Toast.makeText(MainActivity.this, getString(R.string.message) + "\nThis color is indeed " + getString(R.string.yellow_prompt), Toast.LENGTH_LONG);
            	msg.show();
        }
    	
    }
    
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
