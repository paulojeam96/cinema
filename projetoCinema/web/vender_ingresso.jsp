<%-- 
    Document   : vender_ingresso
    Created on : Apr 30, 2015, 9:18:43 PM
    Author     : Paulo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Venda de Ingressos</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/headerNormal.css"/>
        <link rel="stylesheet" type="text/css" href="css/body.css"/>
        <link rel="stylesheet" type="text/css" href="css/section.css"/>
    </head>
    <body>
        <header>

            <c:choose>
                <c:when test="${ocupacao.equals('atendente')}">
                    <c:import url="headerAtendente.jsp"/>
                </c:when>
                <c:otherwise>
                    <c:redirect url="index.jsp"/>
                </c:otherwise>
            </c:choose>
        </header>
        
        
        <section>
            <fieldset>
                <h2>Vender Ingresso</h2>
                <form action="FrontController" method="POST">
                    <input type="number" name="id" placeholder="Numero do Ingresso"/><br>
                    <input type="text" name="inteira" placeholder="Meia ou inteira?"/><br>
                    <input type="text" name="filme" placeholder="Nome do Filme"/><br>
                    <input type="hidden" name="command" value="VendeIngresso"/>
                    <input type="submit"  value="Vender Ingresso"/>
                </form>
            </fieldset>
            <fieldset>
                <h2>Ingressos Vendidos:</h2>
                <form action="FrontController" method="POST">
                    <input type="hidden" name="command" value="BuscaIngressos"/>
                    <input type="submit"  value="Buscar Ingresso"/>
                    
                    <c:forEach var="i" items="${ingressos}">
                        <p>Numero: ${i.getId()}</p>
                        <p>Filme: ${i.getId_filme()}</p>
                        <p>Inteira: ${i.isInteira()}</p>
                    </c:forEach>
                </form>
            </fieldset>
            <fieldset>
                <h2>Excluir Ingresso Vendido:</h2>
                <form action="FrontController" method="POST">
                    <input type="number" name="numero" placeholder="Numero do Ingresso"/>
                    <input type="hidden" name="command" value="DeletarIngressos"/>
                    <input type="submit"  value="Deletar Ingresso"/>                    
                </form>
            </fieldset>
        </section>
    </body>
</html>
