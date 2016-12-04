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
        EditText fullnameField = (EditText)findViewById(R.id.userFullName);
        EditText userEmailField = (EditText)findViewById(R.id.userEmail);
        EditText usernameField = (EditText)findViewById(R.id.username);
        EditText passwordField = (EditText)findViewById(R.id.password);
        EditText confirmPasswordField = (EditText)findViewById(R.id.passwordConfirm);

        String fullName = fullnameField.getText().toString();
        String userEmail = userEmailField.getText().toString();
        String username = usernameField.getText().toString();
        String password = passwordField.getText().toString();
        String confirmPassword = confirmPasswordField.getText().toString();
        try {
            if(!confirmPassword.equals(password)) {
                Toast.makeText(this, "Passwords do not match.", Toast.LENGTH_LONG).show();
            }
            else {
                UserHelper.CreateUser(fullName, userEmail, username, password);
                setResult(Activity.RESULT_OK, getIntent());
                this.finish();
            }
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
    public void cancel(View view) {
        setResult(Activity.RESULT_CANCELED, getIntent());
    }
}
