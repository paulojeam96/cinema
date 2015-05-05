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

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        codigo = Integer.parseInt(request.getParameter("cod"));
        
        User u = new User(codigo);
        boolean cod = u.verificaCod();
        boolean operacao = false;
        
        if(u.verificaGerente(codigo) == true){
            GerenteDAO gDao = new GerenteDAOConcreto();
            operacao = gDao.deleteGerente(codigo);
        } else if(u.verificaAtendente(codigo) == true){
            AtendenteDAO aDao = new AtendenteDAOConcreto();
            operacao = aDao.deleteAtendente(codigo);
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
