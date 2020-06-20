package com.ilopes.jokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void selecpedra(View view){
        this.resultado("pedra");
    }
    public void selecpapel(View view){
        this.resultado("papel");
    }
    public void selectesoura(View view){
        this.resultado("tesoura");
    }
    public void resultado(String opcs){
        ImageView imgresult = findViewById(R.id.result);
        TextView resulttxt = findViewById(R.id.txtresult);
        int valor = new Random().nextInt(3);
        String[] cpuj = {"pedra","papel","tesoura"};
        String resultcpu = cpuj[valor];
        switch (resultcpu){
            case "pedra":
                imgresult.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imgresult.setImageResource(R.drawable.papel);
                break;
            default:
                imgresult.setImageResource(R.drawable.tesoura);
        }
        if(((resultcpu=="pedra")&&(opcs=="tesoura"))||((resultcpu=="papel")&&(opcs=="pedra"))||((resultcpu=="tesoura")&&(opcs=="papel"))){
            resulttxt.setText("Você perdeu");
        }
        else if(((opcs=="pedra")&&(resultcpu=="tesoura"))||((opcs=="papel")&&(resultcpu=="pedra"))||((opcs=="tesoura")&&(resultcpu=="papel"))){
            resulttxt.setText("Você venceu");
        }
        else{
            resulttxt.setText("Você empatou");
        }

    }
}
