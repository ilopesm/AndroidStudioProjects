package com.ilopes.cardview.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.ilopes.cardview.Adapter.postagemAdapter;
import com.ilopes.cardview.Model.Postagemc;
import com.ilopes.cardview.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Postagemc> postagens = new ArrayList<>();
    private RecyclerView postagem ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        postagem = findViewById(R.id.recyclerPostagem);

        //definir layout
        //RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        //LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //layoutManager.setOrientation(LinearLayout.HORIZONTAL);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        postagem.setLayoutManager(layoutManager);
        //adapter
        this.prepararpostagem();
        postagemAdapter adapter = new postagemAdapter(postagens);
        postagem.setAdapter(adapter);
    }
    public void prepararpostagem(){
        Postagemc p = new Postagemc("Ilopes","Agora Mesmo","To de ferias patrao",R.drawable.imagem1);
        this.postagens.add(p);
        p = new Postagemc("Rodrigo Faro","há uma hora","Safe do Safe",R.drawable.imagem2);
        this.postagens.add(p);
        p = new Postagemc("DogaShow","há uma semana","Cebolão é nosso",R.drawable.imagem3);
        this.postagens.add(p);
        p = new Postagemc("Silvazuao","há um mês","Hq de briga é bom dms",R.drawable.imagem4);
        this.postagens.add(p);
    }
}
