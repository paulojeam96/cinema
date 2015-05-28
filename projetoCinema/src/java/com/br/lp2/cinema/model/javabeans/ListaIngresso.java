package com.br.lp2.cinema.model.javabeans;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author 31448471
 * @version 1.0
 */
public class ListaIngresso implements Serializable{
    private int pk;
    private ArrayList<Ingresso> lista;

    public ListaIngresso(int pk) {
        this.pk = pk;
    }

    public ListaIngresso(int pk, ArrayList<Ingresso> lista) {
        this.pk = pk;
        this.lista = lista;
    }
    
    
    public ListaIngresso(){
        lista = new ArrayList<Ingresso>();
    }
    
    public void addIngresso(Ingresso ingresso){
        lista.add(ingresso);
    }

    public ArrayList<Ingresso> getLista() {
        return lista;
    }

    public int getPk() {
        return pk;
    }

    
    @Override
    public String toString() {
        return "ListaIngresso{" + "pk=" + pk + ", lista=" + lista + '}';
    }
    
    
}
