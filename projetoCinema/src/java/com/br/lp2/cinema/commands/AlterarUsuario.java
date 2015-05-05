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
public class AlterarUsuario implements Command {

    private int codigo;
    private String cargoAtual;
    private String nome;
    private String senha;
    private String senha2;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        codigo = Integer.parseInt(request.getParameter("cod"));
        cargoAtual = request.getParameter("cargoAtual");
        nome = request.getParameter("nome");
        senha = request.getParameter("password");
        senha2 = request.getParameter("password2");

        User u = new User(nome, senha, senha2, cargoAtual, codigo);
        boolean usuario = u.verificaUsuario();
        boolean codUser = u.verificaCod();
        boolean senhaUser = u.verificaSenha();
        boolean operacao = false;
        try {
            if (usuario == false || codUser == false || senhaUser == false) {
                response.sendRedirect("fail.jsp");
            } 
            else {
                if (cargoAtual.contentEquals("Gerente")) {
                    GerenteDAO gDao = new GerenteDAOConcreto();
                    Gerente g = new Gerente(nome, senha);
                    operacao = gDao.updateGerente(codigo, g);
                }
                else if (cargoAtual.contentEquals("Atendente")){
                    AtendenteDAO aDao = new AtendenteDAOConcreto();
                    Atendente a = new Atendente(nome, senha);
                    operacao = aDao.updateAtendente(codigo, a);
                }
                
                if(operacao){
                    response.sendRedirect("sucesso.jsp");
                } else{
                    response.sendRedirect("fail.jsp");
                }
            }
        }
        catch (IOException iOException) {
            iOException.getMessage();
        }

    }

}
