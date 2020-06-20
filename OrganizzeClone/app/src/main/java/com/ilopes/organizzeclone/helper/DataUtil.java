package com.ilopes.organizzeclone.helper;

import java.text.SimpleDateFormat;

public class DataUtil {

    public static String dataAtual(){

        long date = System.currentTimeMillis();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dataString = simpleDateFormat.format(date);
        return dataString;
    }

    public static String mesAnoDataescolhida(String data){
        String retornodata[] = data.split("/");
        String mesano = retornodata[1] + retornodata[2];
        return mesano;
    }

}
