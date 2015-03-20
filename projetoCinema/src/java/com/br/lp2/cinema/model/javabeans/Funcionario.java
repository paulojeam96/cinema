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
 */
public class Funcionario implements Serializable{
    private int pk;
    private int id;
    private String nome;

    public Funcionario(int pk, int id, String nome) {
        this.pk = pk;
        this.id = id;
        this.nome = nome;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    
}
