<%-- 
    Document   : manter_filme
    Created on : Apr 30, 2015, 9:16:48 PM
    Author     : Paulo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Manutenção de Filmes</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <header>
            <%@include file = "Hsession.jsp" %>
            <h1>Manutenção de Filmes</h1>
        </header>
        <section>

            <p>Buscar:</p></br>
            <form action="FrontController" method="POST">
                <input type="text" placeholder="Buscar" name="filme" required/></br>
                <input type="hidden" name="command" value="BuscarFilme"/>
                <input type="submit" name="command" value="Buscar"/>
            </form>

            <p>Criar:</p></br>
            <form action="FrontController" method="POST">
                <input type="text" placeholder="Nome" name="nome" required/></br>
                <input type="text" placeholder="Idioma" name="idioma" required/></br>
                <input type="text" placeholder="Situação" name="situacao" required/></br>
                <input type="number" placeholder="duração" name="duracao" required/></br>
                <input type="number" placeholder="Ano" name="ano" required/></br>
                <input type="number" placeholder="Classificação" name="classificacao" required/></br>
                <input type="number" placeholder="Diretor" name="diretor" required/></br>
                <input type="number" placeholder="Genero" name="genero" required/></br>
                <input type="number" placeholder="Distribuidora" name="distribuidora" required/></br>
                <input type="number" placeholder="Lista de Atores" name="listaatores" required/></br>
                <input type="hidden" name="command" value="CriarFilme"/>
                <input type="submit" name="command" value="Criar"/>
            </form>

            <p>Atualizar:</p></br>

            <form action="FrontController" method="POST">
                <input type="number" placeholder="Codigo do filme" name="codF" required/></br></br>
                <input type="text" placeholder="Nome" name="nome" required/></br>
                <input type="text" placeholder="Idioma" name="idioma" required/></br>
                <input type="text" placeholder="Situação" name="situacao" required/></br>
                <input type="number" placeholder="duração" name="duracao" required/></br>
                <input type="number" placeholder="Ano" name="ano" required/></br>
                <input type="number" placeholder="Classificação" name="classificacao" required/></br>
                <input type="number" placeholder="Diretor" name="diretor" required/></br>
                <input type="number" placeholder="Genero" name="genero" required/></br>
                <input type="number" placeholder="Distribuidora" name="distribuidora" required/></br>
                <input type="number" placeholder="Lista de Atores" name="listaatores" required/></br>
                <input type="hidden" name="command" value="AtualizarFilme"/>
                <input type="submit" name="command" value="Atualizar"/>
            </form>

            <p>Excluir:</p></br>
            <form action="FrontController" method="POST">
                <input type="number" placeholder="Codigo do filme" name="codigo" required/></br></br>
                <input type="hidden" name="command" value="ExcluirFilme"/>
                <input type="submit" name="command" value="Excluir"/>
            </form>

        </section>
    </body>
</html>

