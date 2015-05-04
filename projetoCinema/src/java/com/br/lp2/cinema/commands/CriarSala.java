/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.cinema.commands;

import com.br.lp2.cinema.model.DAO.SalaDAO;
import com.br.lp2.cinema.model.DAO.SalaDAOConcreto;
import com.br.lp2.cinema.model.javabeans.Sala;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Paulo
 */
public class CriarSala implements Command {

    private int numero;
    private int lotacao;
    private int especial;
    private String situacao;
    private Sala.Estados s;

    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        numero = Integer.parseInt(request.getParameter("numero"));
        lotacao = Integer.parseInt(request.getParameter("lotacao"));
        especial = Integer.parseInt(request.getParameter("especial"));
        situacao = request.getParameter("situacao");

        boolean operacao = false;

        switch (situacao) {
            case "Em Manutencao":
                s = Sala.Estados.MANUTENCAO;
                break;
            case "Ocupada":
                s = Sala.Estados.OCUPADO;
                break;
            case"Livre": 
                s = Sala.Estados.LIVRE;
                break;
                   
        }
        
        Sala sala = new Sala(numero, lotacao, especial, s);
        SalaDAO dao = new SalaDAOConcreto();
        operacao = dao.insertSala(sala);
        
        if(operacao){
            try {   
                response.sendRedirect("sucesso.jsp");
            } catch (IOException ex) {
                Logger.getLogger(CriarSala.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                response.sendRedirect("fail.jsp");
            } catch (IOException ex) {
                Logger.getLogger(CriarSala.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
