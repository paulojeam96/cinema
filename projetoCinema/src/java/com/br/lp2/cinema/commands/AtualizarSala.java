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
public class AtualizarSala implements Command{
    private int numero;
    private int lotacao;
    private int especial;
    private String situacao;
    private int codSala;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        numero = Integer.parseInt(request.getParameter("numero"));
        lotacao = Integer.parseInt(request.getParameter("lotacao"));
        especial = Integer.parseInt(request.getParameter("especial"));
        situacao = request.getParameter("situacao");
        codSala = Integer.parseInt(request.getParameter("codSala"));

        boolean operacao = false;

        
        
        
        Sala sala = new Sala(numero, lotacao, especial, situacao);
        SalaDAO dao = new SalaDAOConcreto();
        operacao = dao.updateSala(codSala, sala);
        
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
