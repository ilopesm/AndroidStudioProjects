package com.ilopes.organizzeclone.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.heinrichreimersoftware.materialintro.app.IntroActivity;
import com.heinrichreimersoftware.materialintro.slide.FragmentSlide;
import com.ilopes.organizzeclone.R;
import com.ilopes.organizzeclone.activity.CadastroActivity;
import com.ilopes.organizzeclone.activity.LoginActivity;
import com.ilopes.organizzeclone.config.ConfigFirebase;

import java.net.Inet4Address;

public class MainActivity extends IntroActivity {

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        setButtonNextVisible(false);
        setButtonBackVisible(false);

        addSlide(new FragmentSlide.Builder()
                .background(android.R.color.white)
                .fragment(R.layout.intro_1)
                .build()
        );
        addSlide(new FragmentSlide.Builder()
                .background(android.R.color.white)
                .fragment(R.layout.intro_2)
                .build()
        );
        addSlide(new FragmentSlide.Builder()
                .background(android.R.color.white)
                .fragment(R.layout.intro_3)
                .build()
        );
        addSlide(new FragmentSlide.Builder()
                .background(android.R.color.white)
                .fragment(R.layout.intro_4)
                .build()
        );
        addSlide(new FragmentSlide.Builder()
                .background(android.R.color.white)
                .fragment(R.layout.intro_cadastro)
                .canGoForward(false)
                .build()
        );

    }

    public void bentrar(View view){

        startActivity(new Intent(this, LoginActivity.class));

    }
    public void bcadastro(View view){

        startActivity(new Intent(this, CadastroActivity.class));

    }

    public void Verificarusauriologado (){

        auth = ConfigFirebase.getAuth();
        //auth.signOut();
        if(auth.getCurrentUser()!= null){
            abrirTelaprincipal();
        }

    }
    public void abrirTelaprincipal (){
        startActivity(new Intent(this, PrincipalActivity.class));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Verificarusauriologado();
    }
}
