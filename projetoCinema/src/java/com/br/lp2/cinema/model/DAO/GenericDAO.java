/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.cinema.model.DAO;

import java.util.ArrayList;

/**
 *
 * @author 31448471
 */
public interface GenericDAO {
    
     //CREATE
    public boolean insert(Object object);
    
    //READ
    public ArrayList<Object> read();
    public Object readById(int id);
    public Object readByNome(String nome);
    
    //UPDATE
    public boolean update(int id, Object object);
    
    //DELETE
    public boolean delete(int id);
    public boolean delete(String nome);
}
