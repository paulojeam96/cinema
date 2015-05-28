<%-- 
    Document   : manter_sessao
    Created on : Apr 30, 2015, 9:17:38 PM
    Author     : Paulo
--%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Manter Sessão</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="css/headerNormal.css"/>
        <link rel="stylesheet" type="text/css" href="css/body.css"/>
        <link rel="stylesheet" type="text/css" href="css/section.css"/>
        <style>

        </style>
    </head>
    <body>

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

        <section>
            <fieldset>
                <p>Buscar Sessão:</p><br>
                <form name="command" action="FrontController" method="POST">
                    <input type="number" name="numero" placeholder="Sessão"  required/></br>
                    <input type="hidden" name="command" value="BuscarSessao"/>
                    <input type="submit" value="Buscar"/>
                    <p>${sessaoPk}</p>
                </form>
            </fieldset>

            <fieldset>
                <p>Criar Sessão:</p><br>
                <form name="command" action="FrontController" method="POST">
                    <input type="number" placeholder="numero" name="numero"required /><br>
                    <input type="text" placeholder="Filme" name="filme" required/><br>
                    <input type="number" placeholder="Sala" name="sala" required/><br>
                    <input type="text" placeholder="Horário" name="horario" required/><br>
                    <input type="text" placeholder="Legendado ou Dublado?" name="legenda" required/><br>
                    <input type="hidden" name="command" value="CriarSessao"/>
                    <input type="submit" value="Criar"/>
                </form>
            </fieldset>


            <fieldset>
                <p><a id="3">Mudar Sessão:</a></p><br>
                <form name="command" action="FrontController" method="POST">
                    <input type="number" placeholder="Codigo da Sessao" name="codigo" required/></br></br>
                    <input type="text" placeholder="Filme" name="filme" required/><br>
                    <input type="number" placeholder="Sala" name="sala" required/><br>
                    <input type="text" placeholder="Horário" name="horario" required/><br>
                    <input type="text" placeholder="Legendado ou Dublado?" name="legenda" required/><br>
                    <input type="hidden" name="command" value="MudarSessao"/>
                    <input type="submit" value="Mudar"/>
                </form>
            </fieldset>

            <fieldset>
                <p>Deletar Sessão:</p><br>
                <form name="command" action="FrontController" method="POST">
                    <input type="number" placeholder="Codigo da Sessao" name="codigo" required/></br></br>
                    <input type="hidden" name="command" value="DeletarSessao"/>
                    <input type="submit" value="Deletar"/>
                </form>
            </fieldset>
        </section>
    </body>
</html>

