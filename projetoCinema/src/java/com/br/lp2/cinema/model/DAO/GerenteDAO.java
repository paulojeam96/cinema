/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.cinema.model.DAO;

import com.br.lp2.cinema.model.javabeans.Funcionario;
import com.br.lp2.cinema.model.javabeans.Gerente;
import java.util.ArrayList;

/**
 *
 * @author Paulo
 */
public interface GerenteDAO {
            
    //CREATE
    public boolean insertGerente(Funcionario gerente);
    
    //READ
    public ArrayList<Gerente> readGerente();
    public Gerente readGerenteById(int id);
    public Gerente readGerenteByNome(String nome);
    
    //UPDATE
    public boolean updateGerente(int id, Funcionario gerente);
    
    //DELETE
    public boolean deleteGerente(int id);
    public boolean deleteGerente(String nome);    
}