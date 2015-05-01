<%-- 
    Document   : teste
    Created on : 30/04/2015, 10:47:36
    Author     : 31448471
--%>

<%@page import="com.br.lp2.cinema.model.javabeans.Funcionario"%>
<%@page import="com.br.lp2.cinema.model.DAO.FuncionarioDAOConcreto"%>
<%@page import="com.br.lp2.cinema.model.DAO.FuncionarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <%
            
            Funcionario f = new Funcionario(1, 1, "Paulo");
            FuncionarioDAO a = new FuncionarioDAOConcreto();
            
            a.insertFuncionario(f);
            a.readFuncionarioByNome("Paulo");
            
            %>
    </body>
</html>
