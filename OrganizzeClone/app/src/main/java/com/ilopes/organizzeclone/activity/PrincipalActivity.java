package com.ilopes.organizzeclone.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.ilopes.organizzeclone.Adapter.AdapterMovimentacao;
import com.ilopes.organizzeclone.R;
import com.ilopes.organizzeclone.config.ConfigFirebase;
import com.ilopes.organizzeclone.helper.Base64Custom;
import com.ilopes.organizzeclone.model.Movimentacao;
import com.ilopes.organizzeclone.model.User;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnMonthChangedListener;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class PrincipalActivity extends AppCompatActivity {

    private MaterialCalendarView materialCalendarView;
    private TextView textoSaudacao, textoSaldo;
    private Double despesatotal = 0.00;
    private Double receitatotal = 0.00;
    private Double resumouser = 0.00;
    private FirebaseAuth auth =  ConfigFirebase.getAuth();
    private DatabaseReference reference = ConfigFirebase.getReference();
    private DatabaseReference movimentacaoref;
    private DatabaseReference usereference = reference.child("users").child(Base64Custom.encode64(auth.getCurrentUser().getEmail()));
    private ValueEventListener valueEventListenerUser;
    private ValueEventListener valueEventListenermovi;

    private RecyclerView recyclerView;
    private AdapterMovimentacao adapterMovimentacao;
    private List<Movimentacao> movimentacaos = new ArrayList<>();
    private Movimentacao movimentacao;

    private String mesanoSelec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Organizze");
        setSupportActionBar(toolbar);
        recyclerView = findViewById(R.id.recyclerMovimentos);
        textoSaldo = findViewById(R.id.textSaldo);
        textoSaudacao = findViewById(R.id.textSaudacao);
        materialCalendarView = findViewById(R.id.calendarView);
        configuracalendario();
        swipe();
        adapterMovimentacao = new AdapterMovimentacao(movimentacaos,this);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapterMovimentacao);

    }

    public void swipe(){

        ItemTouchHelper.Callback itemTouch = new ItemTouchHelper.Callback() {
            @Override
            public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {

                int dragFlags = ItemTouchHelper.ACTION_STATE_IDLE;
                int swipeFlag = ItemTouchHelper.START | ItemTouchHelper.END;
                return makeMovementFlags(dragFlags,swipeFlag);
            }

            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                excluirmov(viewHolder);
            }
        };
        new ItemTouchHelper(itemTouch).attachToRecyclerView(recyclerView);
    }

    public void excluirmov(final RecyclerView.ViewHolder viewHolder){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Excluir Movimentação da Conta");
        alertDialog.setMessage("Você tem certeza que deseja realmente excluir essa movimentação de sua conta?");
        alertDialog.setCancelable(false);

        alertDialog.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                int position = viewHolder.getAdapterPosition();
                movimentacao = movimentacaos.get(position);
                movimentacaoref = reference.child("movimentacao").child(Base64Custom.encode64(auth.getCurrentUser().getEmail())).child(mesanoSelec);
                movimentacaoref.child(movimentacao.getKey()).removeValue();
                adapterMovimentacao.notifyItemRemoved(position);
                atualizarsaldo();
            }
        });
        alertDialog.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(PrincipalActivity.this, "Cancelado", Toast.LENGTH_SHORT).show();
                adapterMovimentacao.notifyDataSetChanged();
            }
        });
        AlertDialog alert = alertDialog.create();
        alert.show();
    }

    public void atualizarsaldo(){
        if (movimentacao.getTipo().equals("r")){

            receitatotal = receitatotal -movimentacao.getValor();
            usereference.child("receitatotal").setValue(receitatotal);

        }
        if (movimentacao.getTipo().equals("d")){
            despesatotal = despesatotal - movimentacao.getValor();
            usereference.child("despesatotal").setValue(despesatotal);
        }
    }

    public void recuperaMovi(){

        movimentacaoref = reference.child("movimentacao").child(Base64Custom.encode64(auth.getCurrentUser().getEmail())).child(mesanoSelec);

        valueEventListenermovi = movimentacaoref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                movimentacaos.clear();
                for(DataSnapshot dados: dataSnapshot.getChildren()){
                    Movimentacao movimentacao = dados.getValue(Movimentacao.class);
                    movimentacao.setKey(dados.getKey());
                    movimentacaos.add(movimentacao);

                }
                adapterMovimentacao.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    public void recuperaResumo(){

        valueEventListenerUser = usereference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                despesatotal = user.getDespesatotal();
                receitatotal = user.getReceitatotal();
                resumouser = receitatotal - despesatotal;
                DecimalFormat decimalFormat = new DecimalFormat("0.##");
                String resultadoFormat = decimalFormat.format(resumouser);
                textoSaudacao.setText("Olá, "+ user.getNome());
                textoSaldo.setText("R$ "+resultadoFormat);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_principal,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.menuSair:
                auth.signOut();
                startActivity(new Intent(this, MainActivity.class));
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void adicionarreceita(View view){

        startActivity(new Intent(this,ReceitasActivity.class));

    }

    public void adcdespesa(View view){

        startActivity(new Intent(this, DespesasActivity.class));

    }
    public void configuracalendario(){

        CharSequence messes[] = {"Janeiro","Fevereiro","Março","Abril","Maio","Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"};
        materialCalendarView.setTitleMonths(messes);
        CalendarDay dataatual = materialCalendarView.getCurrentDate();
        if(dataatual.getMonth()<10){
            String mes = "0"+dataatual.getMonth();
            mesanoSelec = String.valueOf(mes+""+dataatual.getYear());
        }else {
            mesanoSelec = String.valueOf(dataatual.getMonth() + "" + dataatual.getYear());
        }
        materialCalendarView.setOnMonthChangedListener(new OnMonthChangedListener() {
            @Override
            public void onMonthChanged(MaterialCalendarView widget, CalendarDay date) {
                if(date.getMonth()<10){
                    String mes = "0"+date.getMonth();
                    mesanoSelec = String.valueOf(mes+""+date.getYear());
                }else {
                    mesanoSelec = String.valueOf(date.getMonth() + "" + date.getYear());
                }
                movimentacaoref.removeEventListener(valueEventListenermovi);
                recuperaMovi();
            }
        });
    }



    @Override
    protected void onStop() {

        super.onStop();
        Log.i("onStop","Evento foi removido");
        usereference.removeEventListener(valueEventListenerUser);
        movimentacaoref.removeEventListener(valueEventListenermovi);
    }

    @Override
    protected void onStart() {
        super.onStart();
        recuperaResumo();
        recuperaMovi();
    }
}
