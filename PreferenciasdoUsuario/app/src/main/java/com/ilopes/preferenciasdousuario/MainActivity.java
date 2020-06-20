package com.ilopes.preferenciasdousuario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextView resultado;
    private TextInputEditText nome;
    private Button salvar;
    private static final String ARQUIVO_PREFERENCIA = "ArquivoPreferencia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        salvar = findViewById(R.id.buttonSave);
        nome = findViewById(R.id.editNome);
        resultado = findViewById(R.id.textResult);

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERENCIA,0);
                SharedPreferences.Editor editor =  preferences.edit( );

                //validar o nome
                if(nome.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Preencha o nome",Toast.LENGTH_LONG).show();
                }else{
                    String nomes = nome.getText().toString();
                    editor.putString("nome",nomes);
                    editor.commit();
                    resultado.setText("Olá, "+nomes);
                }
            }
        });
        //recuperar os dados salvos
        SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERENCIA,0);

        //valida se tem o nome em preferencias
        if(preferences.contains("nome")){
            String nomes = preferences.getString("nome","usuario não definido!");
            resultado.setText("Olá, "+ nomes);
        }else{
            resultado.setText("Olá, usuario não definido!");
        }
    }
}
