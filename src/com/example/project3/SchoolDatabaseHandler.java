package com.example.project3;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SchoolDatabaseHandler extends SQLiteOpenHelper {

	// All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 3;
 
    // Database Name
    private static final String DATABASE_NAME = "schoolInfo";
 
    // Contacts table name
    private static final String TABLE_SCHOOLS = "schools";
 
    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_STATE = "state";
    private static final String KEY_GPA = "gpa";
    private static final String KEY_ACT = "act";
    private static final String KEY_SAT = "sat";
 
    public SchoolDatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
 
    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
    	
    	
        String CREATE_USERS_TABLE = "CREATE TABLE " + TABLE_SCHOOLS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT," + KEY_GPA + " REAL," 
        		+ KEY_ACT + " INTEGER," + KEY_SAT + " INTEGER," + KEY_STATE + " TEXT)";
        db.execSQL(CREATE_USERS_TABLE);
        
    }
 
    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    	
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SCHOOLS);
 
        // Create tables again
        onCreate(db);
    }
    
    public void addSchool(SchoolInfo school) {
        SQLiteDatabase db = this.getWritableDatabase();
     
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, school.getName()); 
        values.put(KEY_STATE, school.getState()); 
        values.put(KEY_GPA, school.getGPA()); 
        values.put(KEY_ACT, school.getACT()); 
        values.put(KEY_SAT, school.getSAT()); 
     
        // Inserting Row
        db.insert(TABLE_SCHOOLS, null, values);
        db.close(); // Closing database connection
    }
    
    /*public UserInfo getUser(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
     
        Cursor cursor = db.query(TABLE_SCHOOLS, new String[] { KEY_ID,
                KEY_NAME, KEY_STATE }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
     
        UserInfo user = new UserInfo(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));
        // return contact
        return user;
    }*/
    
    // Getting All Contacts
 public List<SchoolInfo> getAllSchools() {
    List<SchoolInfo> schoolList = new ArrayList<SchoolInfo>();
    // Select All Query
    String selectQuery = "SELECT  * FROM " + TABLE_SCHOOLS;
 
    SQLiteDatabase db = this.getWritableDatabase();
    Cursor cursor = db.rawQuery(selectQuery, null);
 
    // looping through all rows and adding to list
    if (cursor.moveToFirst()) {
        do {
            SchoolInfo school = new SchoolInfo();
            school.setID(Integer.parseInt(cursor.getString(0)));
            school.setName(cursor.getString(1));
            school.setState(cursor.getString(5));
            school.setGPA(Double.parseDouble(cursor.getString(2)));
            school.setACT(Integer.parseInt(cursor.getString(3)));
            school.setSAT(Integer.parseInt(cursor.getString(4)));
            // Adding contact to list
            schoolList.add(school);
        } while (cursor.moveToNext());
    }
 
    // return contact list
    return schoolList;
}
    
    /*// Updating single user
    public int updateUser(UserInfo user) {
    	SQLiteDatabase db = this.getWritableDatabase();
 
    	ContentValues values = new ContentValues();
    
    	values.put(KEY_GPA, user.getGPA());
    	values.put(KEY_ACT, user.getACT());
    	values.put(KEY_SAT, user.getSAT());   	
 
    	// updating rows
    	return db.update(TABLE_USERS, values, KEY_NAME + " = ?", new String[] { user.getName() });
}*/
		
}

