package com.ilopes.frasesdodia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void frasealtera(View view){

        TextView text = findViewById(R.id.frases);
        String[] frases = {
                "vocé é mt especial para mim",
                "o jeito que vc mexe cmg é de outro mundo",
                "me falta palavras para descrever o que eu sinto por você",
                "É deus no ceu e eu na tua"
        };

        text.setText(frases[new Random().nextInt(frases.length)]);
    }
}
