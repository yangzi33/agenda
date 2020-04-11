package com.example.agenda.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "DatabaseHelper";

    private static final String TABLE_USERS = "user_table";
    private static final String COL0 = "ID";
    private static final String COL1 = "username";
    private static final String COL2 = "password";
    private static final String COL3 = "email";

    public DatabaseHelper(@Nullable Context context) {
        super(context, TABLE_USERS, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_USERS + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL1 + "TEXT) ";
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addUsername(String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1, username);
        return false;
    }
}
