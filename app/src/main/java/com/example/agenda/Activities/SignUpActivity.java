package com.example.agenda.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.agenda.R;
import com.example.agenda.database.DatabaseHelper;

public class SignUpActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    private Button signUpButton;
    private EditText usernameInput, passwordInput, passwordRepeatInput;

    private TextView invalidRepeat, usernameExists;
//    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        myDb = new DatabaseHelper(this);
        usernameInput = (EditText) findViewById(R.id.signup_username);
        signUpButton = (Button) findViewById(R.id.signup_button);
        passwordInput = (EditText) findViewById(R.id.signup_pw);
        passwordRepeatInput = (EditText) findViewById(R.id.signup_pw_repeat);

        invalidRepeat = findViewById(R.id.incorrect_repeat_pw);
        usernameExists = findViewById(R.id.username_exists);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            String username = usernameInput.getText().toString();
            String password = passwordInput.getText().toString();
            String passwordRepeat = passwordRepeatInput.getText().toString();
            @Override
            public void onClick(View v) {
                if (!password.equals(passwordRepeat)) {
                    invalidRepeat.setVisibility(View.VISIBLE);
                } else if (usernameDuplicate(username)) {
                    usernameExists.setVisibility(View.VISIBLE);
                } else {
                    boolean insertUserData = myDb.addUserData(username, password);
                    if (insertUserData) {
                        toastMessage("Successfully registered.");
                    } else {
                        toastMessage("Something went wrong.");
                    }
                }
            }
        });
    }

    public void signUp(String username, String password) {



//        boolean insertUserData = mDatabaseHelper.addUserData(username, password);

//        if (password.equals(passwordRepeat)) {
//            if (insertUserData) {
//                toastMessage("Successfully registered.");
//            } else {
//                toastMessage("Failed to register.");
//                usernameExists.setVisibility(View.VISIBLE);
//            }
//        } else {
//            invalidRepeat.setVisibility(View.VISIBLE);
//        }
    }

    private boolean usernameDuplicate(String fieldValue) {
        SQLiteDatabase db = myDb.getReadableDatabase();
        String Query = "Select * from " + "user_table" + " where " + "username" + " = " + fieldValue;
        Cursor cursor = db.rawQuery(Query, null);
        if(cursor.getCount() <= 0){
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }

    private void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
