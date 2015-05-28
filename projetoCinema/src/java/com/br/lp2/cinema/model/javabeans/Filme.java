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
    private int id_diretor;
    private Genero genero;
    private int id_genero;
    private String nome;
    private int classificacao;
    private int ano;
    private Distribuidora dist;
    private int id_distribuidora;
    private String situacao;
    private int duracao;
    private String idioma;

    public Filme(int pk) {
        this.pk = pk;
    }
    
     public Filme( int pk, Diretor diretor, Genero genero , String nome, int clas, int ano, Distribuidora distribuidora, String s, int duracao, String idioma) {
        this.pk = pk;
        this.diretor = diretor;
        this.genero = genero;
        this.nome = nome;
        this.classificacao = clas;
        this.ano = ano;
        this.dist = distribuidora;
        this.situacao = s;
        this.duracao = duracao;
        this.idioma = idioma;
        }

   
    public Filme(Diretor diretor, Genero genero, String nome, int classificacao, int ano, Distribuidora dist, String situacao, int duracao, String idioma) {
        
        this.diretor = diretor;
        this.genero = genero;
        this.nome = nome;
        this.classificacao = classificacao;
        this.ano = ano;
        this.dist = dist;
        this.situacao = situacao;
        this.duracao = duracao;
        this.idioma = idioma;
        
    }
    public Filme(int diretor, int genero, String nome, int classificacao, int ano, int dist, String situacao, int duracao, String idioma) {
        
        this.id_diretor = diretor;
        this.id_genero = genero;
        this.nome = nome;
        this.classificacao = classificacao;
        this.ano = ano;
        this.id_distribuidora = dist;
        this.situacao = situacao;
        this.duracao = duracao;
        this.idioma = idioma;
        
    }

    public int getId_diretor() {
        return id_diretor;
    }

    public void setId_diretor(int id_diretor) {
        this.id_diretor = id_diretor;
    }

    public int getId_genero() {
        return id_genero;
    }

    public void setId_genero(int id_genero) {
        this.id_genero = id_genero;
    }

    public int getId_distribuidora() {
        return id_distribuidora;
    }

    public void setId_distribuidora(int id_distribuidora) {
        this.id_distribuidora = id_distribuidora;
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

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
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
        return "pk=" + pk + "\n diretor=" + diretor + ",\n  genero=" + genero + "\n  nome=" + nome + ",\n  classificacao=" + classificacao + ",\n  ano=" + ano + ",\n  dist=" + dist + ",\n  situacao=" + situacao + ",\n  duracao=" + duracao + ",\n  idioma=" + idioma + '}';
    }

    
    
    
    
    
    
}
