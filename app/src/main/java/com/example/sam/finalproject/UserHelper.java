package com.example.sam.finalproject;

import android.content.Context;
import android.util.Log;

/**
 * Created by Sam on 12/2/16.
 */

public class UserHelper {

        public static DatabaseHandler db;

        public static void openDB(Context context) {
            if(db == null) {
                db = new DatabaseHandler(context);
            }
        }

        // Creates a user with some logic, or throws the error
        public static void CreateUser(String fullname, String email, String username, String password) throws Exception {
            if(username.length() < 5) {
                throw new Exception("Username needs to be 5 chars long");
            } else if(password.length() < 4) {
                throw new Exception("Password needs to be 4 chars long");
            } else if(password.equals(username)) {
                throw new Exception("Password cannot be the username");
            }
            // Call db create user
            db.createUser(fullname, email, username, password);
        }

        public static boolean AuthenticateUser(String username, String password) {
            User user = db.getUserByName(username);
            if(user != null && user.password.equals(password)) {
                return true;
            }
            return false;
        }
    }

