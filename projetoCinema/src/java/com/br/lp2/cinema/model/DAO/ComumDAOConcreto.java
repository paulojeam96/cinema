/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.cinema.model.DAO;

import com.br.lp2.cinema.model.ConnectionFactory.ConnectionFactory;
import com.br.lp2.cinema.model.javabeans.Comum;
import com.br.lp2.cinema.model.javabeans.Gerente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Paulo
 */
public class ComumDAOConcreto implements GenericDAO{
    private static Connection connection;
    private static PreparedStatement pst;
    private static ResultSet rs;  
    
    public ComumDAOConcreto(){
        ConnectionFactory cf = new ConnectionFactory();
        connection = cf.getConnection("derby");
    }

    @Override
    public boolean insert(Object object) {
        Comum comum = (Comum)object;
        boolean resultado = false;
        try {
            String sql = "INSERT INTO comum (nome,senha,codigo) VALUES(?,?,?)";
            pst = connection.prepareStatement(sql);
            pst.setString(1, comum.getNome());
            pst.setString(2, comum.getSenha1());
            pst.setInt(2, comum.getCodigo());
            int r = pst.executeUpdate();
            if(r>0) resultado = true;
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return resultado;
    }

    @Override
    public ArrayList<Object> read() {
        ArrayList<Object> lista = new ArrayList<>();
        try {
            String sql = "SELECT * FROM comum";
            pst = connection.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Comum c = new Comum(rs.getString("nome"), rs.getString("senha"), rs.getInt("codigo"));
                lista.add(c);
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return lista;
    }

    @Override
    public Object readById(int id) {
        Comum c = null;
        try {
            String sql = "SELECT * FROM comum WHERE pk=?";
            pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            while (rs.next()) {
                c = new Comum(rs.getString("nome"), rs.getString("senha"), rs.getInt("codigo"));
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return c;
    }

    @Override
    public Object readByNome(String nome) {
        Comum c = null;
        try {
            String sql = "SELECT * FROM comum WHERE nome=?";
            pst = connection.prepareStatement(sql);
            pst.setString(1, nome);
            rs = pst.executeQuery();
            while (rs.next()) {
                c = new Comum(rs.getString("nome"), rs.getString("senha"), rs.getInt("codigo"));
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return c;
    }

    @Override
    public boolean update(int id, Object object) {
        Comum comum = (Comum)object;
        boolean resultado = false;
        try {
            String sql = "UPDATE comum SET nome=?, senha=?, codigo=? WHERE pk=?";
            pst = connection.prepareStatement(sql);
            pst.setString(1, comum.getNome());
            pst.setString(2, comum.getSenha1());
            pst.setInt(3, comum.getCodigo());
            pst.setInt(4, id);
            int r = pst.executeUpdate();
            if(r>0) resultado = true;
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return resultado;   
    }

    @Override
    public boolean delete(int id) {
        boolean resultado = false;
        try {
            String sql = "DELETE FROM comum WHERE pk=?";
            pst = connection.prepareStatement(sql);
            pst.setInt(1, id); 
            int r = pst.executeUpdate();
            if(r>0) resultado = true;
            
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return resultado;
    }

    @Override
    public boolean delete(String nome) {
         
        boolean resultado = false;
        try {
            String sql = "DELETE FROM comum WHERE nome=?";
            pst = connection.prepareStatement(sql);
            pst.setString(1, nome);
            int r = pst.executeUpdate();
            if(r>0) resultado = true;
            
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return resultado;
    }
    
}
