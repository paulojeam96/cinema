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
public class User {

    private String nome;  //Nome usuario
    private String pass1; //senha 1
    private String pass2; //senha 2
    private String cargo; //cargo do usuario
    private int cod;      //Codigo do usuario

    public User(int cod) {
        this.cod = cod;
    }

    public User(String nome, String pass1, String pass2) {
        this.nome = nome;
        this.pass1 = pass1;
        this.pass2 = pass2;
    }

    public User(String nome, String pass1, String pass2, String cargo, int cod) {
        this.nome = nome;
        this.pass1 = pass1;
        this.pass2 = pass2;
        this.cargo = cargo;
        this.cod = cod;
    }


    //Verifica o codigo do usuario
    public boolean verificaCod(int codigo) {
        boolean v = false; //Cria variavel incial como false, caso encontre o codigo valor passa a ser = true
        GerenteDAO gDao = new GerenteDAOConcreto();
        ArrayList<Gerente> gerentes = gDao.readGerente();
         for (Gerente user : gerentes) {
            if(user.getPk() == codigo)
                v = true;
        }
        return v;

    }

    public boolean verificaGerente(int codigo) {
        
        boolean v = false;
        GerenteDAO gDao = new GerenteDAOConcreto();
        ArrayList<Gerente> listaG = gDao.readGerente();
        for (Gerente gerente : listaG) {
            if (gerente.getPk() == codigo) {
                v = true;
                break;
            }
            
        }
        return v;
    }
    
    public boolean verificaAtendente(int codigo){
        boolean v = false;
        AtendenteDAO aDao = new AtendenteDAOConcreto();
            ArrayList<Atendente> listaA = aDao.readAtendente();
            for (Atendente atendente : listaA) {
                if (atendente.getPk() == codigo) {
                    v = true;
                    break;
                }
            }
        return v;
    }
    
    
    
    

    public boolean verificaUsuario() {
        GerenteDAO gDao = new GerenteDAOConcreto();
        ArrayList<Gerente> listaG = gDao.readGerente();
        AtendenteDAO aDao = new AtendenteDAOConcreto();
        ArrayList<Atendente> listaA = aDao.readAtendente();

        boolean v = true;
        for (Gerente gerente : listaG) {
            if (gerente.getNome().equals(nome)) {
                v = false;
                break;
            }
        }
        if (!v) {
            for (Atendente atendente : listaA) {
                if (atendente.getNome().equals(nome)) {
                    v = false;
                    break;
                }
            }
        }
        return v;
    }

    public boolean verificaSenha() {
        if (this.pass1.equals(pass2)) {
            return true;
        }
        return false;
    }
}
