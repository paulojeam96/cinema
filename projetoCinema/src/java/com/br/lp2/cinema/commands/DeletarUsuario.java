/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.cinema.commands;

import com.br.lp2.cinema.controller.User;
import com.br.lp2.cinema.model.DAO.AtendenteDAO;
import com.br.lp2.cinema.model.DAO.AtendenteDAOConcreto;
import com.br.lp2.cinema.model.DAO.GerenteDAO;
import com.br.lp2.cinema.model.DAO.GerenteDAOConcreto;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Paulo
 */
public class DeletarUsuario implements Command{
    private int codigo;
    private String cargo;
    private String nome;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        codigo = Integer.parseInt(request.getParameter("cod"));
        cargo = request.getParameter("cargo");
        nome = request.getParameter("nome");
        
        User u = new User(nome, cargo, codigo);
        boolean operacao = false;
        
        switch (cargo.toLowerCase()) {
            case "gerente":
                GerenteDAO gDao = new GerenteDAOConcreto();
                operacao = gDao.deleteGerente(codigo);
                break;
            case "atendente":
                AtendenteDAO aDao = new AtendenteDAOConcreto();
                operacao = aDao.deleteAtendente(codigo);
                break;
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
