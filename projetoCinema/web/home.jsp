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
            <% if(session.getAttribute("ocupacao").equals("Atendente")){
                out.print("Acesso Não permitido!");
                response.sendRedirect("index.jsp");
                }
                %>
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

                <p><a href="vender_ingresso.jsp">Vender Ingresso</a></p>
                
            </nav>
        </section>
    </body>
</html>
