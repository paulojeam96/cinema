/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.cinema.commands;

import com.br.lp2.cinema.model.DAO.FilmeDAO;
import com.br.lp2.cinema.model.DAO.FilmeDAOConcreto;
import com.br.lp2.cinema.model.DAO.SalaDAO;
import com.br.lp2.cinema.model.DAO.SalaDAOConcreto;
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
    private String legenda;
    private String horario;
    private int sala;
    private String filme;
    private int codigo;
    

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        codigo = Integer.parseInt(request.getParameter("codigo"));
        filme = request.getParameter("filme");
        sala = Integer.parseInt(request.getParameter("sala"));
        horario = request.getParameter("horario");
        legenda = request.getParameter("legenda");
        boolean legendado = false;
        if(legenda.equals("legendado")){
            legendado = true;
        }
        
        SessaoDAO sDao = new SessaoDAOConcreto();
        FilmeDAO fDao = new FilmeDAOConcreto();
        SalaDAO salaDao = new SalaDAOConcreto();
        
        Filme f = fDao.readFilmeByNome(filme);
        Sala s = salaDao.readSalaById(sala);
        
        Sessao sessao = new Sessao(f, s, horario, legendado);
        boolean operacao = sDao.updateSessao(codigo, sessao);
        
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
