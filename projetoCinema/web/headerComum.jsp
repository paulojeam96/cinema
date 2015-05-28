<%-- 
    Document   : headerComum
    Created on : 27/05/2015, 21:57:09
    Author     : Paulo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <div id='cssmenu'>
        <ul>
            <li><a href='comum.jsp'><span>Home</span></a></li>

            <li><a href='comprar_ingresso.jsp'><span>Comprar Ingresso</span></a></li>
            <li><a href='#'><span>${ocupacao} - ${usuario}</span></a></li>
            <li class='last'><a href='index.jsp'><span>Sair</span></a></li>
        </ul>
    </div>
</html>
