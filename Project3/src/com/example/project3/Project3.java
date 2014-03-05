package com.example.project3;

import java.util.List;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Button;


public class Project3 extends Activity implements OnClickListener {

	private EditText userNameEditableField;
	private EditText passwordEditableField;
	private final static String OPT_NAME = "name";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_project3);

		userNameEditableField = (EditText) findViewById(R.id.username_text);
		passwordEditableField = (EditText) findViewById(R.id.password_text);
		View btnLogin = (Button) findViewById(R.id.login_button);
		btnLogin.setOnClickListener(this);
		View btnCancel = (Button) findViewById(R.id.cancel_button);
		btnCancel.setOnClickListener(this);
		View btnNewUser = (Button) findViewById(R.id.new_user_button);
		btnNewUser.setOnClickListener(this);
	}
	
	@Override
	protected void onResume() {
		userNameEditableField.setText("RESUME");
	super.onResume();
	}

	@Override
	protected void onRestart() {
		userNameEditableField.setText("RESTART");
	super.onRestart();
	}

	@Override
	protected void onPause() {
		userNameEditableField.setText("PAUSE");
	super.onPause();
	}

	@Override
	protected void onStop() {
		userNameEditableField.setText("STOP");
	super.onStop();
	}

	private void checkLogin() {
		String username = this.userNameEditableField.getText().toString();
		String password = this.passwordEditableField.getText().toString();
		startActivity(new Intent(this, Settings.class));
		/*this.dh = new DatabaseHelper(this);
		List<String> names = this.dh.selectAll(username, password);
		if (names.size() > 0) { // Login successful
			// Save username as the name of the player
			SharedPreferences settings = PreferenceManager
					.getDefaultSharedPreferences(this);
			SharedPreferences.Editor editor = settings.edit();
			editor.putString(OPT_NAME, username);
			editor.commit();

			// Bring up the GameOptions screen
			startActivity(new Intent(this, GameOptions.class));
			finish();
		} else {
			// Try again?
			new AlertDialog.Builder(this)
					.setTitle("Error")
					.setMessage("Login failed")
					.setNeutralButton("Try Again",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int which) {
								}
							}).show();
		}*/
		
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
			//startActivity(new Intent(this, Account.class));
			break;
		}
	}
}
