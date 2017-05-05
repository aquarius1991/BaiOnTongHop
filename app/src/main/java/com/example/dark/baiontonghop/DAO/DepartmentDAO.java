package com.example.dark.baiontonghop.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import com.example.dark.baiontonghop.DTO.department_class;

import com.example.dark.baiontonghop.Department;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dark on 4/23/2017.
 */

public class DepartmentDAO {
    SQLiteDatabase db;
    MyDatabase myDatabase;
    Context context;

    public DepartmentDAO(Context context) {
        this.context = context;
        myDatabase=new MyDatabase(context);
    }

    public void add(department_class dept){
        db=myDatabase.getWritableDatabase();
        db.beginTransaction();
        try {
            ContentValues values=new ContentValues();
            values.put(MyDatabase.getDepartmentName(),dept.getName());
            db.insert(MyDatabase.getTableDepartment(),null,values);
            db.setTransactionSuccessful();
        }catch (SQLiteException ex){

        }finally {
            db.endTransaction();
        }
    }

    public List<department_class> getderpartment(){
        List<department_class> list=new ArrayList<department_class>();
        db= myDatabase.getReadableDatabase();
        try {
            String sql="SELECT * FROM "+myDatabase.getTableDepartment();
            Cursor cursor=db.rawQuery(sql,null);
            cursor.moveToPosition(-1);
            while (cursor.moveToNext()){
                department_class dept=new department_class(cursor.getInt(0),cursor.getString(cursor.getColumnIndex("name")));
                list.add(dept);
            }
        }catch (SQLiteException ex){

        }
        return list;
    }
}
