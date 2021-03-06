package com.example.comp304_assignment3;

import com.example.comp304_assignment3.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button btnGo = (Button) findViewById(R.id.btnGo);
        btnGo.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				EditText txtInput = (EditText) findViewById(R.id.txtInput);
		        int size = Integer.parseInt(txtInput.getText().toString());
		        
		        TextView lblOutput = (TextView) findViewById(R.id.lblOutput);
		        
		        
		        if (size%2==0) {
		        	Toast tempMessage = Toast.makeText(MainActivity.this, "The size should be odd!", Toast.LENGTH_SHORT);
		        	tempMessage.show();
		        }
		        else {
		        	int [] [] square= new int [size][size];
		    		int col = size/2;
		    		square [0][col]=1;
		    		square[size-1][col]=size*size;
		    		square[size-1][(size/2)+1] =2;  
		    		int row =(size-1)-1;
		    		col=((size/2)+1)+1;
		    		for (int i=3; i<((size*size)); i++){		
		    			if (col>size-1&&row<0){				
		    				row=row+2;
		    				col=col-1;				
		    				square[row][col]=i;
		    				row=row-1;
		    				col=col+1;
		    				}	
		    		
		    			else if (row<0){			
		    			row=size-1;			
		    		    square[row][col]=i;
		    		    row=row-1;
		    			col=col+1;
		    			}
		    			
		    			else if (col>size-1){			
		    			col=0;			
		    			square[row][col]=i;
		    			row=row-1;
		    			col=col+1;
		    			}
		    			
		    			else if (square[row][col]>0){			
		    			row=row+2;
		    			col=col-1;			
		    			square[row][col]=i;
		    			row=row-1;
		    			col=col+1;			
		    			}	
		    		else{			
		    			square[row][col]=i;
		    			row=row-1;
		    			col=col+1;
		    			}		
		    		}
		    		
		    		String output = "";
		    		
		    		for (int i = 0; i < size; i++) {
		                for (int j = 0; j < size; j++) {
		                    if (square[i][j] < 10)  output += " "; 
		                    if (square[i][j] < 100) output += " "; 
		                    output += "" + square[i][j] + " ";
		                }
		                output += "\n";
		            }
		    		lblOutput.setText("" + output);
		        }
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
