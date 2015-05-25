/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.cinema.commands;

import com.br.lp2.cinema.model.DAO.AtendenteDAO;
import com.br.lp2.cinema.model.DAO.AtendenteDAOConcreto;
import com.br.lp2.cinema.model.DAO.GerenteDAO;
import com.br.lp2.cinema.model.DAO.GerenteDAOConcreto;
import com.br.lp2.cinema.model.javabeans.Atendente;
import com.br.lp2.cinema.model.javabeans.Gerente;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Paulo
 */
public class BuscarUsuario implements Command {

    private String nome;
    private String cargo;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        nome = request.getParameter("nome");
        cargo = request.getParameter("cargo");
        
        ArrayList<Object> funcionarios = null;

        if (cargo.toLowerCase().equals("atendente")) {
            AtendenteDAO a = new AtendenteDAOConcreto();
            ArrayList<Atendente> aux = a.readAtendente();
            for (Atendente atendentes : aux) {
                if (atendentes.getNome().equals(nome)) {
                    funcionarios.add(atendentes);
                }
            }
        }
        
        if (cargo.toLowerCase().equals("gerente")) {
            GerenteDAO a = new GerenteDAOConcreto();
            ArrayList<Gerente> aux = a.readGerente();
            for (Gerente gerente : aux) {
                if (gerente.getNome().equals(nome)) {
                    funcionarios.add(gerente);
                }
            }
        }
        
        
        
        if (funcionarios != null) {
            request.getSession().setAttribute("nome", funcionarios);
        }
    }

}
