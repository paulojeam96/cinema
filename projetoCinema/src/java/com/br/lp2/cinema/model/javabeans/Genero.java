/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.cinema.model.javabeans;

import java.io.Serializable;

/**
 *
 * @author 31448471
 * @version 2.0
 */
public class Genero implements Serializable{
    private int id; //Primary Key
    private String nome;

    public Genero(String nome) {
        this.nome = nome;
    }

    public Genero(int pk, String nome) {
        this.id = pk;
        this.nome = nome;
    }

    public Genero(int genero) {
        this.id = genero;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return this.nome;
    }
    
    
}
