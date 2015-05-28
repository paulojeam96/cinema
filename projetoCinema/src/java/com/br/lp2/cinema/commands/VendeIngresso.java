/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.cinema.commands;

import com.br.lp2.cinema.model.DAO.FilmeDAO;
import com.br.lp2.cinema.model.DAO.FilmeDAOConcreto;
import com.br.lp2.cinema.model.DAO.IngressoDAO;
import com.br.lp2.cinema.model.DAO.IngressoDAOConcreto;
import com.br.lp2.cinema.model.javabeans.Filme;
import com.br.lp2.cinema.model.javabeans.Ingresso;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 31448471
 */
public class VendeIngresso implements Command{
    private int numero;
    private String filme;
    private String inteira;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        numero = Integer.parseInt(request.getParameter("id"));
        filme = request.getParameter("filme");
        inteira = request.getParameter("inteira");
        boolean ingresso = false;
        
        if(inteira.equals("inteira")){
            ingresso = true;
        }
        
        IngressoDAO iDao = new IngressoDAOConcreto();
        FilmeDAO fDao = new FilmeDAOConcreto();
        
        Filme f = fDao.readFilmeByNome(filme);
        Ingresso i = new Ingresso(numero, f, ingresso);
        
        boolean operacao = iDao.insertIngresso(i);
        
        try {
            if (operacao == true) {
                response.sendRedirect("sucesso.jsp");
            } else if (operacao == false) {
                response.sendRedirect("fail.jsp");
            }
        } catch (IOException iOException) {
            System.out.println(iOException.getMessage());
        }
    }
    
}
