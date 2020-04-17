package com.example.agenda.login;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.agenda.main.CalendarActivity;
import com.example.agenda.R;
import com.example.agenda.database.DatabaseHelper;
import com.example.agenda.user.User;


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

        signInButton = (Button) findViewById(R.id.sign_in_button);
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
                if (validSignIn(username, password)) {
                    Intent intent = new Intent(v.getContext(), CalendarActivity.class);
                    DatabaseHelper.loggedUser = new User(username, password, myDb.getUserId(username).toString());
                    startActivity(intent);
                } else {
                    Toast.makeText(v.getContext(), "Invalid login info.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean validSignIn(String username, String password) {
        SQLiteDatabase db = myDb.getReadableDatabase();
//        String userid = "-1";
        String usernameCol = DatabaseHelper.USERNAME;
        String passwordCol = DatabaseHelper.PASSWORD;
        boolean valid = false;
        Cursor cursor = db.query(DatabaseHelper.USER_TABLE, new String[]{"ID", usernameCol, passwordCol},
                usernameCol + "=?", new String[]{username},
                null, null, "password");
        if (cursor.moveToNext()) {
            String curr_password = cursor.getString(cursor.getColumnIndex("password"));
            if (password.equals(curr_password)) {
                valid = true;
            }
        }
        cursor.close();
        return valid;
    }
}
