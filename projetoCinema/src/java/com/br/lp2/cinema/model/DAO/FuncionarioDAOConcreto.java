/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.cinema.model.DAO;

import com.br.lp2.cinema.model.ConnectionFactory.ConnectionFactory;
import com.br.lp2.cinema.model.javabeans.Funcionario;
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
public class FuncionarioDAOConcreto implements FuncionarioDAO{
    
    private Connection connection;
    private PreparedStatement pst;
    private ResultSet rs;
    
    public FuncionarioDAOConcreto(){
        ConnectionFactory cf = new ConnectionFactory();
        connection = cf.getConnection("derby");
    }

    @Override
    public boolean insertFuncionario(Funcionario funcionario) {
        boolean resultado = false;
        try{
            String sql = "INSERT INTO funcionario(nome) VALUES (?)";
            pst = connection.prepareStatement(sql);
            pst.setString(1, funcionario.getNome());
            resultado = pst.execute();
        } catch(SQLException ex){
             Logger.getLogger(FuncionarioDAOConcreto.class.getName()).log(Level.SEVERE, null, ex);
               }
        return resultado;
    }

    @Override
    public ArrayList<Funcionario> readFuncionarios() {
        ArrayList<Funcionario> lista = new ArrayList<>();
        try{
            String sql = "SELECT * FROM  funcionario";
            pst = connection.prepareStatement(sql);
            
            rs = pst.executeQuery();
            while(rs.next()){
                Funcionario d = new Funcionario(rs.getInt("pk"), rs.getInt("id"), rs.getString("nome"));
                lista.add(d);
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return lista;    
    }

    @Override
    public Funcionario readFuncionarioById(int id) {
        Funcionario a = null;
        
        try {
            String sql = "SELECT * FROM funcionario WHERE id=?";
            pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            rs=pst.executeQuery();
            while (rs.next()) {
            a = new Funcionario(rs.getInt("pk"),rs. getInt("id"), rs.getString("nome"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return a;
    }

    @Override
    public Funcionario readFuncionarioByNome(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateFuncionario(int id, Funcionario funcionario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteFuncionario(Funcionario funcionario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteFuncionario(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
