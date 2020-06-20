package com.ilopes.bancodedadossqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{
            //cria o bd
            SQLiteDatabase bd = openOrCreateDatabase("app", MODE_PRIVATE,null);

            //criar tabela
            bd.execSQL("CREATE TABLE IF NOT EXISTS pessoas (id INTEGER PRIMARY KEY AUTOINCREMENT,nome VARCHAR,idade INT(3))");
            //bd.execSQL("DROP TABLE pessoas");


            //inserir registros
            //bd.execSQL("INSERT INTO pessoas(nome,idade)VALUES ('Mario',18)");
            //bd.execSQL("INSERT INTO pessoas(nome,idade)VALUES ('Pedro',50)");

            //Fazer updates
            //bd.execSQL("UPDATE pessoas SET idade = 19 WHERE nome = 'Mariana'");
            //bd.execSQL("DELETE FROM pessoas WHERE id >2 ");

            //recuperar pessoas
            /*String consulta =
                    "SELECT nome,idade" +
                    " FROM pessoas WHERE idade IN(18,40) ";*/
            /*String consulta =
                    "SELECT nome,idade" +
                    " FROM pessoas WHERE idade BETWEEN 18 AND 45 ";*/
            /*String Filtro = "mar";
            String consulta =
                    "SELECT nome,idade" +
                            " FROM pessoas WHERE nome LIKE '%"+Filtro+"%' ";*/
            String consulta =
                    "SELECT *" +
                            " FROM pessoas WHERE 1=1";
            Cursor cursor = bd.rawQuery(consulta,null);
            int indiceid = cursor.getColumnIndex("id");
            int indicenome = cursor.getColumnIndex("nome");
            int indiceidade = cursor.getColumnIndex("idade");

            cursor.moveToFirst();

            while(cursor!=null){
                String id = cursor.getString(indiceid);
                String nome = cursor.getString(indicenome);
                String idade = cursor.getString(indiceidade);

                Log.i("Resultado - id" ,id+" /nome: " + nome+" /idade:"+idade+"");
                cursor.moveToNext();
            }

        }catch(Exception e){
            e.printStackTrace();
        }


    }
}
