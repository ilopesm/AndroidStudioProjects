package com.ilopes.meczap.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ilopes.meczap.R;
import com.ilopes.meczap.activity.CadastroActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void abrecadastro(View view){
        startActivity(new Intent(this, CadastroActivity.class));
    }

}
