/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.cinema.commands;

import com.br.lp2.cinema.controller.User;
import com.br.lp2.cinema.model.DAO.AtendenteDAO;
import com.br.lp2.cinema.model.DAO.AtendenteDAOConcreto;
import com.br.lp2.cinema.model.DAO.ComumDAOConcreto;
import com.br.lp2.cinema.model.DAO.GenericDAO;
import com.br.lp2.cinema.model.DAO.GerenteDAO;
import com.br.lp2.cinema.model.DAO.GerenteDAOConcreto;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 31448471
 */
public class DeletarUsuarioNome implements Command{
    private String nome;
    private String cargo;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        cargo = request.getParameter("cargo");
        nome = request.getParameter("nome");
        
        User u = new User(nome, cargo);
        boolean operacao = false;
        
        switch (cargo.toLowerCase()) {
            case "gerente":
                GerenteDAO gDao = new GerenteDAOConcreto();
                operacao = gDao.deleteGerente(nome);
                break;
            case "atendente":
                AtendenteDAO aDao = new AtendenteDAOConcreto();
                operacao = aDao.deleteAtendente(nome);
                break;
            case "normal":
                GenericDAO cDao = new ComumDAOConcreto();
                operacao = cDao.delete(nome);
        }
        
        try {
            if (operacao) {
                response.sendRedirect("sucesso.jsp");
            } else {
                response.sendRedirect("fail.jsp");
            }
        } catch (IOException iOException) {
            iOException.getMessage();
        }
    }
    
}
