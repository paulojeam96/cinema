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
public class BuscarFilmeID implements Command{
    private int id;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        id = Integer.parseInt(request.getParameter("numero"));
        
        FilmeDAO fDao = new FilmeDAOConcreto();
        
        Filme f = fDao.readFilmeById(id);
        
        request.getSession().setAttribute("idFilme", f);
        
        RequestDispatcher rd = request.getRequestDispatcher("BuscarFilme.jsp");
        
        try {
            rd.forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(BuscarFilmeID.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BuscarFilmeID.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
