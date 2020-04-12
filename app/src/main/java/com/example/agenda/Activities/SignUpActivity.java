package com.example.agenda.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
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

import org.w3c.dom.Text;


public class SignUpActivity extends AppCompatActivity {

    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        myDb = new DatabaseHelper(this);
        Button signUpButton = (Button) findViewById(R.id.signup_button);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText passwordRepeatInput = (EditText) findViewById(R.id.signup_pw_repeat);
                EditText passwordInput = (EditText) findViewById(R.id.signup_pw);
                EditText usernameInput = (EditText) findViewById(R.id.signup_username);

                String username = usernameInput.getText().toString();
                String password = passwordInput.getText().toString();
                String passwordRepeat = passwordRepeatInput.getText().toString();
                TextView invalidRepeat = (TextView) findViewById(R.id.incorrect_repeat_pw);
                TextView signUpSuccess = (TextView) findViewById(R.id.signup_success);
                TextView usernameExists = (TextView) findViewById(R.id.username_exists);

                if (!password.equals(passwordRepeat)) {
                    invalidRepeat.setVisibility(View.VISIBLE);
                } else if (!usernameDuplicate(username)) {
                    usernameExists.setVisibility(View.VISIBLE);
                } else if (username.isEmpty() || password.isEmpty()) {
                    toastMessage("Fields cannot be blank.");
                } else {
                    boolean insertUserData = myDb.addUserData(username, password);
                    if (insertUserData) {
                        invalidRepeat.setVisibility(View.GONE);
                        usernameExists.setVisibility(View.GONE);
                        toastMessage("Successfully registered.");
                        signUpSuccess.setVisibility(View.VISIBLE);
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
        boolean duplicated = false;
        SQLiteDatabase tempDb = myDb.getReadableDatabase();
        try{
        String Query = "SELECT * FROM " + DatabaseHelper.TABLE_USERS + " WHERE username = " + fieldValue;
            Cursor cursor = tempDb.rawQuery(Query, null);
            if (cursor.getCount() > 0){
                duplicated = true;
            }
            cursor.close();
            tempDb.close();
//            return duplicated;
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
        return duplicated;
    }

    private void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
