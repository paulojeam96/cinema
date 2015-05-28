/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.cinema.model.DAO;

import com.br.lp2.cinema.model.ConnectionFactory.ConnectionFactory;
import com.br.lp2.cinema.model.javabeans.Ingresso;
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
public class ListaIngressoDAOConcreto implements ListaIngressoDAO {

    private Connection connection;
    private PreparedStatement pst;
    private ResultSet rs;

    public ListaIngressoDAOConcreto() {
        ConnectionFactory cf = new ConnectionFactory();
        connection = cf.getConnection("derby");
    }

    @Override
    public boolean insertIngresso(int ingresso) {
        boolean resultado = false;
        try {
            String sql = "INSERT INTO ListaIngressos(id_ingresso) VALUES (?)";
            pst = connection.prepareStatement(sql);
            pst.setInt(1, ingresso);
            int r = pst.executeUpdate();
            if (r > 0) {
                resultado = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ListaIngressoDAOConcreto.class.getName()).log(Level.SEVERE, null, ex);

        }
        return resultado;
    }

    @Override
    public ArrayList<ListaIngresso> readListaIngresso() {
        ArrayList<ListaIngresso> lista = new ArrayList<>();
        try {
            String sql = "SELECT * FROM ListaIngressos INNER JOIN ingresso ON ListaIngressos.id_ingresso = ingresso.id WHERE ingresso.id=?";
            pst = connection.prepareStatement(sql);
            IngressoDAO iDao = new IngressoDAOConcreto();
            rs = pst.executeQuery();
            
            ListaIngresso a = new ListaIngresso();
                lista.add(a);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    @Override
    public ListaIngresso readListaIngressoById(int id) {
        ListaIngresso a = null;

        try {
            String sql = "SELECT * FROM ListaIngressos WHERE pk=?";
            pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            while (rs.next()) {
                a = new ListaIngresso();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return a;
    }

    @Override
    public boolean updateListaIngresso(int id, int listaIngresso) {
        boolean res = false;

        try {
            String sql = "UPDATE listaIngresso SET nome=? WHERE id=?";
            pst = connection.prepareStatement(sql);
            pst.setInt(2, id);
            int r = pst.executeUpdate();
            if (r > 0) {
                res = true;
            } else {
                res = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ListaIngressoDAOConcreto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    @Override
    public boolean deleteListaIngresso(int listaIngresso) {
        boolean resultado = false;
        try {
            String sql = "DELETE FROM listaIngresso WHERE id=?";
            pst = connection.prepareStatement(sql);
            pst.setInt(1, listaIngresso);
            int r = pst.executeUpdate();
            if (r > 0) {
                resultado = true;
            } else {
                resultado = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AtorDAOConcreto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
}
