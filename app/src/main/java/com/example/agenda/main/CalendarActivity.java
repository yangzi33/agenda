package com.example.agenda.main;

import android.content.Intent;
import android.os.Bundle;

import com.example.agenda.database.DatabaseHelper;
import com.example.agenda.user.User;
import com.getbase.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Toast;

import com.example.agenda.R;

public class CalendarActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    Intent intent = getIntent();
    public User loggedUser;

    String USER_ID = intent.getStringExtra("USER_ID");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        myDb = new DatabaseHelper(this);

        String username = intent.getStringExtra("USERNAME");
        loggedUser = new User(username, intent.getStringExtra("PASSWORD"), myDb.getUserId(username));

        FloatingActionButton fab1 = findViewById(R.id.fab_add_event);
        FloatingActionButton fab2 = findViewById(R.id.fab_add_series);
        FloatingActionButton fab3 = findViewById(R.id.fab_add_alarm);

        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Add Event");
            }
        });
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Add Series");
            }
        });
        fab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Add Alarm");
            }
        });

    }

    /**
     * Show short toast message
     * @param message message to show
     */
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}


