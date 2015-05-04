package com.br.lp2.cinema.model.javabeans;

import java.io.Serializable;

/**
 *
 * @author paulojeam
 * @version 1.0
 */
public class Distribuidora implements Serializable{
    private String nome;
    private int pk;

    public Distribuidora(String nome, int pk) {
        this.nome = nome;
        this.pk = pk;
    }

    public Distribuidora(int dist) {
        this.pk=pk;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    @Override
    public String toString() {
        return "Distribuidora{" + "nome=" + nome + ", pk=" + pk + '}';
    }
    
    
}
