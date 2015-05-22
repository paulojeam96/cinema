<%-- 
    Document   : atendente
    Created on : Apr 30, 2015, 9:14:23 PM
    Author     : Paulo
--%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/header.css"/>
        <link rel="stylesheet" type="text/css" href="css/body.css"/>
    </head>
    <body>
        <header>
            <%
                if(session.getAttribute("ocupacao").equals("gerente") || session.getAttribute("ocupacao")!= ("atendente")){
                    response.sendRedirect("home.jsp");
                }
                %>
        </header>
            <c:import url="headerAtendente.jsp"/>
    </body>
</html>
