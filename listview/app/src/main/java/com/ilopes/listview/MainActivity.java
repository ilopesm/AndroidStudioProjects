package com.ilopes.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ListView listlocais;
    private String[] locais= {
            "Angra dos Reis","Caldas Novas",
            "Campos do Jordão", "Costa do Sauípe",
            "Ilheus","Porto Seguro","Tiradentes",
            "Praga", "Santiago", "Zurique", "Caribe",
            "Buenos Aires", "Budapeste", "Cancún","Aruba"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listlocais = findViewById(R.id.listLocais);

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                locais
        );
        listlocais.setAdapter(adaptador);
        listlocais.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String Valorselecionado = listlocais.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),Valorselecionado,Toast.LENGTH_SHORT).show();

            }
        });

    }
}
