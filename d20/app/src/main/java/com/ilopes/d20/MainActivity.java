package com.ilopes.d20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void opselec(View view){

        TextView text = findViewById(R.id.textex);
        int numb = new Random().nextInt(20);
        text.setText(""+(numb+1));

    }
}
