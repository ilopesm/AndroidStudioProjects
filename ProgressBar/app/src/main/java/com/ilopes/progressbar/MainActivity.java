package com.ilopes.progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    private ProgressBar h;
    private ProgressBar c;
    private int progresso = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        h = findViewById(R.id.progressBarh);
        c = findViewById(R.id.progressBarC);
    }
    public void Carregar (View view){
        progresso ++;
        h.setProgress(progresso);
        if (progresso<10){
            c.setVisibility(View.VISIBLE);
        }
        else{
            c.setVisibility(View.GONE);
            h.setVisibility(View.GONE);
        }
    }
}
