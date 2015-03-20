<%-- 
    Document   : index
    Created on : 24/02/2015, 09:58:15
    Author     : 31448471
--%>


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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <% 
            Ator a = new Ator("Ronaldo", new Date(), "americano", 1);
            ListaAtores listaAtores = new ListaAtores();
            listaAtores.addAtor(a, "Jack", "Principal");
            
            Filme f = new Filme(1, new Diretor("Tim Burton", "123", 1), new Genero(1, "Acao"), listaAtores, "Busca Implacavel", 18, 1998, new Distribuidora("Warner", 1), "CARTAZ", 120, "LEG", true);
            out.println(f.toString());
        %>
        
    </body>
</html>

