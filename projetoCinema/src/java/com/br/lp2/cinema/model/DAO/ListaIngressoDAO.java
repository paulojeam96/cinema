/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.cinema.model.DAO;

import com.br.lp2.cinema.model.javabeans.ListaIngresso;
import java.util.ArrayList;

/**
 *
 * @author Paulo
 */
public interface ListaIngressoDAO {
    //CRUD
    //C - CREATE
    public boolean insertListaIngresso(ListaIngresso listaIngresso);
    
    //R - READ
    public ArrayList<ListaIngresso> readListaIngresso();
    public ListaIngresso readListaIngressoById(int id);
    
    
    //U - UPDATE
    public boolean updateListaIngresso(int id, ListaIngresso listaIngresso);
    
    //D - DELETE
    public boolean deleteListaIngresso(ListaIngresso listaIngresso);
    public boolean deleteListaIngresso(int id);
}
