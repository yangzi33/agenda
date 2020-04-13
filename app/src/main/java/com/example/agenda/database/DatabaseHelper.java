package com.example.agenda.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.agenda.Activities.SignUpActivity;


public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "agenda.db";

    // Table for userdata
    public static final String USER_TABLE = "user_table";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";

    // Table for series

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "create table " + USER_TABLE + " (ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                USERNAME + " TEXT NOT NULL UNIQUE, " + PASSWORD + " TEXT NOT NULL)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + USER_TABLE);
        onCreate(db);
    }

    public boolean addUser(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(USERNAME, username);
        contentValues.put(PASSWORD, password);

        Log.d(DATABASE_NAME, "addUserData: adding " + username + ", " + password + " to " + USER_TABLE);

        long result = db.insert(USER_TABLE, null, contentValues);

        return result != -1;
    }

    /**
     * Precondition: Username and password exist in one row of USER_TABLE
     * @param username username string to check
     * @param password password string to check
     * @return the primary key of corresponding user with username and password.
     */
    public String getUserId(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        String Query = ("SELECT ID FROM " + USER_TABLE + " WHERE "
                + USERNAME + " = " + username + " AND " + PASSWORD + " = " + password);
        Cursor cursor = db.rawQuery(Query, null);
        String ret = cursor.toString();
        cursor.close();
        return ret;
    }
}
