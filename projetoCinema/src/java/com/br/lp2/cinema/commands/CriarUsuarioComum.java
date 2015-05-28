/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.cinema.commands;

import com.br.lp2.cinema.model.DAO.ComumDAOConcreto;
import com.br.lp2.cinema.model.DAO.GenericDAO;
import com.br.lp2.cinema.model.javabeans.Comum;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 31448471
 */
public class CriarUsuarioComum implements Command {

    private String nome;
    private String senha1;
    private String senha2;
    private int codigo;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        nome = request.getParameter("nome");
        senha1 = request.getParameter("password");
        senha2 = request.getParameter("password2");
        codigo = Integer.parseInt(request.getParameter("cod"));
        boolean existe = false;
        boolean operacao = false;
        GenericDAO cDao = new ComumDAOConcreto();
        ArrayList<Object> lista = cDao.read();

        for (Object obj : lista) {
            Comum c = (Comum) obj;
            if (c.getCodigo() == codigo) {
                existe = true;
            }
        }

        if (existe == false) {
            Comum c = new Comum(nome, senha1, codigo);
            operacao = cDao.insert(c);
        }

        try {
            if (operacao == true) {
                response.sendRedirect("sucesso.jsp");
            } else {
                response.sendRedirect("fail.jsp");
            }
        } catch (IOException iOException) {
            System.out.println(iOException.getMessage());
        }
    }

}
