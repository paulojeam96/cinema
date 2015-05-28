/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.cinema.commands;

import com.br.lp2.cinema.model.DAO.SessaoDAO;
import com.br.lp2.cinema.model.DAO.SessaoDAOConcreto;
import com.br.lp2.cinema.model.javabeans.Sessao;
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
public class BuscarSessao implements Command{
    private int numero;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        numero = Integer.parseInt(request.getParameter("numero"));
        
        SessaoDAO sDao= new SessaoDAOConcreto();
        Sessao s = sDao.readSessaoByPk(numero);
        
        request.getSession().setAttribute("sessaoPk", s);
        RequestDispatcher rd = request.getRequestDispatcher("manter_sessao.jsp");
        
        try {
            rd.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(BuscarSessao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
