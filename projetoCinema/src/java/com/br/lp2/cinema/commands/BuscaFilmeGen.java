/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.cinema.commands;

import com.br.lp2.cinema.model.DAO.FilmeDAO;
import com.br.lp2.cinema.model.DAO.FilmeDAOConcreto;
import com.br.lp2.cinema.model.DAO.GeneroDAO;
import com.br.lp2.cinema.model.DAO.GeneroDAOConcreto;
import com.br.lp2.cinema.model.javabeans.Filme;
import com.br.lp2.cinema.model.javabeans.Genero;
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
public class BuscaFilmeGen implements Command{
    private String genero;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        genero = request.getParameter("nome");
        int id = 1;
        
        //Pega ID do genero pelo nome do genero que veio pelo parametro
        GeneroDAO gDao = new GeneroDAOConcreto();
        Genero g = gDao.readGeneroByNome(genero);
        id = g.getId();
        
        
        FilmeDAOConcreto fDao = new FilmeDAOConcreto();
        ArrayList<Filme> filmes = fDao.readFilmeByGeneroID(id);
        
        
        
        request.getSession().setAttribute("filmesGen", filmes);
        RequestDispatcher rd = request.getRequestDispatcher("BuscarFilme.jsp");
        
        try {
            rd.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(BuscaFilmeGen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
