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

            <c:choose>
                <c:when test="${ocupacao != 'normal'}">
                    <c:import url="headerComum.jsp"/>
                </c:when>
                <c:otherwise>
                    <c:redirect url="index.jsp"/>
                </c:otherwise>
            </c:choose> 
                
            </c:if>    

            
        </header>


    </body>
</html>
