/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.cinema.commands;

import com.br.lp2.cinema.model.DAO.SalaDAO;
import com.br.lp2.cinema.model.DAO.SalaDAOConcreto;
import com.br.lp2.cinema.model.javabeans.Sala;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Paulo
 */
public class BuscarSala implements Command{
    private int buscar;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        buscar = Integer.parseInt(request.getParameter("Buscar"));
        
        SalaDAO dao = new SalaDAOConcreto();
        dao.readSalaById(buscar);
    }
    
}
