/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.cinema.commands;

import com.br.lp2.cinema.model.DAO.SessaoDAO;
import com.br.lp2.cinema.model.DAO.SessaoDAOConcreto;
import com.br.lp2.cinema.model.javabeans.Filme;
import com.br.lp2.cinema.model.javabeans.ListaIngresso;
import com.br.lp2.cinema.model.javabeans.Sala;
import com.br.lp2.cinema.model.javabeans.Sessao;
import java.io.IOException;
import java.sql.Time;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Paulo
 */
public class MudarSessao implements Command{
    private int codigo;
    private int filme;
    private int sala;
    private long horario;
    private boolean legenda = false;
    private int listadeingressos;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        codigo = Integer.parseInt(request.getParameter("codigo"));
        filme = Integer.parseInt(request.getParameter("filme"));
        sala = Integer.parseInt(request.getParameter("sala"));
        horario = Long.parseLong(request.getParameter("horario"));
        String legendado = request.getParameter("legendado");
        listadeingressos = Integer.parseInt(request.getParameter("listadeingressos"));
        boolean operacao = false;
        
        if(legendado.equals("Sim")){
            legenda = true;
        }
        
         SessaoDAO sDao = new SessaoDAOConcreto();
        Filme f = new Filme(filme);
        Sala sl = new Sala(sala);
        Time t = new Time(horario);
        ListaIngresso li = new ListaIngresso(listadeingressos);
        Sessao s = new Sessao(f, sl, t, legenda, li);
        operacao = sDao.insertSessao(s);
        
        try {
            if (operacao) {
                response.sendRedirect("sucesso.jsp");
                
            } else {
                response.sendRedirect("fail.jsp");
            }
        } catch (IOException iOException) {
            iOException.getMessage();
        }
    }
    
}
