<%-- 
    Document   : index
    Created on : 24/02/2015, 09:58:15
    Author     : 31448471
--%>


<%@page import="com.br.lp2.cinema.model.DAO.FilmeDAOConcreto"%>
<%@page import="com.br.lp2.cinema.model.DAO.FilmeDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.br.lp2.cinema.model.DAO.AtorDAOConcreto"%>
<%@page import="com.br.lp2.cinema.model.DAO.AtorDAO"%>
<%@page import="com.br.lp2.cinema.model.DAO.AtorDAO"%>
<%@page import="java.util.Date"%>
<%@page import="com.br.lp2.cinema.model.javabeans.ListaAtores"%>
<%@page import="com.br.lp2.cinema.model.javabeans.Ator"%>
<%@page import="com.br.lp2.cinema.model.javabeans.Distribuidora"%>
<%@page import="com.br.lp2.cinema.model.javabeans.Genero"%>
<%@page import="com.br.lp2.cinema.model.javabeans.Diretor"%>
<%@page import="com.br.lp2.cinema.model.javabeans.Filme"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Atores Cinema</title>
        <style>
            
            h1{
                background-color: #333300;
                color: #ffffff;
            }
        </style>
            
    </head>
    <body>
        <h1>Atores Americanos</h1>
        <% 
            AtorDAO atorDAO = new AtorDAOConcreto();
        ArrayList<Ator> listaAtor = atorDAO.readAtores();
        for (Ator ator : listaAtor) {
            out.println("<h1>"+ator.getNome()+" - "+ator.getDataNascimento()+ " - "+ ator.getNascionalidade()+"</h1>");
        }
        
        FilmeDAO filmeDAO= new FilmeDAOConcreto();
        filmeDAO.readFilmes();
        
        out.print(filmeDAO.readFilmeByNome("HANCOCK"));
        
        %>
        
    </body>
</html>

