package com.example.project3;

public class UserInfo {
     
    //private variables
    int _id;
    String _username;
    String _password;
    int _act;
    int _sat;
    double _gpa;
     
    // Empty constructor
    public UserInfo(){
         
    }
    
    // constructor
    public UserInfo(String username, String password, double gpa, int act, int sat){
        this._username = username;
        this._password = password;
        this._gpa = gpa;
        this._act = act;
        this._sat = sat;
    }
    
    public UserInfo(int id, String username, String password){
        this._id = id;
        this._username = username;
        this._password = password;
    }
     
    // constructor
    public UserInfo(String username, String password){
        this._username = username;
        this._password = password;
    }
    // getting ID
    public int getID(){
        return this._id;
    }
     
    // setting id
    public void setID(int id){
        this._id = id;
    }
     
    // getting name
    public String getName(){
        return this._username;
    }
     
    // setting name
    public void setName(String username){
        this._username = username;
    }
     
    // getting password
    public String getPassword(){
        return this._password;
    }
     
    // setting password
    public void setPassword(String password){
        this._password = password;
    }
    
 // getting gpa
    public double getGPA(){
        return this._gpa;
    }
     
    // setting gpa
    public void setGPA(double gpa){
        this._gpa = gpa;
    }
    
 // getting act
    public int getACT(){
        return this._act;
    }
     
    // setting act
    public void setACT(int act){
        this._act = act;
    }
    
 // getting SAT
    public int getSAT(){
        return this._sat;
    }
     
    // setting SAT
    public void setSAT(int sat){
        this._sat = sat;
    }
}
