package com.br.lp2.cinema.model.javabeans;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author 31448471
 * @version 1.0
 */
public class ListaAtores implements Serializable{
    private ArrayList<InfoAtor> lista;
    private int pk;

    public ListaAtores() {
        lista = new ArrayList<InfoAtor>();
    }

    public ListaAtores(int la) {
        this.pk = la;
    }

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }
    
    public void addAtor(Ator ator, String papel, String part){
        InfoAtor ia = new InfoAtor(ator, papel, part);
        lista.add(ia);
    }
    
    public void removeAtor(Ator ator){
        for(InfoAtor infoAtor : lista){
            if(ator.compara(infoAtor.getAtor())) lista.remove(infoAtor);
        }
    }
    
    public void trocaAtor(Ator ator1, Ator ator2, String papel, String part){
        removeAtor(ator1);
        addAtor(ator2, papel, part);
        
    }
    
    public boolean procuraAtor(Ator ator){
        boolean resp = false;
        
        for (InfoAtor infoAtor : lista) {
            if(ator.compara(infoAtor.getAtor())) resp = true;
        }
        return resp;
    }

    public ArrayList<InfoAtor> getLista() {
        return lista;
    }

    @Override
    public String toString() {
        return "ListaAtores{" + "lista=" + lista + '}';
    }
    
    
}
