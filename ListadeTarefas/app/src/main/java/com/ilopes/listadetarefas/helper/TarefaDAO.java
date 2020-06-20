package com.ilopes.listadetarefas.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.ilopes.listadetarefas.model.Tarefa;

import java.util.ArrayList;
import java.util.List;

public class TarefaDAO implements iTarefaDAO {

    private SQLiteDatabase escreve;
    private SQLiteDatabase ler;

    public TarefaDAO(Context context) {
        DbHelper db = new DbHelper(context);
        escreve = db.getWritableDatabase();
        ler = db.getReadableDatabase();
    }

    @Override
    public boolean salvar(Tarefa tarefa) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("nome",tarefa.getNometarefa());
        try{
            escreve.insert(DbHelper.TABELA_TAREFAS,null,contentValues);
            Log.i("INFO","TAREFA SALVA COM SUCESSO");
        }catch (Exception e){
            Log.i("INFO", "ERRO AO SALVAR TAREFA"+e.getMessage());
            return false;
        }

        return true;
    }

    @Override
    public boolean atualizar(Tarefa tarefa) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("nome",tarefa.getNometarefa());
        try{
            String[] args = {tarefa.getId().toString()};
            escreve.update(DbHelper.TABELA_TAREFAS,contentValues,"id=?",args);
            Log.i("INFO","TAREFA ATUALIZADA COM SUCESSO");
        }catch (Exception e){
            Log.i("INFO", "ERRO AO ATUALIZAR TAREFA"+e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean deletar(Tarefa tarefa) {

        try{
            String[] args = {tarefa.getId().toString()};
            escreve.delete(DbHelper.TABELA_TAREFAS,"id=?",args);
            Log.i("INFO","TAREFA DELETADA COM SUCESSO");
        }catch (Exception e){
            Log.i("INFO", "ERRO AO DELETAR TAREFA"+e.getMessage());
            return false;
        }

        return true;
    }

    @Override
    public List<Tarefa> listart() {
        List<Tarefa> tarefas = new ArrayList<>();
        String sql = "SELECT * FROM "+DbHelper.TABELA_TAREFAS+";";
        Cursor cursor = ler.rawQuery(sql,null);
        while(cursor.moveToNext()){
            Tarefa tarefa = new Tarefa();
            Long id = cursor.getLong(cursor.getColumnIndex("id"));
            String nome = cursor.getString(cursor.getColumnIndex("nome"));
            tarefa.setId(id);
            tarefa.setNometarefa(nome);
            tarefas.add(tarefa);
        }
        return tarefas;
    }
}
