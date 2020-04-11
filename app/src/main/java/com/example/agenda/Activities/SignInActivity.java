package com.example.agenda.Activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.example.agenda.R;
import com.example.agenda.data.DataManager;
import com.example.agenda.user.User;

import java.util.ArrayList;
import java.util.List;

@RequiresApi(api = Build.VERSION_CODES.O)
public class SignInActivity extends AppCompatActivity {

//    private ArrayList<User> allUser = DataManager.readData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
    }

    public void signIn(View view) {
//        EditText usernameInput = findViewById(R.id.sign_in_input_username);
//        EditText passwordInput = findViewById(R.id.sign_in_input_password);
//        TextView signInWarning = findViewById(R.id.invalid_sign_in_alert);
//
//        String username = usernameInput.getText().toString();
//        String password = passwordInput.getText().toString();
//
//        boolean validInput = false;
//
//        for (User user: allUser) {
//            if (user.username.equals(username) && user.password.equals(password)) {
//                MainActivity.loggedInUser = user;
//                validInput = true;
//                Intent intent = new Intent(this, CalendarActivity.class);
//                startActivity(intent);
//            }
//        }
//        if (!validInput) {
//        signInWarning.setVisibility(View.VISIBLE);}

//        System.out.println(allUser);
    }
}
