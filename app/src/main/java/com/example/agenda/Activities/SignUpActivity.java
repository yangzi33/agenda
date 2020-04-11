package com.example.agenda.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.agenda.R;
import com.example.agenda.database.DatabaseHelper;

public class SignUpActivity extends AppCompatActivity {

    DatabaseHelper mDatabaseHelper;
    String username;
    String password;
    String passwordRepeat;
    // String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mDatabaseHelper = new DatabaseHelper(this);
    }

    public void signUp(View view) {
        EditText usernameInput = findViewById(R.id.signup_username);
        EditText passwordInput = findViewById(R.id.signup_pw);
        EditText passwordRepeatInput = findViewById(R.id.signup_pw_repeat);
        TextView invalidRepeat = findViewById(R.id.incorrect_repeat_pw);

        username = usernameInput.getText().toString();
        password = passwordInput.getText().toString();
        passwordRepeat = passwordRepeatInput.getText().toString();

        if (password.equals(passwordRepeat)) {
            addUser();
        } else {
            invalidRepeat.setVisibility(View.VISIBLE);
        }
    }

    public void addUser() {
        TextView usernameExists = findViewById(R.id.username_exists);
        boolean insertUserData = mDatabaseHelper.addUserData(username, username);

        if (insertUserData) {
            toastMessage("Successfully registered.");
        } else {
            toastMessage("Failed to register.");
            usernameExists.setVisibility(View.VISIBLE);
        }
    }

    private void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
