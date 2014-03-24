package com.example.project3;

import java.util.Locale;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class School_Listings extends FragmentActivity implements
		ActionBar.TabListener {

	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a
	 * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which
	 * will keep every loaded fragment in memory. If this becomes too memory
	 * intensive, it may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */
	SectionsPagerAdapter mSectionsPagerAdapter;

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	ViewPager mViewPager;
	
	@Override
    public boolean onOptionsItemSelected(MenuItem menuItem)
    {       
		onBackPressed();
        return true;
    }
	
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		SchoolDatabaseHandler sdh = new SchoolDatabaseHandler(this);
    	
		if (sdh.getAllSchools().size()==0){
		sdh.addSchool(new SchoolInfo("The Ohio State University", "OH", 3.5, 1850, 28));
		sdh.addSchool(new SchoolInfo("University of Akron", "OH", 3.0, 1600, 21));
		sdh.addSchool(new SchoolInfo("University of Michigan", "MI", 3.8, 2000, 31));
		sdh.addSchool(new SchoolInfo("Bowling Green State University", "OH", 2.7, 1350, 18));
		sdh.addSchool(new SchoolInfo("University of Cincinnati", "OH", 3.0, 1500, 21));
		sdh.addSchool(new SchoolInfo("Kent State University", "OH", 2.7, 1350, 18));
		sdh.addSchool(new SchoolInfo("Miami University (OH)", "OH", 3.0, 1650, 23));
		sdh.addSchool(new SchoolInfo("University of Toledo", "OH", 2.5, 1500, 20));
		sdh.addSchool(new SchoolInfo("Ohio University", "OH", 3.0, 1500, 21));
		sdh.addSchool(new SchoolInfo("Denison University", "OH", 3.3, 1800, 26));
		sdh.addSchool(new SchoolInfo("Kenyon College", "OH", 4.0, 1900, 28));
		sdh.addSchool(new SchoolInfo("Oberlin College", "OH", 3.7, 1900, 28));
		sdh.addSchool(new SchoolInfo("Ohio Wesleyan University", "OH", 2.75, 1500, 24));
		sdh.addSchool(new SchoolInfo("College of Wooster", "OH", 3.3, 1650, 23));
		sdh.addSchool(new SchoolInfo("Case Western Reserve University", "OH", 4.0, 1800, 27));
		sdh.addSchool(new SchoolInfo("Franklin University", "OH", 0.0, 0, 0));
		sdh.addSchool(new SchoolInfo("Baldwin Wallace University", "OH", 3.0, 1600, 25));
		sdh.addSchool(new SchoolInfo("Heidelberg University", "OH", 2.75, 1500, 20));
		sdh.addSchool(new SchoolInfo("Wittenberg University", "OH", 2.75, 1600, 20));
		sdh.addSchool(new SchoolInfo("University of Findlay", "OH", 2.5, 1600, 20));
		sdh.addSchool(new SchoolInfo("University of Dayton", "OH", 3.3, 1650, 23));
		sdh.addSchool(new SchoolInfo("John Carroll University", "OH", 3.0, 1500, 22));
		sdh.addSchool(new SchoolInfo("Ohio Dominican University", "OH", 2.5, 1600, 20));
		sdh.addSchool(new SchoolInfo("Xavier University", "OH", 3.0, 1500, 21));
		sdh.addSchool(new SchoolInfo("Capital University", "OH", 2.75, 1500, 21));
		sdh.addSchool(new SchoolInfo("Alabama State University", "AL", 2.5, 1200, 14));
		sdh.addSchool(new SchoolInfo("Auburn University", "AL", 3.0, 1700, 23));
		sdh.addSchool(new SchoolInfo("University of Alabama", "AL", 3.0, 1350, 18));
		sdh.addSchool(new SchoolInfo("Arizona State University", "AZ", 2.5, 1350, 18));
		sdh.addSchool(new SchoolInfo("University of Arizona", "AZ", 2.5, 1350, 18));
		sdh.addSchool(new SchoolInfo("Hendrix College", "AR", 3.3, 1700, 24));
		sdh.addSchool(new SchoolInfo("University of Arkansas", "AR", 2.75, 1500, 20));
		sdh.addSchool(new SchoolInfo("Berkeley", "CA", 3.6, 1800, 26));
		sdh.addSchool(new SchoolInfo("California State University of Fullerton", "CA", 3.0, 1400, 19));
		sdh.addSchool(new SchoolInfo("Loyola Marymount University", "CA", 3.7, 1700, 24));
		sdh.addSchool(new SchoolInfo("Occidental College", "CA", 4.0, 1800, 26));
		sdh.addSchool(new SchoolInfo("University of California at Davis", "CA", 3.3, 1500, 21));
		sdh.addSchool(new SchoolInfo("University of California at Irvine", "CA", 3.5, 1600, 23));
		sdh.addSchool(new SchoolInfo("University of California Los Angeles", "CA", 3.6, 1700, 24));
		sdh.addSchool(new SchoolInfo("Colorado College", "CO", 4.0, 1900, 27));
		sdh.addSchool(new SchoolInfo("Colorado School of Mines", "CO", 3.5, 1750, 24));
		sdh.addSchool(new SchoolInfo("Connecticut College", "CT", 3.3, 1850, 26));
		sdh.addSchool(new SchoolInfo("Fairfield University", "CT", 3.3, 1700, 24));
		sdh.addSchool(new SchoolInfo("Providence College", "CT", 3.4, 1700, 24));
		sdh.addSchool(new SchoolInfo("Quinnipac University", "CT", 3.0, 1500, 20));
		sdh.addSchool(new SchoolInfo("University of Connecticut", "CT", 3.0, 1700, 25));
		sdh.addSchool(new SchoolInfo("University of Delaware", "DE", 3.7, 1650, 23));
		sdh.addSchool(new SchoolInfo("Flagler College", "FL", 3.0, 1550, 21));
		sdh.addSchool(new SchoolInfo("Florida Atlantic University", "FL", 2.7, 1500, 20));
		sdh.addSchool(new SchoolInfo("Florida Gulf Coast University", "FL", 3.0, 1500, 20));
		sdh.addSchool(new SchoolInfo("Florida International University", "FL", 2.5, 1500, 20));
		sdh.addSchool(new SchoolInfo("Stetson University", "FL", 3.0, 1500, 21));
		sdh.addSchool(new SchoolInfo("University of Central Florida", "FL", 3.0, 1650, 22));
		sdh.addSchool(new SchoolInfo("University of Florida", "FL", 3.5, 1650, 22));
		sdh.addSchool(new SchoolInfo("University of Miami (FL)", "FL", 4.0, 1750, 25));
		sdh.addSchool(new SchoolInfo("University of South Florida", "FL", 3.0, 1500, 20));
		sdh.addSchool(new SchoolInfo("Georgia Tech", "GA", 3.5, 1800, 26));
		sdh.addSchool(new SchoolInfo("University of Georgia", "GA", 3.5, 1700, 23));
		sdh.addSchool(new SchoolInfo("DePaul University", "IL", 3.0, 1500, 20));
		sdh.addSchool(new SchoolInfo("University of Illinois at Chicago", "IL", 3.0, 1400, 19));
		sdh.addSchool(new SchoolInfo("University of Illinois", "IL", 3.3, 1600, 22));
		sdh.addSchool(new SchoolInfo("Butler University", "IN", 3.3, 1650, 23));
		sdh.addSchool(new SchoolInfo("Indiana University", "IN", 3.0, 1600, 22));
		sdh.addSchool(new SchoolInfo("Notre Dame", "IN", 4.0, 2000, 28));
		sdh.addSchool(new SchoolInfo("University of Iowa", "IA", 3.0, 1500, 20));
		sdh.addSchool(new SchoolInfo("University of Kansas", "KS", 2.7, 1400, 20));
		sdh.addSchool(new SchoolInfo("University of Kentucky", "KY", 2.7, 1450, 19));
		sdh.addSchool(new SchoolInfo("Louisiana State University", "LA", 3.0, 1600, 22));
		sdh.addSchool(new SchoolInfo("Bates College", "ME", 3.7, 1800, 26));
		sdh.addSchool(new SchoolInfo("University of Maryland", "MD", 3.3, 1650, 22));
		sdh.addSchool(new SchoolInfo("Massachusetts Institute of Technology", "MA", 4.0, 2100, 30));
		sdh.addSchool(new SchoolInfo("University of Minnesota", "MN", 3.3, 1700, 24));
		sdh.addSchool(new SchoolInfo("University of Mississippi", "MS", 2.7, 1400, 20));
		sdh.addSchool(new SchoolInfo("University of Missouri", "MO", 3.0, 1500, 20));
		sdh.addSchool(new SchoolInfo("University of Nebraska", "NE", 3.0, 1500, 21));
		sdh.addSchool(new SchoolInfo("Rutgers University", "NJ", 3.3, 1600, 22));
		sdh.addSchool(new SchoolInfo("New York University", "NY", 3.4, 1700, 24));
		sdh.addSchool(new SchoolInfo("University of North Carolina", "NC", 3.7, 1750, 25));
		sdh.addSchool(new SchoolInfo("University of Oregon", "OR", 3.0, 1500, 20));
		sdh.addSchool(new SchoolInfo("University of Oklahoma", "OK", 3.3, 1550, 21));
		sdh.addSchool(new SchoolInfo("Pennsylvania State University", "PA", 3.0, 1600, 22));
		sdh.addSchool(new SchoolInfo("University of Tennessee", "TN", 3.0, 1500, 20));
		sdh.addSchool(new SchoolInfo("University of Texas", "TX", 3.3, 1600, 22));
		sdh.addSchool(new SchoolInfo("University of Virginia", "VA", 4.0, 1800, 26));
		sdh.addSchool(new SchoolInfo("University of Washington", "WA", 3.5, 1650, 22));
		sdh.addSchool(new SchoolInfo("University of Wisconsin", "WI", 3.3, 1700, 23));
		}
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.school_listings);

		// Set up the action bar.
		final ActionBar actionBar = getActionBar();
		actionBar.setHomeButtonEnabled(true);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		// Create the adapter that will return a fragment for each of the three
		// primary sections of the app.
		mSectionsPagerAdapter = new SectionsPagerAdapter(
				getSupportFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);

		// When swiping between different sections, select the corresponding
		// tab. We can also use ActionBar.Tab#select() to do this if we have
		// a reference to the Tab.
		mViewPager
				.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
					@Override
					public void onPageSelected(int position) {
						actionBar.setSelectedNavigationItem(position);
					}
				});

		// For each of the sections in the app, add a tab to the action bar.
		for (int i = 0; i < mSectionsPagerAdapter.getCount(); i++) {
			// Create a tab with text corresponding to the page title defined by
			// the adapter. Also specify this Activity object, which implements
			// the TabListener interface, as the callback (listener) for when
			// this tab is selected.
			actionBar.addTab(actionBar.newTab()
					.setText(mSectionsPagerAdapter.getPageTitle(i))
					.setTabListener(this));
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.school__listings, menu);
		return true;
	}

	@Override
	public void onTabSelected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
		// When the given tab is selected, switch to the corresponding page in
		// the ViewPager.
		mViewPager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
	}

	@Override
	public void onTabReselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
	}

	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			// getItem is called to instantiate the fragment for the given page.
			// Return a DummySectionFragment (defined as a static inner class
			// below) with the page number as its lone argument.
			Fragment fragment;
			if (position==0)
				fragment = new NationalFragment();
			else
				fragment = new InStateFragment();
			Bundle args = new Bundle();
			args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, position + 1);
			Bundle extras = getIntent().getExtras();
			String username="";
			if (extras != null) {
				username = extras.getString("NAME");
			}
			args.putString("NAME", username);
			fragment.setArguments(args);
			return fragment;
		}

		@Override
		public int getCount() {
			// Show 2 total pages.
			return 2;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			Locale l = Locale.getDefault();
			switch (position) {
			case 0:
				return "National".toUpperCase(l);
			case 1:
				return "In State".toUpperCase(l);
			}
			return null;
		}
	}

	/**
	 * A dummy fragment representing a section of the app, but that simply
	 * displays dummy text.
	 */
	public static class DummySectionFragment extends Fragment {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		public static final String ARG_SECTION_NUMBER = "section_number";

		public DummySectionFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(
					R.layout.national_fragment, container, false);
			//TextView dummyTextView = (TextView) rootView
					//.findViewById(R.id.section_label);
			//dummyTextView.setText(Integer.toString(getArguments().getInt(
					//ARG_SECTION_NUMBER)));
			return rootView;
		}
	}

}
