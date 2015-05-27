/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.cinema.model.DAO;

import com.br.lp2.cinema.model.javabeans.Sala;
import java.util.ArrayList;

/**
 *
 * @author Paulo
 */
public interface SalaDAO {
    //CRUD
    //C - CREATE
    public boolean insertSala(Sala sala);
    
    //R - READ
    public ArrayList<Sala> readSalas();
    public Sala readSalaById(int id);
    public Sala readSalaByEstados(String estado);
    
    //U - UPDATE
    public boolean updateSala(int id, Sala sala);
    
    //D - DELETE
    public boolean deleteSala(Sala sala);
    public boolean deleteSala(int id);
}
