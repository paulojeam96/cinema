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
public class FilmeDAOConcreto implements FilmeDAO{
    
    private Connection connection;
    private PreparedStatement pst;
    private ResultSet rs;
    
    public FilmeDAOConcreto(){
        ConnectionFactory cf = new ConnectionFactory();
        connection = cf.getConnection("derby");
    }

    @Override
    public boolean insertFilme(Filme filme) {
        boolean resultado = false;
        try{
            String sql = "INSERT INTO cinema.filme(nome) VALUES (?)";
            pst = connection.prepareStatement(sql);
            pst.setString(1, filme.getNome());
            resultado = pst.execute();
        } catch(SQLException ex){
             Logger.getLogger(FilmeDAOConcreto.class.getName()).log(Level.SEVERE, null, ex);
               }
        return resultado;
    }

    @Override
    public ArrayList<Filme> readFilmes() {
        ArrayList<Filme> lista = new ArrayList<>();
        try{
            String sql = "SELECT * FROM  cinema.filme";
            pst = connection.prepareStatement(sql);
            
            rs = pst.executeQuery();
            while(rs.next()){
                Filme d = new Filme(rs.getInt("pk"),(Diretor) rs.getObject("diretor"), (Genero)rs.getObject("genero"),(ListaAtores) rs.getObject("listaAtores"), rs.getString("nome"), rs.getInt("classificacao"), rs.getInt("ano"), (Distribuidora)rs.getObject("distribuidora"), rs.getString("situacao"), rs.getInt("duracao"), rs.getString("idioma"));
                lista.add(d);
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return lista;    
    }

    @Override
    public Filme readFilmeById(int id) {
        Filme a = null;
        
        try {
            String sql = "SELECT * FROM cinema.filme WHERE id=?";
            pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            rs=pst.executeQuery();
            while (rs.next()) {
            a = new Filme(rs.getInt("pk"),(Diretor) rs.getObject("diretor"), (Genero)rs.getObject("genero"),(ListaAtores) rs.getObject("listaAtores"), rs.getString("nome"), rs.getInt("classificacao"), rs.getInt("ano"), (Distribuidora)rs.getObject("distribuidora"), rs.getString("situacao"), rs.getInt("duracao"), rs.getString("idioma"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return a;
    }

    @Override
    public Filme readFilmeByNome(String nome) {
        Filme a = null;
        
        try{
            String sql = "SELECT * FROM cinema.filme WHERE nome=?";
            pst = connection.prepareStatement(sql);
            pst.setString(1, nome);
            rs = pst.executeQuery();
            while(rs.next()){
            a = new Filme(rs.getInt("pk"),(Diretor) rs.getObject("diretor"), (Genero)rs.getObject("genero"),(ListaAtores) rs.getObject("listaAtores"), rs.getString("nome"), rs.getInt("classificacao"), rs.getInt("ano"), (Distribuidora)rs.getObject("distribuidora"), rs.getString("situacao"), rs.getInt("duracao"), rs.getString("idioma"));
           }
        } catch( SQLException ex){
            ex.printStackTrace();
        }
        return a;
    }

    @Override
    public boolean updateFilme(int id, Filme filme) {
        boolean res =false;
        
        try{
            String sql = "UPDATE cinema.filme SET nome=? WHERE id=?";
            pst = connection.prepareStatement(sql);
            pst.setInt(2, id);
            int r = pst.executeUpdate();
            if(r > 0) res = true;
            else res = false;
        } catch (SQLException ex){
            Logger.getLogger(FilmeDAOConcreto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    @Override
    public boolean deleteFilme(Filme filme) {
        boolean resultado=false;
        try {
            String sql = "DELETE FROM cinema.filme WHERE id=?";
            pst = connection.prepareStatement(sql);
            pst.setInt(1,filme.getPk());
            int r = pst.executeUpdate();
            if(r>0) resultado = true;
            else resultado = false;
        } catch (SQLException ex) {
            Logger.getLogger(FilmeDAOConcreto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    @Override
    public boolean deleteFilme(int id) {
        boolean res = false;
        try{
            String sql = "DELETE FROM cinema.filme WHERE id=?";
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
