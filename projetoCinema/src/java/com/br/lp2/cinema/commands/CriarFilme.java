/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.cinema.commands;

import com.br.lp2.cinema.model.DAO.DiretorDAO;
import com.br.lp2.cinema.model.DAO.DiretorDAOConcreto;
import com.br.lp2.cinema.model.DAO.DistribuidoraDAO;
import com.br.lp2.cinema.model.DAO.DistribuidoraDAOConcreto;
import com.br.lp2.cinema.model.DAO.FilmeDAO;
import com.br.lp2.cinema.model.DAO.FilmeDAOConcreto;
import com.br.lp2.cinema.model.DAO.GeneroDAO;
import com.br.lp2.cinema.model.DAO.GeneroDAOConcreto;
import com.br.lp2.cinema.model.javabeans.Diretor;
import com.br.lp2.cinema.model.javabeans.Distribuidora;
import com.br.lp2.cinema.model.javabeans.Filme;
import com.br.lp2.cinema.model.javabeans.Genero;
import com.br.lp2.cinema.model.javabeans.ListaAtores;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Paulo
 */
public class CriarFilme implements Command{
    private String nome;
    private String idioma;
    private String situacao;
    private int duracao;
    private int ano;
    private int clas;
    private String diretor;
    private String genero;
    private String dist;
    private String s;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        nome = request.getParameter("nome");
        idioma = request.getParameter("idioma");
        situacao = request.getParameter("situacao");
        duracao = Integer.parseInt(request.getParameter("duracao"));
        ano = Integer.parseInt(request.getParameter("ano"));
        clas = Integer.parseInt(request.getParameter("classificacao"));
        diretor = request.getParameter("diretor");
        genero = request.getParameter("genero");
        dist = request.getParameter("distribuidora");
        
        FilmeDAO dao = new FilmeDAOConcreto();
        DiretorDAO dDao = new DiretorDAOConcreto();
        GeneroDAO gDao = new GeneroDAOConcreto();
        DistribuidoraDAO dsDao = new DistribuidoraDAOConcreto();
        
        Diretor dir = dDao.readDiretorByNome(this.diretor);
        Genero gen = gDao.readGeneroByNome(this.genero);
        Distribuidora ds = dsDao.readDistribuidoraByNome(dist);
        
        Filme f = new Filme(dir, gen, nome, clas, ano, ds, situacao, duracao, idioma );
        boolean operacao = false;
        operacao  = dao.insertFilme(f);
        
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
