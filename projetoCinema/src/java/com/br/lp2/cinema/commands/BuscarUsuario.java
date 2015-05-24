/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.cinema.commands;

import com.br.lp2.cinema.model.DAO.AtendenteDAO;
import com.br.lp2.cinema.model.DAO.AtendenteDAOConcreto;
import com.br.lp2.cinema.model.javabeans.Atendente;
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
        ArrayList<Atendente> funcionarios = null;

        if (cargo.toLowerCase().contentEquals("atendente")) {
            AtendenteDAO a = new AtendenteDAOConcreto();
            ArrayList<Atendente> aux = a.readAtendente();
            for (Atendente atendentes : aux) {
                if (atendentes.getNome().equals(nome)) {
                    funcionarios.add(atendentes);
                }
            }
        }
        
        if (cargo.toLowerCase().contentEquals("gerente")) {
            AtendenteDAO a = new AtendenteDAOConcreto();
            ArrayList<Atendente> aux = a.readAtendente();
            for (Atendente atendentes : aux) {
                if (atendentes.getNome().equals(nome)) {
                    funcionarios.add(atendentes);
                }
            }
        }
        
        
        
        if (funcionarios != null) {
            request.getSession().setAttribute("nome", funcionarios);
        }
    }

}
