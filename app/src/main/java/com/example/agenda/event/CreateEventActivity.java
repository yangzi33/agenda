package com.example.agenda.event;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.agenda.R;
import com.example.agenda.database.DatabaseHelper;
import com.example.agenda.main.CalendarActivity;

import static com.example.agenda.database.DatabaseHelper.loggedUser;

public class CreateEventActivity extends AppCompatActivity {

    DatabaseHelper myDb;

    EditText nameInput, desc;
    Spinner startMinInput, startHourInput, startDayInput, startMonthInput, startYearInput;
    Spinner endMinInput, endHourInput, endDayInput, endMonthInput, endYearInput;
    Button createBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        myDb = new DatabaseHelper(this);

        nameInput = (EditText) findViewById(R.id.createEvent_name);

        startDayInput = (Spinner) findViewById(R.id.createEvent_startDay);
        startMonthInput = (Spinner) findViewById(R.id.createEvent_startMonth);
        startYearInput = (Spinner) findViewById(R.id.createEvent_startYear);
        startMinInput = (Spinner) findViewById(R.id.createEvent_startMin);
        startHourInput = (Spinner) findViewById(R.id.createEvent_startHour);
        endHourInput = (Spinner) findViewById(R.id.createEvent_endHour);
        endHourInput = (Spinner) findViewById(R.id.createEvent_endMin);
        createBtn = (Button) findViewById(R.id.Btn_createEvent);
        desc = (EditText) findViewById(R.id.event_desc_input);
        createEvent();
    }

    public void createEvent() {
        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String startTime = startDayInput.toString() + "-" + startMonthInput.toString() + "-" +
                        startYearInput.toString() + " " + startHourInput.toString() + ":" + startMinInput.toString();
                String endTime = endDayInput.toString() + "-" + endMonthInput.toString() + "-" +
                        endYearInput.toString() + " " + endHourInput.toString() + ":" + endMinInput.toString();
                boolean insertEvent = myDb.addEvent(nameInput.toString(), startTime, endTime, loggedUser.getId(), desc.toString());
                if (insertEvent) {
                    Intent intent = new Intent(v.getContext(), CalendarActivity.class);
                    startActivity(intent);
                    Toast.makeText(v.getContext(), "Event Created", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(v.getContext(), "Something went wrong.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
