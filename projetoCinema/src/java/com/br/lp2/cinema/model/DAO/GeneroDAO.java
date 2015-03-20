/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.cinema.model.DAO;

import com.br.lp2.cinema.model.javabeans.Genero;
import java.util.ArrayList;

/**
 *
 * @author 31448471
 */
public interface GeneroDAO {
     //CRUD
    //C - CREATE
    public boolean insertGenero(Genero genero);
    
    //R - READ
    public ArrayList<Genero> readGeneros();
    public Genero readGeneroById(int id);
    public Genero readGeneroByNome(String nome);
    
    //U - UPDATE
    public boolean updateGenero(int id, Genero genero);
    
    //D - DELETE
    public boolean deleteGenero(Genero filme);
    public boolean deleteGenero(int id);
}
