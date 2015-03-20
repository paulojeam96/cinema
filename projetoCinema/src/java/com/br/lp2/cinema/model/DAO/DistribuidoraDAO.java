/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.cinema.model.DAO;

import com.br.lp2.cinema.model.javabeans.Distribuidora;
import java.util.ArrayList;

/**
 *
 * @author Paulo
 */
public interface DistribuidoraDAO {
    //CRUD
    //C - CREATE
    public boolean insertDistribuidora(Distribuidora distribuidora);
    
    //R - READ
    public ArrayList<Distribuidora> readDistribuidoras();
    public Distribuidora readDistribuidoraById(int id);
    public Distribuidora readDistribuidoraByNome(String nome);
    
    //U - UPDATE
    public boolean updateDistribuidora(int id, Distribuidora distribuidora);
    
    //D - DELETE
    public boolean deleteDistribuidora(Distribuidora distribuidora);
    public boolean deleteDistribuidora(int id);
}
