/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.cinema.model.DAO;

import com.br.lp2.cinema.model.javabeans.Sessao;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Paulo
 */
public interface SessaoDAO {
    //CRUD
    //C - CREATE
    public boolean insertSessao(Sessao sessao);
    
    //R - READ
    public ArrayList<Sessao> readSessoes();
    public Sessao readSessaoByHora(String diaHora);
    public Sessao readSessaoByFilme(String nome);
    public Sessao readSessaoBySala(int sala);
    public Sessao readSessaoByPk(int id);
    
    //U - UPDATE
    public boolean updateSessao(int id, Sessao sessao);
    
    //D - DELETE
    public boolean deleteSessao(Sessao sessao);
    public boolean deleteSessao(int id);
}
