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
import com.br.lp2.cinema.model.javabeans.Gerente;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 31448471
 */
public class BuscaAtendente implements Command{
    private int id;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        id = Integer.parseInt(request.getParameter("numero"));
        
        AtendenteDAO aDao = new AtendenteDAOConcreto();
        ArrayList<Atendente> lista = new ArrayList<>();
        
        lista = aDao.readAtendente();
        
        for (Atendente lista1 : lista) {
            if(id == lista1.getPk()){
                request.getSession().setAttribute("funcionario", lista1);
            }
        }
    }
    
}
