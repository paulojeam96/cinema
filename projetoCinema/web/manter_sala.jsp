<%-- 
    Document   : manter_sala
    Created on : Apr 30, 2015, 9:17:08 PM
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
        <title>Manter Sala</title>
        <meta charset="UTF-8">
    </head>
    <body>
        <header>
            <%@include file = "Hsession.jsp" %>
            <h1>Manutenção das Salas</h1>
        </header>

        <h2><p>Buscar:</p></h2><br>
        <form action="FrontController" method="POST">
            <input type="number" placeholder="Buscar" name="sala" /></br>
            <input type="hidden" name="command" value="BuscarSala"/>
            <input type="submit" value="Buscar"/>
        </form>
        
        
        <h2><p>Criar: </p></h2><br>
        <form action="FrontController" method="POST"/>
            <input type="number" name="numero" placeholder="Número da Sala"/>
            <input type="number" name="lotacao" placeholder="Lotação Máxima da Sala"/>
            <input type="number" name="especial" placeholder="Cadeiras especiais"/>
            <select name="Situação"/>
                <option>Em Manutenção</option>
                <option>Ocupada</option>
                <option>Livre</option>
            </select>
            <input type="hidden" name="command" value="CriarSala"/>
            <input type="submit" value="Criar Sala"/>
        </form>
        
        
        <h2><p>Atualizar Sala</p></h2>
        <form action="FrontController" method="POST">
            <input type="number" name="codSala" placeholder="Codigo da Sala"/>
            <input type="number" name="numero" placeholder="Numero Da Sala"/>
            <input type="number" name="lotacao" placeholder="Lotação Máxima da Sala"/>
            <input type="number" name="especial" placeholder="Numero de cadeiras especiais"/>
            <select name="Situacao">
                <option>Em Manutenção</option>
                <option>Em Espera</option>
                <option>Em Exibição</option>
            </select>
            <input type="hidden" name="command" value="AtualizarSala"/>
            <input type="submit" value="atualizar"/>
        </form>
        
        <h2><p>Deletar Sala:</p></h2><br>
                <form action="FrontController" method="POST">
                    <input type="number" placeholder="Codigo da Sala" name="codigo" required/></br></br>
                    <input type="hidden" name="command" value="DeletarSala"/>
                    <input type="submit" value="Deletar"/>
                </form>
    </body>
</html>

