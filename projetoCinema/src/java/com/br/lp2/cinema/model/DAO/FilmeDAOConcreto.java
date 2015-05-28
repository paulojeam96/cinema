/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.cinema.model.DAO;

import com.br.lp2.cinema.model.ConnectionFactory.ConnectionFactory;
import com.br.lp2.cinema.model.javabeans.Diretor;
import com.br.lp2.cinema.model.javabeans.Distribuidora;
import com.br.lp2.cinema.model.javabeans.Filme;
import com.br.lp2.cinema.model.javabeans.Genero;
import com.br.lp2.cinema.model.javabeans.ListaAtores;
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
public class FilmeDAOConcreto implements FilmeDAO {

    private Connection connection;
    private PreparedStatement pst;
    private ResultSet rs;

    public FilmeDAOConcreto() {
        ConnectionFactory cf = new ConnectionFactory();
        connection = cf.getConnection("derby");
    }

    @Override
    public boolean insertFilme(Filme filme) {
        boolean resultado = false;
        try {
            String sql = "INSERT INTO filme(id_diretor, id_genero,id_distribuidora, nome, classificacao, ano,duracao, situacao, idioma) VALUES (?,?,?,?,?,?,?,?,?)";
            pst = connection.prepareStatement(sql);
            pst.setInt(1, filme.getId_diretor());
            pst.setInt(2, filme.getId_genero());
            pst.setObject(3, filme.getId_distribuidora());
            pst.setString(4, filme.getNome());
            pst.setInt(5, filme.getClassificacao());
            pst.setInt(6, filme.getAno());
            pst.setInt(7, filme.getDuracao());
            pst.setString(8, filme.getSituacao());
            pst.setString(9, filme.getIdioma());
            int r = pst.executeUpdate();
            if(r > 0) resultado = true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }

    @Override
    public ArrayList<Filme> readFilmes() {
        ArrayList<Filme> filmes = new ArrayList<>();
        try {
            String sql = "SELECT * FROM  filme";
            pst = connection.prepareStatement(sql);
            DiretorDAO diretor = new DiretorDAOConcreto();
            GeneroDAO genero = new GeneroDAOConcreto();
            InfoAtorDAO infoator = new InfoAtorDAOConcreto();
            DistribuidoraDAO distribuidora = new DistribuidoraDAOConcreto();
            rs = pst.executeQuery();
            while (rs.next()) {
                Filme f;
                f = new Filme(rs.getInt("pk"), (Diretor) diretor.readDiretorById(rs.getInt("id_diretor")), (Genero) genero.readGeneroById(rs.getInt("id_genero")), rs.getString("nome"), rs.getInt("classificacao"), rs.getInt("ano"), (Distribuidora) distribuidora.readDistribuidoraById(rs.getInt("id_distribuidora")), rs.getString("situacao"), rs.getInt("duracao"), rs.getString("idioma"));
                filmes.add(f);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return filmes;
    }

    @Override
    public Filme readFilmeById(int pk) {
        Filme f = null;

        try {
            String sql = "SELECT * FROM filme WHERE pk=?";
            pst = connection.prepareStatement(sql);
            pst.setInt(1, pk);
            DiretorDAO diretor = new DiretorDAOConcreto();
            GeneroDAO genero = new GeneroDAOConcreto();
            InfoAtorDAO infoator = new InfoAtorDAOConcreto();
            DistribuidoraDAO distribuidora = new DistribuidoraDAOConcreto();
            rs = pst.executeQuery();
            while (rs.next()) {
                f = new Filme(rs.getInt("pk"), (Diretor) diretor.readDiretorById(rs.getInt("id_diretor")), (Genero) genero.readGeneroById(rs.getInt("id_genero")), rs.getString("nome"), rs.getInt("classificacao"), rs.getInt("ano"), (Distribuidora) distribuidora.readDistribuidoraById(rs.getInt("id_distribuidora")), rs.getString("situacao"), rs.getInt("duracao"), rs.getString("idioma"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return f;
    }

    public ArrayList<Filme> readFilmeByGeneroID(int id) {
        ArrayList<Filme> filmes = new ArrayList();
        try {
            String sql = "SELECT * FROM filme INNER JOIN genero ON filme.id_genero = genero.pk WHERE genero.pk=?";
            pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            DiretorDAO diretor = new DiretorDAOConcreto();
            GeneroDAO genero = new GeneroDAOConcreto();
            InfoAtorDAO infoator = new InfoAtorDAOConcreto();
            DistribuidoraDAO distribuidora = new DistribuidoraDAOConcreto();
            while (rs.next()) {
                Filme f = new Filme(rs.getInt("pk"), (Diretor) diretor.readDiretorById(rs.getInt("id_diretor")), (Genero) genero.readGeneroById(rs.getInt("id_genero")), rs.getString("nome"), rs.getInt("classificacao"), rs.getInt("ano"), (Distribuidora) distribuidora.readDistribuidoraById(rs.getInt("id_distribuidora")), rs.getString("situacao"), rs.getInt("duracao"), rs.getString("idioma"));
                filmes.add(f);
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return filmes;
    }

    public ArrayList<Filme> readFilmeByAtorID(int id) {
        ArrayList<Filme> atores = new ArrayList();
        try {
            String sql = "SELECT * FROM filmes INNER JOIN Infoator ON filme.pk = Infoator.id_filme JOIN ator ON Infoator.id_ator = ator.pk WHERE ator.pk=?";
            pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            DiretorDAO diretor = new DiretorDAOConcreto();
            GeneroDAO genero = new GeneroDAOConcreto();
            InfoAtorDAO infoator = new InfoAtorDAOConcreto();
            DistribuidoraDAO distribuidora = new DistribuidoraDAOConcreto();
            while (rs.next()) {
                Filme f = new Filme(rs.getInt("pk"), (Diretor) diretor.readDiretorById(rs.getInt("id_diretor")), (Genero) genero.readGeneroById(rs.getInt("id_genero")), rs.getString("nome"), rs.getInt("classificacao"), rs.getInt("ano"), (Distribuidora) distribuidora.readDistribuidoraById(rs.getInt("id_distribuidora")), rs.getString("situacao"), rs.getInt("duracao"), rs.getString("idioma"));
                atores.add(f);
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return atores;
    }

    public ArrayList<Filme> readFilmeByDiretorID(int id) {
        ArrayList<Filme> lista = new ArrayList();
        try {
            String sql = "SELECT * FROM filme INNER JOIN diretor ON diretor.pk = filme.id_diretor WHERE diretor.pk=?";
            pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            DiretorDAO diretor = new DiretorDAOConcreto();
            GeneroDAO genero = new GeneroDAOConcreto();
            InfoAtorDAO infoator = new InfoAtorDAOConcreto();
            DistribuidoraDAO distribuidora = new DistribuidoraDAOConcreto();
            while (rs.next()) {
                Filme f = new Filme(rs.getInt("pk"), (Diretor) diretor.readDiretorById(rs.getInt("id_diretor")), (Genero) genero.readGeneroById(rs.getInt("id_genero")), rs.getString("nome"), rs.getInt("classificacao"), rs.getInt("ano"), (Distribuidora) distribuidora.readDistribuidoraById(rs.getInt("id_distribuidora")), rs.getString("situacao"), rs.getInt("duracao"), rs.getString("idioma"));
                lista.add(f);
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return lista;
    }

    public ArrayList<Filme> readFilmeByDistribuidoraID(int id) {
        ArrayList<Filme> lista = new ArrayList();
        try {
            String sql = "SELECT * FROM filme INNER JOIN distribuidora ON distribuidora.pk = filme.id_distribuidora WHERE distribuidora.pk=?";
            pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            DiretorDAO diretor = new DiretorDAOConcreto();
            GeneroDAO genero = new GeneroDAOConcreto();
            InfoAtorDAO infoator = new InfoAtorDAOConcreto();
            DistribuidoraDAO distribuidora = new DistribuidoraDAOConcreto();
            while (rs.next()) {
                Filme f = new Filme(rs.getInt("pk"), (Diretor) diretor.readDiretorById(rs.getInt("id_diretor")), (Genero) genero.readGeneroById(rs.getInt("id_genero")), rs.getString("nome"), rs.getInt("classificacao"), rs.getInt("ano"), (Distribuidora) distribuidora.readDistribuidoraById(rs.getInt("id_distribuidora")), rs.getString("situacao"), rs.getInt("duracao"), rs.getString("idioma"));
                lista.add(f);
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        return lista;

    }

    @Override
    public Filme readFilmeByNome(String nome) {
        Filme f = null;

        try {
            String sql = "SELECT * FROM filme WHERE nome=?";
            pst = connection.prepareStatement(sql);
            pst.setString(1, nome);
            DiretorDAO diretor = new DiretorDAOConcreto();
            GeneroDAO genero = new GeneroDAOConcreto();
            InfoAtorDAO infoator = new InfoAtorDAOConcreto();
            DistribuidoraDAO distribuidora = new DistribuidoraDAOConcreto();
            rs = pst.executeQuery();
            while (rs.next()) {
                f = new Filme(rs.getInt("pk"), (Diretor) diretor.readDiretorById(rs.getInt("id_diretor")), (Genero) genero.readGeneroById(rs.getInt("id_genero")), rs.getString("nome"), rs.getInt("classificacao"), rs.getInt("ano"), (Distribuidora) distribuidora.readDistribuidoraById(rs.getInt("id_distribuidora")), rs.getString("situacao"), rs.getInt("duracao"), rs.getString("idioma"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return f;
    }

    @Override
    public boolean updateFilme(int id, Filme filme) {
        boolean res = false;

        try {
            String sql = "UPDATE filme SET id_diretor=?, id_genero=?, id_distribuidora=?, nome=?, classificacao=?, ano=?, duracao=?, situacao=?, idioma=? WHERE pk=?";
            pst = connection.prepareStatement(sql);
            pst.setObject(1, filme.getId_diretor());
            pst.setObject(2, filme.getId_genero());
            pst.setObject(3, filme.getId_distribuidora());
            pst.setString(4, filme.getNome());
            pst.setInt(5, filme.getClassificacao());
            pst.setInt(6, filme.getAno());
            pst.setInt(7, filme.getDuracao());
            pst.setString(8, filme.getSituacao());
            pst.setString(9, filme.getIdioma());
            pst.setInt(10, id);
            int r = pst.executeUpdate();
            res = r > 0;
        } catch (SQLException ex) {
            Logger.getLogger(FilmeDAOConcreto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    @Override
    public boolean deleteFilme(Filme filme) {
        boolean resultado = false;
        try {
            String sql = "DELETE FROM filme WHERE nome=?";
            pst = connection.prepareStatement(sql);
            pst.setString(1, filme.getNome());
            int r = pst.executeUpdate();
            if (r > 0) {
                resultado = true;
            } else {
                resultado = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FilmeDAOConcreto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    @Override
    public boolean deleteFilme(int id) {
        boolean res = false;
        try {
            String sql = "DELETE FROM filme WHERE pk=?";
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
