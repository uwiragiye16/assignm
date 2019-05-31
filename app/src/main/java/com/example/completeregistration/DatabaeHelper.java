package com.example.completeregistration;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaeHelper extends SQLiteOpenHelper {
    public DatabaeHelper( Context context) {
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
      db.execSQL("Create table user(RegNumber text primary key, FullName text, Email text, Password text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists user");
// inserting in batabase

        }
    public boolean insert(String RegNumber,String FullName,String Email, String Password){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues ContentValues = new ContentValues();
        ContentValues.put("RegNumber",RegNumber);
        ContentValues.put("FullName",FullName);
        ContentValues.put("Email",Email);
        ContentValues.put("Password",Password);
        long ins = db.insert("user",null,ContentValues);
        if (ins==-1) return false;
        else return true;
    }
    //Checking if RegNumber is exist
    public boolean CheckRegNumber(String RegNumber){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor Cursor = db.rawQuery("Select * from user where RegNumber =?", new String[]{RegNumber});
        if (Cursor.getCount()>0) return false;
        else return  true;
}
}