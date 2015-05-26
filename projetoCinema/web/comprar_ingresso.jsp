<%-- 
    Document   : index
    Created on : 22/05/2015, 07:50:23
    Author     : 31448471
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/headerNormal.css"/>
        <link rel="stylesheet" type="text/css" href="css/body.css"/>
        <link rel="stylesheet" type="text/css" href="css/section.css"/>
        <title>Cinema</title>
    </head>
    <body>
        <c:if test="${cadeiras==null}">
            <c:redirect url="ControladorIngressos?command=init"/>
        </c:if>
        <header>
            <c:choose>
                <c:when test="${ocupacao.equals('usuario')}">
                    <c:import url="headerUsuario.jsp"/>
                </c:when>
                <c:otherwise>
                    <c:redirect url="FrontController?command=Logout" />
                </c:otherwise>
            </c:choose>
        </header>
        <section>
            
            <hr>
            <fieldset>
                Sala: <select onchange="window.location = 'ControladorIngressos?command=trocasala.' + this.value">
                    <c:forEach var="i" begin="0" end="${salas.size()-1}">
                        <c:choose>
                            <c:when test="${i==sala_selecionada}">
                                <option value="${i}" selected >${i+1}</option>>

                            </c:when>
                            <c:otherwise>
                                <option value="${i}" >${i+1}</option>>
                            </c:otherwise>
                        </c:choose>

                    </c:forEach>

                </select>
                Sessão: <select>
                    <c:forEach var="i" begin="0" end="${salas.get(sala_selecionada).size()-1}">
                        <option value="${i}">${i+1} </option>

                    </c:forEach>


                </select>
                <hr>

                <c:forEach var="i" begin="0" end="59">
                    <c:if test="${i%10==0}"> <br> </c:if>
                    <img alt="cadeira" src="img/cadeira${cadeiras.get(i)+1}.png" style="width:60px" id="${i}" onclick="window.location = 'ControladorIngressos?command=selecionar.cad' + this.id"/>
                </c:forEach>


                <form action="ControladorIngressos" method="GET">
                    <input type="hidden" name="command" value="comprar"/>
                    <input type="submit" value="COMPRAR"/>
                </form>
            </fieldset>
        </section>
    </body>
</html>
