package com.ilopes.minhasanotaes;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private AnotacoesPreferencias preferencias;
    private EditText anota;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anota = findViewById(R.id.editTexta);
        preferencias = new AnotacoesPreferencias(getApplicationContext());

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textorecup =anota.getText().toString();
                if(textorecup.equals("")){
                    Snackbar.make(view, "Digite uma anotacao!", Snackbar.LENGTH_LONG).show();
                }
                else{

                    preferencias.salvaranot(textorecup);
                    Snackbar.make(view, "Anotacao salva!", Snackbar.LENGTH_LONG).show();

                }

            }
        });

        //recuperar a anotação
        String anotacaoo = preferencias.recuperanot();
        if(!anotacaoo.equals("")){
            anota.setText(anotacaoo);
        }
    }


}
