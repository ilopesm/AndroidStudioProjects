package com.ilopes.intarfacetst;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText cnome;
    private EditText cemail;
    private TextView resultado;
    private CheckBox vermelho, branco, verde;
    private RadioButton m, f;
    private RadioGroup sex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         cnome = findViewById(R.id.editNome);
         cemail = findViewById(R.id.editEmail);
         resultado = findViewById(R.id.textResult);
         vermelho = findViewById(R.id.checkVermelho);
         verde = findViewById(R.id.checkVerde);
         branco = findViewById(R.id.checkBranco);
         m = findViewById(R.id.radioButtonM);
         f = findViewById(R.id.radioButtonF);
         sex = findViewById(R.id.sexo);
         sexo();
    }
    public void checkbox(){
        String textr ="";
        if (verde.isChecked()){
            textr = verde.getText().toString();
        }
        if(branco.isChecked()){
            textr = textr + branco.getText().toString();;
        }
        if(vermelho.isChecked()){
            textr = textr + vermelho.getText().toString();;
        }

        //else{
            //textr = "nenhuma opcao selecionada";
        //}
        resultado.setText(textr);
    }
    public void sexo(){
        sex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.radioButtonM){
                    resultado.setText("Masculino");
                }else if(checkedId == R.id.radioButtonF){
                    resultado.setText("Feminino");
                }
            }
        });
        /*
        if (m.isChecked()){
            resultado.setText("Sexo Masculino");
        }
        else if (f.isChecked()){
            resultado.setText("Sexo Feminino");
        }
        else{
            resultado.setText("Escolha um sexo");
        }*/
    }
    public void enviar(View view){

         sexo();
         /*
        checkbox();
        String nome = cnome.getText().toString();
        String email = cemail.getText().toString();
        String textr = "Nome: " + nome + " Email: " + email;
        resultado.setText("Nome: " + nome + " Email: " + email);
        */

    }
    public void limpar(View view){

        cnome.setText("");
        cemail.setText("");

    }

}
