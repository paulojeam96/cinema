<%-- 
    Document   : atendente
    Created on : Apr 30, 2015, 9:14:23 PM
    Author     : Paulo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <header>
            <%
                if(session.getAttribute("ocupacao").equals("Gerente")){
                    out.print("Acesso para Atendentes, você será redirecionado para a Página gerencial!");
                    response.sendRedirect("home.jsp");
                }
                %>
            <%@include file = "Hsession.jsp" %>
        </header>
        <p><a href="vender_ingresso.jsp">Vender Ingresso</a></p>
        
    </body>
</html>
