/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.cinema.model.DAO;

import com.br.lp2.cinema.model.javabeans.Funcionario;
import java.util.ArrayList;

/**
 *
 * @author 31448471
 */
public interface FuncionarioDAO {
    //CRUD
    
    //CREATE
    public boolean insertFuncionario(Funcionario funcionario);
    
    //READ
    public ArrayList<Funcionario> readFuncionarios();
    public Funcionario readFuncionarioById(int id);
    public Funcionario readFuncionarioByNome(String nome);
    
    //UPDATE
    public boolean updateFuncionario(int id, Funcionario funcionario);
    
    //DELETE
    public boolean deleteFuncionario(Funcionario funcionario);
    public boolean deleteFuncionario(int id);
}
