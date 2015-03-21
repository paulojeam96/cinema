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
    
    public ListaIngresso(){
        lista = new ArrayList<Ingresso>();
    }
    
    public void addIngresso(Ingresso ingresso){
        lista.add(ingresso);
    }
    
    public void removeIngresso(Ingresso ingresso){
        for (Ingresso i : lista) {
            if(i.compara(ingresso)) lista.remove(ingresso);
        }
    }
    
    public void trocaIngresso(Ingresso i1, Ingresso i2){
        removeIngresso(i1);
        addIngresso(i2);
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
