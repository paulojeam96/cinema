/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.cinema.model.DAO;

import com.br.lp2.cinema.model.ConnectionFactory.ConnectionFactory;
import com.br.lp2.cinema.model.javabeans.Funcionario;
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
public class GerenteDAOConcreto implements GerenteDAO {
    private static Connection connection;
    private static PreparedStatement pst;
    private static ResultSet rs;  
    
    public GerenteDAOConcreto(){
        ConnectionFactory cf = new ConnectionFactory();
        connection = cf.getConnection("derby");
    }
    
    @Override
    public boolean insertGerente(Funcionario gerente) {
        boolean resultado = false;
        try {
            String sql = "INSERT INTO cinema.gerente (nome,senha) VALUES(?,?)";
            pst = connection.prepareStatement(sql);
            pst.setString(1, gerente.getNome());
            pst.setString(2, gerente.getSenha());
            int r = pst.executeUpdate();
            if(r>0) resultado = true;
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return resultado;
    }

    @Override
    public ArrayList<Gerente> readGerente() {
        ArrayList<Gerente> lista = new ArrayList();
        try {
            String sql = "SELECT * FROM cinema.gerente";
            pst = connection.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Gerente a = new Gerente(rs.getString("nome"), rs.getString("senha"));
                lista.add(a);
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return lista;
    }

    @Override
    public Gerente readGerenteById(int id) {
        Gerente g = null;
        try {
            String sql = "SELECT * FROM cinema.gerente WHERE pk =?";
            pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            while (rs.next()) {
                g = new Gerente(rs.getString("nome"), rs.getString("senha"));
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return g;
    }

    @Override
    public Gerente readGerenteByNome(String nome) {
        Gerente g = null;
        try {
            String sql = "SELECT * FROM cinema.gerente WHERE nome =?";
            pst = connection.prepareStatement(sql);
            pst.setString(1, nome);
            rs = pst.executeQuery();
            while (rs.next()) {
                g = new Gerente(rs.getString("nome"), rs.getString("senha"));
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return g;
    }

    @Override
    public boolean updateGerente(int id, Funcionario gerente) {
        boolean resultado = false;
        try {
            String sql = "UPDATE cinema.gerente SET nome=?, senha=? WHERE pk=?";
            pst = connection.prepareStatement(sql);
            pst.setString(1, gerente.getNome());
            pst.setString(2, gerente.getSenha());
            pst.setInt(3, id);
            int r = pst.executeUpdate();
            if(r>0) resultado = true;
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return resultado;    
    }

    @Override
    public boolean deleteGerente(int id) {
        boolean resultado = false;
        try {
            String sql = "DELETE FROM cinema.gerente WHERE pk = ?";
            pst = connection.prepareStatement(sql);
            pst.setInt(1, id); 
            int r = pst.executeUpdate();
            resultado = r>0;
            
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return resultado;
    }

    @Override
    public boolean deleteGerente(Funcionario gerente) {
        boolean resultado = false;
        try {
            String sql = "DELETE FROM cinema.gerente WHERE VALUES(?)";
            pst = connection.prepareStatement(sql);
            int r = pst.executeUpdate();
            resultado = r>0;
            
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return resultado;
    }
}
