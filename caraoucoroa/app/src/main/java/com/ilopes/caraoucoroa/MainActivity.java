package com.ilopes.caraoucoroa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button enviar;
    private int cara;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enviar = findViewById(R.id.Enviar);
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), ResultadoActivity.class);
                cara = new Random().nextInt(2);
                intent.putExtra("lado",cara);
                startActivity(intent);

            }
        });
    }
}
