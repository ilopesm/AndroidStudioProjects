package com.ilopes.caraoucoroa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ResultadoActivity extends AppCompatActivity {
    private ImageView imagem;
    private Button volta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        imagem = findViewById(R.id.imagemResult);
        volta = findViewById(R.id.buttonVolta);

        Bundle resultado = getIntent().getExtras();
        int lado = resultado.getInt("lado");
        if (lado == 0){
            imagem.setImageResource(R.drawable.moeda_cara);
        }
        else{
            imagem.setImageResource(R.drawable.moeda_coroa);
        }
        volta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
