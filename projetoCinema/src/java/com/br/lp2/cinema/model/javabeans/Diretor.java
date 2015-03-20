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
    private String id;
    
    


    public Diretor(String nome, String id, int pk) {
        this.nome = nome;
        this.id = id;
        this.pk = pk;
    }

    public String getNome() {
        return nome;
    }

    public int getPk() {
        return pk;
    }
    
    public String getId(){
        return this.id;
    }

    @Override
    public String toString() {
        return "[Nome: "+this.nome+","+"PK: "+this.pk+"]";
    }
    
    
    
    
    
}
