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
			sdh.addSchool(new SchoolInfo("The Ohio State University", "OH", 3.5, 1850, 28, "http://www.osu.edu"));
            sdh.addSchool(new SchoolInfo("University of Akron", "OH", 3.0, 1600, 21, "http://www.uakron.edu"));
            sdh.addSchool(new SchoolInfo("University of Michigan", "MI", 3.8, 2000, 31, "http://www.umich.edu"));
            sdh.addSchool(new SchoolInfo("Bowling Green State University", "OH", 2.7, 1350, 18, "http://www.bgsu.edu"));
            sdh.addSchool(new SchoolInfo("University of Cincinnati", "OH", 3.0, 1500, 21, "http://www.uc.edu"));
            sdh.addSchool(new SchoolInfo("Kent State University", "OH", 2.7, 1350, 18, "http://www.kent.edu"));
            sdh.addSchool(new SchoolInfo("Miami University (OH)", "OH", 3.0, 1650, 23, "http://www.muohio.edu"));
            sdh.addSchool(new SchoolInfo("University of Toledo", "OH", 2.5, 1500, 20, "http://www.utoledo.edu"));
            sdh.addSchool(new SchoolInfo("Ohio University", "OH", 3.0, 1500, 21, "http://www.ohio.edu"));
            sdh.addSchool(new SchoolInfo("Denison University", "OH", 3.3, 1800, 26, "http://www.denison.edu"));
            sdh.addSchool(new SchoolInfo("Kenyon College", "OH", 4.0, 1900, 28, "http://www.kenyon.edu"));
            sdh.addSchool(new SchoolInfo("Oberlin College", "OH", 3.7, 1900, 28, "http://www.oberlin.edu"));
            sdh.addSchool(new SchoolInfo("Ohio Wesleyan University", "OH", 2.75, 1500, 24, "http://www.owu.edu"));
            sdh.addSchool(new SchoolInfo("College of Wooster", "OH", 3.3, 1650, 23, "http://www.woosteroh.edu"));
            sdh.addSchool(new SchoolInfo("Case Western Reserve University", "OH", 4.0, 1800, 27, "http://www.cwru.edu"));
            sdh.addSchool(new SchoolInfo("Franklin University", "OH", 0.0, 0, 0, "http://www.franklin.edu"));
            sdh.addSchool(new SchoolInfo("Baldwin Wallace University", "OH", 3.0, 1600, 25, "www.bw.edu/‎"));
            sdh.addSchool(new SchoolInfo("Heidelberg University", "OH", 2.75, 1500, 20, "www.heidelberg.edu/‎"));
            sdh.addSchool(new SchoolInfo("Wittenberg University", "OH", 2.75, 1600, 20, "https://www.wittenberg.edu/‎"));
            sdh.addSchool(new SchoolInfo("University of Findlay", "OH", 2.5, 1600, 20, "www.findlay.edu/‎"));
            sdh.addSchool(new SchoolInfo("University of Dayton", "OH", 3.3, 1650, 23, "www.udayton.edu/‎"));
            sdh.addSchool(new SchoolInfo("John Carroll University", "OH", 3.0, 1500, 22, "http://sites.jcu.edu/"));
            sdh.addSchool(new SchoolInfo("Ohio Dominican University", "OH", 2.5, 1600, 20, "https://www.ohiodominican.edu/"));
            sdh.addSchool(new SchoolInfo("Xavier University", "OH", 3.0, 1500, 21, "http://www.xu.edu"));
            sdh.addSchool(new SchoolInfo("Capital University", "OH", 2.75, 1500, 21, "http://www.capital.edu/"));
            sdh.addSchool(new SchoolInfo("Alabama State University", "AL", 2.5, 1200, 14, "http://www.alasu.edu/index.aspx"));
            sdh.addSchool(new SchoolInfo("Auburn University", "AL", 3.0, 1700, 23, "http://www.auburn.edu/"));
            sdh.addSchool(new SchoolInfo("University of Alabama", "AL", 3.0, 1350, 18, "http://www.ua.edu/"));
            sdh.addSchool(new SchoolInfo("Arizona State University", "AZ", 2.5, 1350, 18, "http://www.asu.edu/"));
            sdh.addSchool(new SchoolInfo("University of Arizona", "AZ", 2.5, 1350, 18, "http://www.arizona.edu/"));
            sdh.addSchool(new SchoolInfo("Hendrix College", "AR", 3.3, 1700, 24, "https://www.hendrix.edu/"));
            sdh.addSchool(new SchoolInfo("University of Arkansas", "AR", 2.75, 1500, 20, "https://www.uark.edu/"));
            sdh.addSchool(new SchoolInfo("Berkeley", "CA", 3.6, 1800, 26, "http://www.berkeley.edu/index.html"));
            sdh.addSchool(new SchoolInfo("California State University of Fullerton", "CA", 3.0, 1400, 19, "http://www.fullerton.edu/"));
            sdh.addSchool(new SchoolInfo("Loyola Marymount University", "CA", 3.7, 1700, 24, "http://www.lmu.edu/"));
            sdh.addSchool(new SchoolInfo("Occidental College", "CA", 4.0, 1800, 26, "https://www.oxy.edu/"));
            sdh.addSchool(new SchoolInfo("University of California at Davis", "CA", 3.3, 1500, 21, "http://www.ucdavis.edu/"));
            sdh.addSchool(new SchoolInfo("University of California at Irvine", "CA", 3.5, 1600, 23, "http://uci.edu/"));
            sdh.addSchool(new SchoolInfo("University of California Los Angeles", "CA", 3.6, 1700, 24, "http://www.ucla.edu/"));
            sdh.addSchool(new SchoolInfo("Colorado College", "CO", 4.0, 1900, 27, "http://www.coloradocollege.edu/"));
            sdh.addSchool(new SchoolInfo("Colorado School of Mines", "CO", 3.5, 1750, 24, "https://www.mines.edu/"));
            sdh.addSchool(new SchoolInfo("Connecticut College", "CT", 3.3, 1850, 26, "https://www.conncoll.edu/"));
            sdh.addSchool(new SchoolInfo("Fairfield University", "CT", 3.3, 1700, 24, "http://www.fairfield.edu/"));
            sdh.addSchool(new SchoolInfo("Providence College", "CT", 3.4, 1700, 24, "https://www.providence.edu/Pages/default.aspx"));
            sdh.addSchool(new SchoolInfo("Quinnipac University", "CT", 3.0, 1500, 20, "http://www.quinnipiac.edu/"));
            sdh.addSchool(new SchoolInfo("University of Connecticut", "CT", 3.0, 1700, 25, "http://www.uconn.edu/"));
            sdh.addSchool(new SchoolInfo("University of Delaware", "DE", 3.7, 1650, 23, "https://www.udel.edu/"));
            sdh.addSchool(new SchoolInfo("Flagler College", "FL", 3.0, 1550, 21, "http://www.flagler.edu/"));
            sdh.addSchool(new SchoolInfo("Florida Atlantic University", "FL", 2.7, 1500, 20, "http://www.fau.edu/"));
            sdh.addSchool(new SchoolInfo("Florida Gulf Coast University", "FL", 3.0, 1500, 20, "http://www.fgcu.edu/"));
            sdh.addSchool(new SchoolInfo("Florida International University", "FL", 2.5, 1500, 20, "https://www.fiu.edu/"));
            sdh.addSchool(new SchoolInfo("Stetson University", "FL", 3.0, 1500, 21, "http://www.stetson.edu/home/"));
            sdh.addSchool(new SchoolInfo("University of Central Florida", "FL", 3.0, 1650, 22, "http://www.ucf.edu"));
            sdh.addSchool(new SchoolInfo("University of Florida", "FL", 3.5, 1650, 22, "http://www.uf.edu"));
            sdh.addSchool(new SchoolInfo("University of Miami (FL)", "FL", 4.0, 1750, 25, "http://www.miami.edu/"));
            sdh.addSchool(new SchoolInfo("University of South Florida", "FL", 3.0, 1500, 20, "http://www.usf.edu"));
            sdh.addSchool(new SchoolInfo("Georgia Tech", "GA", 3.5, 1800, 26, "http://www.gatech.edu/"));
            sdh.addSchool(new SchoolInfo("University of Georgia", "GA", 3.5, 1700, 23, "http://www.uga.edu"));
            sdh.addSchool(new SchoolInfo("DePaul University", "IL", 3.0, 1500, 20, "http://www.depaul.edu"));
            sdh.addSchool(new SchoolInfo("University of Illinois at Chicago", "IL", 3.0, 1400, 19, "http://www.uic.edu/uic/"));
            sdh.addSchool(new SchoolInfo("University of Illinois", "IL", 3.3, 1600, 22, "http://www.illinois.edu"));
            sdh.addSchool(new SchoolInfo("Butler University", "IN", 3.3, 1650, 23, "http://www.butler.edu"));
            sdh.addSchool(new SchoolInfo("Indiana University", "IN", 3.0, 1600, 22, "http://www.iu.edu"));
            sdh.addSchool(new SchoolInfo("Notre Dame", "IN", 4.0, 2000, 28, "http://www.nd.edu"));
            sdh.addSchool(new SchoolInfo("University of Iowa", "IA", 3.0, 1500, 20, "http://www.uiowa.edu/"));
            sdh.addSchool(new SchoolInfo("University of Kansas", "KS", 2.7, 1400, 20, "http://www.ku.edu/"));
            sdh.addSchool(new SchoolInfo("University of Kentucky", "KY", 2.7, 1450, 19, "http://www.uky.edu"));
            sdh.addSchool(new SchoolInfo("Louisiana State University", "LA", 3.0, 1600, 22, "http://www.lsu.edu/"));
            sdh.addSchool(new SchoolInfo("Bates College", "ME", 3.7, 1800, 26, "http://www.bates.edu/"));
            sdh.addSchool(new SchoolInfo("University of Maryland", "MD", 3.3, 1650, 22, "http://www.umd.edu/"));
            sdh.addSchool(new SchoolInfo("Massachusetts Institute of Technology", "MA", 4.0, 2100, 30, "http://www.mit.edu"));
            sdh.addSchool(new SchoolInfo("University of Minnesota", "MN", 3.3, 1700, 24, "http://www1.umn.edu/twincities/index.html"));
            sdh.addSchool(new SchoolInfo("University of Mississippi", "MS", 2.7, 1400, 20, "http://www.olemiss.edu/"));
            sdh.addSchool(new SchoolInfo("University of Missouri", "MO", 3.0, 1500, 20, "http://missouri.edu/"));
            sdh.addSchool(new SchoolInfo("University of Nebraska", "NE", 3.0, 1500, 21, "http://www.unl.edu/"));
            sdh.addSchool(new SchoolInfo("Rutgers University", "NJ", 3.3, 1600, 22, "https://www.rutgers.edu/"));
            sdh.addSchool(new SchoolInfo("New York University", "NY", 3.4, 1700, 24, "http://www.nyu.edu/"));
            sdh.addSchool(new SchoolInfo("University of North Carolina", "NC", 3.7, 1750, 25, "http://unc.edu/"));
            sdh.addSchool(new SchoolInfo("University of Oregon", "OR", 3.0, 1500, 20, "https://uoregon.edu/"));
            sdh.addSchool(new SchoolInfo("University of Oklahoma", "OK", 3.3, 1550, 21, "https://www.ou.edu/"));
            sdh.addSchool(new SchoolInfo("Pennsylvania State University", "PA", 3.0, 1600, 22, "http://www.psu.edu/"));
            sdh.addSchool(new SchoolInfo("University of Tennessee", "TN", 3.0, 1500, 20, "http://www.utk.edu/"));
            sdh.addSchool(new SchoolInfo("University of Texas", "TX", 3.3, 1600, 22, "https://www.utexas.edu/"));
            sdh.addSchool(new SchoolInfo("University of Virginia", "VA", 4.0, 1800, 26, "http://www.virginia.edu/"));
            sdh.addSchool(new SchoolInfo("University of Washington", "WA", 3.5, 1650, 22, "https://www.washington.edu/"));
            sdh.addSchool(new SchoolInfo("University of Wisconsin", "WI", 3.3, 1700, 23, "http://www.wisc.edu/"));
            sdh.addSchool(new SchoolInfo("Yale University", "CT", 4.0, 2100, 30, "http://www.yale.edu/"));
            sdh.addSchool(new SchoolInfo("Brown University", "RI", 4.0, 2100, 30, "http://www.brown.edu/"));
            sdh.addSchool(new SchoolInfo("Columbia University", "NY", 4.0, 2100, 30, "http://www.columbia.edu/"));
            sdh.addSchool(new SchoolInfo("Cornell University", "NY", 4.0, 2000, 29, "https://www.cornell.edu/"));
            sdh.addSchool(new SchoolInfo("Dartmouth College", "NH", 4.0, 2100, 30, "http://dartmouth.edu/"));
            sdh.addSchool(new SchoolInfo("Harvard University", "MA", 4.0, 2100, 30, "http://www.harvard.edu/"));
            sdh.addSchool(new SchoolInfo("University of Pennsylvania", "PA", 3.8, 2000, 29, "http://www.upenn.edu/"));
            sdh.addSchool(new SchoolInfo("Princeton University", "NJ", 4.0, 2100, 30, "http://www.princeton.edu/main/"));
            sdh.addSchool(new SchoolInfo("Williams College", "MA", 3.7, 2000, 30, "http://www.williams.edu/"));
            sdh.addSchool(new SchoolInfo("William & Mary", "VA", 4.0, 1900, 28, "https://www.wm.edu/"));
            sdh.addSchool(new SchoolInfo("Williamette University", "OR", 3.0, 1700, 24, "https://www.willamette.edu/"));
            sdh.addSchool(new SchoolInfo("Whitman College", "WA", 4.0, 1800, 27, "http://www.whitman.edu/"));
            sdh.addSchool(new SchoolInfo("Wheaton College Illinois", "IL", 3.7, 1800, 27, "http://www.wheaton.edu/"));
            sdh.addSchool(new SchoolInfo("Westmont College", "CA", 3.5, 1700, 24, "http://www.westmont.edu/"));
            sdh.addSchool(new SchoolInfo("Western Washington University", "WA", 3.0, 1450, 20, "http://www.wwu.edu/"));
            sdh.addSchool(new SchoolInfo("Western Kentucky University", "KY", 2.7, 1200, 15, "http://www.wku.edu/"));
            sdh.addSchool(new SchoolInfo("Western Carolina University", "NC", 3.0, 1450, 20, "http://www.wcu.edu/"));
            sdh.addSchool(new SchoolInfo("West Virginia University", "WV", 2.5, 1400, 19, "http://www.wvu.edu/"));
            sdh.addSchool(new SchoolInfo("West Point", "NY", 3.5, 1800, 25, "http://www.usma.edu/SitePages/Home.aspx"));
            sdh.addSchool(new SchoolInfo("Washington University in St. Louis", "MO", 4.0, 2100, 31, "http://wustl.edu/"));
            sdh.addSchool(new SchoolInfo("Washington and Lee", "VA", 4.0, 2000, 29, "http://wustl.edu/"));
            sdh.addSchool(new SchoolInfo("Worcester Polytechnic Institute", "MA", 3.3, 1700, 24, "http://www.wpi.edu/"));
            sdh.addSchool(new SchoolInfo("Warren Wilson College", "NC", 3.0, 1600, 23, "http://www.warren-wilson.edu/external_index.php"));
            sdh.addSchool(new SchoolInfo("Wake Forest University", "NC", 4.0, 1800, 26, "http://www.wfu.edu/"));
            sdh.addSchool(new SchoolInfo("Virginia Tech", "VA", 3.3, 1600, 22, "https://www.vt.edu/"));
            sdh.addSchool(new SchoolInfo("Virginia Military Institute", "VA", 3.0, 1600, 22, "http://www.vmi.edu/"));
            sdh.addSchool(new SchoolInfo("Virginia Commonwealth University", "VA", 3.3, 1700, 23, "http://www.vcu.edu/"));
            sdh.addSchool(new SchoolInfo("Villanova University", "PA", 3.5, 1850, 27, "http://www1.villanova.edu/main.html"));
            sdh.addSchool(new SchoolInfo("Vanderbilt University", "TN", 4.0, 1850, 26, "http://www.vanderbilt.edu/"));
            sdh.addSchool(new SchoolInfo("Valparaiso University", "IN", 3.0, 1500, 20, "http://www.valpo.edu/"));
            sdh.addSchool(new SchoolInfo("University of Utah", "UT", 3.0, 1400, 19, "http://www.utah.edu/"));
            sdh.addSchool(new SchoolInfo("University of Texas at El Paso", "TX", 3.0, 1350, 18, "http://www.utep.edu/"));
            sdh.addSchool(new SchoolInfo("University of Southern California", "CA", 4.0, 1900, 29, "http://www.usc.edu/"));
            sdh.addSchool(new SchoolInfo("University of South Carolina", "SC", 3.0, 1600, 21, "http://www.sc.edu/"));
            sdh.addSchool(new SchoolInfo("University of Pittsburgh", "PA", 3.3, 1750, 25, "http://pitt.edu/"));
            sdh.addSchool(new SchoolInfo("University of Evansville", "IN", 3.0, 1550, 20, "https://www.evansville.edu/"));
            sdh.addSchool(new SchoolInfo("Tulane University", "LA", 3.5, 1900, 28, "http://admission.tulane.edu/"));
            sdh.addSchool(new SchoolInfo("Texas Tech University", "TX", 3.0, 1500, 20, "http://www.ttu.edu/"));
            sdh.addSchool(new SchoolInfo("Texas A&M University", "TX", 3.0, 1500, 22, "http://www.tamu.edu/"));
            sdh.addSchool(new SchoolInfo("Temple University", "PA", 3.0, 1500, 21, "http://www.temple.edu/"));
            sdh.addSchool(new SchoolInfo("Texas Christian University", "TX", 3.3, 1600, 22, "http://www.tcu.edu/"));
            sdh.addSchool(new SchoolInfo("Syracuse University", "NY", 3.0, 1600, 22, "https://www.syr.edu/"));
            sdh.addSchool(new SchoolInfo("SUNY Albany", "NY", 3.3, 1600, 22, "http://www.albany.edu/"));
            sdh.addSchool(new SchoolInfo("Stony Brook University", "NY", 3.3, 1700, 24, "http://www.stonybrook.edu/"));
            sdh.addSchool(new SchoolInfo("Stanford University", "CA", 4.0, 2100, 30, "http://www.stanford.edu/"));
            sdh.addSchool(new SchoolInfo("Southern Methodist University", "TX", 3.7, 1700, 24, "http://www.smu.edu/"));
            sdh.addSchool(new SchoolInfo("Southern Illinois University", "IL", 2.5, 1200, 16, "http://www.siu.edu/"));
            sdh.addSchool(new SchoolInfo("Siena College", "NY", 3.0, 1700, 24, "http://www.siena.edu/pages/1.asp"));
            sdh.addSchool(new SchoolInfo("Seton Hall University", "NJ", 3.0, 1450, 20, "http://www.shu.edu/"));
            sdh.addSchool(new SchoolInfo("Santa Clara University", "CA", 3.5, 1800, 26, "http://www.scu.edu/"));
            sdh.addSchool(new SchoolInfo("San Jose State University", "CA", 3.0, 1350, 18, "http://www.sjsu.edu/"));
            sdh.addSchool(new SchoolInfo("San Diego State University", "", 3.3, 1400, 19, "http://sdsu.edu/"));
            sdh.addSchool(new SchoolInfo("Samford University", "AL", 3.3, 1600, 22, "http://www.samford.edu/"));
            sdh.addSchool(new SchoolInfo("Saint Louis University", "MO", 3.0, 1600, 23, "http://slu.edu/"));
            sdh.addSchool(new SchoolInfo("Saint Joseph's University", "PA", 3.0, 1550, 21, "http://sju.edu/"));
            sdh.addSchool(new SchoolInfo("St. John's University", "NY", 2.7, 1450, 20, "http://www.stjohns.edu/"));
            sdh.addSchool(new SchoolInfo("Rice University", "TX", 4.0, 2070, 30, "http://www.rice.edu/"));
            sdh.addSchool(new SchoolInfo("Purdue University", "IN", 3.3, 1600, 22, "http://www.purdue.edu/"));
            sdh.addSchool(new SchoolInfo("Pepperdine University", "CA", 4.0, 1750, 25, "http://www.pepperdine.edu/"));
            sdh.addSchool(new SchoolInfo("Oregon State University", "OR", 3.0, 1450, 20, "http://oregonstate.edu/"));
            sdh.addSchool(new SchoolInfo("Oklahoma State University", "OK", 3.0, 1500, 21, "http://go.okstate.edu/"));
            sdh.addSchool(new SchoolInfo("Northwestern University", "IL", 4.0, 2000, 30, "http://www.northwestern.edu/"));
            sdh.addSchool(new SchoolInfo("Mississippi State University", "MS", 2.7, 1350, 18, "http://www.msstate.edu/"));
            sdh.addSchool(new SchoolInfo("Michigan State University", "MI", 3.0, 1500, 20, "http://msu.edu/"));
            sdh.addSchool(new SchoolInfo("Marquette University", "WI", 3.3, 1600, 22, "http://www.marquette.edu/"));
            sdh.addSchool(new SchoolInfo("Lehigh University", "PA", 3.7, 1900, 28, "http://www4.lehigh.edu/default.aspx"));
            sdh.addSchool(new SchoolInfo("Kansas State University", "KS", 2.7, 1300, 16, "http://www.k-state.edu/"));
            sdh.addSchool(new SchoolInfo( "Iowa State University", "IA", 3.0, 1500, 20, "http://www.iastate.edu/"));
            sdh.addSchool(new SchoolInfo( "Trinity College", "CT", 3.3, 1800, 26, "http://www.trincoll.edu/Pages/default.aspx"));
            sdh.addSchool(new SchoolInfo( "Trinity University", "TX", 3.3, 1750, 26, "http://new.trinity.edu/"));
            sdh.addSchool(new SchoolInfo( "Scripps College", "CA", 4.0, 1900, 28, "http://www.scrippscollege.edu/"));
            sdh.addSchool(new SchoolInfo( "Thomas Aquinas College", "CA", 4.0, 1800, 27, "http://www.thomasaquinas.edu/"));
            sdh.addSchool(new SchoolInfo( "University of California, Merced", "CA", 3.0, 1400, 18, "http://www.ucmerced.edu/"));
            sdh.addSchool(new SchoolInfo( "University of California, Riverside", "CA", 3.0, 1400, 19, "http://www.ucr.edu/"));
            sdh.addSchool(new SchoolInfo( "Cal State Bakersfield", "CA", 2.75, 1300, 17, "http://www.csub.edu/"));
            sdh.addSchool(new SchoolInfo( "Cal State Channel Islands", "CA", 3.0, 1350, 18, "http://www.csuci.edu/"));
            sdh.addSchool(new SchoolInfo( "Cal State Dominguez Hills", "CA", 2.6, 1300, 17, "https://www.csudh.edu/"));
            sdh.addSchool(new SchoolInfo( "Cal State East Bay", "CA", 2.7, 1250, 16, "http://www20.csueastbay.edu/"));
            sdh.addSchool(new SchoolInfo( "Cal State Long Beach", "CA", 3.0, 1400, 19, "http://www.csulb.edu/"));
            sdh.addSchool(new SchoolInfo( "Cal State Los Angeles", "CA", 2.6, 1300, 17, "http://www.calstatela.edu/"));
            sdh.addSchool(new SchoolInfo( "Cal State Bernardino", "CA", 2.7, 1250, 16, "https://www.csusb.edu/"));
            sdh.addSchool(new SchoolInfo( "Claremont McKenna", "CA", 4.0, 2000, 29, "http://www.claremontmckenna.edu/discovercmc/index.php"));
            sdh.addSchool(new SchoolInfo( "United States Coast Guard Academy", "CT", 4.0, 1800, 26, "http://www.cga.edu/"));
            sdh.addSchool(new SchoolInfo( "University of North Florida", "FL", 3.0, 1500, 20, "http://www.unf.edu/"));
            sdh.addSchool(new SchoolInfo( "Agnes Scott College", "GA", 3.0, 1600, 22, "http://www.agnesscott.edu/"));
            sdh.addSchool(new SchoolInfo( "Georgia Southern University", "GA", 3.0, 1500, 21, "http://www.georgiasouthern.edu/"));
            sdh.addSchool(new SchoolInfo( "Georgia State University", "GA", 3.0, 1450, 20, "http://www.gsu.edu/"));
            sdh.addSchool(new SchoolInfo( "Georgia Court University", "GA", 3.0, 1450, 20, "http://www.georgian.edu/index.htm"));
            sdh.addSchool(new SchoolInfo( "University of Hawaii", "HI", 3.0, 1500, 21, "http://manoa.hawaii.edu/"));
            sdh.addSchool(new SchoolInfo( "Augustana College", "IL", 3.0, 1500, 20, "http://www.augustana.edu/"));
            sdh.addSchool(new SchoolInfo( "Illinois State University", "IL", 2.7, 1350, 18, "https://illinoisstate.edu/"));
            sdh.addSchool(new SchoolInfo( "Illinois Wesleyan University", "IL", 3.3, 1650, 23, "http://www.iwu.edu/"));
            sdh.addSchool(new SchoolInfo( "Illinois Institute of Technology", "IL", 3.0, 1600, 22, "http://web.iit.edu/"));
            sdh.addSchool(new SchoolInfo( "Northern Illinois University", "IL", 2.5, 1150, 16, "http://www.niu.edu/index.shtml"));
            sdh.addSchool(new SchoolInfo( "Ball State University", "IN", 2.7, 1400, 19, "http://cms.bsu.edu/"));
            sdh.addSchool(new SchoolInfo( "Northwestern College", "IA", 3.0, 1400, 19, "http://www.nwciowa.edu/"));
            sdh.addSchool(new SchoolInfo( "University of Northern Iowa", "IA", 3.0, 1400, 19, "https://www.uni.edu/"));
            sdh.addSchool(new SchoolInfo( "Hendrix College", "KS", 3.3, 1700, 24, "https://www.hendrix.edu/"));
            sdh.addSchool(new SchoolInfo( "Bethel College", "KS", 3.3, 1700, 26, "http://www.bethelks.edu/"));
            sdh.addSchool(new SchoolInfo( "University of Louisville", "KY", 3.0, 1500, 21, "http://louisville.edu/"));
            sdh.addSchool(new SchoolInfo( "Louisiana Tech University", "LA", 3.0, 1500, 20, "http://www.latech.edu/"));
            sdh.addSchool(new SchoolInfo( "Centenary College of Louisiana", "LA", 3.0, 1550, 21, "http://www.centenary.edu/"));
            sdh.addSchool(new SchoolInfo( "University of Maine", "ME", 2.7, 1350, 18, "https://umaine.edu/"));
            sdh.addSchool(new SchoolInfo( "Loyola University of Maryland", "MD", 3.3, 1700, 24, "http://www.loyola.edu/"));
            sdh.addSchool(new SchoolInfo( "University of Maryland Baltimore County", "MD", 3.0, 1700, 24, "http://www.umbc.edu/"));
            sdh.addSchool(new SchoolInfo( "Central Michigan University", "MI", 2.7, 1300, 18, "https://www.cmich.edu/Pages/default.aspx"));
            sdh.addSchool(new SchoolInfo( "Macalester College", "MN", 4.0, 1900, 28, "http://www.macalester.edu/"));
            sdh.addSchool(new SchoolInfo( "University of Minnesota Morris", "", 3.3, 1650, 23, "http://www.morris.umn.edu/"));
            sdh.addSchool(new SchoolInfo( "Creighton University", "NE", 3.3, 1600, 22, "https://www.creighton.edu/"));
            sdh.addSchool(new SchoolInfo( "University of New Hampshire", "NH", 3.0, 1500, 21, "http://www.unh.edu/"));
            sdh.addSchool(new SchoolInfo( "Monmouth University", "NJ", 3.0, 1500, 21, "http://www.monmouth.edu/university.aspx"));
            sdh.addSchool(new SchoolInfo( "Ramapo College", "NJ", 3.3, 1600, 22, "http://www.ramapo.edu/"));
            sdh.addSchool(new SchoolInfo( "Rider University", "NJ", 3.0, 1400, 19, "http://www.rider.edu/"));
            sdh.addSchool(new SchoolInfo( "Hofstra University", "NY", 3.0, 1600, 22, "http://www.hofstra.edu/home/"));
            sdh.addSchool(new SchoolInfo( "Pace University", "NY", 2.7, 1450, 20, "http://www.pace.edu/"));
            sdh.addSchool(new SchoolInfo( "Reed College", "OR", 4.0, 2000, 29, "https://www.reed.edu/"));
            sdh.addSchool(new SchoolInfo( "Allegheny College", "PA", 3.3, 1700, 24, "http://allegheny.edu/"));
            sdh.addSchool(new SchoolInfo( "Bryn Mawr College", "PA", 3.7, 1800, 26, "http://www.brynmawr.edu/"));
            sdh.addSchool(new SchoolInfo( "Bucknell University", "PA", 4.0, 1900, 28, "http://www.bucknell.edu/"));
            sdh.addSchool(new SchoolInfo( "University of Rhode Island", "RI", 3.3, 1500, 20, "http://ww2.uri.edu/"));
            sdh.addSchool(new SchoolInfo( "Clemson University", "SC", 3.3, 1700, 23, "http://www.clemson.edu/"));
            sdh.addSchool(new SchoolInfo( "College of Charleston", "SC", 3.0, 1600, 22, "https://www.cofc.edu/"));
            sdh.addSchool(new SchoolInfo( "Brigham Young University", "UT", 3.7, 1700, 24, "http://home.byu.edu/home/"));
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
