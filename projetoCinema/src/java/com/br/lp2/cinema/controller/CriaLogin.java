/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.cinema.controller;

import com.br.lp2.cinema.model.DAO.AtendenteDAO;
import com.br.lp2.cinema.model.DAO.AtendenteDAOConcreto;
import com.br.lp2.cinema.model.DAO.GerenteDAO;
import com.br.lp2.cinema.model.DAO.GerenteDAOConcreto;
import com.br.lp2.cinema.model.javabeans.Atendente;
import com.br.lp2.cinema.model.javabeans.Gerente;
import java.util.ArrayList;

/**
 *
 * @author Paulo
 */
public class CriaLogin {
    private String nome;
    private String senha;

    public CriaLogin(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public boolean isGerente(){
        GerenteDAO g = new GerenteDAOConcreto();
        ArrayList<Gerente> lista = g.readGerente();
        boolean v = false;
        for (Gerente gr : lista) {
            if(gr.getNome().equals(nome) && gr.getSenha().equals(senha)){    
                v = true;
                break;
            } 
        }
        return v;
    }
    
    public boolean isAtendente(){
        AtendenteDAO a = new AtendenteDAOConcreto();
        ArrayList<Atendente> lista = a.readAtendente();
        
        boolean v = false;
        if(!v){
            for (Atendente at : lista) {
                if(at.getNome().equals(nome) && at.getSenha().equals(senha)){    
                    v = true;
                    break;
                } 
            }
        }
        return v;
    }

    public String getUsuario() {
        return nome;
    }

    public boolean isNormal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
