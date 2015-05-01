/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.cinema.model.DAO;

import com.br.lp2.cinema.model.ConnectionFactory.ConnectionFactory;
import com.br.lp2.cinema.model.javabeans.Ator;
import com.br.lp2.cinema.model.javabeans.InfoAtor;
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
public class InfoAtorDAOConcreto implements InfoAtorDAO{
    
    private Connection connection;
    private PreparedStatement pst;
    private ResultSet rs;
    
    public InfoAtorDAOConcreto(){
        ConnectionFactory cf = new ConnectionFactory();
        connection = cf.getConnection("derby");
    }

    @Override
    public boolean insertInfoAtor(InfoAtor infoAtor) {
         boolean resultado = false;
        try{
            String sql = "INSERT INTO cinema.infoAtor(ator, papel, participacao) VALUES (?,?,?)";
            pst = connection.prepareStatement(sql);
            pst.setObject(1, infoAtor.getAtor());
            pst.setObject(2, infoAtor.getPapel());
            pst.setObject(3, infoAtor.getPart());
            resultado = pst.execute();
        } catch(SQLException ex){
             Logger.getLogger(InfoAtorDAOConcreto.class.getName()).log(Level.SEVERE, null, ex);
               }
        return resultado;
    }

    @Override
    public ArrayList<InfoAtor> readInfoAtores() {
        ArrayList<InfoAtor> lista = new ArrayList<>();
        try{
            String sql = "SELECT * FROM  cinema.infoAtor";
            pst = connection.prepareStatement(sql);
            
            rs = pst.executeQuery();
            while(rs.next()){
                InfoAtor d = new InfoAtor((Ator) rs.getObject("ator"),rs.getString("papel"), rs.getString("part"));
                lista.add(d);
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return lista;    
    }

    @Override
    public InfoAtor readInfoAtorById(int id) {
         InfoAtor a = null;
        
        try {
            String sql = "SELECT * FROM cinema.infoAtor WHERE id=?";
            pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            rs=pst.executeQuery();
            while (rs.next()) {
            a = new InfoAtor((Ator)rs.getObject("ator"), rs.getString("papel"), rs.getString("part") );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return a;
    }

    @Override
    public InfoAtor readInfoAtorByNome(String ator) {
        InfoAtor a = null;
        
        try{
            String sql = "SELECT * FROM cinema.infoAtor WHERE ator=?";
            pst = connection.prepareStatement(sql);
            pst.setString(1, ator);
            rs = pst.executeQuery();
            while(rs.next()){
                a = new InfoAtor((Ator)rs.getObject("ator"), rs.getString("papel"), rs.getString("part"));
           }
        } catch( SQLException ex){
            ex.printStackTrace();
        }
        return a;
    }

    @Override
    public boolean updateInfoAtor(int id, InfoAtor infoAtor) {
        boolean res =false;
        
        try{
            String sql = "UPDATE cinema.infoAtor SET ator=? WHERE id=?";
            pst = connection.prepareStatement(sql);
            pst.setInt(2, id);
            int r = pst.executeUpdate();
            if(r > 0) res = true;
            else res = false;
        } catch (SQLException ex){
            Logger.getLogger(InfoAtorDAOConcreto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    @Override
    public boolean deleteInfoAtor(InfoAtor infoAtor) {
        boolean resultado=false;
        try {
            String sql = "DELETE FROM cinema.infoAtor WHERE id=?";
            pst = connection.prepareStatement(sql);
            pst.setObject(1,infoAtor.getAtor());
            int r = pst.executeUpdate();
            if(r>0) resultado = true;
            else resultado = false;
        } catch (SQLException ex) {
            Logger.getLogger(InfoAtorDAOConcreto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    @Override
    public boolean deleteInfoAtor(int id) {
        boolean res = false;
        try{
            String sql = "DELETE FROM cinema.infoAtor WHERE id=?";
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
