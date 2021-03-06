package com.example.agenda.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.agenda.event.Event;
import com.example.agenda.user.User;

import java.util.ArrayList;


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
    public static final String EVENT_DESC = "descriptions";
    public static final String EVENT_POSTPONED = "postponed";
    public static final String EVENT_USER_REF = "user_reference";

    // Table for alerts
    public static final String ALERT_TABLE = "alert_table";
    public static final String ALERT_NAME = "alert_name";
    public static final String ALERT_EVENT_REF = "event_ref";

//+ " FOREIGN KEY ("+TASK_CAT+") REFERENCES "+CAT_TABLE+"("+CAT_ID+"));";
    // Table for series

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createUserTable = "CREATE TABLE " + USER_TABLE + " (ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                USERNAME + " TEXT NOT NULL UNIQUE, " + PASSWORD + " TEXT NOT NULL);";

        String createEventTable = "CREATE TABLE " + EVENT_TABLE + " (ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                EVENT_NAME + " TEXT NOT NULL, " + EVENT_START_TIME + " TEXT NOT NULL, " + EVENT_END_TIME +
                " TEXT NOT NULL, " + EVENT_DESC + " VARCHAR(120), "
                + EVENT_POSTPONED + " BOOLEAN DEFAULT (0), " + EVENT_USER_REF + " INTEGER," +
                "FOREIGN KEY ( " + EVENT_USER_REF + " ) REFERENCES " + USER_TABLE + " ( ID ));";

        String createAlertTable = "CREATE TABLE alert_table (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "alert_name TEXT NOT NULL, event_ref INT, FOREIGN KEY ( event_ref ) REFERENCES event_table ( ID ))";

        db.execSQL(createAlertTable);
        db.execSQL(createUserTable);
        db.execSQL(createEventTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + USER_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + EVENT_TABLE);
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
    public Cursor getUserId(String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + " ID " + " FROM " + USER_TABLE +
                " WHERE " + USERNAME + " = '" + username + "'";
        return db.rawQuery(query, null);
    }

    public Cursor getUserEvents(String userId) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        String query = "select * from "+ EVENT_TABLE + " where " + EVENT_USER_REF + " = '" + userId + "'";
        return db.rawQuery(query, null) ;
    }

    public boolean validSignIn(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        boolean valid = false;
        Cursor cursor = db.query(DatabaseHelper.USER_TABLE, new String[]{"ID", USERNAME, PASSWORD},
                USERNAME + "=?", new String[]{username},
                null, null, "password");
        if (cursor.moveToNext()) {
            String curr_password = cursor.getString(cursor.getColumnIndex("password"));
            if (password.equals(curr_password)) {
                valid = true;
            }
        }
        cursor.close();
        return valid;
    }

    public boolean addEvent(String name, String startTime, String endTime, String userId, String descriptions) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(EVENT_NAME, name);
        contentValues.put(EVENT_START_TIME, startTime);
        contentValues.put(EVENT_END_TIME, endTime);
        contentValues.put(EVENT_USER_REF, userId);
        contentValues.put(EVENT_DESC, descriptions);

        Log.d(DATABASE_NAME, "addUserData: adding event " + EVENT_NAME + "to" + EVENT_TABLE);

        long result = db.insert(EVENT_TABLE, null, contentValues);

        return result != -1;
    }
}
