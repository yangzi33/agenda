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

    public static final String DATABASE_NAME = "agenda.db";

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
}
//public class DatabaseHelper extends SQLiteOpenHelper {
//
//    public static final String DATABASE_NAME = "agenda";
//
//    // User table columns
//    public static final String TABLE_USERS = "user_table";
//    public static final String KEY_USER_ID = "id";
//    public static final String USERNAME = "username";
//    public static final String PASSWORD = "password";
////    public static final String EMAIL = "email";
//
//    // Series table columns
//    public static final String TABLE_SERIES = "series_table";
//    public static final String KEY_SERIES_ID = "id";
//    public static final String SERIES_NAME = "seriesName";
//    public static final String SERIES_REF_ID = "refID";
//
//    public DatabaseHelper(@Nullable Context context) {
//        super(context, DATABASE_NAME, null, 1);
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USERS +
//                "(" +
//                KEY_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
//                USERNAME + " TEXT NOT NULL UNIQUE, " +
//                PASSWORD + " TEXT NOT NULL"
//                + ")";
//
//        String CREATE_SERIES_TABLE = "CREATE TABLE " + TABLE_SERIES +
//                "(" +
//                KEY_SERIES_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
//                SERIES_REF_ID + " INTEGER REFERENCES " + TABLE_USERS + ", " + // Foreign key for user ref
//                SERIES_NAME + " TEXT"
//                + ")";
//
//        db.execSQL(CREATE_USER_TABLE);
//        db.execSQL(CREATE_SERIES_TABLE);
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SERIES);
//        onCreate(db);
//    }
//
//    public boolean addUserData(String username, String password) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(USERNAME, username);
//        contentValues.put(PASSWORD, password);
//
//        Log.d(DATABASE_NAME, "addUserData: adding " + username + ", " + password + " to " + TABLE_USERS);
//
//        long result = db.insert(TABLE_USERS, null, contentValues);
//
//        return result != -1;
//    }
//}
