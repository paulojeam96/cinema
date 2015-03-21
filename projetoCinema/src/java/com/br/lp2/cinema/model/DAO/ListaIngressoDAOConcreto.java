/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.cinema.model.DAO;

import com.br.lp2.cinema.model.ConnectionFactory.ConnectionFactory;
import com.br.lp2.cinema.model.javabeans.ListaIngresso;
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
public class ListaIngressoDAOConcreto implements ListaIngressoDAO{
    
    private Connection connection;
    private PreparedStatement pst;
    private ResultSet rs;
    
    public ListaIngressoDAOConcreto(){
        ConnectionFactory cf = new ConnectionFactory();
        connection = cf.getConnection("derby");
    }

    @Override
    public boolean insertListaIngresso(ListaIngresso listaIngresso) {
        boolean resultado = false;
        try{
            String sql = "INSERT INTO listaIngresso(nome) VALUES (?)";
            pst = connection.prepareStatement(sql);
            pst.setObject(1, listaIngresso.getLista());
            resultado = pst.execute();
        } catch(SQLException ex){
            Logger.getLogger(ListaIngressoDAOConcreto.class.getName()).log(Level.SEVERE, null, ex);
           
        }
        return resultado;
    }

    @Override
    public ArrayList<ListaIngresso> readListaIngresso() {
        ArrayList<ListaIngresso> lista = new ArrayList<>();
        try{
            String sql = "SELECT * FROM  listaIngresso";
            pst = connection.prepareStatement(sql);
            
            rs = pst.executeQuery();
            
                ListaIngresso a = new ListaIngresso();
                lista.add(a);
            
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return lista;
    }

    @Override
    public ListaIngresso readListaIngressoById(int id) {
        ListaIngresso a = null;
        
        try {
            String sql = "SELECT * FROM listaIngresso WHERE pk=?";
            pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            rs=pst.executeQuery();
            while (rs.next()) {
                a = new ListaIngresso();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return a;
    }

    @Override
    public boolean updateListaIngresso(int id, ListaIngresso listaIngresso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteListaIngresso(ListaIngresso listaIngresso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteListaIngresso(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
