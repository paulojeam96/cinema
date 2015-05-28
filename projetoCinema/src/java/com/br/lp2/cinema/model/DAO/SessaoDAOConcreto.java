/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.cinema.model.DAO;

import com.br.lp2.cinema.model.ConnectionFactory.ConnectionFactory;
import com.br.lp2.cinema.model.javabeans.Filme;
import com.br.lp2.cinema.model.javabeans.ListaIngresso;
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
public class SessaoDAOConcreto implements SessaoDAO {

    private Connection connection;
    private PreparedStatement pst;
    private ResultSet rs;

    public SessaoDAOConcreto() {
        ConnectionFactory cf = new ConnectionFactory();
        connection = cf.getConnection("derby");
    }

    @Override
    public boolean insertSessao(Sessao sessao) {
        boolean resultado = false;
        try {
            String sql = "INSERT INTO sessao (id_filme,id_sala, diaHora, legendado)VALUES (?,?,?,?)";
            pst = connection.prepareStatement(sql);

            pst.setObject(1, sessao.getFilme().getPk());
            pst.setObject(2, sessao.getSala().getNum());
            pst.setObject(3, sessao.getDiaHora());
            pst.setBoolean(4, sessao.isLegendado());
            int r = pst.executeUpdate();
            if(r > 0) resultado = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resultado;
    }

    @Override
    public ArrayList<Sessao> readSessoes() {
        ArrayList<Sessao> lista = new ArrayList<>();
        try {
            String sql = "SELECT * FROM  sessao";
            pst = connection.prepareStatement(sql);
            rs = pst.executeQuery();
            FilmeDAO fDao = new FilmeDAOConcreto();
            SalaDAO sDao = new SalaDAOConcreto();
            while (rs.next()) {
                Sessao a = new Sessao(rs.getInt("pk"), (Sala)sDao.readSalaById(rs.getInt("id_sala")) , (Filme)fDao.readFilmeById(rs.getInt("id_filme")) , rs.getString("diaHora"), rs.getBoolean("legendado"));
                lista.add(a);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    @Override
    public Sessao readSessaoByHora(String diaHora) {
        Sessao a = null;

        try {
            String sql = "SELECT * FROM sessao WHERE diaHora=?";
            pst = connection.prepareStatement(sql);
            pst.setString(1, diaHora);
            rs = pst.executeQuery();
            FilmeDAO fDao = new FilmeDAOConcreto();
            SalaDAO sDao = new SalaDAOConcreto();
            while (rs.next()) {
                a = new Sessao(rs.getInt("pk"), (Sala)sDao.readSalaById(rs.getInt("id_sala")), (Filme)fDao.readFilmeById(rs.getInt("id_filme")) , rs.getString("diaHora"), rs.getBoolean("legendado"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return a;
    }

    @Override
    public Sessao readSessaoByPk(int id) {
        Sessao a = null;

        try {
            String sql = "SELECT * FROM sessao WHERE pk=?";
            pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            SalaDAO sDao = new SalaDAOConcreto();
            FilmeDAO fDao = new FilmeDAOConcreto();
            while (rs.next()) {
                a = new Sessao(rs.getInt("pk"), (Sala) sDao.readSalaById(rs.getInt("id_sala")), (Filme) fDao.readFilmeById(rs.getInt("id_filme")), rs.getString("diaHora"), rs.getBoolean("legendado"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return a;
    }

    @Override
    public boolean updateSessao(int id, Sessao sessao) {
        boolean res = false;

        try {
            String sql = "UPDATE sessao SET id_sala=?, id_filme=?,legendado=?, diaHora=? WHERE pk=?";
            pst = connection.prepareStatement(sql);
            pst.setInt(1, sessao.getSala().getNum());
            pst.setInt(2, sessao.getFilme().getPk());
            pst.setBoolean(3, sessao.isLegendado());
            pst.setString(4, sessao.getDiaHora());
            pst.setInt(5, id);
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
    public boolean deleteSessao(Sessao sessao) {
        boolean resultado = false;
        try {
            String sql = "DELETE FROM sessao WHERE id=?";
            pst = connection.prepareStatement(sql);
            pst.setObject(1, sessao);
            int r = pst.executeUpdate();
            if (r > 0) {
                resultado = true;
            } else {
                resultado = false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resultado;
    }

    @Override
    public boolean deleteSessao(int id) {
        boolean res = false;
        try {
            String sql = "DELETE FROM sessao WHERE pk=?";
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
    public Sessao readSessaoByFilme(String nome) {
        Sessao a = null;

        try {
            String sql = "SELECT * FROM sessao INNER JOIN filme ON sessao.id_filme = filme.pk WHERE filme.pk=?";
            pst = connection.prepareStatement(sql);
            pst.setString(1, nome);
            rs = pst.executeQuery();
            SalaDAO sDao = new SalaDAOConcreto();
            FilmeDAO fDao = new FilmeDAOConcreto();
            while (rs.next()) {
                a = new Sessao(rs.getInt("pk"), (Sala) sDao.readSalaById(rs.getInt("id_sala")), (Filme) fDao.readFilmeById(rs.getInt("id_filme")), rs.getString("diaHora"), rs.getBoolean("legendado"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return a;
    }

    @Override
    public Sessao readSessaoBySala(int sala) {
        Sessao a = null;

        try {
            String sql = "SELECT * FROM sessao INNER JOIN sala ON sessao.id_sala = sala.num WHERE sala.num=?";
            pst = connection.prepareStatement(sql);
            pst.setInt(1, sala);
            rs = pst.executeQuery();
            SalaDAO sDao = new SalaDAOConcreto();
            FilmeDAO fDao = new FilmeDAOConcreto();
            while (rs.next()) {
                a = new Sessao(rs.getInt("pk"), (Sala) sDao.readSalaById(rs.getInt("id_sala")), (Filme) fDao.readFilmeById(rs.getInt("id_filme")), rs.getString("diaHora"), rs.getBoolean("legendado"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return a;
    }

}
