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
        <link rel="stylesheet" type="text/css" href="css/body.css"/>
        <link rel="stylesheet" type="text/css" href="css/section.css"/>
        <title>Cadastro</title>
    </head>
    <body>
        <section>
            <fieldset>
                <h2>Criar Funcionario</h2>
                <form action="FrontController" method="POST">
                    Nome:<input type="text" name="nome" placeholder="Nome" required/><br>
                    Senha:<input type="password" name="password" placeholder="senha" required/><br>
                    Repita a senha:<input type="password" name="password2" placeholder="confirma Senha" required/><br>
                    Cargo:<input type="text" name="cargo" placeholder="Cargo" required/><br>
                    Codigo Usuario<input type="number" name="cod" value="Codigo do Usuario"/>
                    <input type="hidden" name="command" value="CriarUsuario"/>
                    <input type="submit" value="Criar Usuario"/>
                </form>
            </fieldset>
            <fieldset>
                <h2>Criar Usuario</h2>
                <form action="FrontController" method="POST">
                    Nome:<input type="text" name="nome" placeholder="Nome" required/><br>
                    Senha:<input type="password" name="password" placeholder="senha" required/><br>
                    Repita a senha:<input type="password" name="password2" placeholder="confirma Senha" required/><br>
                    Codigo Usuario<input type="number" name="cod" value="Codigo do Usuario"/>
                    <input type="hidden" name="command" value="CriarUsuarioNormal"/>
                    <input type="submit" value="Criar Usuario"/>
                </form>
            </fieldset>
        </section>



    </body>
</html>
