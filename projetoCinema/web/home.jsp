<%-- 
    Document   : home
    Created on : Apr 30, 2015, 9:15:54 PM
    Author     : Paulo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Home</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <header>
            <%@ include file= "Hsession.jsp"%>
    
        </header>

        <section>
            <nav>
                <p>Manutenção</p>
                <ul>
                    <li><a href="manter_sala.jsp">Manter Sala</a></li>
                    <li><a href="manter_filme.jsp">Manter Filme</a></li>
                    <li><a href="manter_sessao.jsp">Manter Sessão</a></li>
                    <li><a href="manter_usuario.jsp">Manter Usuário</a></li>
                </ul>

                <p>Vender Ingresso</p>
                <ul>
                    <li><a href="vender_ingresso.jsp">Filme</a></li>
                    <li><a href="vender_ingresso.jsp">Sessão</a></li>
                </ul>
            </nav>
        </section>
    </body>
</html>
