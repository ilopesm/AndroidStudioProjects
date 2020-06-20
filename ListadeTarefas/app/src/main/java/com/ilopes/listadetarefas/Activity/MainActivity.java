package com.ilopes.listadetarefas.Activity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.ilopes.listadetarefas.R;
import com.ilopes.listadetarefas.adapter.TarefaAdapter;
import com.ilopes.listadetarefas.helper.DbHelper;
import com.ilopes.listadetarefas.helper.RecyclerItemClickListener;
import com.ilopes.listadetarefas.helper.TarefaDAO;
import com.ilopes.listadetarefas.model.Tarefa;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvlistatarefas;
    private TarefaAdapter adapter;
    private List<Tarefa> listarefa = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //configurar o RV
        rvlistatarefas = findViewById(R.id.TarefasLista);


        //adicionar evento de clique
        rvlistatarefas.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(), rvlistatarefas, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                //recuperando tarefa  para edição
                Tarefa tarefaSelc = listarefa.get(position);

                //enviar tarefa para a tela adcionar tarefa
                Intent intent = new Intent(MainActivity.this,AdicionarTarefaActivity.class);
                intent.putExtra("Tarefaselecionada", tarefaSelc);
                startActivity(intent);

            }

            @Override
            public void onLongItemClick(View view, int position) {
                final Tarefa tarefaSelc = listarefa.get(position);

                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);

                dialog.setTitle("Confirmar exclusão!");
                dialog.setMessage("Deseja excluir a tarefa: "+tarefaSelc.getNometarefa()+" ?");

                dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        TarefaDAO tarefaDAO = new TarefaDAO(getApplicationContext());
                        if(tarefaDAO.deletar(tarefaSelc)){
                            carregalistatafera();
                            Toast.makeText(MainActivity.this, "A tarefa foi excluida com sucesso!", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(MainActivity.this, "Erro ao excluir a tarefa!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                dialog.setNegativeButton("Não", null);

                dialog.create();
                dialog.show();

            }

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        }));


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),AdicionarTarefaActivity.class);
                startActivity(intent);

            }
        });
    }
    public void carregalistatafera(){
        //Listar tarefas
        TarefaDAO tarefaDAO = new TarefaDAO(getApplicationContext());
        listarefa = tarefaDAO.listart();
        //EXIBIR A LISTA NO RV
        //adapter
        adapter = new TarefaAdapter(listarefa);
        //configura o rv
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        rvlistatarefas.setLayoutManager(layoutManager);
        rvlistatarefas.setHasFixedSize(true);
        rvlistatarefas.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));
        rvlistatarefas.setAdapter(adapter);

    }

    @Override
    protected void onStart() {
        carregalistatafera();
        super.onStart();
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
