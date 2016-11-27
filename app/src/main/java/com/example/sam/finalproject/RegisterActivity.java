package com.example.sam.finalproject;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void registerAccount(View view) {
        // validate the form
        EditText usernameField = (EditText)findViewById(R.id.username);
        EditText passwordField = (EditText)findViewById(R.id.password);
        String username = usernameField.getText().toString();
        String password = passwordField.getText().toString();
        // Register a user, and if successful
        try {
            // TODO check if user exists
            // if so login
            // else create new user

            setResult(Activity.RESULT_OK, getIntent());
            this.finish();
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
    public void cancelBtn(View view) {
        setResult(Activity.RESULT_CANCELED, getIntent());
    }
}
