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
public class FuncionarioDAOConcreto implements FuncionarioDAO {

    private Connection connection;
    private PreparedStatement pst;
    private ResultSet rs;

    public FuncionarioDAOConcreto() {
        ConnectionFactory cf = new ConnectionFactory();
        connection = cf.getConnection("derby");
    }

    @Override
    public boolean insertFuncionario(Funcionario funcionario) {
        boolean resultado = false;
        try {
            String sql = "INSERT INTO cinema.funcionario(pk, id, nome) VALUES(?,?,?)";
            pst = connection.prepareStatement(sql);
            pst.setInt(1, funcionario.getPk());
            pst.setInt(2, funcionario.getId());
            pst.setString(3, funcionario.getNome());
            resultado = pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    @Override
    public ArrayList<Funcionario> readFuncionarios() {
        ArrayList<Funcionario> lista = new ArrayList<>();

        try {
            String sql = "SELECT * FROM cinema.funcionario";
            pst = connection.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Funcionario f = new Funcionario(rs.getInt("pk"), rs.getInt("id"), rs.getString("nome"));
                lista.add(f);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    @Override
    public Funcionario readFuncionarioById(int id) {
        Funcionario f = null;

        try {
            String sql = "SELECT * FROM cinema.funcionario WHERE id=?";
            pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            while (rs.next()) {
                f = new Funcionario(rs.getInt("pk"), rs.getInt("id"), rs.getString("nome"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return f;
    }

    @Override
    public Funcionario readFuncionarioByNome(String nome) {
        Funcionario f = null;

        try {
            String sql = "SELECT * FROM cinema.funcionario WHERE nome=?";
            pst = connection.prepareStatement(sql);
            pst.setString(1, nome);
            rs = pst.executeQuery();
            while (rs.next()) {
                f = new Funcionario(rs.getInt("pk"), rs.getInt("id"), rs.getString("nome"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return f;
    }

    @Override
    public boolean updateFuncionario(int id, Funcionario funcionario) {
        boolean res = false;

        try {
            String sql = "UPDATE cinema.funcionario SET nome=? WHERE id=?";
            pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            int r = pst.executeUpdate();
            if (r > 0) {
                res = true;
            } else {
                res = false;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return res;
    }

    @Override
    public boolean deleteFuncionario(Funcionario funcionario) {
        boolean resultado = false;
        try {
            String sql = "DELETE FROM cinema.funcionario WHERE id=?";
            pst = connection.prepareStatement(sql);
            pst.setInt(1, funcionario.getPk());
            int r = pst.executeUpdate();
            if (r > 0) {
                resultado = true;
            } else {
                resultado = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAOConcreto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    @Override
    public boolean deleteFuncionario(int id) {
        boolean res = false;
        try {
            String sql = "DELETE FROM cinema.funcionario WHERE id=?";
            pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            int r = pst.executeUpdate();
            if (r > 0) {
                res = true;
            } else {
                res = false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return res;
    }

}
