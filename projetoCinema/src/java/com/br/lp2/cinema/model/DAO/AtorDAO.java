/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.cinema.model.DAO;
import com.br.lp2.cinema.model.javabeans.Ator;

import java.util.ArrayList;

/**
 *
 * @author Paulo
 */
public interface AtorDAO {
    //CRUD
    //C - CREATE
    public boolean insertAtor(Ator ator);
    
    //R - READ
    public ArrayList<Ator> readAtores();
    public Ator readAtorById(int id);
    public Ator readAtorByNome(String nome);
    
    //U - UPDATE
    public boolean updateAtor(int id, Ator ator);
    
    //D - DELETE
    public boolean deleteAtor(Ator ator);
    public boolean deleteAtor(int id);
    
}
