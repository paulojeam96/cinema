/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.cinema.commands;


import com.br.lp2.cinema.model.DAO.DiretorDAO;
import com.br.lp2.cinema.model.DAO.DiretorDAOConcreto;
import com.br.lp2.cinema.model.DAO.FilmeDAOConcreto;
import com.br.lp2.cinema.model.javabeans.Diretor;
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
public class BuscarFilmeDiretor implements Command{
    private String diretor;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        diretor = request.getParameter("nome");
        int id = 1;
        
        DiretorDAO dDao = new DiretorDAOConcreto();
        Diretor a = dDao.readDiretorByNome(diretor);
        id = a.getPk();
        
        FilmeDAOConcreto fDao = new FilmeDAOConcreto();
        ArrayList<Filme> filmes = fDao.readFilmeByDiretorID(id);
        
        request.getSession().setAttribute("fDiretor", filmes);
        RequestDispatcher rd = request.getRequestDispatcher("BuscarFilme.jsp");
        
        try {
            rd.forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(BuscarFilmeDiretor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BuscarFilmeDiretor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
