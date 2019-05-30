package com.example.mycontactapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final int DATABASE_Version = 1;
    public static final String DATABASE_Name = "Contact2-2019.db";
    public static final String TABLE_Name = "Contact2-2019_table";
    public static final String ID = "ID";
    public static final String COLUMN_NAME_CONTACT = "contact";


    public static final String SQL_CREATE_ENTERIES =
            "CREATE TABLE " + TABLE_Name + " (" +
                    ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COLUMN_NAME_CONTACT + " TEXT)";

    public static final String SQL_DELETE_ENTRIES =
        "DROP TABLE IF EXISTS " + TABLE_Name;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_Name,null, DATABASE_Version);
        Log.d("MyContactApp", "DatabaseHelper: constructed DatabaseHelper" );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTERIES);
        Log.d("MyContactApp", "DatabaseHelper: created database" );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        Log.d("MyContactApp", "DatabaseHelper: upgraded database " );
        onCreate(db);
    }

    public boolean insertData(String name)
    {
        Log.d("MyContactApp", "DatabaseHelper: inserting data" );
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN_NAME_CONTACT, name);
        long result = db.insert(TABLE_Name, null, contentValues);

        if (result == -1)
        {
            Log.d("MyContactApp", "DatabaseHelper: Contact Insert Failed" );
            return false;
        }
        else
        {
            Log.d("MyContactApp", "DatabaseHelper: Contact Insert Passed" );
            return true;
        }

    }




























    public Cursor getAllData()
    {

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_Name, null );
        return res;
    }

}
