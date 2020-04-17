package com.example.agenda.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.agenda.R;
import com.example.agenda.user.User;

public class MainActivity extends AppCompatActivity {

    public static User loggedInUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}
