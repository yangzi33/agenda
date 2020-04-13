package com.example.agenda.Activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.agenda.R;
import com.example.agenda.data.DataManager;
import com.example.agenda.database.DatabaseHelper;
import com.example.agenda.user.User;

import java.util.ArrayList;
import java.util.List;

@RequiresApi(api = Build.VERSION_CODES.O)
public class SignInActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    Button signInButton;
    TextView userNameInput, passwordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        myDb = new DatabaseHelper(this);

        signInButton = findViewById(R.id.sign_in_button);
        userNameInput = findViewById(R.id.sign_in_input_username);
        passwordInput = findViewById(R.id.sign_in_input_password);
        signIn();
    }

    public void signIn() {
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = userNameInput.getText().toString();
                String password = passwordInput.getText().toString();
                if (validSignIn(username, password) != -1) {
                    Intent intent = new Intent(v.getContext(), CalendarActivity.class);
                    intent.putExtra("user", username);
                    intent.putExtra("pw", password);
                    startActivity(intent);
                }
            }
        });
    }

    private int validSignIn(String username, String password) {
        SQLiteDatabase db = myDb.getReadableDatabase();

    }
}
