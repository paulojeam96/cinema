<%-- 
    Document   : comum
    Created on : Apr 30, 2015, 9:15:22 PM
    Author     : Paulo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Usuario</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/header.css"/>
        <link rel="stylesheet" type="text/css" href="css/body.css"/>
    </head>
    <body>
        <header>

            <c:if test="${ocupacao != 'normal'}">
                <c:redirect url="index.jsp"/>
            </c:if>    

            <div id='cssmenu'>
                <ul>
                    <li><a href='atendente.jsp'><span>Home</span></a></li>

                    <li><a href='comprar_ingresso.jsp'><span>Comprar Ingresso</span></a></li>
                    <li><a href='#'><span>${ocupacao} - ${usuario}</span></a></li>
                    <li class='last'><a href='index.jsp'><span>Sair</span></a></li>
                </ul>
            </div>
        </header>


    </body>
</html>
