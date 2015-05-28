/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.cinema.model.DAO;

import com.br.lp2.cinema.model.ConnectionFactory.ConnectionFactory;
import com.br.lp2.cinema.model.javabeans.Cliente;
import com.br.lp2.cinema.model.javabeans.Diretor;
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
public class DiretorDAOConcreto implements DiretorDAO{
    
    private Connection connection;
    private PreparedStatement pst;
    private ResultSet rs;
    
    public DiretorDAOConcreto(){
        ConnectionFactory cf = new ConnectionFactory();
        connection = cf.getConnection("derby");
    }

    @Override
    public boolean insertDiretor(Diretor diretor) {
        boolean resultado = false;
        try{
            String sql = "INSERT INTO diretor(nome, id, pk) VALUES (?,?,?)";
            pst = connection.prepareStatement(sql);
            pst.setString(1, diretor.getNome());
            pst.setInt(2, diretor.getId());
            pst.setInt(3, diretor.getPk());
            resultado = pst.execute();
        } catch(SQLException ex){
             Logger.getLogger(DiretorDAOConcreto.class.getName()).log(Level.SEVERE, null, ex);
               }
        return resultado;
    }

    @Override
    public ArrayList<Diretor> readDiretores() {
        ArrayList<Diretor> lista = new ArrayList<>();
        try{
            String sql = "SELECT * FROM  diretor";
            pst = connection.prepareStatement(sql);
            
            rs = pst.executeQuery();
            while(rs.next()){
                Diretor d = new Diretor( rs.getString("nome"), rs.getInt("id"), rs.getInt("pk"));
                lista.add(d);
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return lista;    
    }

    @Override
    public Diretor readDiretorById(int id) {
        Diretor a = null;
        
        try {
            String sql = "SELECT * FROM diretor WHERE id=?";
            pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            rs=pst.executeQuery();
            while (rs.next()) {
            a = new Diretor(rs.getString("nome"), rs.getInt("id"), rs.getInt("pk") );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return a;
    }

    @Override
    public Diretor readDiretorByNome(String nome) {
        Diretor a = null;
        
        try{
            String sql = "SELECT * FROM diretor WHERE nome=?";
            pst = connection.prepareStatement(sql);
            pst.setString(1, nome);
            rs = pst.executeQuery();
            while(rs.next()){
                a = new Diretor(rs.getString("nome"), rs.getInt("id"), rs.getInt("pk"));
           }
        } catch( SQLException ex){
            ex.printStackTrace();
        }
        return a;
    }

    @Override
    public boolean updateDiretor(int id, Diretor diretor) {
        boolean res =false;
        
        try{
            String sql = "UPDATE diretor SET nome=? WHERE id=?";
            pst = connection.prepareStatement(sql);
            pst.setString(1, diretor.getNome());
            int r = pst.executeUpdate();
            if(r > 0) res = true;
            else res = false;
        } catch (SQLException ex){
            Logger.getLogger(DiretorDAOConcreto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    @Override
    public boolean deleteDiretor(Diretor diretor) {
        boolean resultado=false;
        try {
            String sql = "DELETE FROM diretor WHERE id=?";
            pst = connection.prepareStatement(sql);
            pst.setInt(1,diretor.getId());
            int r = pst.executeUpdate();
            if(r>0) resultado = true;
            else resultado = false;
        } catch (SQLException ex) {
            Logger.getLogger(DiretorDAOConcreto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    @Override
    public boolean deleteDiretor(int id) {
        boolean res = false;
        try{
            String sql = "DELETE FROM diretor WHERE id=?";
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
