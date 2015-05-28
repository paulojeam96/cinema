/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.cinema.commands;

import com.br.lp2.cinema.model.DAO.FilmeDAO;
import com.br.lp2.cinema.model.DAO.FilmeDAOConcreto;
import com.br.lp2.cinema.model.DAO.ListaIngressoDAO;
import com.br.lp2.cinema.model.DAO.ListaIngressoDAOConcreto;
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
public class CriarSessao implements Command{
    private String filme;
    private int sala;
    private String horario;
    private String legenda;
    private int ingressos;
    private int numero;
    

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        numero = Integer.parseInt(request.getParameter("numero"));
        filme = request.getParameter("filme");
        sala = Integer.parseInt(request.getParameter("sala"));
        horario = request.getParameter("horario");
        legenda = request.getParameter("legenda");
        boolean legendado = false;
        
        if(legenda.toLowerCase().equals("legendado")){
            legendado = true;
        }
        
        SessaoDAO sDao= new SessaoDAOConcreto();
        SalaDAO salasDao = new SalaDAOConcreto();
        FilmeDAO fDao = new FilmeDAOConcreto();
        ListaIngressoDAO lDao = new ListaIngressoDAOConcreto();
        ListaIngresso id = lDao.readListaIngressoById(ingressos);
        
        Filme f = fDao.readFilmeByNome(filme);
        Sala s = salasDao.readSalaById(sala);
        Sessao sessao = new Sessao(f, s, horario, legendado);
        
        boolean operacao = sDao.insertSessao(sessao);
        
        
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
