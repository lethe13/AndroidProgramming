package com.example.comp304_group1_microproject6;

import com.example.comp304_group1_microproject6.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.Settings.Global;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {
	Button Login;
	EditText USERNAME, USERPASS;
	static String username;
	String userpass;
	Context CTX = this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		Login = (Button) findViewById(R.id.b_login);
		USERNAME = (EditText) findViewById(R.id.user_name);
		USERPASS = (EditText) findViewById(R.id.user_pass);
		Login.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				username = USERNAME.getText().toString();
				userpass = USERPASS.getText().toString();
				if (username.equalsIgnoreCase("") || userpass.equalsIgnoreCase("")) {
					Toast.makeText(getBaseContext(),
							"Please enter a username and password.", Toast.LENGTH_LONG).show();
				} else {
					DatabaseOperations DOP = new DatabaseOperations(CTX);
					Cursor CR = DOP.getInformation(DOP);
					CR.moveToFirst();
					boolean login_status = false;
					String NAME = "";
					do {
						if (username.equals(CR.getString(0))
								&& (userpass.equals(CR.getString(1)))) {
							login_status = true;
							NAME = CR.getString(0);
						}
					} while (CR.moveToNext());
					if (login_status) {
						Toast.makeText(getBaseContext(), "Login Success",
								Toast.LENGTH_LONG).show();
						finish();
						startActivity(new Intent(LoginActivity.this,
								MainActivity.class));
					} else {
						Toast.makeText(getBaseContext(), "Login Failed",
								Toast.LENGTH_LONG).show();
						finish();
					}
				}
				
			}
		});
	}

}
