/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.cinema.model.DAO;

import com.br.lp2.cinema.model.ConnectionFactory.ConnectionFactory;
import com.br.lp2.cinema.model.javabeans.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Paulo
 */
public class ClienteDAOConcreto implements ClienteDAO{
    
  private Connection connection;
    private PreparedStatement pst;
    private ResultSet rs;
    
    public ClienteDAOConcreto(){
        ConnectionFactory cf = new ConnectionFactory();
        connection = cf.getConnection("derby");
    }
    
    
    @Override
    public boolean insertCliente(Cliente cliente) {
        boolean resultado = false;
        try{
            String sql = "INSERT INTO cinema.cliente(pk,nome,anoNasc,especiais) VALUES (?,?,?,?)";
            pst = connection.prepareStatement(sql);
            pst.setInt(1, cliente.getPk());
            pst.setString(2, cliente.getNome());
            pst.setInt(3, cliente.getAnoNasc());
            pst.setObject(4, cliente.getTipo());
            resultado = pst.execute();
        } catch(SQLException ex){
             Logger.getLogger(ClienteDAOConcreto.class.getName()).log(Level.SEVERE, null, ex);
           
        }
        return resultado;
    }

    @Override
    public ArrayList<Cliente> readClientes() {
        ArrayList<Cliente> lista = new ArrayList<>();
        try{
            String sql = "SELECT * FROM  cinema.cliente";
            pst = connection.prepareStatement(sql);
            
            rs = pst.executeQuery();
            while(rs.next()){
                Cliente c = new Cliente(rs.getInt("pk"), rs.getString("nome"), rs.getInt("anoNasc"));
                lista.add(c);
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return lista;
    }

    @Override
    public Cliente readClienteById(int id) {
        Cliente a = null;
        
        try {
            String sql = "SELECT * FROM cinema.cliente WHERE id=?";
            pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            rs=pst.executeQuery();
            while (rs.next()) {
            a = new Cliente(rs.getInt("pk"), rs.getString("nome"), rs.getInt("anoNasc") );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return a;
    }

    @Override
    public Cliente readClienteByNome(String nome) {
        Cliente a = null;
        
        try{
            String sql = "SELECT * FROM cinema.cliente WHERE nome=?";
            pst = connection.prepareStatement(sql);
            pst.setString(1, nome);
            rs = pst.executeQuery();
            while(rs.next()){
                a = new Cliente(rs.getInt("pk"), rs.getString("nome"), rs.getInt("anoNasc"));
           }
        } catch( SQLException ex){
            ex.printStackTrace();
        }
        return a;
    }

    @Override
    public boolean updateCliente(int id, Cliente cliente) {
        boolean res =false;
        
        try{
            String sql = "UPDATE cinema.cliente SET nome=? WHERE id=?";
            pst = connection.prepareStatement(sql);
            pst.setInt(2, id);
            int r = pst.executeUpdate();
            if(r > 0) res = true;
            else res = false;
        } catch (SQLException ex){
            Logger.getLogger(ClienteDAOConcreto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    
    @Override
    public boolean deleteCliente(Cliente cliente) {
        boolean resultado=false;
        try {
            String sql = "DELETE FROM cinema.cliente WHERE id=?";
            pst = connection.prepareStatement(sql);
            pst.setInt(1,cliente.getPk());
            int r = pst.executeUpdate();
            if(r>0) resultado = true;
            else resultado = false;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOConcreto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
    
    @Override
    public boolean deleteCliente(int id) {
        boolean res = false;
        try{
            String sql = "DELETE FROM cinema.cliente WHERE id=?";
            pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            int r = pst.executeUpdate();
            if (r > 0) res = true;
            else res = false;
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return res;
    
    }    
}
