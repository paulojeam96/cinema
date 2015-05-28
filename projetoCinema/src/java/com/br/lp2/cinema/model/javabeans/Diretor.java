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
 * @version 1.0
 */
public class Diretor implements Serializable{
    private String nome;
    private  int pk; //Identificador, Primary Key
    private int id;
    
    


    public Diretor(String nome, int id, int pk) {
        this.nome = nome;
        this.id = id;
        this.pk = pk;
    }

    public Diretor(int diretor) {
        this.pk = diretor;
    }

    public String getNome() {
        return nome;
    }

    public int getPk() {
        return pk;
    }
    
    public int getId(){
        return this.id;
    }

    @Override
    public String toString() {
        return this.nome;
    }
    
    
    
    
    
}
