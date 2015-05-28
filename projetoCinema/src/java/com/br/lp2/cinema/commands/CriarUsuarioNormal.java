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
 * @author Paulo
 */
public class CriarUsuarioNormal implements Command {

    private int codigo;
    private String senha2;
    private String senha;
    private String nome;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        nome = request.getParameter("nome");
        senha = request.getParameter("password");
        senha2 = request.getParameter("password2");
        codigo = Integer.parseInt(request.getParameter("cod"));        
        
        GenericDAO cDao = new ComumDAOConcreto();        
        ArrayList<Object> lista = cDao.read();
        Comum c = null;
        String erro = "";
        for (Object obj : lista) {
            Comum comum = (Comum)obj;
            if(comum.getNome().equals(nome) && comum.getCodigo() == codigo){
                erro = "usuario já existe!!";
                break;
            }
        }
        
        request.getSession().setAttribute("erro", erro);
        
        if (senha.equals(senha2)) {
            c = new Comum(nome, senha, senha2, codigo);
        }
        
        boolean operacao = cDao.insert(c);
        
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
