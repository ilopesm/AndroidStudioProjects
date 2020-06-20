package com.ilopes.gorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private EditText valorin;
    private SeekBar seekpor;
    private TextView textpor;
    private TextView textgor;
    private TextView texttotal;
    private double porcentagem = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        valorin= findViewById(R.id.editvalor);
        seekpor = findViewById(R.id.seekPorcen);
        textpor = findViewById(R.id.textPorce);
        texttotal = findViewById(R.id.textTotal);
        textgor = findViewById(R.id.textGorj);
        seekpor.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                porcentagem = progress;
                textpor.setText(Math.round(porcentagem)+"%");
                calcular();
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    public void calcular(){

        String valorecu = valorin.getText().toString();
        if (valorecu == null|| valorecu.equals("")){

            Toast.makeText(this, "Digite o valor primeiro!", Toast.LENGTH_SHORT).show();

        }
        else{

            double valordigitado = Double.parseDouble(valorecu);
            textgor.setText("R$"+(valordigitado*(porcentagem/100)));
            texttotal.setText("R$"+(valordigitado+(valordigitado*(porcentagem/100))));

        }
    }
}
