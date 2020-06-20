package com.ilopes.switchetoggle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private Switch ssenha;
    private ToggleButton tsenha;
    private TextView resutado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ssenha = findViewById(R.id.switchSenha);
        tsenha = findViewById(R.id.toggleSenha);
        resutado = findViewById(R.id.textR);
    }
    public void enviar(View view){
        if (ssenha.isChecked()){
            resutado.setText("Switch Ligado");
        }else{
            resutado.setText("Switch Desligado");
        }
    }
}
