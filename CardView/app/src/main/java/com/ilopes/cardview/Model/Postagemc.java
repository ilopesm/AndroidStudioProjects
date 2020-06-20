package com.ilopes.cardview.Model;

public class Postagemc {
    private String nome;
    private String data;
    private String postamge;
    private int imagem;

    public Postagemc(){

    }

    public Postagemc(String nome, String data, String postamge, int imagem) {
        this.nome = nome;
        this.data = data;
        this.postamge = postamge;
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getPostamge() {
        return postamge;
    }

    public void setPostamge(String postamge) {
        this.postamge = postamge;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }
}
