/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.cinema.model.javabeans;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author 31448471
 * @version 1.0
 */
public class Ator implements Serializable{

    private String nome;
    private Date dataNascimento;
    private String nascionalidade;
    private int pk;
            
            
    
   
    public Ator(String nome, Date dataNascimento, String nascionalidade, int pk) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.nascionalidade = nascionalidade;
        this.pk = pk;
    } 

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setNascionalidade(String nascionalidade) {
        this.nascionalidade = nascionalidade;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }
    
    public String getNome() {
        return nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public String getNascionalidade() {
        return nascionalidade;
    }

    public int getPk() {
        return pk;
    }

    @Override
    public String toString() {
        return "[nome= " + this.nome + ", dataNascimento= " + this.dataNascimento + ", nascionalidade= " + this.nascionalidade + ", pk= " + this.pk + '}';
    }
    
    public boolean compara(Ator a){
        
        //If é redundante, nesse caso ele já retorna a informação direto sm precisar fazer o uso do IF...
        return a.getPk() == this.pk && a.getDataNascimento() == this.dataNascimento && a.getNascionalidade().equalsIgnoreCase(this.nascionalidade) && a.getNome().equalsIgnoreCase(this.nome);
    }
    

    
}