package com.example.sam.finalproject;

/**
 * Created by Sam on 12/2/16.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.ArrayList;

public class DatabaseHandler extends SQLiteOpenHelper {

    public DatabaseHandler(Context context) {
        super(context, "FinalProject", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        // users table
        // full name
        // email
        // username
        // password
        db.execSQL("CREATE TABLE users (id INTEGER PRIMARY KEY, " +
                "name TEXT, email TEXT, username TEXT, password TEXT)");

        // Workouts table


        // posts table
//        db.execSQL("CREATE TABLE posts (id INTEGER PRIMARY KEY, " +
//                "title TEXT, content TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}

    public User getUserByName(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM users WHERE username = '" + username + "'", null);
        if(cursor.moveToFirst()) {
            // 1 name, 2 email, 3 username, 4 password
            User user = new User(cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));
            return user; // Found user
        }
        return null; // No user found
    }

    // createUser Function

    public void createUser(String _name, String _email, String _username, String _password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name", _name);
        cv.put("email", _email);
        cv.put("username", _username);
        cv.put("password", _password);

        // Write to database
        db.insert("users", null, cv);
        Log.d("USERS", "Insertion success");

        db.close();
    }

}
