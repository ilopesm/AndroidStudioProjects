package com.ilopes.meczap.config;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ConfigFb {

    private static DatabaseReference database;
    private static FirebaseAuth auth;

    public static DatabaseReference getDatabase() {
        if( database == null){
            database = FirebaseDatabase.getInstance().getReference();
        }
        return database;
    }

    public static FirebaseAuth getAuth() {
        if(auth==null){
            auth = FirebaseAuth.getInstance();
        }
        return auth;
    }
}
