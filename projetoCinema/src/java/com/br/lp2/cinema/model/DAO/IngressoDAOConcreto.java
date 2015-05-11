/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.cinema.model.DAO;

import com.br.lp2.cinema.model.ConnectionFactory.ConnectionFactory;
import com.br.lp2.cinema.model.javabeans.Ingresso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 31448471
 */
public class IngressoDAOConcreto implements IngressoDAO{
    
    private Connection connection;
    private PreparedStatement pst;
    private ResultSet rs;
    
    public IngressoDAOConcreto(){
        ConnectionFactory cf = new ConnectionFactory();
        connection = cf.getConnection("derby");
    }

    @Override
    public boolean insertIngresso(Ingresso ingresso) {
        boolean resultado = false;
        try{
            String sql = "INSERT INTO ingresso(pk, id, inteira, especiais) VALUES (?,?,?,?)";
            pst = connection.prepareStatement(sql);
            pst.setInt(1, ingresso.getPk());
            pst.setInt(2, ingresso.getId());
            pst.setBoolean(3, ingresso.isInteira());
            pst.setObject(4, ingresso.getTipo());
            resultado = pst.execute();
        } catch(SQLException ex){
            ex.printStackTrace();
               }
        return resultado;
    }

    @Override
    public ArrayList<Ingresso> readIngresso() {
        ArrayList<Ingresso> lista = new ArrayList<>();
        try{
            String sql = "SELECT * FROM  ingresso";
            pst = connection.prepareStatement(sql);
            
            rs = pst.executeQuery();
            while(rs.next()){
                Ingresso d = new Ingresso(rs.getInt("pk"), rs.getInt("id"), rs.getBoolean("inteira"));
                lista.add(d);
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return lista;    
    }

    @Override
    public Ingresso readIngressoById(int id) {
        Ingresso a = null;
        
        try {
            String sql = "SELECT * FROM ingresso WHERE id=?";
            pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            rs=pst.executeQuery();
            while (rs.next()) {
            a = new Ingresso(rs.getInt("pk"), rs.getInt("id"), rs.getBoolean("inteira"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return a;
    }

    @Override
    public boolean updateIngresso(int id, Ingresso ingresso) {
         boolean res =false;
        
        try{
            String sql = "UPDATE ingresso SET inteira=? WHERE id=?";
            pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            int r = pst.executeUpdate();
            if(r > 0) res = true;
            else res = false;
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return res;
    }

    @Override
    public boolean deleteIngresso(Ingresso ingresso) {
         boolean resultado=false;
        try {
            String sql = "DELETE FROM ingresso WHERE id=?";
            pst = connection.prepareStatement(sql);
            pst.setInt(1,ingresso.getPk());
            int r = pst.executeUpdate();
            if(r>0) resultado = true;
            else resultado = false;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resultado;
    }

    @Override
    public boolean deleteIngresso(int id) {
        boolean res = false;
        try{
            String sql = "DELETE FROM ingresso WHERE id=?";
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
