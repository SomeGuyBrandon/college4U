package com.example.project3;

import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Button;


public class Login extends Activity implements OnClickListener {
	class Information{
		public String name, state;
		public int act, sat;
		public double gpa;
	};

	
	private UserInfo user;
	private DatabaseHandler dh;
	private EditText userNameEditableField;
	private EditText passwordEditableField;
	private final static String OPT_NAME = "name";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);

		userNameEditableField = (EditText) findViewById(R.id.username_text);
		passwordEditableField = (EditText) findViewById(R.id.password_text);
		View btnLogin = (Button) findViewById(R.id.login_button);
		btnLogin.setOnClickListener(this);
		View btnCancel = (Button) findViewById(R.id.cancel_button);
		btnCancel.setOnClickListener(this);
		View btnNewUser = (Button) findViewById(R.id.new_user_button);
		btnNewUser.setOnClickListener(this);
	}
	
	
	private void checkLogin() {
		String username = this.userNameEditableField.getText().toString();
		String password = this.passwordEditableField.getText().toString();
		
		
		SchoolDatabaseHandler sdh = new SchoolDatabaseHandler(this);
		sdh.addSchool(new SchoolInfo("Ohio State University", "OH", 3.5, 1800, 30));
		sdh.addSchool(new SchoolInfo("Akron University", "OH", 3.0, 1600, 24));
		sdh.addSchool(new SchoolInfo("University of Michigan", "MI", 3.8, 2000, 31));
		
		
		
	
		this.user = new UserInfo(username,password);
		this.dh = new DatabaseHandler(this);
		List<UserInfo> users = this.dh.getAllUsers();
		boolean valid=false;
		for (int i =0; i < users.size(); i++)
		{
			if (users.get(i).getName().equals(username) && users.get(i).getPassword().equals(password)){
				valid = true;
				break;
			}
		}
		if (valid) { // Login successful
			// Save username as the name of the player
			SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);
			SharedPreferences.Editor editor = settings.edit();
			editor.putString(OPT_NAME, username);
			editor.commit();
			
			// Bring up the Settings screen
			Intent intent = new Intent(this, Settings.class);
			intent.putExtra("NAME", username);
			startActivity(intent);
			
			finish();
		
		} else {
			// Try again?
			new AlertDialog.Builder(this)
					.setTitle("Error")
					.setMessage("Login failed")
					.setNeutralButton("OK",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int which) {
								}
							}).show();
		}
		
	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.login_button:
			checkLogin();
			break;
		case R.id.cancel_button:
			finish();
			break;
		case R.id.new_user_button:
			startActivity(new Intent(this, NewUser.class));
			break;
		}
	}
}
