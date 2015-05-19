/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.cinema.commands;

import com.br.lp2.cinema.controller.CriaLogin;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Paulo
 */
public class Login implements Command{
    private String senha;
    private String usuario;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        usuario = request.getParameter("usuario");
        senha = request.getParameter("password");
        //Manda usuario e senha para CriaLogin e faz a verificação da ocupação do usuario
        CriaLogin cl = new CriaLogin(usuario, senha);
        
        //Cria uma session
        HttpSession session = request.getSession();
        session.setAttribute("usuario", usuario);
        session.setAttribute("lg", "");
        try {
            if (cl.isGerente()) {
                session.setAttribute("ocupacao", "gerente");
                response.sendRedirect("home.jsp");
            } else if (cl.isAtendente()) {
                session.setAttribute("ocupacao","atendente");
                response.sendRedirect("atendente.jsp");
            } else {
                session.setAttribute("lg", "inválido");
                response.sendRedirect("index.jsp");
            }
        } catch (IOException iOException) {
            iOException.getMessage();
        }
    }
    
}
