/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.cinema.commands;

import com.br.lp2.cinema.model.DAO.AtendenteDAO;
import com.br.lp2.cinema.model.DAO.AtendenteDAOConcreto;
import com.br.lp2.cinema.model.DAO.GerenteDAO;
import com.br.lp2.cinema.model.DAO.GerenteDAOConcreto;
import com.br.lp2.cinema.model.javabeans.Atendente;
import com.br.lp2.cinema.model.javabeans.Gerente;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Paulo
 */
public class CadastraFuncionario implements Command {

    private String ocupacao;
    private String nome;
    private String senha;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        ocupacao = request.getParameter("ocupacao");
        nome = request.getParameter("nome");
        senha = request.getParameter("senha");
        boolean operacao = false;
        if (ocupacao.toLowerCase().equals("gerente")) {
            boolean existe = verificaGerente(nome);
            if (existe == true) {
                GerenteDAO gDao = new GerenteDAOConcreto();
                operacao = gDao.insertGerente(new Gerente(nome, senha));
            }
        }

        if (ocupacao.toLowerCase().equals("atendente")) {
            boolean existe = verificaAtendente(nome);
            if(existe == true){
                AtendenteDAO aDao = new AtendenteDAOConcreto();
                operacao = aDao.insertAtendente(new Atendente(nome, senha));
            }
        }
        
        try {
            if (operacao == true) {
                response.sendRedirect("sucesso.jsp");
            } else {
                response.sendRedirect("fail.jsp");
            }
        } catch (IOException iOException) {
            System.out.println(iOException.getMessage());
        }

    }

    public boolean verificaGerente(String nome) {
        GerenteDAO gDao = new GerenteDAOConcreto();
        ArrayList<Gerente> listaGerentes = gDao.readGerente();
        boolean v = true;

        for (Gerente gerente : listaGerentes) {
            if (gerente.getNome().equals(nome)) {
                v = false;
            }
        }

        return v;
    }

    public boolean verificaAtendente(String nome) {
        boolean v = true;
        AtendenteDAO aDao = new AtendenteDAOConcreto();
        ArrayList<Atendente> listaAtendente = aDao.readAtendente();

        for (Atendente atendente : listaAtendente) {
            if (atendente.getNome().equals(nome)) {
                v = false;
            }
        }

        return v;
    }
}
