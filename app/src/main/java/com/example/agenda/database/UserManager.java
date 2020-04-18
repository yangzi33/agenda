package com.example.agenda.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.agenda.database.DatabaseHelper;
import com.example.agenda.user.User;

import java.util.Observable;
import java.util.Observer;

import static com.example.agenda.database.DatabaseHelper.PASSWORD;
import static com.example.agenda.database.DatabaseHelper.USERNAME;
import static com.example.agenda.database.DatabaseHelper.USER_TABLE;

public class UserManager {

    public static User loggedUser;

}
