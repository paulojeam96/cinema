/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.cinema.commands;

import com.br.lp2.cinema.model.DAO.IngressoDAO;
import com.br.lp2.cinema.model.DAO.IngressoDAOConcreto;
import com.br.lp2.cinema.model.javabeans.Ingresso;
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
public class BuscaIngressos implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        IngressoDAO iDao = new IngressoDAOConcreto();
        ArrayList<Ingresso> lista = iDao.readIngresso();
        
        request.getSession().setAttribute("ingressos", lista);
        RequestDispatcher rd = request.getRequestDispatcher("vender_ingresso.jsp");
        
        try {
            rd.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(BuscaIngressos.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }
    
}
