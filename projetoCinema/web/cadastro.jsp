<%-- 
    Document   : cadastro
    Created on : 19/05/2015, 16:49:51
    Author     : 31448471
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro</title>
    </head>
    <body>
        <h1>Cadastro</h1>

        <fieldset>
            <h2>Cadastro de Gerentes</h2>
            <form action="FrontController" method="POST">
                <input type="text" name="nome" placeholder="Nome do Gerente"/>
                <input type="text" name="senha" placeholder="senha"/>
                <input type="hidden" value="command" name="Cadastrar"/>
                <input type="submit" value="CadastraGerente"/>
            </form>
        </fieldset>
        
        <fieldset>
            <h2>Cadastro de Atendente</h2>
            <form action="FrontController" method="POST">
                <input type="text" name="nome" placeholder="Nome do Atendente"/>
                <input type="text" name="senha" placeholder="senha"/>
                <input type="hidden" value="command" name="Cadastrar"/>
                <input type="submit" value="CadastraAtendente"/>
            </form>
        </fieldset>


    </body>
</html>
