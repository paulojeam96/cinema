/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.cinema.model.javabeans;

/**
 *
 * @author Paulo
 */
public class Comum {
    private String nome;
    private String senha1;
    private String senha2;
    private int codigo;

    public Comum(String nome, String senha1, String senha2, int codigo) {
        this.nome = nome;
        this.senha1 = senha1;
        this.senha2 = senha2;
        this.codigo = codigo;
    }

    public Comum(String nome, String senha1, int codigo) {
        this.nome = nome;
        this.senha1 = senha1;
        this.codigo = codigo;
    }
    

    public Comum(String nome, int codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }
    
    public Comum(String nome, String senha) {
        this.nome = nome;
        this.senha1 = senha;
    }

    public Comum(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha1() {
        return senha1;
    }

    public void setSenha1(String senha1) {
        this.senha1 = senha1;
    }

    public String getSenha2() {
        return senha2;
    }

    public void setSenha2(String senha2) {
        this.senha2 = senha2;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Comum{" + "nome=" + nome + ", senha1=" + senha1 + ", senha2=" + senha2 + ", codigo=" + codigo + '}';
    }
    
    
    
}
