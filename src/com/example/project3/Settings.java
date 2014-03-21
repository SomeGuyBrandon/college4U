package com.example.project3;

import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Settings extends Activity implements OnClickListener{

	private EditText gpa;
	private EditText act;
	private EditText sat;
	private final static String OPT_NAME = "name";
	DatabaseHandler dh;
	String username = "";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings);
		
		View save = (Button) findViewById(R.id.save);
		save.setOnClickListener(this);
		View logout = (Button) findViewById(R.id.logout);
		logout.setOnClickListener(this);
	
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			username = extras.getString("NAME");
		}
		
		gpa = (EditText) findViewById(R.id.gpa);
		sat = (EditText) findViewById(R.id.sat);
		act = (EditText) findViewById(R.id.act);
		
		dh = new DatabaseHandler(this);
		List<UserInfo> users = dh.getAllUsers();
		for (int i =0; i < users.size(); i++)
		{
			if (users.get(i).getName().equals(username)){
				Double d = users.get(i).getGPA();
				gpa.setText(d.toString());
				Integer n = users.get(i).getACT();
				act.setText(n.toString());
				n = users.get(i).getSAT();
				sat.setText(n.toString());
				break;
			}
		}
		
		
		/*gpa.addTextChangedListener(new TextWatcher() {
			
	          public void afterTextChanged(Editable s) {
	        	  
	        	  if (!gpa.getText().toString().equals("") && ( Double.parseDouble(gpa.getText().toString())<0.0
	        			  ||Double.parseDouble(gpa.getText().toString())>4.0)){
	        		  
	        		  	new AlertDialog.Builder(this)
	        		  		.setTitle("GPA").setMessage("GPA Invalid").setNeutralButton("Set GPA to a valid number from 0.0-4.0",
	        		  				new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int which) {
								}
							}).show();
	        		  
	        	  }

	          }

	          public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

	          public void onTextChanged(CharSequence s, int start, int before, int count) {}
		});
		
		act.addTextChangedListener(new TextWatcher() {
			
	          public void afterTextChanged(Editable s) {
	        	  
	        	  if (!act.getText().toString().equals("") && (Integer.parseInt(act.getText().toString())<0
	        			  ||Integer.parseInt(act.getText().toString())>36)){
	        		  
	        		  	new AlertDialog.Builder(this)
	        		  		.setTitle("GPA").setMessage("GPA Invalid").setNeutralButton("Set GPA to a valid number from 0.0-4.0",
	        		  				new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int which) {
								}
							}).show();
	        		  
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
		});*/
		
		
	}
	
	
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.save:
			dh = new DatabaseHandler(this);
			List<UserInfo> users = dh.getAllUsers();
			for (int i =0; i < users.size(); i++)
			{
				if (users.get(i).getName().equals(username)){
					double gpa_num;
					int sat_num, act_num;
					
					if (gpa.getText().toString().equals(""))
						gpa.setText("0.0");
					if (act.getText().toString().equals(""))
						act.setText("0");
					if (sat.getText().toString().equals(""))
						sat.setText("0");
					
					gpa_num = Double.parseDouble(gpa.getText().toString());
					sat_num = Integer.parseInt(sat.getText().toString());
					act_num = Integer.parseInt(act.getText().toString());
					
					
					if (gpa_num < 0.0 || gpa_num > 4.0)
						new AlertDialog.Builder(this)
    		  		.setTitle("GPA").setMessage("GPA Invalid").setNeutralButton("Set GPA to a valid number from 0.0-4.0",
    		  				new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,
								int which) {
						}
					}).show();
					else if (act_num < 0 || act_num > 36)
						new AlertDialog.Builder(this)
    		  		.setTitle("GPA").setMessage("ACT Invalid").setNeutralButton("Set ACT to a valid number between 0 and 36",
    		  				new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,
								int which) {
						}
					}).show();
					else if (sat_num < 0 || sat_num > 2400)
						new AlertDialog.Builder(this)
    		  		.setTitle("GPA").setMessage("SAT Invalid").setNeutralButton("Set SAT to a valid number between 0 and 2400",
    		  				new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,
								int which) {
						}
					}).show();
					else{
						users.get(i).setGPA(gpa_num);
						users.get(i).setACT(sat_num);
						users.get(i).setSAT(act_num);
						Integer k = dh.updateUser(users.get(i));
						startActivity(new Intent(this, School_Listings.class));
					}
					break;
				}
			}
			break;
		case R.id.logout:
			startActivity(new Intent(this, Login.class));
			finish();
			break;
		}
	}
	

}
