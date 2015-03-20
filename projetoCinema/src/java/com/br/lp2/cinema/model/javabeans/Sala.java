/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.cinema.model.javabeans;

/**
 *
 * @author 31448471
 */
public class Sala {
    private int pk;
    private int num;
    private int lotacao;
    private int poltEsp;
    public enum Estados { MANUTENCAO, OCUPADO, LIVRE; }
    private Estados estadoSala;

    public Sala(int pk, int num, int lotacao, int poltEsp, Estados estadoSala) {
        this.pk = pk;
        this.num = num;
        this.lotacao = lotacao;
        this.poltEsp = poltEsp;
        this.estadoSala = estadoSala;
    }

    @Override
    public String toString() {
        return "Sala{" + "pk=" + pk + ", num=" + num + ", lotacao=" + lotacao + ", poltEsp=" + poltEsp + ", estadoSala=" + estadoSala + '}';
    }
    
    

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getLotacao() {
        return lotacao;
    }

    public void setLotacao(int lotacao) {
        this.lotacao = lotacao;
    }

    public int getPoltEsp() {
        return poltEsp;
    }

    public void setPoltEsp(int poltEsp) {
        this.poltEsp = poltEsp;
    }

    public Estados getEstadoSala() {
        return estadoSala;
    }

    public void setEstadoSala(Estados estadoSala) {
        this.estadoSala = estadoSala;
    }
    
    
    
    
}
