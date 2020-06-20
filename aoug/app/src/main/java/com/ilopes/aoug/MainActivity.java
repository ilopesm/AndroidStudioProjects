package com.ilopes.aoug;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText a , g;
    private TextView resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a = findViewById(R.id.alcool);
        g = findViewById(R.id.gasolina);
        resultado = findViewById(R.id.Resultado);
    }
    public void envia (View view){
        String gasolina = g.getText().toString();
        String alcool = a.getText().toString();
        //boolean valida = validacampos(alcool,gasolina);
        if (validacampos(alcool,gasolina)){
            double vAl = Double.parseDouble(alcool);
            double VGa = Double.parseDouble(gasolina);
            double media = vAl/VGa;
            if (media >= 0.7){
                resultado.setText("Melhor usar gasolina!");
            }else{
                resultado.setText("Melhor usar Alcool!");
            }

        }else{
            resultado.setText("Primeiro preencha os campos!");
        }
    }
    public boolean validacampos (String pAl,String pGa){
        boolean camposvalida= true;
        if (pAl == null || pAl.equals("")){
            camposvalida = false;
        }else if(pGa ==null || pGa.equals("")){
            camposvalida = false;
        }
        return  camposvalida;
    }
}
