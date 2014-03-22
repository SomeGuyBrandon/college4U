package com.example.project3;

public class SchoolInfo {
     
    //private variables
    int _id;
    String _name;
    String _state;
    int _act;
    int _sat;
    double _gpa;
     
    // Empty constructor
    public SchoolInfo(){
         
    }
    
    // constructor
    public SchoolInfo(String name, String state, double gpa, int act, int sat){
        this._name = name;
        this._state = state;
        this._gpa = gpa;
        this._act = act;
        this._sat = sat;
    }
    
    public SchoolInfo(int id, String name, String state){
        this._id = id;
        this._name = name;
        this._state = state;
    }
     
    // constructor
    public SchoolInfo(String name, String state){
        this._name = name;
        this._state = state;
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
        return this._name;
    }
     
    // setting name
    public void setName(String name){
        this._name = name;
    }
     
    // getting password
    public String getState(){
        return this._state;
    }
     
    // setting password
    public void setState(String state){
        this._state = state;
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

