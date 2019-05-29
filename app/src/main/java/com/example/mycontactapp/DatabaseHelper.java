package com.example.mycontactapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final int DATABASE_Version = 1;
    public static final String DATABASE_Name = "Contact2-2019.db";
    public static final String TABLE_Name = "Contact2-2019_table";
    public static final String ID = "ID";
    public static final String COLUMN_NAME_CONTACT = "contact";


    public static final String SQL_CREATE_ENTERIES =
            "CREATE TABLE" + TABLE_Name + " (" +
                    ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COLUMN_NAME_CONTACT + " TEXT)";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_Name, factory : null, DATABASE_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
