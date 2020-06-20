package com.ilopes.listadetarefas.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.ilopes.listadetarefas.R;
import com.ilopes.listadetarefas.helper.TarefaDAO;
import com.ilopes.listadetarefas.model.Tarefa;

public class AdicionarTarefaActivity extends AppCompatActivity {
    private TextInputEditText editTarefa;
    private Tarefa tarefaAtual;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_tarefa);
        editTarefa = findViewById(R.id.inputTarefa);
        //recupera tarefa caso seja edição
        tarefaAtual = (Tarefa) getIntent().getSerializableExtra("Tarefaselecionada");

        //configurar caixa de txt
        if(tarefaAtual!= null){
            editTarefa.setText(tarefaAtual.getNometarefa());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_adicionar_tarefa, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemsalvar:
                //Executar ação para o item salvar
                TarefaDAO tarefaDAO = new TarefaDAO(getApplicationContext());
                if(tarefaAtual!=null){
                    String nometarefa = editTarefa.getText().toString();
                    if(!nometarefa.isEmpty()){
                        Tarefa tarefa = new Tarefa();
                        tarefa.setNometarefa(nometarefa);
                        tarefa.setId(tarefaAtual.getId());

                        //atualizar bd
                        if(tarefaDAO.atualizar(tarefa)){
                            finish();
                            Toast.makeText(this, "Sucesso ao atualizar tarefa!", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(this, "Erro ao atualizar a tarefa!", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(this, "Digite o nome da tarefa!", Toast.LENGTH_SHORT).show();
                    }


                }else{//salvar

                    String nometarefa = editTarefa.getText().toString();
                    if(!nometarefa.isEmpty()){
                        Tarefa tarefa = new Tarefa();
                        tarefa.setNometarefa(nometarefa);
                        if(tarefaDAO.salvar(tarefa)){
                            finish();
                            Toast.makeText(this, "Sucesso ao salvar tarefa!", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(this, "Erro ao salvar a tarefa!", Toast.LENGTH_SHORT).show();
                        }

                    }else{
                        Toast.makeText(this, "Digite o nome da tarefa!", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
