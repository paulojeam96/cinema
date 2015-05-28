/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.cinema.model.DAO;

import com.br.lp2.cinema.model.ConnectionFactory.ConnectionFactory;
import com.br.lp2.cinema.model.javabeans.Filme;
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
            String sql = "INSERT INTO ingresso(id, id_filme, inteira) VALUES (?,?,?)";
            pst = connection.prepareStatement(sql);
            pst.setInt(1, ingresso.getId());
            pst.setInt(2, ingresso.getId_filme().getPk());
            pst.setBoolean(3, ingresso.isInteira());
            int r = pst.executeUpdate();
            if(r>0) resultado = true;
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
            FilmeDAO fDao = new FilmeDAOConcreto();
            rs = pst.executeQuery();
            while(rs.next()){
                Ingresso d = new Ingresso(rs.getInt("id"), (Filme)fDao.readFilmeById(rs.getInt("id_filme")), rs.getBoolean("inteira") );
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
            FilmeDAO fDao = new FilmeDAOConcreto();
            while (rs.next()) {
            a = new Ingresso(rs.getInt("id"),(Filme)fDao.readFilmeById(rs.getInt("id_filme")), rs.getBoolean("inteira"));
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
            String sql = "UPDATE ingresso SET id=?, id_filme=?, inteira=? WHERE pk=?";
            pst = connection.prepareStatement(sql);
            pst.setInt(1, ingresso.getId());
            pst.setInt(2, ingresso.getId_filme().getPk());
            pst.setBoolean(3, ingresso.isInteira());
            pst.setInt(4, id);
            int r = pst.executeUpdate();
            if(r > 0) res = true;
            else res = false;
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return res;
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
