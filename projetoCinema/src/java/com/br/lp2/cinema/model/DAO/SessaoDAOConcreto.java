/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.cinema.model.DAO;

import com.br.lp2.cinema.model.ConnectionFactory.ConnectionFactory;
import com.br.lp2.cinema.model.javabeans.Filme;
import com.br.lp2.cinema.model.javabeans.Sala;
import com.br.lp2.cinema.model.javabeans.Sessao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Paulo
 */
public class SessaoDAOConcreto implements SessaoDAO{
    
    private Connection connection;
    private PreparedStatement pst;
    private ResultSet rs;
    
    public SessaoDAOConcreto(){
        ConnectionFactory cf = new ConnectionFactory();
        connection = cf.getConnection("derby");
    }
    
    @Override
    public boolean insertSessao(Sessao sessao) {
        boolean resultado = false;
        try{
            String sql = "INSERT INTO sessao (filme,sala, diaHora, legendado, ingressos)VALUES (?,?,?,?,?)";
            pst = connection.prepareStatement(sql);
            
            pst.setObject(1, sessao.getSala());
            pst.setObject(2, sessao.getFilme());
            pst.setObject(3, sessao.getDiaHora());
            pst.setBoolean(4, sessao.isLegendado());
            pst.setObject(5, sessao.getIngressos());
            resultado = pst.execute();
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return resultado;
    }

    @Override
    public ArrayList<Sessao> readSessoes() {
        ArrayList<Sessao> lista = new ArrayList<>();
        try{
            String sql = "SELECT * FROM  sessao";
            pst = connection.prepareStatement(sql);
            
            rs = pst.executeQuery();
            while(rs.next()){
                Sessao a = new Sessao(rs.getInt("pk"), (Sala)rs.getObject("sala"), (Filme)rs.getObject("filme"), rs.getDate("diaHora"), rs.getBoolean("legendado"));
                lista.add(a);
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return lista;
    }

    @Override
    public Sessao readSessaoByHora(Date diaHora) {
        Sessao a = null;
        
        try{
            String sql = "SELECT * FROM sessao WHERE diaHora=?";
            pst = connection.prepareStatement(sql);
            pst.setDate(1, (java.sql.Date)diaHora);
            rs = pst.executeQuery();
            while(rs.next()){
                a = new Sessao(rs.getInt("pk"), (Sala)rs.getObject("sala"), (Filme)rs.getObject("filme"), rs.getDate("diaHora"), rs.getBoolean("legendado"));
           }
        } catch( SQLException ex){
        ex.printStackTrace();
        }
        return a;
    }

    @Override
    public boolean updateSessao(int id, Sessao sessao) {
        boolean res =false;
        
        try{
            String sql = "UPDATE sessao SET sala=? WHERE id=?";
            pst = connection.prepareStatement(sql);
            pst.setInt(2, id);
            int r = pst.executeUpdate();
            if(r > 0) res = true;
            else res = false;
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return res;
    }

    @Override
    public boolean deleteSessao(Sessao sessao) {
        boolean resultado=false;
        try {
            String sql = "DELETE FROM sessao WHERE id=?";
            pst = connection.prepareStatement(sql);
            pst.setObject(1, sessao);
            int r = pst.executeUpdate();
            if(r>0) resultado = true;
            else resultado = false;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resultado;
    }

    @Override
    public boolean deleteSessao(int id) {
        boolean res = false;
        try{
            String sql = "DELETE FROM sessao WHERE id=?";
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
