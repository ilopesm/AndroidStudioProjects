package com.ilopes.cardview.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ilopes.cardview.Model.Postagemc;
import com.ilopes.cardview.R;

import java.util.List;

public class postagemAdapter extends RecyclerView.Adapter<postagemAdapter.MyViewHolder> {

    private List<Postagemc> listpostagem;

    public postagemAdapter(List<Postagemc> p) {
        this.listpostagem = p;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.postagem_detalhe, parent,false);
        return new MyViewHolder(itemLista);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Postagemc postagem = listpostagem.get(position);
        holder.nome.setText(postagem.getNome());
        holder.data.setText(postagem.getData());
        holder.postagem.setText(postagem.getPostamge());
        holder.imagem.setImageResource(postagem.getImagem());

    }

    @Override
    public int getItemCount() {
        return listpostagem.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView nome;
        private TextView postagem;
        private ImageView imagem;
        private TextView data;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nome = itemView.findViewById(R.id.textUser);
            postagem = itemView.findViewById(R.id.textPostagem);
            data = itemView.findViewById(R.id.textData);
            imagem = itemView.findViewById(R.id.imagePostagem);

        }
    }

}
