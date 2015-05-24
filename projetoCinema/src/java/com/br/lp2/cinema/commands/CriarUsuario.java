/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.cinema.commands;

import com.br.lp2.cinema.controller.User;
import com.br.lp2.cinema.model.DAO.AtendenteDAO;
import com.br.lp2.cinema.model.DAO.AtendenteDAOConcreto;
import com.br.lp2.cinema.model.DAO.GerenteDAO;
import com.br.lp2.cinema.model.DAO.GerenteDAOConcreto;
import com.br.lp2.cinema.model.javabeans.Atendente;
import com.br.lp2.cinema.model.javabeans.Gerente;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Paulo
 */
public class CriarUsuario implements Command {

    private String nome;
    private String senha;
    private String senha2;
    private String cargo;
    private int codigo;
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        nome = request.getParameter("nome");
        senha = request.getParameter("password");
        senha2 = request.getParameter("password2");
        cargo = request.getParameter("cargo");
        codigo = Integer.parseInt(request.getParameter("cod"));
        
        User u = new User(nome, senha, senha2, cargo, codigo);
        
        boolean usuario = u.verificaUsuario();
        boolean password = u.verificaSenha();
        
        try {
            if (usuario == false || password == false) {
                response.sendRedirect("fail.jsp");
            }            
        } catch (IOException iOException) {
            iOException.getMessage();
        }
        
        boolean operacao = false;
        
        if (cargo.toLowerCase().contentEquals("atendente")) {
            AtendenteDAO aDao = new AtendenteDAOConcreto();
            Atendente a = new Atendente(nome, senha);
            operacao = aDao.insertAtendente(a);
        } else if (cargo.toLowerCase().contentEquals("gerente")) {
            GerenteDAO gDao = new GerenteDAOConcreto();
            Gerente g = new Gerente(nome, senha);
            operacao = gDao.insertGerente(g);
        }
        
        
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
