/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.cinema.commands;

import com.br.lp2.cinema.model.DAO.GerenteDAO;
import com.br.lp2.cinema.model.DAO.GerenteDAOConcreto;
import com.br.lp2.cinema.model.javabeans.Gerente;
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
public class BuscaGerente implements Command {

    private int id;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        id = Integer.parseInt(request.getParameter("numero"));

        GerenteDAO gDao = new GerenteDAOConcreto();
        ArrayList<Gerente> lista = new ArrayList<>();

        lista = gDao.readGerente();
        Gerente g = null;
        for (Gerente lista1 : lista) {
            if (id == lista1.getPk()) {
                g = lista1;

            }
        }
        request.getSession().setAttribute("funcionario", g);
        RequestDispatcher rd = request.getRequestDispatcher("BuscaUsuario.jsp");
        try {
            rd.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(BuscaGerente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
