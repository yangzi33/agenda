package com.example.agenda.event;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.agenda.R;

public class CreateEventActivity extends AppCompatActivity {

    EditText eventName;
    Spinner day, month, year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        eventName = (EditText) findViewById(R.id.createEvent_name);
        day = (Spinner) findViewById(R.id.createEvent_day);
        month = (Spinner) findViewById(R.id.createEvent_month);
        year = (Spinner) findViewById(R.id.createEvent_year);

    }
}
