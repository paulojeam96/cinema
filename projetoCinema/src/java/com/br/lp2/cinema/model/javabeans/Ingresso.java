package com.br.lp2.cinema.model.javabeans;

import com.br.lp2.cinema.model.javabeans.Cliente.Especiais;
import java.io.Serializable;

/**
 *
 * @author 31448471
 * @version 1.0
 */
public class Ingresso implements Serializable{
    private int id;
    private Filme id_filme;
    private boolean inteira;

    public Ingresso(int id, Filme id_filme, boolean inteira) {
        this.id = id;
        this.id_filme = id_filme;
        this.inteira = inteira;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Filme getId_filme() {
        return id_filme;
    }

    public void setId_filme(Filme id_filme) {
        this.id_filme = id_filme;
    }

    public boolean isInteira() {
        return inteira;
    }

    public void setInteira(boolean inteira) {
        this.inteira = inteira;
    }

    @Override
    public String toString() {
        return "id=" + id + ", filme=" + id_filme + ", inteira=" + inteira;
    }
    
   
}
