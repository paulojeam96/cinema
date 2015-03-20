/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.cinema.model.DAO;

import com.br.lp2.cinema.model.javabeans.Diretor;
import java.util.ArrayList;

/**
 *
 * @author Paulo
 */
public interface DiretorDAO {
    //CRUD
    //C - CREATE
    public boolean insertDiretor(Diretor iretor);
    
    //R - READ
    public ArrayList<Diretor> readDiretores();
    public Diretor readDiretorById(int id);
    public Diretor readDiretorByNome(String nome);
    
    //U - UPDATE
    public boolean updateDiretor(int id, Diretor diretor);
    
    //D - DELETE
    public boolean deleteDiretor(Diretor diretor);
    public boolean deleteDiretor(int id);
}
