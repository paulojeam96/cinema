/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.cinema.commands;

import com.br.lp2.cinema.model.DAO.AtendenteDAO;
import com.br.lp2.cinema.model.DAO.AtendenteDAOConcreto;
import com.br.lp2.cinema.model.DAO.GerenteDAO;
import com.br.lp2.cinema.model.DAO.GerenteDAOConcreto;
import com.br.lp2.cinema.model.javabeans.Atendente;
import com.br.lp2.cinema.model.javabeans.Funcionario;
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
 * @author Paulo
 */
public class BuscarUsuario implements Command {

    private int pk;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        pk = Integer.parseInt(request.getParameter("numero"));

        ArrayList<Atendente> lista = new ArrayList<>();
        ArrayList<Funcionario> lista1 = new ArrayList<>();
        Funcionario funcionario = null;

        GerenteDAO gDao = new GerenteDAOConcreto();
        AtendenteDAO aDao = new AtendenteDAOConcreto();

        lista = aDao.readAtendente();
        for (Funcionario at : lista) {
            if (this.pk == at.getPk()) {
                lista.add((Atendente) at);
            }
        }

        /*
         if (cargo.toLowerCase().equals("gerente")) {
         lista.addAll(gDao.readGerente());
         for (Funcionario lista1 : lista) {
         if(lista1.getNome().equals(nome)){
         funcionario = lista1;
         request.getSession().setAttribute("funcinario", funcionario);
         }
         }
         } else if (cargo.toLowerCase().equals("atendente")) {
         lista.addAll(aDao.readAtendente());
         for (Funcionario lista1 : lista) {
         if(lista1.getNome().equals(nome)){
         funcionario = lista1;
         request.getSession().setAttribute("funcinario", funcionario);
         }
         }
         }

         for (Funcionario lista1 : lista) {
         if (lista1.getNome().equals("nome")) {
         request.getSession().setAttribute("funcionario", lista.add(lista1));
         }
         }
         */
    }

}
