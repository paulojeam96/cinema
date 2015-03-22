/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.cinema.model;

import com.br.lp2.cinema.model.DAO.AtorDAO;
import com.br.lp2.cinema.model.DAO.AtorDAOConcreto;
import com.br.lp2.cinema.model.javabeans.Ator;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Paulo
 */
public class testeCinema {
    
    public static void main(String[] args){
        AtorDAO atorDAO = new AtorDAOConcreto();
        ArrayList<Ator> listaAtor = atorDAO.readAtores();
        for (Ator ator : listaAtor) {
            System.out.println(ator.getNome()+" - "+ator.getDataNascimento()+ " - "+ ator.getNascionalidade());
        }
        
        
        
        
    }
}
