package com.ilopes.organizzeclone.config;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ConfigFirebase {
    private static FirebaseAuth auth;
    private static DatabaseReference reference;
    //retornar a instacia do firebase
    public static DatabaseReference getReference(){
        if(reference ==null){
            reference = FirebaseDatabase.getInstance().getReference();
        }
        return reference;
    }
    //retorna o firebaseauth
    public static FirebaseAuth getAuth(){
        if(auth == null){
            auth = FirebaseAuth.getInstance();
        }
        return auth;
    }
}
