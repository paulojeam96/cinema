<%-- 
    Document   : manter_usuario
    Created on : Apr 30, 2015, 9:17:57 PM
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
        <title>Manter Usuario</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/headerNormal.css"/>
        <link rel="stylesheet" type="text/css" href="css/body.css"/>
        <link rel="stylesheet" type="text/css" href="css/section.css"/>


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

        <div class="body">

        </div>
        <section>

            <div id="2">
                <fieldset>
                    <h2>Criar Usuario:</h2>
                    <form action="FrontController" method="POST">
                        Nome:<input type="text" name="nome" placeholder="Nome" required/><br>
                        Senha:<input type="password" name="password" placeholder="senha" required/><br>
                        Repita a senha:<input type="password" name="password2" placeholder="confirma Senha" required/><br>
                        Cargo <input type="text" name="cargo" plaqceholder="cargo"/><br>
                        Codigo Usuario<input type="number" name="cod" value="Codigo do Usuario"/>
                        <input type="hidden" name="command" value="CriarUsuario"/>
                        <input type="submit" value="Criar Usuario"/>
                    </form>
                </fieldset>
            </div>

            <div id="3">
                <fieldset>
                    <h2>Alterar Usuario:</h2>
                    <form name="command" action="FrontController" method="POST">
                        <input type="number" placeholder="Código do Usuário" name="cod" required/></br>
                        Cargo Atual:<input type="text" name="cargoAtual" placeholder="Cargo Atual"/></br>
                        <input type="text" placeholder="Nome" name="nome" required/></br>
                        <input type="password" placeholder="Senha" name="password" required/></br>
                        <input type="password" placeholder="Confirma Senha" name="password2" required/></br>
                        <input type="hidden" name="command" value="AlterarUsuario"/>
                        <input type="submit" value="Alterar Usuario"/>
                    </form>
                </fieldset>
            </div>

            <div id="4">
                <fieldset>
                    <h2>Deletar Usuario Por Cargo e ID:</h2>
                    <form action="FrontController" method="POST">
                        <input type="text" name="cargo" placeholder="Cargo"/><br>
                        <input type="number" name="cod" placeholder="Codigo do Usuario"/>
                        <input type="hidden" name="command" value="DeletarUsuario"/>
                        <input type="submit" value="Deletar Usuario"/>
                    </form>
                </fieldset>
            </div>
            
        </section>

    </body>
</html>

