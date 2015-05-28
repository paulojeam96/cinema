/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.cinema.model.javabeans;

import java.io.Serializable;
import java.util.Date;

/**
 * Determina o filme a ser exibido na sala específica
 * @author 31448471
 * @version 1.0
 */
public class Sessao implements Serializable{
    private int pk;
    private Sala sala;
    private Filme filme;
    private String diaHora;
    private boolean legendado;
    private ListaIngresso ingressos;

    public Sessao(int pk) {
        this.pk = pk;
    }

    
    public Sessao(int pk, Sala sala, Filme filme, String diaHora, boolean legendado) {
        this.pk = pk;
        this.sala = sala;
        this.filme = filme;
        this.diaHora = diaHora;
        this.legendado = legendado;
    }

    public Sessao(Filme filme, Sala sala, String diaHora, boolean legendado) {
        this.filme = filme;
        this.sala = sala;
        this.diaHora = diaHora;
        this.legendado = legendado;
    }
    
    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public String getDiaHora() {
        return diaHora;
    }

    public void setDiaHora(String diaHora) {
        this.diaHora = diaHora;
    }

    public boolean isLegendado() {
        return legendado;
    }

    public void setLegendado(boolean legendado) {
        this.legendado = legendado;
    }

    public ListaIngresso getIngressos() {
        return ingressos;
    }
   
    @Override
    public String toString() {
        return "pk=" + pk + "," + sala + ", Filme = " + filme + ", diaHora=" + diaHora + ", legendado=" + legendado + ", ingressos=" + ingressos;
    }
    
    
    
}
