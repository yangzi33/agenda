package com.example.agenda.database;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.agenda.event.Event;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static com.example.agenda.database.DatabaseHelper.EVENT_END_TIME;
import static com.example.agenda.database.DatabaseHelper.EVENT_NAME;
import static com.example.agenda.database.DatabaseHelper.EVENT_START_TIME;
import static com.example.agenda.database.DatabaseHelper.EVENT_TABLE;
import static com.example.agenda.database.DatabaseHelper.EVENT_USER_REF;
import static com.example.agenda.database.DatabaseHelper.PASSWORD;
import static com.example.agenda.database.DatabaseHelper.USERNAME;
import static com.example.agenda.database.DatabaseHelper.USER_TABLE;

public class EventManager {
    /* Event Table: ID  USER_REF  START_TIME  END_TIME  POSTPONE
     *
     *
     */
//    private SQLiteDatabase myDb = DatabaseHelper.db;

    public boolean addEvent(String name, String startTime, String endTime, String userId) {
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(EVENT_NAME, name);
//        contentValues.put(EVENT_START_TIME, startTime);
//        contentValues.put(EVENT_END_TIME, endTime);
//        contentValues.put(EVENT_USER_REF, userId);
//        contentValues.put(EVENT_USER_REF, "0");

//        Log.d(DatabaseHelper.DATABASE_NAME, "addUserData: adding " + username + ", " + password + " to " + USER_TABLE);

//        long result = myDb.insert(EVENT_TABLE, null, contentValues);

//        return result != -1;
        return true;
    }

    public boolean changeEventName(String id, String username, String password) {
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(USERNAME, username);
//        contentValues.put(PASSWORD, password);
//        contentValues.put("ID", id);
//        myDb.update(USER_TABLE, contentValues, "ID = ?", new String[] { id });
        return true;
    }

    public Integer removeEvent (String id) {
//        return myDb.delete(DatabaseHelper.USER_TABLE, "ID = ?",new String[] { id });
        return 0;
    }

    public ArrayList<Event> getUsersEvents(String userId) {
        ArrayList<Event> ret = new ArrayList<>();
        return ret;
    }
}
