// This class is used to handle the in-state school listings

package com.example.project3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.example.project3.NationalFragment.BestColleges;

import android.content.Intent;
import android.content.res.Configuration;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class InStateFragment extends Fragment implements OnClickListener{

	WebView schoolWebView;
	SchoolDatabaseHandler sdh;
	TextView name1,name2,name3,name4,name5,name6,name7,name8,name9,name10;
	
	// data structure for storing top colleges for user
	class BestColleges
	{
		public int _pos;
		public double _val;

		public BestColleges(int pos, double val)
		{
			_pos = pos;
			_val = val;
		}
	}

	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		
		View rootView;
		
		// whether to load the portrait view or landscape view
		if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
			rootView = inflater.inflate(R.layout.in_state_fragment, container, false);
		else
			rootView = inflater.inflate(R.layout.in_state_fragment_horizontal, container, false);
		
		// Enable certain settings for webview
	    schoolWebView = (WebView) rootView.findViewById(R.id.schoolwebview);
	    schoolWebView.getSettings().setJavaScriptEnabled(true);
	    schoolWebView.getSettings().setLoadWithOverviewMode(true);
	    schoolWebView.getSettings().setUseWideViewPort(true);
	    
	    
	    // make it so the WebView content can be changed
	    schoolWebView.setWebViewClient(new WebViewClient() {
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url)
			{
				return false;
			}
			
		});
		
		
		// retrieve username from bundle
		Bundle bundle = this.getArguments();
		String username="";
		if(bundle != null){
			username = bundle.getString("NAME");
		}

		// Get the user information from searching user db
		DatabaseHandler dh = new DatabaseHandler(rootView.getContext());
		List<UserInfo> users = dh.getAllUsers();
		UserInfo user = new UserInfo();
		for (int i = 0; i < users.size(); i++)
		{
			if (users.get(i).getName().equals(username)){
				user = users.get(i);
				break;
			}
		}

		// Retrieve all the colleges
		sdh = new SchoolDatabaseHandler(rootView.getContext());
		List<SchoolInfo> schools = new ArrayList<SchoolInfo>();
		schools = sdh.getAllSchools();

		List<BestColleges> best = new ArrayList<BestColleges>();

		// Get GPS location
		GPSTracker gps = new GPSTracker(rootView.getContext());
		boolean GPS_enabled = true;
		Double latitude = 0.0;
		Double longitude = 0.0;
		if(gps.canGetLocation()){
			latitude = gps.getLatitude();
			longitude = gps.getLongitude();
		}
		else
			GPS_enabled = false;

		
		if (GPS_enabled){
			// Get Location
			Geocoder geocoder = new Geocoder(rootView.getContext());
			List<Address> addr = new ArrayList<Address>();
			try {
				addr = geocoder.getFromLocation(latitude, longitude, 1);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			String state = addr.get(0).getAdminArea();


			// convert GPS admin area to abbreviated state name
			// only about 10 states are represented
			if (state.equals("Ohio"))
				state = "OH";
			else if (state.equals("California"))
				state = "CA";
			else if (state.equals("Florida"))
				state = "FL";
			else if (state.equals("New York"))
				state = "NY";
			else if (state.equals("Massachusetts"))
				state = "MA";
			else if (state.equals("Texas"))
				state = "TX";
			else if (state.equals("Illinois"))
				state = "IL";
			else if (state.equals("North Carolina"))
				state = "NC";
			else if (state.equals("Washington"))
				state = "WA";
			else if (state.equals("Georgia"))
				state = "GA";
			else 
				state = "CO";
				
			// Search appropriate colleges for user
			for (int i = 0 ; i < schools.size(); i++)
			{
				if (schools.get(i).getState().equals(state)){
					double gpaE = Math.abs(schools.get(i).getGPA() - user.getGPA()) / 4.0;
					double actE = Math.abs(schools.get(i).getACT() - user.getACT()) / 36.;
					double satE = Math.abs(schools.get(i).getSAT() - user.getSAT()) / 2400.;

					best.add(new BestColleges(i, gpaE+actE+satE));
				}
			}
			// Sort
			Collections.sort(best, new Comparator<BestColleges>() {

				public int compare(BestColleges o1, BestColleges o2) {
					Double a = o1._val;
					Double b = o2._val;
					return (a).compareTo(b);
				}
			});



			// Print best colleges
			// set up textviews
			name1 =  (TextView) rootView.findViewById(R.id.name1);
			name2 =  (TextView) rootView.findViewById(R.id.name2);
			name3 =  (TextView) rootView.findViewById(R.id.name3);
			name4 =  (TextView) rootView.findViewById(R.id.name4);
			name5 =  (TextView) rootView.findViewById(R.id.name5);
			name6 =  (TextView) rootView.findViewById(R.id.name6);
			name7 =  (TextView) rootView.findViewById(R.id.name7);
			name8 =  (TextView) rootView.findViewById(R.id.name8);
			name9 =  (TextView) rootView.findViewById(R.id.name9);
			name10 =  (TextView) rootView.findViewById(R.id.name10);
			name1.setOnClickListener(this);
			name2.setOnClickListener(this);
			name3.setOnClickListener(this);
			name4.setOnClickListener(this);
			name5.setOnClickListener(this);
			name6.setOnClickListener(this);
			name7.setOnClickListener(this);
			name8.setOnClickListener(this);
			name9.setOnClickListener(this);
			name10.setOnClickListener(this);
			TextView gpa1 =  (TextView) rootView.findViewById(R.id.gpa1);
			TextView gpa2 =  (TextView) rootView.findViewById(R.id.gpa2);
			TextView gpa3 =  (TextView) rootView.findViewById(R.id.gpa3);
			TextView gpa4 =  (TextView) rootView.findViewById(R.id.gpa4);
			TextView gpa5 =  (TextView) rootView.findViewById(R.id.gpa5);
			TextView gpa6 =  (TextView) rootView.findViewById(R.id.gpa6);
			TextView gpa7 =  (TextView) rootView.findViewById(R.id.gpa7);
			TextView gpa8 =  (TextView) rootView.findViewById(R.id.gpa8);
			TextView gpa9 =  (TextView) rootView.findViewById(R.id.gpa9);
			TextView gpa10 =  (TextView) rootView.findViewById(R.id.gpa10);
			TextView sat1 =  (TextView) rootView.findViewById(R.id.sat1);
			TextView sat2 =  (TextView) rootView.findViewById(R.id.sat2);
			TextView sat3 =  (TextView) rootView.findViewById(R.id.sat3);
			TextView sat4 =  (TextView) rootView.findViewById(R.id.sat4);
			TextView sat5 =  (TextView) rootView.findViewById(R.id.sat5);
			TextView sat6 =  (TextView) rootView.findViewById(R.id.sat6);
			TextView sat7 =  (TextView) rootView.findViewById(R.id.sat7);
			TextView sat8 =  (TextView) rootView.findViewById(R.id.sat8);
			TextView sat9 =  (TextView) rootView.findViewById(R.id.sat9);
			TextView sat10 =  (TextView) rootView.findViewById(R.id.sat10);
			TextView act1 =  (TextView) rootView.findViewById(R.id.act1);
			TextView act2 =  (TextView) rootView.findViewById(R.id.act2);
			TextView act3 =  (TextView) rootView.findViewById(R.id.act3);
			TextView act4 =  (TextView) rootView.findViewById(R.id.act4);
			TextView act5 =  (TextView) rootView.findViewById(R.id.act5);
			TextView act6 =  (TextView) rootView.findViewById(R.id.act6);
			TextView act7 =  (TextView) rootView.findViewById(R.id.act7);
			TextView act8 =  (TextView) rootView.findViewById(R.id.act8);
			TextView act9 =  (TextView) rootView.findViewById(R.id.act9);
			TextView act10 =  (TextView) rootView.findViewById(R.id.act10);

			if (best.size() >= 10){
				name1.setText(schools.get(best.get(0)._pos).getName());
				name2.setText(schools.get(best.get(1)._pos).getName());
				name3.setText(schools.get(best.get(2)._pos).getName());
				name4.setText(schools.get(best.get(3)._pos).getName());
				name5.setText(schools.get(best.get(4)._pos).getName());
				name6.setText(schools.get(best.get(5)._pos).getName());
				name7.setText(schools.get(best.get(6)._pos).getName());
				name8.setText(schools.get(best.get(7)._pos).getName());
				name9.setText(schools.get(best.get(8)._pos).getName());
				name10.setText(schools.get(best.get(9)._pos).getName());

				Double gpa = schools.get(best.get(0)._pos).getGPA();
				gpa1.setText(gpa.toString());
				gpa = schools.get(best.get(1)._pos).getGPA();
				gpa2.setText(gpa.toString());
				gpa = schools.get(best.get(2)._pos).getGPA();
				gpa3.setText(gpa.toString());
				gpa = schools.get(best.get(3)._pos).getGPA();
				gpa4.setText(gpa.toString());
				gpa = schools.get(best.get(4)._pos).getGPA();
				gpa5.setText(gpa.toString());
				gpa = schools.get(best.get(5)._pos).getGPA();
				gpa6.setText(gpa.toString());
				gpa = schools.get(best.get(6)._pos).getGPA();
				gpa7.setText(gpa.toString());
				gpa = schools.get(best.get(7)._pos).getGPA();
				gpa8.setText(gpa.toString());
				gpa = schools.get(best.get(8)._pos).getGPA();
				gpa9.setText(gpa.toString());
				gpa = schools.get(best.get(9)._pos).getGPA();
				gpa10.setText(gpa.toString());

				Integer sat = schools.get(best.get(0)._pos).getSAT();
				sat1.setText(sat.toString());
				sat = schools.get(best.get(1)._pos).getSAT();
				sat2.setText(sat.toString());
				sat = schools.get(best.get(2)._pos).getSAT();
				sat3.setText(sat.toString());
				sat = schools.get(best.get(3)._pos).getSAT();
				sat4.setText(sat.toString());
				sat = schools.get(best.get(4)._pos).getSAT();
				sat5.setText(sat.toString());
				sat = schools.get(best.get(5)._pos).getSAT();
				sat6.setText(sat.toString());
				sat = schools.get(best.get(6)._pos).getSAT();
				sat7.setText(sat.toString());
				sat = schools.get(best.get(7)._pos).getSAT();
				sat8.setText(sat.toString());
				sat = schools.get(best.get(8)._pos).getSAT();
				sat9.setText(sat.toString());
				sat = schools.get(best.get(9)._pos).getSAT();
				sat10.setText(sat.toString());

				Integer act = schools.get(best.get(0)._pos).getACT();
				act1.setText(act.toString());
				act = schools.get(best.get(1)._pos).getACT();
				act2.setText(act.toString());
				act = schools.get(best.get(2)._pos).getACT();
				act3.setText(act.toString());
				act = schools.get(best.get(3)._pos).getACT();
				act4.setText(act.toString());
				act = schools.get(best.get(4)._pos).getACT();
				act5.setText(act.toString());
				act = schools.get(best.get(5)._pos).getACT();
				act6.setText(act.toString());
				act = schools.get(best.get(6)._pos).getACT();
				act7.setText(act.toString());
				act = schools.get(best.get(7)._pos).getACT();
				act8.setText(act.toString());
				act = schools.get(best.get(8)._pos).getACT();
				act9.setText(act.toString());
				act = schools.get(best.get(9)._pos).getACT();
				act10.setText(act.toString());
			}
		}
		
		// set webview to top school
		schoolWebView.loadUrl(schools.get(best.get(0)._pos).getURL());

		return rootView;
	}
	
	// if the school's name is touched/clicked, load the website for that school in the WebView
	public void onClick(View v) {
		List<SchoolInfo> schools = sdh.getAllSchools();
		switch (v.getId()) {
		case R.id.name1:
			for (int i = 0; i < schools.size(); i++){
				if (schools.get(i).getName().equals(name1.getText().toString())){
					schoolWebView.loadUrl(schools.get(i).getURL());
					break;
				}
			}
			break;
		case R.id.name2:
			for (int i = 0; i < schools.size(); i++){
				if (schools.get(i).getName().equals(name2.getText().toString())){
					schoolWebView.loadUrl(schools.get(i).getURL());
					break;
				}
			}
			break;
		case R.id.name3:
			for (int i = 0; i < schools.size(); i++){
				if (schools.get(i).getName().equals(name3.getText().toString())){
					schoolWebView.loadUrl(schools.get(i).getURL());
					break;
				}
			}
			break;
		case R.id.name4:
			for (int i = 0; i < schools.size(); i++){
				if (schools.get(i).getName().equals(name4.getText().toString())){
					schoolWebView.loadUrl(schools.get(i).getURL());
					break;
				}
			}
			break;
		case R.id.name5:
			for (int i = 0; i < schools.size(); i++){
				if (schools.get(i).getName().equals(name5.getText().toString())){
					schoolWebView.loadUrl(schools.get(i).getURL());
					break;
				}
			}
			break;
		case R.id.name6:
			for (int i = 0; i < schools.size(); i++){
				if (schools.get(i).getName().equals(name6.getText().toString())){
					schoolWebView.loadUrl(schools.get(i).getURL());
					break;
				}
			}
			break;
		case R.id.name7:
			for (int i = 0; i < schools.size(); i++){
				if (schools.get(i).getName().equals(name7.getText().toString())){
					schoolWebView.loadUrl(schools.get(i).getURL());
					break;
				}
			}
			break;
		case R.id.name8:
			for (int i = 0; i < schools.size(); i++){
				if (schools.get(i).getName().equals(name8.getText().toString())){
					schoolWebView.loadUrl(schools.get(i).getURL());
					break;
				}
			}
			break;
		case R.id.name9:
			for (int i = 0; i < schools.size(); i++){
				if (schools.get(i).getName().equals(name9.getText().toString())){
					schoolWebView.loadUrl(schools.get(i).getURL());
					break;
				}
			}
			break;
		case R.id.name10:
			for (int i = 0; i < schools.size(); i++){
				if (schools.get(i).getName().equals(name10.getText().toString())){
					schoolWebView.loadUrl(schools.get(i).getURL());
					break;
				}
			}
			break;
		}	
	}	
}
