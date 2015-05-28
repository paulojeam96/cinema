/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.cinema.commands;

import com.br.lp2.cinema.model.DAO.AtendenteDAO;
import com.br.lp2.cinema.model.DAO.AtendenteDAOConcreto;
import com.br.lp2.cinema.model.DAO.ComumDAOConcreto;
import com.br.lp2.cinema.model.DAO.GenericDAO;
import com.br.lp2.cinema.model.DAO.GerenteDAO;
import com.br.lp2.cinema.model.DAO.GerenteDAOConcreto;
import com.br.lp2.cinema.model.javabeans.Atendente;
import com.br.lp2.cinema.model.javabeans.Comum;
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
public class Listar implements Command {

    private String funcionario;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        funcionario = request.getParameter("funcionario");

        if (funcionario.toLowerCase().equals("gerente")) {
            GerenteDAO gDao = new GerenteDAOConcreto();
            ArrayList<Gerente> lista = gDao.readGerente();

            request.getSession().setAttribute("listarGerentes", lista);
            RequestDispatcher rd = request.getRequestDispatcher("buscarUsuario.jsp");

            try {
                rd.forward(request, response);
            } catch (ServletException ex) {
                System.out.println(ex.getMessage());
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        } else if (funcionario.toLowerCase().equals("atendente")) {
            AtendenteDAO aDao = new AtendenteDAOConcreto();
            ArrayList<Atendente> lista = aDao.readAtendente();

            request.getSession().setAttribute("listarAtendentes", lista);
            RequestDispatcher rd = request.getRequestDispatcher("buscarUsuario.jsp");

            try {
                rd.forward(request, response);
            } catch (ServletException ex) {
                System.out.println(ex.getMessage());
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        } else if (funcionario.toLowerCase().equals("usuario")) {
            GenericDAO cDao = new ComumDAOConcreto();
            ArrayList<Object> lista = cDao.read();

            request.getSession().setAttribute("listarUsuarios", lista);
            RequestDispatcher rd = request.getRequestDispatcher("buscarUsuario.jsp");

            try {
                rd.forward(request, response);
            } catch (ServletException ex) {
                System.out.println(ex.getMessage());
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

}
