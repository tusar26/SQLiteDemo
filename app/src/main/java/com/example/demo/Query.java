package com.example.demo;

public class Query {

    public static final String DATABASE_NAME = "Student.db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "student";

    public static final String ID ="id";
    public static final String Name = "Name";
    public static final String Roll = "Roll";

    public static final String CREATE_TABLE = " CREATE TABLE "+TABLE_NAME+"("
        +ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, "
        +Name+ " TEXT , "+Roll+ " TEXT "+")";
}
