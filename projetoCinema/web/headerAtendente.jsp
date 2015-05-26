<%-- 
    Document   : headerAtendente
    Created on : 12/05/2015, 09:54:10
    Author     : 31448471
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    </head>
    <div id='cssmenu'>
        <ul>
            <li><a href='atendente.jsp'><span>Home</span></a></li>
            
            <li><a href='vender_ingresso.jsp'><span>Vender Ingresso</span></a></li>
            <li><a href='#'><span>${ocupacao} - ${usuario}</span></a></li>
            <li class='last'><a href='logout.jsp'><span>Sair</span></a></li>
        </ul>
    </div>
</html>
