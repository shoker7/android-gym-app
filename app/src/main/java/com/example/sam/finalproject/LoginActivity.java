package com.example.sam.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void login(View view) {
        Intent profileIntent = new Intent(this, ProfileActivity.class);
        EditText edtUsername = (EditText) findViewById(R.id.username);
        String curUser = edtUsername.getText().toString();
        profileIntent.putExtra("username", curUser);
        startActivity(profileIntent);
    }

    public void startRegisterActivity(View view) {
        Intent registerIntent = new Intent(this, RegisterActivity.class);
        startActivityForResult(registerIntent, 1);
    }
}
