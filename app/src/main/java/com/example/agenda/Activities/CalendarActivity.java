package com.example.agenda.Activities;

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
    Intent intent = this.getIntent();
    User current_user = new User(intent.getStringExtra("user"),
            intent.getStringExtra("pw"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        myDb = new DatabaseHelper(this);

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

    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}


