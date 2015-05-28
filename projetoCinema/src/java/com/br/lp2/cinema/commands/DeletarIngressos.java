/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.cinema.commands;

import com.br.lp2.cinema.model.DAO.IngressoDAO;
import com.br.lp2.cinema.model.DAO.IngressoDAOConcreto;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 31448471
 */
public class DeletarIngressos implements Command{
    private int numero;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        numero = Integer.parseInt(request.getParameter("numero"));
        
        IngressoDAO iDao = new IngressoDAOConcreto();
        
        boolean operacao = iDao.deleteIngresso(numero);
        
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
