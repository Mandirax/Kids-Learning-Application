package com.example.kids_learning_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper  extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "User.db";
    public static final String TABLE_NAME = "user_name";

    public static final String col1 = "name";



    public DataBaseHelper(@Nullable Context context){
        super(context, DATABASE_NAME,null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+TABLE_NAME+"(name text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP IF TABLE EXISTS"+TABLE_NAME);
        onCreate(db);

    }


    public boolean insertdata(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentvalue = new ContentValues();
        contentvalue.put(col1,name);

        long result = db.insert(TABLE_NAME,null,contentvalue);
        if(result == -1){
            return false;
        }
        else{
            return true;
        }

    }
    public Cursor getalldata(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;

    }



}

