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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
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
        
        if (cargo.toLowerCase().equals("atendente")) {
            AtendenteDAO aDao = new AtendenteDAOConcreto();
            operacao = aDao.insertAtendente(new Atendente(nome, senha));
        } else if (cargo.toLowerCase().equals("gerente")) {
            GerenteDAO gDao = new GerenteDAOConcreto();
            System.out.println("aqui");
            operacao = gDao.insertGerente(new Gerente(nome, senha));
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
