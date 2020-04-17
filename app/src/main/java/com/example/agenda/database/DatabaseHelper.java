package com.example.agenda.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;


public class DatabaseHelper extends SQLiteOpenHelper {

    // For managers' use
//    public static SQLiteDatabase db;

    public static final String DATABASE_NAME = "agenda.db";

    // Table for User data
    public static final String USER_TABLE = "user_table";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";

    // Table for Event
    public static final String EVENT_TABLE = "event_table";
    public static final String EVENT_NAME = "event_name";
    public static final String EVENT_START_TIME = "start_time";
    public static final String EVENT_END_TIME = "end_time";
    public static final String EVENT_POSTPONED = "postponed";
    public static final String EVENT_USER_REF = "user_reference";

//+ " FOREIGN KEY ("+TASK_CAT+") REFERENCES "+CAT_TABLE+"("+CAT_ID+"));";
    // Table for series

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db = this.getWritableDatabase();
        String createUserTable = "CREATE TABLE " + USER_TABLE + " (ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                USERNAME + " TEXT NOT NULL UNIQUE, " + PASSWORD + " TEXT NOT NULL)";
        String createEventTable = "CREATE TABLE " + EVENT_TABLE + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                EVENT_NAME + " TEXT NOT NULL, " + EVENT_START_TIME + " TEXT NOT NULL, " + EVENT_END_TIME +
                " TEXT NOT NULL, " + EVENT_POSTPONED + " BOOLEAN NOT NULL," +
                " FOREIGN KEY (" + EVENT_USER_REF + ") REFERENCES " + USER_TABLE + "(" + "ID" + "));";
        db.execSQL(createUserTable);
        db.execSQL(createEventTable);
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
     * @return the primary key of corresponding user with username and password.
     */
    public String getUserId(String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        try {Cursor cursor = db.query(DatabaseHelper.USER_TABLE, new String[]{"ID", USERNAME, PASSWORD},
                USERNAME + "=?", new String[]{username},
                null, null, null);
        if (cursor.moveToNext()){
            String userId = cursor.getString(cursor.getColumnIndex("ID"));
            cursor.close();
            return userId;}
        else {
            return "-1";
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
            return "-1";
        }
    }
}
