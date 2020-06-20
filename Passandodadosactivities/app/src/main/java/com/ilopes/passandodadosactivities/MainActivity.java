package com.ilopes.passandodadosactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button butao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        butao = findViewById(R.id.buttonEnviar);
        butao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),SegundaActivity.class);

                //instaciar objt
                User user = new User("Ilopes", "ilopesadventure@gmail.com");

                //passar dados
                intent.putExtra("nome","Ilopes");
                intent.putExtra("idade",22);
                intent.putExtra("obj",user);
                //começa a activity
                startActivity(intent);

            }
        });
    }
}
