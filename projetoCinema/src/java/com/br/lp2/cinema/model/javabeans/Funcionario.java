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
public class Funcionario implements Serializable {

    private int pk;
    private String nome;
    private String senha;

    public Funcionario(String nome, String senha) {
        this.senha = senha;
        this.nome = nome;
    }

    public Funcionario(int pk, String nome, String senha) {
        this.pk = pk;
        this.nome = nome;
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
