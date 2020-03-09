package com.example.demo;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {

    Context context;
    public DataBaseHelper(@Nullable Context context) {
        super(context, Query.DATABASE_NAME, null, Query.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Query.CREATE_TABLE);
        Toast.makeText(context, "DataBase Created", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE "+Query.Name);
        onCreate(db);


    }

    // DATA INSERT

    public  long insertData (Student student){

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();


        ContentValues contentValues = new ContentValues();
        contentValues.put(Query.Name,student.getName());
        contentValues.put(Query.Roll,student.getRoll());

        long RowID = sqLiteDatabase.insert(Query.TABLE_NAME,null,contentValues);

        return RowID;

    }

    public Cursor showData(){

    SQLiteDatabase sqLiteDatabase = getReadableDatabase();
    Cursor cursor =sqLiteDatabase.rawQuery("SELECT * FROM "+ Query.TABLE_NAME,null);
    return cursor;

    }

    public int deleteData(String id){

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        int status =sqLiteDatabase.delete(Query.TABLE_NAME,"id=?",new String[]{String.valueOf(id)});
        return status;


    }
}
