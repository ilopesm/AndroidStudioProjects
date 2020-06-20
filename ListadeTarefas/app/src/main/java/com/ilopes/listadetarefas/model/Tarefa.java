package com.ilopes.listadetarefas.model;

import java.io.Serializable;

public class Tarefa implements Serializable {
    private Long id;
    private String nometarefa;

    public Tarefa() {

    }

    public Tarefa(Long id, String nometarefa) {
        this.id = id;
        this.nometarefa = nometarefa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNometarefa() {
        return nometarefa;
    }

    public void setNometarefa(String nometarefa) {
        this.nometarefa = nometarefa;
    }
}
