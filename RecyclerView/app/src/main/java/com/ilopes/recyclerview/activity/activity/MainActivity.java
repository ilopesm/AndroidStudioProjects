package com.ilopes.recyclerview.activity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.ilopes.recyclerview.R;
import com.ilopes.recyclerview.activity.RecyclerItemClickListener;
import com.ilopes.recyclerview.activity.adapter.Adapter;
import com.ilopes.recyclerview.activity.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView lista;
    private List<Filme> listafilmes= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.recyclerView);
        //lista de filme
        this.criarfilmes();

        //adapter
        Adapter adapter = new Adapter(listafilmes);
        //configurar
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        lista.setLayoutManager(layoutManager);
        lista.setHasFixedSize(true);
        lista.addItemDecoration( new DividerItemDecoration(this, LinearLayout.VERTICAL));
        lista.setAdapter(adapter);

        //evento de clique
        lista.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(),lista, new RecyclerItemClickListener.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onItemClick(View view, int position) {
                Filme filme = listafilmes.get(position);
                Toast.makeText(MainActivity.this, " Selecionado "+ filme.getTitulo(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongItemClick(View view, int position) {
                Filme filme = listafilmes.get(position);
                Toast.makeText(MainActivity.this, "Click Longo "+ filme.getTitulo(), Toast.LENGTH_SHORT).show();
            }
        }));
    }

    public void criarfilmes(){

        Filme filme = new Filme("Miranha","Ação","2017");
        this.listafilmes.add(filme);

        filme = new Filme("Test01","terror","2010");
        this.listafilmes.add(filme);

        filme = new Filme("Test02","Ação","2001");
        this.listafilmes.add(filme);

        filme = new Filme("Test03","Comedia","2005");
        this.listafilmes.add(filme);

        filme = new Filme("Test04","Ação","2012");
        this.listafilmes.add(filme);

        filme = new Filme("Test05","Terror","2000");
        this.listafilmes.add(filme);

        filme = new Filme("Test06","Comedia","2005");
        this.listafilmes.add(filme);

    }
}
