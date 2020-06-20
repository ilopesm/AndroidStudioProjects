package com.ilopes.recyclerview.activity.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ilopes.recyclerview.R;
import com.ilopes.recyclerview.activity.model.Filme;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    private List<Filme> listafilme;
    public Adapter(List<Filme> listafilmes) {
        this.listafilme = listafilmes;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemlista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_lista,parent,false);

        return new MyViewHolder(itemlista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Filme filme = listafilme.get(position);
        holder.Titulo.setText(filme.getTitulo());
        holder.ano.setText(filme.getAno());
        holder.Genero.setText(filme.getGenero());
    }

    @Override
    public int getItemCount() {
        return listafilme.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView Titulo;
        TextView ano;
        TextView Genero;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Titulo = itemView.findViewById(R.id.textTitulo);
            ano = itemView.findViewById(R.id.textAno);
            Genero = itemView.findViewById(R.id.textGenero);
        }

    }

}
