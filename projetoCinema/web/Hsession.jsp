<%-- 
    Document   : Hsession
    Created on : May 3, 2015, 3:49:01 PM
    Author     : Paulo
--%>

<%
    if(session.getAttribute("usuario")!=null && !session.getAttribute("usuario").equals("")){
        out.print("Ol�! ");
        out.print(session.getAttribute("usuario \n"));
        
        if(session.getAttribute("ocupacao").equals("gerente")){
            out.print("Acesso total permitido - Gerente");
        }
            
        else{
            out.print("Acesso para com�rcio - Atendente");
        }
    }
    else{
        response.sendRedirect("index.jsp");
    }
%>