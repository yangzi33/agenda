package com.example.agenda.login;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.agenda.R;
import com.example.agenda.database.DatabaseHelper;
import com.example.agenda.database.UserManager;


public class SignUpActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText usernameInput, passwordInput, passwordRepeatInput;
    TextView invalidRepeat, signUpSuccess, usernameExists;
    Button signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        myDb = new DatabaseHelper(this);

        signUpButton = (Button) findViewById(R.id.signup_button);
        invalidRepeat = (TextView) findViewById(R.id.incorrect_repeat_pw);
        signUpSuccess = (TextView) findViewById(R.id.signup_success);
        usernameExists = (TextView) findViewById(R.id.username_exists);
        passwordRepeatInput = (EditText) findViewById(R.id.signup_pw_repeat);
        passwordInput = (EditText) findViewById(R.id.signup_pw);
        usernameInput = (EditText) findViewById(R.id.signup_username);

        signUp();
    }

    public void signUp() {
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = usernameInput.getText().toString();
                String password = passwordInput.getText().toString();
                String passwordRepeat = passwordRepeatInput.getText().toString();

                try {if (!password.equals(passwordRepeat)) {
                    invalidRepeat.setVisibility(View.VISIBLE);
                } else if (username.isEmpty() || password.isEmpty()) {
                    toastMessage("Fields cannot be blank.");
                } else {
                    boolean insertUserData = myDb.addUser(username, password);
                    if (insertUserData) {
                        invalidRepeat.setVisibility(View.GONE);
                        usernameExists.setVisibility(View.GONE);
                        toastMessage("Successfully registered.");
                        signUpSuccess.setVisibility(View.VISIBLE);
                    } else {
                        toastMessage("Something went wrong.");
                        usernameExists.setVisibility(View.VISIBLE);
                    }
                // Exception thrown if username duplicates
                }} catch (SQLiteConstraintException e) {
                    e.printStackTrace();
                }
            }
        });
    }

//    not required any longer, since the values are set to be unique.
//    private boolean usernameDuplicate(String fieldValue) {
//        boolean duplicated = false;
//        SQLiteDatabase tempDb = myDb.getReadableDatabase();
//        try{
//            String Query = ("SELECT * FROM " + DatabaseHelper.USER_TABLE + " WHERE "
//                    + DatabaseHelper.USERNAME + " = " + fieldValue);
//            Cursor cursor = tempDb.rawQuery(Query, null);
//            cursor.close();
//        } catch (SQLiteException e) {
//            e.printStackTrace();
//            duplicated = true;
//        }
//        tempDb.close();
//        return duplicated;
//    }

    private void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
