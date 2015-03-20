/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.cinema.model.DAO;

import com.br.lp2.cinema.model.javabeans.InfoAtor;
import java.util.ArrayList;

/**
 *
 * @author 31448471
 */
public interface InfoAtorDAO {
     //CRUD
    //C - CREATE
    public boolean insertInfoAtor(InfoAtor infoAtor);
    
    //R - READ
    public ArrayList<InfoAtor> readInfoAtores();
    public InfoAtor readInfoAtorById(int id);
    public InfoAtor readInfoAtorByNome(String nome);
    
    //U - UPDATE
    public boolean updateInfoAtor(int id, InfoAtor infoAtor);
    
    //D - DELETE
    public boolean deleteInfoAtor(InfoAtor infoAtor);
    public boolean deleteInfoAtor(int id);
}
