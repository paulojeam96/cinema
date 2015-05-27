<%-- 
    Document   : logout
    Created on : 26/05/2015, 16:14:13
    Author     : 31448471
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<c:choose>
    <c:when test="${ocupacao.equals('gerente') || ocupacao.equals('atendente')}">
        
        <c:redirect url="FrontController?command=Logout"/>
    </c:when>
    <c:otherwise>
        <c:redirect url="FrontController?command=Logout" />
    </c:otherwise>
</c:choose>
