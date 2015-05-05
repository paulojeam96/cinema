<%-- 
    Document   : manter_usuario
    Created on : Apr 30, 2015, 9:17:57 PM
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
        <title>Manter Usuario</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <header>
            <%@include file = "Hsession.jsp" %>
        </header>
        <section>
            <fieldset>
                <h2>Buscar Usuario:</h2>
                <form action="FrontController" method="POST">
                    <input type="text" name="usuario" placeholder="Buscar Usuario" required/><br>
                    <input type="hidden" name="command" value="BuscaUsuario"/><br>
                    <input type="submit" value="Buscar Usuario"/><br>
                </form>
            </fieldset>
            
            <fieldset>
                <h2>Criar Usuario:</h2>
                <form action="FrontController" method="POST">
                    <input type="text" name="nome" placeholder="Nome" required/><br>
                    <input type="password" name="password" placeholder="senha" required/><br>
                    <input type="password" name="password2" placeholder="confirma Senha" required/><br>
                    Gerente <input type="radio" name="cargo" value="Gerente"/>
                    Atendente <input type="radio" name="cargo" value="Atendente"/>
                    <input type="number" name="cod" value="Codigo do Usuario"/>
                    <input type="hidden" name="command" value="CriarUsuario"/>
                    <input type="submit" value="Criar Usuario"/>
                </form>
            </fieldset>
            
            <fieldset>
                <h2>Alterar Usuario:</h2>
                <form name="command" action="FrontController" method="POST">
                    <input type="number" placeholder="Código do Usuário" name="cod" required/></br>
                    <p>Cargo Atual:</p><br>
                    Gerente:<input type="radio" name="cargoAtual" value="Gerente"/>
                    Atendente:<input type="radio" name="cargoAtual" value="Atendente"/></br>
                    <input type="text" placeholder="Nome" name="nome" required/></br>
                    <input type="password" placeholder="Senha" name="password" required/></br>
                    <input type="password" placeholder="Confirma Senha" name="password2" required/></br>
                    <input type="hidden" name="command" value="AlterarUsuario"/>
                    <input type="submit" value="Alterar Usuario"/>
                </form>
            </fieldset>
            
            <fieldset>
                <h2>Deletar Usuario:</h2>
                <form action="FrontController" method="POST">
                    <input type="number" name="cod" placeholder="Codigo do Usuario"/>
                    <input type="hidden" name="command" value="DeletarUsuario"/>
                    <input type="submit" value="Deletar Usuario"/>
                </form>
            </fieldset>
        </section>
        
    </body>
</html>

