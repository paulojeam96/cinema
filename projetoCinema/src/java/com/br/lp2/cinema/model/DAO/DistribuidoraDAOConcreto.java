/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.cinema.model.DAO;

import com.br.lp2.cinema.model.ConnectionFactory.ConnectionFactory;
import com.br.lp2.cinema.model.javabeans.Distribuidora;
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
public class DistribuidoraDAOConcreto implements DistribuidoraDAO{
    
    private Connection connection;
    private PreparedStatement pst;
    private ResultSet rs;
    
    public DistribuidoraDAOConcreto(){
        ConnectionFactory cf = new ConnectionFactory();
        connection = cf.getConnection("derby");
    }

    @Override
    public boolean insertDistribuidora(Distribuidora distribuidora) {
        boolean resultado = false;
        try{
            String sql = "INSERT INTO distribuidora(nome) VALUES (?)";
            pst = connection.prepareStatement(sql);
            pst.setString(1, distribuidora.getNome());
            resultado = pst.execute();
        } catch(SQLException ex){
             Logger.getLogger(DistribuidoraDAOConcreto.class.getName()).log(Level.SEVERE, null, ex);
               }
        return resultado;
    }

    @Override
    public ArrayList<Distribuidora> readDistribuidoras() {
        ArrayList<Distribuidora> lista = new ArrayList<>();
        try{
            String sql = "SELECT * FROM  distribuidora";
            pst = connection.prepareStatement(sql);
            
            rs = pst.executeQuery();
            while(rs.next()){
                Distribuidora d = new Distribuidora( rs.getString("nome"),rs.getInt("pk"));
                lista.add(d);
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return lista;    
    }

    @Override
    public Distribuidora readDistribuidoraById(int id) {
        Distribuidora a = null;
        
        try {
            String sql = "SELECT * FROM distribuidora WHERE id=?";
            pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            rs=pst.executeQuery();
            while (rs.next()) {
            a = new Distribuidora(rs.getString("nome"), rs.getInt("pk") );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return a;
    }

    @Override
    public Distribuidora readDistribuidoraByNome(String nome) {
        Distribuidora a = null;
        
        try{
            String sql = "SELECT * FROM distribuidora WHERE nome=?";
            pst = connection.prepareStatement(sql);
            pst.setString(1, nome);
            rs = pst.executeQuery();
            while(rs.next()){
                a = new Distribuidora(rs.getString("nome"), rs.getInt("pk"));
           }
        } catch( SQLException ex){
            ex.printStackTrace();
        }
        return a;
    }

    @Override
    public boolean updateDistribuidora(int id, Distribuidora distribuidora) {
        boolean res =false;
        
        try{
            String sql = "UPDATE distribuidora SET nome=? WHERE id=?";
            pst = connection.prepareStatement(sql);
            pst.setInt(2, id);
            int r = pst.executeUpdate();
            if(r > 0) res = true;
            else res = false;
        } catch (SQLException ex){
            Logger.getLogger(DistribuidoraDAOConcreto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    @Override
    public boolean deleteDistribuidora(Distribuidora distribuidora) {
        boolean resultado=false;
        try {
            String sql = "DELETE FROM distribuidora WHERE id=?";
            pst = connection.prepareStatement(sql);
            pst.setInt(1,distribuidora.getPk());
            int r = pst.executeUpdate();
            if(r>0) resultado = true;
            else resultado = false;
        } catch (SQLException ex) {
            Logger.getLogger(DistribuidoraDAOConcreto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    @Override
    public boolean deleteDistribuidora(int id) {
        boolean res = false;
        try{
            String sql = "DELETE FROM distribuidora WHERE id=?";
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
