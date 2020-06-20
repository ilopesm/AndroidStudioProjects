package com.ilopes.organizzeclone.helper;

import android.util.Base64;

public class Base64Custom {

    public static String encode64 (String Texto){

        return Base64.encodeToString(Texto.getBytes(),Base64.DEFAULT).replaceAll("(\\n|\\r)","");

    }
    public static String decode64(String TextoCod){

        return new String(Base64.decode(TextoCod,Base64.DEFAULT));

    }

}
