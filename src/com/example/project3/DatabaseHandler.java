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

public class DatabaseHandler extends SQLiteOpenHelper {

	// All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 7;
 
    // Database Name
    private static final String DATABASE_NAME = "userInfo";
 
    // Contacts table name
    private static final String TABLE_USERS = "users";
 
    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "username";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_GPA = "gpa";
    private static final String KEY_ACT = "act";
    private static final String KEY_SAT = "sat";
 
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
 
    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
    	
    	
        String CREATE_USERS_TABLE = "CREATE TABLE " + TABLE_USERS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_PASSWORD + " TEXT," + KEY_GPA + " REAL," + KEY_ACT + " INTEGER," + KEY_SAT + " INTEGER" +")";
        db.execSQL(CREATE_USERS_TABLE);
        
    }
 
    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    	
        // Drop older table if existed
        //db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
 
        if (newVersion > oldVersion) {
            //db.execSQL("ALTER TABLE "+ TABLE_USERS + " ADD COLUMN " + KEY_GPA +  " REAL DEFAULT 0.0");
            db.execSQL("ALTER TABLE "+ TABLE_USERS + " ADD COLUMN " + KEY_ACT +  " INTEGER DEFAULT 0");
            db.execSQL("ALTER TABLE "+ TABLE_USERS + " ADD COLUMN " + KEY_SAT +  " INTEGER DEFAULT 0");
        }
        
        
        // Create tables again
        //onCreate(db);
    }
    
    public void addUser(UserInfo user) {
        SQLiteDatabase db = this.getWritableDatabase();
     
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, user.getName()); 
        values.put(KEY_PASSWORD, user.getPassword()); 
        values.put(KEY_GPA, user.getGPA()); 
        values.put(KEY_ACT, user.getACT()); 
        values.put(KEY_SAT, user.getSAT()); 
     
        // Inserting Row
        db.insert(TABLE_USERS, null, values);
        db.close(); // Closing database connection
    }
    
    public UserInfo getUser(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
     
        Cursor cursor = db.query(TABLE_USERS, new String[] { KEY_ID,
                KEY_NAME, KEY_PASSWORD }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
     
        UserInfo user = new UserInfo(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));
        // return contact
        return user;
    }
    
    // Getting All Contacts
 public List<UserInfo> getAllUsers() {
    List<UserInfo> userList = new ArrayList<UserInfo>();
    // Select All Query
    String selectQuery = "SELECT  * FROM " + TABLE_USERS;
 
    SQLiteDatabase db = this.getWritableDatabase();
    Cursor cursor = db.rawQuery(selectQuery, null);
 
    // looping through all rows and adding to list
    if (cursor.moveToFirst()) {
        do {
            UserInfo user = new UserInfo();
            user.setID(Integer.parseInt(cursor.getString(0)));
            user.setName(cursor.getString(1));
            user.setPassword(cursor.getString(2));
            user.setGPA(Double.parseDouble(cursor.getString(3)));
            user.setSAT(Integer.parseInt(cursor.getString(4)));
            user.setACT(Integer.parseInt(cursor.getString(5)));
            // Adding contact to list
            userList.add(user);
        } while (cursor.moveToNext());
    }
 
    // return contact list
    return userList;
}
    
    // Updating single user
    public int updateUser(UserInfo user) {
    	SQLiteDatabase db = this.getWritableDatabase();
 
    	ContentValues values = new ContentValues();
    
    	values.put(KEY_GPA, user.getGPA());
    	values.put(KEY_ACT, user.getACT());
    	values.put(KEY_SAT, user.getSAT());   	
 
    	// updating rows
    	return db.update(TABLE_USERS, values, KEY_NAME + " = ?", new String[] { user.getName() });
}
		
}
