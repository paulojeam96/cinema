/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.cinema.commands;

import com.br.lp2.cinema.model.DAO.DistribuidoraDAO;
import com.br.lp2.cinema.model.DAO.DistribuidoraDAOConcreto;
import com.br.lp2.cinema.model.DAO.FilmeDAOConcreto;
import com.br.lp2.cinema.model.javabeans.Distribuidora;
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
public class BuscarFilmeDist implements Command{
    private String nome;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        nome = request.getParameter("nome");
        int id = 1;
        
        DistribuidoraDAO dDao = new DistribuidoraDAOConcreto();
        Distribuidora dist = dDao.readDistribuidoraByNome(nome);
        id = dist.getId();
        
        
        FilmeDAOConcreto fDao = new FilmeDAOConcreto();
        ArrayList<Filme> filmes = fDao.readFilmeByDistribuidoraID(id);
        
        request.getSession().setAttribute("fDist", filmes);
        RequestDispatcher rd = request.getRequestDispatcher("BuscarFilme.jsp");
        
        try {
            rd.forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(BuscarFilmeDist.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BuscarFilmeDist.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
