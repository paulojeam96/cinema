package com.br.lp2.cinema.model.DAO;

import com.br.lp2.cinema.model.javabeans.Ator;
import com.br.lp2.cinema.model.ConnectionFactory.ConnectionFactory;
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
public class AtorDAOConcreto implements AtorDAO{
    
    private Connection connection;
    private PreparedStatement pst;
    private ResultSet rs;
    
    public AtorDAOConcreto(){
        ConnectionFactory cf = new ConnectionFactory();
        connection = cf.getConnection("derby");
    }
    
    
    @Override
    public boolean insertAtor(Ator ator) {
        boolean resultado = false;
        try{
            String sql = "INSERT INTO ator(nome) VALUES (?)";
            pst = connection.prepareStatement(sql);
            pst.setString(1, ator.getNome());
            resultado = pst.execute();
        } catch(SQLException ex){
             Logger.getLogger(AtorDAOConcreto.class.getName()).log(Level.SEVERE, null, ex);
           
        }
        return resultado;
    }

    @Override
    public ArrayList<Ator> readAtores() {
        ArrayList<Ator> lista = new ArrayList<>();
        try{
            String sql = "SELECT * FROM  ator";
            pst = connection.prepareStatement(sql);
            
            rs = pst.executeQuery();
            while(rs.next()){
                Ator a = new Ator(rs.getString("nome"), rs.getDate("dataNascimento"), rs.getString("nascionalidade"), rs.getInt("pk"));
                lista.add(a);
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return lista;
    }

    @Override
    public Ator readAtorById(int id) {
        Ator a = null;
        
        try {
            String sql = "SELECT * FROM ator WHERE id=?";
            pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            rs=pst.executeQuery();
            while (rs.next()) {
                a = new Ator(rs.getString("nome"), rs.getDate("dataNascimento"), rs.getString("nascionalidade"), rs.getInt("pk"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return a;
    }

    @Override
    public Ator readAtorByNome(String nome) {
        Ator a = null;
        
        try{
            String sql = "SELECT * FROM ator WHERE nome=?";
            pst = connection.prepareStatement(sql);
            pst.setString(1, nome);
            rs = pst.executeQuery();
            while(rs.next()){
                a = new Ator(rs.getString("nome"), rs.getDate("dataNascimento"), rs.getString("nascionalidade"), rs.getInt("pk"));
           }
        } catch( SQLException ex){
        ex.printStackTrace();
        }
        return a;
    }

    @Override
    public boolean updateAtor(int id, Ator ator) {
        boolean res =false;
        
        try{
            String sql = "UPDATE ator SET nome=? WHERE id=?";
            pst = connection.prepareStatement(sql);
            pst.setInt(2, id);
            int r = pst.executeUpdate();
            if(r > 0) res = true;
            else res = false;
        } catch (SQLException ex){
            Logger.getLogger(AtorDAOConcreto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    
    @Override
    public boolean deleteAtor(Ator ator) {
        boolean resultado=false;
        try {
            String sql = "DELETE FROM ator WHERE id=?";
            pst = connection.prepareStatement(sql);
            pst.setInt(1,ator.getPk());
            int r = pst.executeUpdate();
            if(r>0) resultado = true;
            else resultado = false;
        } catch (SQLException ex) {
            Logger.getLogger(AtorDAOConcreto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
    
    @Override
    public boolean deleteAtor(int id) {
        boolean res = false;
        try{
            String sql = "DELETE FROM ator WHERE id=?";
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