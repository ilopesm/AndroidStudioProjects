package com.ilopes.organizzeclone.model;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.ilopes.organizzeclone.config.ConfigFirebase;
import com.ilopes.organizzeclone.helper.Base64Custom;
import com.ilopes.organizzeclone.helper.DataUtil;

public class Movimentacao {
    private String data,categoria,decricao,tipo,key;
    private double valor;

    public Movimentacao() {
    }

    public Movimentacao(String data, String categoria, String decricao, String tipo, double valor) {
        this.data = data;
        this.categoria = categoria;
        this.decricao = decricao;
        this.tipo = tipo;
        this.valor = valor;
        this.key = key;
    }
    public void salvar(){
        FirebaseAuth auth = ConfigFirebase.getAuth();
        DatabaseReference reference = ConfigFirebase.getReference();
        reference.child("movimentacao")
                .child(Base64Custom.encode64(auth.getCurrentUser().getEmail()))
                .child(DataUtil.mesAnoDataescolhida(this.data))
                .push()
                .setValue(this);

    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDecricao() {
        return decricao;
    }

    public void setDecricao(String decricao) {
        this.decricao = decricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
