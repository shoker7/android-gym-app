package com.example.sam.finalproject;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        UserHelper.openDB(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void login(View view) {
        EditText edtUsername = (EditText) findViewById(R.id.username);
        EditText edtPassword = (EditText) findViewById(R.id.password);
        String username = edtUsername.getText().toString();
        String password = edtPassword.getText().toString();

        if (UserHelper.AuthenticateUser(username, password)) {
            Intent profileIntent = new Intent(this, ProfileActivity.class);
            profileIntent.putExtra("username", username);
            startActivity(profileIntent);
        } else {
            Toast.makeText(this, "Invalid username or password combination", Toast.LENGTH_LONG).show();
        }

    }

    public void startRegisterActivity(View view) {
        Intent registerIntent = new Intent(this, RegisterActivity.class);
        startActivityForResult(registerIntent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 1 && resultCode == Activity.RESULT_OK) {
            Toast.makeText(this, "Account Created", Toast.LENGTH_LONG).show();
        }
    }

}
