/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.cinema.model.javabeans;

import java.io.Serializable;

/**
 *
 * @author Paulo
 */
public class Gerente extends Funcionario implements Serializable{

    public Gerente(String nome, String senha) {
        super(nome, senha);
    }

    public Gerente(int id, String nome, String senha) {
        super(id, nome, senha);
    }
    
}
