package com.br.lp2.cinema.model.javabeans;

import java.io.Serializable;

/**
 *
 * @author paulojeam
 * @version 1.0
 */
public class Filme implements Serializable{
    private int pk;
    private Diretor diretor;
    private Genero genero;
    private ListaAtores listaAtores;
    private String nome;
    private int classificacao;
    private int ano;
    private Distribuidora dist;
    private tipoSituacao situacao;
    public enum tipoSituacao{ CARTAZ, ESTREIA, LANCAMENTO;}
    private int duracao;
    private String idioma;
    
    
     public Filme( int pk, Diretor diretor, Genero genero, ListaAtores listaAtores, String nome, int clas, int ano, Distribuidora distribuidora, tipoSituacao s, int duracao, String idioma) {
        this.pk = pk;
        this.diretor = diretor;
        this.genero = genero;
        this.listaAtores = listaAtores;
        this.nome = nome;
        this.classificacao = classificacao;
        this.ano = ano;
        this.dist = dist;
        this.situacao = s;
        this.duracao = duracao;
        this.idioma = idioma;
        }

   
    public Filme(Diretor diretor, Genero genero, ListaAtores listaAtores, String nome, int classificacao, int ano, Distribuidora dist, tipoSituacao situacao, int duracao, String idioma) {
        
        this.diretor = diretor;
        this.genero = genero;
        this.listaAtores = listaAtores;
        this.nome = nome;
        this.classificacao = classificacao;
        this.ano = ano;
        this.dist = dist;
        this.situacao = situacao;
        this.duracao = duracao;
        this.idioma = idioma;
        
    }

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public Diretor getDiretor() {
        return diretor;
    }

    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public ListaAtores getListaAtores() {
        return listaAtores;
    }

    public void setListaAtores(ListaAtores listaAtores) {
        this.listaAtores = listaAtores;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Distribuidora getDist() {
        return dist;
    }

    public void setDist(Distribuidora dist) {
        this.dist = dist;
    }

    public tipoSituacao getSituacao() {
        return situacao;
    }

    public void setSituacao(tipoSituacao situacao) {
        this.situacao = situacao;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    @Override
    public String toString() {
        return "Filme{" + "pk=" + pk + ", diretor=" + diretor + ", genero=" + genero + ", listaAtores=" + listaAtores + ", nome=" + nome + ", classificacao=" + classificacao + ", ano=" + ano + ", dist=" + dist + ", situacao=" + situacao + ", duracao=" + duracao + ", idioma=" + idioma + '}';
    }

    
    
    
    
    
    
}
