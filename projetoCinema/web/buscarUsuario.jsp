<%-- 
    Document   : buscarUsuario
    Created on : 25/05/2015, 12:00:08
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
        <title>Buscar Usuarios</title>
    </head>
    <body>

        <header>
            <header>            
                <c:choose>
                    <c:when test="${ocupacao == 'gerente'}">
                        <c:import url="headerGerente.jsp"/>
                    </c:when>
                    <c:otherwise>
                        <c:redirect url="index.jsp"/>
                    </c:otherwise>
                </c:choose>

            </header>
        </header>

        <div class="body">
            <section>
                <div id="1">
                    <fieldset>
                        <h2>Buscar Gerente:</h2>
                        <form action="FrontController" method="POST">
                            ID:<input type="number" name="numero" placeholder="ID do Usuario" required/><br>
                            <select>
                                <c:set var="usuario" value="${lista1}" />
                                <option value="${usuario}"> ${usuario.getNome()}</option>
                                <option value="${usuario}"> ${usuario.getSenha()}</option>
                                <option value="${usuario}"> ${usuario.getCargo()}</option>
                                <option value="${usuario}"> ${usuario.getPk()}</option>
                            </select>  

                            <input type="hidden" name="command" value="BuscaGerente"/><br>
                            <input type="submit" value="Buscar Usuario"/><br>
                            <c:set var='funcionario' value="${funcionario}"/>
                        </form>
                    </fieldset>
                    <fieldset>
                        <h2>Buscar Atendente:</h2>
                        <form action="FrontController" method="POST">
                            ID:<input type="number" name="numero" placeholder="ID do Usuario" required/><br>
                            <select>
                                <c:set var="usuario" value="${lista1}" />
                                <option value="${usuario}"> ${usuario.getNome()}</option>
                                <option value="${usuario}"> ${usuario.getSenha()}</option>
                                <option value="${usuario}"> ${usuario.getCargo()}</option>
                                <option value="${usuario}"> ${usuario.getPk()}</option>
                            </select>  

                            <input type="hidden" name="command" value="BuscaAtendente"/><br>
                            <input type="submit" value="Buscar Usuario"/><br>
                            <c:set var='funcionario' value="${funcionario}"/>
                        </form>
                    </fieldset>
                </div>
            </section>
    </body>
</html>
