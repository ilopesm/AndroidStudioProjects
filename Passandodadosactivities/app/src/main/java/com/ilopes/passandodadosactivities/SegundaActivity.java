package com.ilopes.passandodadosactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {
    private TextView textnome;
    private TextView textidade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        textnome = findViewById(R.id.textNome);
        textidade = findViewById(R.id.textIdade);
        //Recuperar dados

        Bundle dados = getIntent().getExtras();
        User user= (User) dados.getSerializable("obj");
        String nome = dados.getString("nome");
        int idade = dados.getInt("idade");
        textnome.setText(user.getNome());
        textidade.setText(String.valueOf(idade));
    }
}
