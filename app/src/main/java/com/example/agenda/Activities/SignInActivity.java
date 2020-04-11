package com.example.agenda.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.agenda.R;
import com.example.agenda.user.User;
import com.example.agenda.user.UserDataManager;

import java.util.ArrayList;

public class SignInActivity extends AppCompatActivity {

    public static ArrayList<User> allUser = UserDataManager.readUserData("com/example/agenda/data/userdata.csv");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
    }

    public void signIn(View view) {
        EditText usernameInput = findViewById(R.id.sign_in_input_username);
        EditText passwordInput = findViewById(R.id.sign_in_input_password);
        TextView signInWarning = findViewById(R.id.invalid_sign_in_alert);

        String username = usernameInput.getText().toString();
        String password = passwordInput.getText().toString();

        boolean validInput = false;

        for (User user: allUser) {
            if (user.username.equals(username) && user.password.equals(password)) {
                MainActivity.loggedInUser = user;
                validInput = true;
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            }
        }
        if (!validInput) {
        signInWarning.setVisibility(View.VISIBLE);}

    }
}
