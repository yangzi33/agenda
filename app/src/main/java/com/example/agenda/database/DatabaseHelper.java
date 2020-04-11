package com.example.agenda.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "DatabaseHelper";

    // User table columns
    private static final String TABLE_USERS = "user_table";
    private static final String KEY_USER_ID = "id";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String EMAIL = "email";

    // Series table columns
    private static final String TABLE_SERIES = "series_table";
    private static final String KEY_SERIES_ID = "id";
    private static final String SERIES_NAME = "seriesName";
    private static final String SERIES_REF_ID = "seriesID";

    public DatabaseHelper(@Nullable Context context) {
        super(context, TABLE_USERS, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USERS +
                "(" +
                KEY_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                USERNAME + "TEXT," +
                PASSWORD + "TEXT," +
                EMAIL + "TEXT"
                + ")";

        String CREATE_SERIES_TABLE = "CREATE TABLE " + TABLE_SERIES +
                "(" +
                KEY_SERIES_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, " +
                SERIES_REF_ID + " INTEGER REFERENCES " + TABLE_USERS + "," + // Foreign key for user ref
                SERIES_NAME + "TEXT"
                + ")";

        db.execSQL(CREATE_USER_TABLE);
        db.execSQL(CREATE_SERIES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SERIES);
        onCreate(db);
    }

    public boolean addUserData(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(USERNAME, username);
        contentValues.put(PASSWORD, password);

        Log.d(TAG, "addUserData: adding " + username + ", " + password + " to " + TABLE_USERS);

        long result = db.insert(TABLE_USERS, null, contentValues);

        return result == -1;
    }
}
