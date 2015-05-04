/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.cinema.commands;

import com.br.lp2.cinema.model.DAO.FilmeDAO;
import com.br.lp2.cinema.model.DAO.FilmeDAOConcreto;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Paulo
 */
public class ExcluirFilme implements Command{
    private int codigo;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        
        codigo = Integer.parseInt(request.getParameter("codigo"));
        
        FilmeDAO dao = new FilmeDAOConcreto();
        boolean operacao = dao.deleteFilme(codigo);
        
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
