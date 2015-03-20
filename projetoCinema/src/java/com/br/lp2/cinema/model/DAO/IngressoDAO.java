/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.cinema.model.DAO;

import com.br.lp2.cinema.model.javabeans.Ingresso;
import java.util.ArrayList;

/**
 *
 * @author 31448471
 */
public interface IngressoDAO {
     //CRUD
    //C - CREATE
    public boolean insertIngresso(Ingresso ingresso);
    
    //R - READ
    public ArrayList<Ingresso> readIngresso();
    public Ingresso readIngressoById(int id);
    
    
    //U - UPDATE
    public boolean updateIngresso(int id, Ingresso ingresso);
    
    //D - DELETE
    public boolean deleteIngresso(Ingresso ingresso);
    public boolean deleteIngresso(int id);
}
