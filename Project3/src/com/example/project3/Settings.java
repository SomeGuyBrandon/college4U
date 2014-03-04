package com.example.project3;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Settings extends Activity{

	private EditText gpa;
	private EditText act;
	private EditText sat;
	private final static String OPT_NAME = "name";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings);

		gpa = (EditText) findViewById(R.id.gpa);
		sat = (EditText) findViewById(R.id.sat);
		act = (EditText) findViewById(R.id.act);
	}
	
	

}
