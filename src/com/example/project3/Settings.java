// Settings activity class

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
		
		// set listeners
		View save = (Button) findViewById(R.id.save);
		save.setOnClickListener(this);
		View logout = (Button) findViewById(R.id.logout);
		logout.setOnClickListener(this);
	
		// get the username that is sent with the intent.
		// this is whose settings these are
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			username = extras.getString("NAME");
		}
		
		// set values to the values of textboxes
		gpa = (EditText) findViewById(R.id.gpa);
		sat = (EditText) findViewById(R.id.sat);
		act = (EditText) findViewById(R.id.act);
		
		// get the values for the user from the users db
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
					
					// if any box is empty set to 0
					if (gpa.getText().toString().equals(""))
						gpa.setText("0.0");
					if (act.getText().toString().equals(""))
						act.setText("0");
					if (sat.getText().toString().equals(""))
						sat.setText("0");
					
					// set GPA, SAT, ACT to the values in the textboxes (converted)
					gpa_num = Double.parseDouble(gpa.getText().toString());
					sat_num = Integer.parseInt(sat.getText().toString());
					act_num = Integer.parseInt(act.getText().toString());
					
					// check and ensure GPA is a value between 0 and 4
					if (gpa_num < 0.0 || gpa_num > 4.0)
						new AlertDialog.Builder(this)
    		  		.setTitle("GPA").setMessage("GPA Invalid").setNeutralButton("Set GPA to a valid number from 0.0-4.0",
    		  				new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,
								int which) {
						}
					}).show();
					// ensure ACT is a value between 0 and 36
					else if (act_num < 0 || act_num > 36)
						new AlertDialog.Builder(this)
    		  		.setTitle("GPA").setMessage("ACT Invalid").setNeutralButton("Set ACT to a valid number between 0 and 36",
    		  				new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,
								int which) {
						}
					}).show();
					// ensure SAT is a value between 0 and 2400
					else if (sat_num < 0 || sat_num > 2400)
						new AlertDialog.Builder(this)
    		  		.setTitle("GPA").setMessage("SAT Invalid").setNeutralButton("Set SAT to a valid number between 0 and 2400",
    		  				new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,
								int which) {
						}
					}).show();
					else{
						// otherwise, the values are good
						// Add the user's scores to the user database
						users.get(i).setGPA(gpa_num);
						users.get(i).setACT(sat_num);
						users.get(i).setSAT(act_num);
						Integer k = dh.updateUser(users.get(i));
						
						// load the school listings
						Intent intent = new Intent(this, School_Listings.class);
						intent.putExtra("NAME", username);
						startActivity(intent);
					}
					break;
				}
			}
			break;
		case R.id.logout:
			// back to the login screen
			startActivity(new Intent(this, Login.class));
			finish();
			break;
		}
	}
	

}
