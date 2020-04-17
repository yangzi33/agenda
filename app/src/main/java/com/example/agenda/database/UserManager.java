package com.example.agenda.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.agenda.database.DatabaseHelper;

import static com.example.agenda.database.DatabaseHelper.PASSWORD;
import static com.example.agenda.database.DatabaseHelper.USERNAME;
import static com.example.agenda.database.DatabaseHelper.USER_TABLE;

public class UserManager extends AppCompatActivity {

//    static DatabaseHelper myDb = new DatabaseHelper(this);
//
//    public static boolean addUser(String username, String password) {
//
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(USERNAME, username);
//        contentValues.put(PASSWORD, password);
//
//        Log.d(DatabaseHelper.DATABASE_NAME, "addUserData: adding " + username + ", " + password + " to " + USER_TABLE);
//
//        long result = myDb.insert(USER_TABLE, null, contentValues);
//
//        return result != -1;
//    }
//
//    public static String getUserId(String username) {
//        return '1';
//    }

//    public static boolean changeUserPassword(String id, String username, String password) {
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(USERNAME, username);
//        contentValues.put(PASSWORD, password);
//        contentValues.put("ID", id);
//        myDb.update(USER_TABLE, contentValues, "ID = ?", new String[] { id });
//        return true;
//    }
//
//    public static Integer removeUser (String id) {
//        return myDb.delete(DatabaseHelper.USER_TABLE, "ID = ?",new String[] { id });
//    }
}
