package com.ilopes.organizzeclone.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.ilopes.organizzeclone.R;
import com.ilopes.organizzeclone.config.ConfigFirebase;
import com.ilopes.organizzeclone.helper.Base64Custom;
import com.ilopes.organizzeclone.helper.DataUtil;
import com.ilopes.organizzeclone.model.Movimentacao;
import com.ilopes.organizzeclone.model.User;

public class DespesasActivity extends AppCompatActivity {

    private TextInputEditText campodata,campocategoria,campodescrição;
    private EditText campovalor;
    private Movimentacao movimentacao;
    private DatabaseReference reference= ConfigFirebase.getReference();
    private FirebaseAuth auth = ConfigFirebase.getAuth();
    private double despesatotal ,despesaatt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_despesas);
        campovalor = findViewById(R.id.editValor);
        campodata = findViewById(R.id.editData);
        campocategoria = findViewById(R.id.editCategoria);
        campodescrição = findViewById(R.id.editDescricao);

        //Preenche o campo data com a data atual
        campodata.setText(DataUtil.dataAtual());
        recuperarDespesaTotal();
    }
    public void Salvardespesa (View view){
        if(validarcamposDespesa()){
            movimentacao = new Movimentacao(campodata.getText().toString(),
                    campocategoria.getText().toString(),
                    campodescrição.getText().toString(),
                    "d",
                    Double.parseDouble(campovalor.getText().toString())
            );
            despesaatt = despesatotal + Double.parseDouble(campovalor.getText().toString());
            attdespesa();
            movimentacao.salvar();
            finish();
        }

    }

    public Boolean validarcamposDespesa (){

        String Textodata = campodata.getText().toString();
        String Textocategoria = campocategoria.getText().toString();
        String Textodescricao = campodescrição.getText().toString();
        String TextoValor = campovalor.getText().toString();

        if(!Textodata.isEmpty()){
            if(!Textocategoria.isEmpty()){
                if(!Textodescricao.isEmpty()){
                    if(!TextoValor.isEmpty()){
                        return true;
                    }else{
                        Toast.makeText(DespesasActivity.this, "Preencha o valor!", Toast.LENGTH_SHORT).show();
                        return false;
                    }
                }else{
                    Toast.makeText(DespesasActivity.this, "Preencha a descrição!", Toast.LENGTH_SHORT).show();
                    return false;
                }
            }else{
                Toast.makeText(DespesasActivity.this, "Preencha a categoria!", Toast.LENGTH_SHORT).show();
                return false;
            }
        }else{
            Toast.makeText(DespesasActivity.this, "Preencha a data!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    public void recuperarDespesaTotal(){
        String emailuser =auth.getCurrentUser().getEmail();
        String iduser = Base64Custom.encode64(emailuser);
        DatabaseReference userref = reference.child("users").child(iduser);
        userref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);

                despesatotal = user.getDespesatotal();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    public void attdespesa(){
        String emailuser =auth.getCurrentUser().getEmail();
        String iduser = Base64Custom.encode64(emailuser);
        DatabaseReference userref = reference.child("users").child(iduser);
        userref.child("despesatotal").setValue(despesaatt);
    }

}
