/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.cinema.commands;

import com.br.lp2.cinema.model.DAO.ComumDAOConcreto;
import com.br.lp2.cinema.model.DAO.GenericDAO;
import com.br.lp2.cinema.model.javabeans.Comum;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 31448471
 */
public class BuscaComum implements Command{
    private String nome;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        nome = request.getParameter("nome");
        Comum comum = null;
        
        GenericDAO cDao = new ComumDAOConcreto();
        ArrayList<Object> lista = cDao.read();
        
        for (Object obj : lista) {
            Comum c = (Comum) obj;
            if(c.getNome().equals(nome)){
                comum = c;
            }
        }
        
        request.getSession().setAttribute("comum", comum);
        RequestDispatcher rd = request.getRequestDispatcher("buscarUsuario.jsp");
        
        try {
            rd.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(BuscaComum.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
