<%-- 
    Document   : manter_filme
    Created on : Apr 30, 2015, 9:16:48 PM
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
        <title>Manutenção de Filmes</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/headerNormal.css"/>
        <link rel="stylesheet" type="text/css" href="css/body.css"/>
        <link rel="stylesheet" type="text/css" href="css/section.css"/>
    </head>
    <body>
        <header>
            <c:import url="headerGerente.jsp"/>
        </header>
        <section>

            <fieldset class="bloco1">
                <p>Buscar Filme:</p></br>
                <form action="FrontController" method="POST">
                    <input type="text" placeholder="Buscar" name="filme" required/></br>
                    <input type="hidden" name="command" value="BuscarFilme"/>
                    <input type="submit" value="Buscar"/>
                </form>
            </fieldset>

            <fieldset>
                <p>Criar Filme:</p></br>
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
                    <input type="submit" value="Criar"/>
                </form>
            </fieldset>

            <fieldset>
                <p>Atualizar Filme:</p></br>

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
                    <input type="submit" value="Atualizar"/>
                </form>
            </fieldset>

            <fieldset>
                <p>Excluir filme:</p></br>
                <form action="FrontController" method="POST">
                    <input type="number" placeholder="Codigo do filme" name="codigo" required/></br></br>
                    <input type="hidden" name="command" value="ExcluirFilme"/>
                    <input type="submit" value="Excluir"/>
                </form>
            </fieldset>


        </section>
    </body>
</html>

