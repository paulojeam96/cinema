/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.cinema.model.javabeans;

import java.io.Serializable;

/**
 * Informações sobre a participação do Ator em um Filme 
 * @author PauloJeam
 * @version 1.0
 */
public class InfoAtor implements Serializable{
    private Ator ator;
    private String papel;
    private String part;

    /**
     * 
     * @param ator Ator 
     * @param papel Personagem apresentado
     * @param part  Participação do Filme (coadjuvante, principal, figurante)
     */
    public InfoAtor(Ator ator, String papel, String part) {
        this.ator = ator;
        this.papel = papel;
        this.part = part;
    }

    public Ator getAtor() {
        return ator;
    }

    public void setAtor(Ator ator) {
        this.ator = ator;
    }

    public String getPapel() {
        return papel;
    }

    public void setPapel(String papel) {
        this.papel = papel;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    @Override
    public String toString() {
        return "InfoAtor{" + "ator=" + ator + ", papel=" + papel + ", part=" + part + '}';
    }
    
    
    
    
    
}
