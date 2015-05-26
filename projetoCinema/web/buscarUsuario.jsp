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
                            Nome:<input type="text" name="nome" placeholder="Nome do Usuario" required/><br>
                            <input type="hidden" name="command" value="BuscaGerente"/><br>
                            <input type="submit" value="Buscar Usuario"/><br>
                            <p> Nome: ${func.getNome()}</p>
                            <p> Senha: ${func.getSenha()}</p>
                            <p> ID: ${func.getPk()}</p>  
                        </form>
                    </fieldset>
                    <fieldset>
                        <h2>Buscar Atendente:</h2>
                        <form action="FrontController" method="POST">
                            Nome:<input type="text" name="nome" placeholder="Nome do Usuario" required/><br>
                            <input type="hidden" name="command" value="BuscaAtendente"/><br>
                            <input type="submit" value="Buscar Usuario"/><br>
                            <p> Nome: ${funcionario.getNome()}</p>
                            <p> Senha: ${funcionario.getSenha()}</p>
                            <p> ID: ${funcionario.getPk()}</p>
                        </form>
                    </fieldset>
                </div>
            </section>
    </body>
</html>
