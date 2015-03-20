/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.cinema.model.DAO;

import com.br.lp2.cinema.model.javabeans.Ator;
import com.br.lp2.cinema.model.javabeans.Cliente;
import java.util.ArrayList;

/**
 *
 * @author Paulo
 */
public interface ClienteDAO {
    
    //CRUD
    //C - CREATE
    public boolean insertCliente(Cliente cliente);
    
    //R - READ
    public ArrayList<Cliente> readClientes();
    public Cliente readClienteById(int id);
    public Cliente readClienteByNome(String nome);
    
    //U - UPDATE
    public boolean updateCliente(int id, Cliente cliente);
    
    //D - DELETE
    public boolean deleteCliente(Cliente cliente);
    public boolean deleteCliente(int id);
    
    
}
