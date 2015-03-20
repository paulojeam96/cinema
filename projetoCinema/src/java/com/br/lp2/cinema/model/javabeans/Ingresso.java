package com.br.lp2.cinema.model.javabeans;

import com.br.lp2.cinema.model.javabeans.Cliente.Especiais;
import java.io.Serializable;

/**
 *
 * @author 31448471
 * @version 1.0
 */
public class Ingresso implements Serializable{
    private int pk;
    private int id;
    private boolean inteira;
    private Cliente.Especiais tipo;

    public Ingresso(int pk, int id, boolean inteira, Especiais tipo) {
        this.pk = pk;
        this.id = id;
        this.inteira = inteira;
        this.tipo = tipo;
    }

    public Ingresso(int pk, int id, boolean inteira) {
        this.pk = pk;
        this.id = id;
        this.inteira = inteira;
        this.tipo = Cliente.Especiais.GERAL;
    }

    public Ingresso(int pk, int id) {
        this.pk = pk;
        this.id = id;
        this.inteira = true;
        this.tipo = Cliente.Especiais.GERAL;
    }

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isInteira() {
        return inteira;
    }

    public void setInteira(boolean inteira) {
        this.inteira = inteira;
    }

    public Especiais getTipo() {
        return tipo;
    }

    public void setTipo(Especiais tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Ingresso{" + "pk=" + pk + ", id=" + id + ", inteira=" + inteira + ", tipo=" + tipo + '}';
    }
    
    public boolean compara(Ingresso i){
        return (this.pk == i.getPk() && this.id == i.getId() && this.inteira == i.isInteira() && this.tipo == i.getTipo());
    }
    
}
