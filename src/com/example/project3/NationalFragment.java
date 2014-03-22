package com.example.project3;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
 
public class NationalFragment extends Fragment {
 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.national_fragment, container, false);
         
        
        //TableLayout tblLayout = (TableLayout)findViewById(R.id.tableLayout);
        //TableRow row = (TableRow)tblLayout.getChildAt(0);
        
        
        return rootView;
    }

}
