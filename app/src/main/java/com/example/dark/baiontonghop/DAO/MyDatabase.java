package com.example.dark.baiontonghop.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Dark on 4/23/2017.
 */

public class MyDatabase extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "EmployeeManagement";
    private static final int DATABASE_VERSION = 1;

    // Table Names
    private static final String TABLE_DEPARTMENT = "department";
    private static final String TABLE_EMPLOYEE = "employee";

    public static String getTableDepartment() {
        return TABLE_DEPARTMENT;
    }

    // Department Table Columns
    private static final String DEPARTMENT_ID = "id";
    private static final String DEPARTMENT_NAME = "name";

    public static String getDepartmentName() {
        return DEPARTMENT_NAME;
    }

    // Employee Table Columns
    private static final String EMPLOYEE_ID = "id";
    private static final String EMPLOYEE_LASTNAME = "lasttName";
    private static final String EMPLOYEE_FIRSTNAME = "firstName";
    private static final String EMPLOYEE_DEPARTMENT_ID_FK = "departmentId";


    public MyDatabase(Context context) {
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_DEPARTMENT_TABLE = "CREATE TABLE " + TABLE_DEPARTMENT +
                "(" +
                DEPARTMENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                DEPARTMENT_NAME + " TEXT" +
                ")";

        String CREATE_EMPLOYEE_TABLE = "CREATE TABLE " + TABLE_EMPLOYEE +
                "(" +
                EMPLOYEE_ID + " INTEGER PRIMARY KEY," + // Define a primary key
                EMPLOYEE_FIRSTNAME + " TEXT," +
                EMPLOYEE_LASTNAME + " TEXT," +
                EMPLOYEE_DEPARTMENT_ID_FK + " INTEGER CONSTRAINT FK_DEPARTMENT REFERENCES " + TABLE_DEPARTMENT + " ON UPDATE CASCADE" + // Define a foreign key
                ")";

        db.execSQL(CREATE_DEPARTMENT_TABLE);
        db.execSQL(CREATE_EMPLOYEE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion != oldVersion){
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_EMPLOYEE);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_DEPARTMENT);
            onCreate(db);
        }

    }
}
