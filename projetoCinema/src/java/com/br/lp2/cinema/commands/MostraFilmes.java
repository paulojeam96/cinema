/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.cinema.commands;

import com.br.lp2.cinema.model.DAO.FilmeDAO;
import com.br.lp2.cinema.model.DAO.FilmeDAOConcreto;
import com.br.lp2.cinema.model.javabeans.Filme;
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
public class MostraFilmes implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        FilmeDAO fDao = new FilmeDAOConcreto();
        ArrayList<Filme> lista = fDao.readFilmes();
        
        request.getSession().setAttribute("mostraFilmes", lista);
        
        RequestDispatcher rd = request.getRequestDispatcher("comprar_ingresso.jsp");
        
        try {
            rd.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(MostraFilmes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
