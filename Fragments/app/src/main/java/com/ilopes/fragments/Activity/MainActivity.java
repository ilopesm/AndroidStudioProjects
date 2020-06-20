package com.ilopes.fragments.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.ilopes.fragments.R;
import com.ilopes.fragments.fragment.ContatosFragment;
import com.ilopes.fragments.fragment.ConversasFragment;

public class MainActivity extends AppCompatActivity {

    private Button bconversa;
    private Button bcontatos;
    private ConversasFragment conversasFragment;
    private ContatosFragment contatosFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //remover sombra actionbar
        getSupportActionBar().setElevation(0);

        bconversa = findViewById(R.id.buttonConversas);
        bcontatos = findViewById(R.id.buttonContatos);

        conversasFragment = new ConversasFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameconteudo , conversasFragment );
        transaction.commit();


        bcontatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contatosFragment = new ContatosFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameconteudo, contatosFragment);
                transaction.commit();

            }
        });
        bconversa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conversasFragment = new ConversasFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameconteudo , conversasFragment );
                transaction.commit();

            }
        });
    }
}
