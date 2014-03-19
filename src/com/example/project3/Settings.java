package com.example.project3;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Settings extends Activity implements OnClickListener{

	private EditText gpa;
	private EditText act;
	private EditText sat;
	private final static String OPT_NAME = "name";
		
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings);
		
		View save = (Button) findViewById(R.id.save);
		save.setOnClickListener(this);

		//DatabaseHelper dh = new DatabaseHelper(this);
	
		
		gpa = (EditText) findViewById(R.id.gpa);
		sat = (EditText) findViewById(R.id.sat);
		act = (EditText) findViewById(R.id.act);
		
		gpa.addTextChangedListener(new TextWatcher() {
			
	          public void afterTextChanged(Editable s) {
	        	  
	        	  if (!gpa.getText().toString().equals("") && ( Double.parseDouble(gpa.getText().toString())<0.0
	        			  ||Double.parseDouble(gpa.getText().toString())>4.0)){
	        		  
	        		  	/*new AlertDialog.Builder(this)
	        		  		.setTitle("GPA").setMessage("GPA Invalid").setNeutralButton("Set GPA to a valid number from 0.0-4.0",
	        		  				new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int which) {
								}
							}).show();*/
	        		  
	        	  }

	          }

	          public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

	          public void onTextChanged(CharSequence s, int start, int before, int count) {}
		});
		
		act.addTextChangedListener(new TextWatcher() {
			
	          public void afterTextChanged(Editable s) {
	        	  
	        	  if (!act.getText().toString().equals("") && (Integer.parseInt(act.getText().toString())<0
	        			  ||Integer.parseInt(act.getText().toString())>36)){
	        		  
	        		  	/*new AlertDialog.Builder(this)
	        		  		.setTitle("GPA").setMessage("GPA Invalid").setNeutralButton("Set GPA to a valid number from 0.0-4.0",
	        		  				new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int which) {
								}
							}).show();*/
	        		  
	        	  }

	          }

	          public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

	          public void onTextChanged(CharSequence s, int start, int before, int count) {}
		});
		
		sat.addTextChangedListener(new TextWatcher() {
			
	          public void afterTextChanged(Editable s) {
	        	  
	        	  if (!sat.getText().toString().equals("") && (Integer.parseInt(sat.getText().toString())<0
	        			  ||Integer.parseInt(sat.getText().toString())>2400)  ){
	        		  
	        		  
	        	  }
	        		 
	        	  

	          }
	          

	          public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

	          public void onTextChanged(CharSequence s, int start, int before, int count) {}
		});
		
		
	}
	
	
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.save:
			startActivity(new Intent(this, School_Listings.class));
			break;
		}
	}
	

}
