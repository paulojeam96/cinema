package com.br.lp2.cinema.model.javabeans;

import java.io.Serializable;

/**
 *
 * @author paulojeam
 * @version 1.0
 */
public class Distribuidora implements Serializable{
    private String nome;
    private int id;

    public Distribuidora(String nome, int id) {
        this.nome = nome;
        this.id = id;
    }

    public Distribuidora(int id) {
        this.id=id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int pk) {
        this.id = id;
    }

    @Override
    public String toString() {
        return  nome;
    }
    
    
}
