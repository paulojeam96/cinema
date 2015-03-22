/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.cinema.model.DAO;

import com.br.lp2.cinema.model.ConnectionFactory.ConnectionFactory;
import com.br.lp2.cinema.model.javabeans.Genero;
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
public class GeneroDAOConcreto implements GeneroDAO{
    
    private Connection connection;
    private PreparedStatement pst;
    private ResultSet rs;
    
    public GeneroDAOConcreto(){
        ConnectionFactory cf = new ConnectionFactory();
        connection = cf.getConnection("derby");
    }

    @Override
    public boolean insertGenero(Genero genero) {
        boolean resultado = false;
        try{
            String sql = "INSERT INTO cinema.genero(nome) VALUES (?)";
            pst = connection.prepareStatement(sql);
            pst.setString(1, genero.getNome());
            resultado = pst.execute();
        } catch(SQLException ex){
             Logger.getLogger(GeneroDAOConcreto.class.getName()).log(Level.SEVERE, null, ex);
               }
        return resultado;
    }

    @Override
    public ArrayList<Genero> readGeneros() {
        ArrayList<Genero> lista = new ArrayList<>();
        try{
            String sql = "SELECT * FROM  cinema.genero";
            pst = connection.prepareStatement(sql);
            
            rs = pst.executeQuery();
            while(rs.next()){
                Genero d = new Genero( rs.getInt("pk"), rs.getString("nome"));
                lista.add(d);
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return lista;    
    }

    @Override
    public Genero readGeneroById(int id) {
         Genero a = null;
        
        try {
            String sql = "SELECT * FROM cinema.genero WHERE id=?";
            pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            rs=pst.executeQuery();
            while (rs.next()) {
            a = new Genero( rs.getInt("pk"), rs.getString("nome"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return a;
    }

    @Override
    public Genero readGeneroByNome(String nome) {
        Genero a = null;
        
        try{
            String sql = "SELECT * FROM cinema.genero WHERE nome=?";
            pst = connection.prepareStatement(sql);
            pst.setString(1, nome);
            rs = pst.executeQuery();
            while(rs.next()){
                a = new Genero( rs.getInt("pk"), rs.getString("nome"));
           }
        } catch( SQLException ex){
            ex.printStackTrace();
        }
        return a;
    }

    @Override
    public boolean updateGenero(int id, Genero genero) {
       boolean res =false;
        
        try{
            String sql = "UPDATE cinema.genero SET nome=? WHERE id=?";
            pst = connection.prepareStatement(sql);
            pst.setInt(2, id);
            int r = pst.executeUpdate();
            if(r > 0) res = true;
            else res = false;
        } catch (SQLException ex){
            Logger.getLogger(GeneroDAOConcreto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    @Override
    public boolean deleteGenero(Genero genero) {
        boolean resultado=false;
        try {
            String sql = "DELETE FROM cinema.genero WHERE id=?";
            pst = connection.prepareStatement(sql);
            pst.setInt(1,genero.getPk());
            int r = pst.executeUpdate();
            if(r>0) resultado = true;
            else resultado = false;
        } catch (SQLException ex) {
            Logger.getLogger(GeneroDAOConcreto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    @Override
    public boolean deleteGenero(int id) {
        boolean res = false;
        try{
            String sql = "DELETE FROM cinema.genero WHERE id=?";
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
