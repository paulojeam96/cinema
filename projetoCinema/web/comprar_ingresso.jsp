<%-- 
    Document   : index
    Created on : 22/05/2015, 07:50:23
    Author     : 31448471
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/headerNormal.css"/>
        <link rel="stylesheet" type="text/css" href="css/body.css"/>
        <link rel="stylesheet" type="text/css" href="css/section.css"/>
        <title>Cinema</title>
    </head>
    <body>
        <c:choose>
            <c:when test="${ocupacao.equals('normal')}">
                <c:import url="headerComum.jsp"/>
            </c:when>
            <c:otherwise>
                <c:redirect url="index.jsp"/>
            </c:otherwise>
        </c:choose>

        <section>
            <fieldset>
                <h2>Comprar Ingresso</h2>
                <form action="FrontController" method="POST">
                    <input type="hidden" name="command" value="MostraFilmes"/>
                    <input type="submit" value="Mostrar Filmes Disponíveis"/><br>

                    <c:forEach var="filmes" items="${mostraFilmes}">
                        <p>Nome: ${filmes.getNome()}</p>
                    </c:forEach>
                </form>

                <form action="FrontController" method="POST">
                    <input type="text" name="filme" placeholder="Nome do Filme"/>
                    <input type="text" name="inteira" placeholder="Meia ou Inteira?"/>

                    <input type="hidden" name="command" value="ComprarIngresso"/>
                    <input type="submit" value="COMPRAR"/>
                </form>
            </fieldset>
        </section>
    </body>
</html>
