package com.ilopes.organizzeclone.model;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;
import com.ilopes.organizzeclone.config.ConfigFirebase;

public class User {
    private String nome,email,senha,iduser;
    private Double receitatotal = 00.00;
    private Double despesatotal = 00.00;
    public User() {
    }

    public User(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public void salvar(){
        DatabaseReference reference = ConfigFirebase.getReference();
        reference.child("users")
        .child(this.iduser)
        .setValue(this);
    }

    public Double getReceitatotal() {
        return receitatotal;
    }

    public void setReceitatotal(Double receitatotal) {
        this.receitatotal = receitatotal;
    }

    public Double getDespesatotal() {
        return despesatotal;
    }

    public void setDespesatotal(Double despesatotal) {
        this.despesatotal = despesatotal;
    }

    @Exclude
    public String getIduser() {
        return iduser;
    }

    public void setIduser(String iduser) {
        this.iduser = iduser;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Exclude
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
