/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.cinema.model.DAO;

import com.br.lp2.cinema.model.javabeans.Filme;
import java.util.ArrayList;

/**
 *
 * @author Paulo
 */
public interface FilmeDAO {
     //CRUD
    //C - CREATE
    public boolean insertFilme(Filme filme);
    
    //R - READ
    public ArrayList<Filme> readFilmes();
    public Filme readFilmeById(int id);
    public Filme readFilmeByNome(String nome);
    
    //U - UPDATE
    public boolean updateFilme(int id, Filme filme);
    
    //D - DELETE
    public boolean deleteFilme(Filme filme);
    public boolean deleteFilme(int id);
}
