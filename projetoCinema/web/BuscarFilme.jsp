<%-- 
    Document   : BuscarFilme
    Created on : 26/05/2015, 11:29:54
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
        <title>Buscar Filmes</title>
    </head>
    <body>

        <header>
            <c:choose>
                <c:when test="${ocupacao.equals('gerente')}">
                    <c:import url="headerGerente.jsp"/>
                </c:when>
                <c:otherwise>
                    <c:when test="${ocupacao.equals('atendente')}">
                        <c:import url="headerAtendente.jsp" />
                    </c:when>
                </c:otherwise>
            </c:choose>

        </header>
        <section>
            <fieldset>
                <form action="FrontController" method="POST">
                    <h2>Buscar Filme por Nome</h2>
                    <p>Nome: <input type="text" name="nome" placeholder="Nome do Filme"/></p>
                    <input type="hidden" name="command" value="BuscarFilmeNome"/>
                    <input type="submit"  value="Buscar Filme"/>

                        <p>Nome:${nomeFilme.getNome()}</p>
                        <p>Idioma:${nomeFilme.getIdioma()}</p>
                        <p>Situacao: ${nomeFilme.getSituacao()}</p>
                        <p>Genero: ${nomeFilme.getGenero()}</p>
                        <p>Distribuidora: ${nomeFilme.getDist()}</p>
                        <p>Diretor: ${nomeFilme.getDiretor()}</p>
                        <p>Classificação: ${nomeFilme.getClassificacao()}</p>
                        <p>Ano: ${nomeFilme.getAno()}</p>
                        <p>Duração: ${nomeFilme.getDuracao()}</p>



                </form>
            </fieldset>
            <fieldset>
                <form action="FrontController" method="POST">
                    <h2>Buscar Filme por Gênero</h2>
                    <p>Gênero: <input type="text" name="nome" placeholder="Gênero"/></p>
                    <input type="hidden" name="command" value="BuscaFilmeGen"/>
                    <input type="submit"  value="Buscar Filme"/>

                    <c:forEach var="i" items="${filmesGen}">
                        <p>${i.getNome()}</p>
                    </c:forEach>


                </form>
            </fieldset>            
            <fieldset>
                <form action="FrontController" method="POST">
                    <h2>Buscar Filme por Distribuidora</h2>
                    <p>Distribuidora: <input type="text" name="nome" placeholder="Distribuidora"/></p>
                    <input type="hidden" name="command" value="BuscarFilmeDist"/>
                    <input type="submit"  value="Buscar Filme"/>
                    <c:forEach var="filmes" items="${fDist}">
                        <p>${filmes.getNome()}</p>
                    </c:forEach>

                </form>
            </fieldset>
            <fieldset>
                <form action="FrontController" method="POST">
                    <h2>Buscar Filme por Diretor</h2>
                    <p>Diretor: <input type="text" name="nome" placeholder="Nome do Diretor"/></p>
                    <input type="hidden" name="command" value="BuscarFilmeDiretor"/>
                    <input type="submit"  value="Buscar Filme"/>
                    <c:forEach var="diretor" items="${fDiretor}">
                        <p>${diretor.getNome()}</p>
                        <p>${diretor}</p>
                    </c:forEach>

                </form>
            </fieldset>
            <fieldset>
                <form action="FrontController" method="POST">
                    <h2>Buscar Filme por ID</h2>
                    <p>ID: <input type="number" name="numero" placeholder="Id do Filme"/></p>
                    <input type="hidden" name="command" value="BuscarFilmeID"/>
                    <input type="submit"  value="Buscar Filme"/>

                    <p>${idFilme}</p>
                </form>
            </fieldset>
        </section>
    </body>
</html>
