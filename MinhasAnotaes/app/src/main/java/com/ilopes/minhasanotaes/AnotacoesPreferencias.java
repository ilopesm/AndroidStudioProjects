package com.ilopes.minhasanotaes;

import android.content.Context;
import android.content.SharedPreferences;

public class AnotacoesPreferencias {

    private Context context;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    private static final String CHAVE_NOME = "nome";
    private static final String NOME_ARQUIVO = "anotacao.preferencias";


    public AnotacoesPreferencias(Context c) {
        this.context = c;
        preferences = context.getSharedPreferences(NOME_ARQUIVO,0);
        editor = preferences.edit();
    }

    public void salvaranot(String texto){
        editor.putString(CHAVE_NOME,texto);
        editor.commit();
    }
    public String recuperanot(){
        return preferences.getString(CHAVE_NOME,"");
    }

}
