<%-- 
    Document   : manter_sessao
    Created on : Apr 30, 2015, 9:17:38 PM
    Author     : Paulo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Manter Sessão</title>
        <meta charset="UTF-8">
    </head>
    <body>
        <h1>Sessões</h1>
        
        
        <h2><p>Buscar:</p></h2><br>
                <form name="command" action="FrontController" method="POST">
                    <input type="text" name="sessao" placeholder="Sessão"  required/></br>
                    <input type="hidden" name="command" value="Buscar"/>
                    <input type="button" value="Buscar"/>
                </form>
            
            
        <h2><p>Criar:</p></h2><br>
                <form name="command" action="FrontController" method="POST">
                    <input type="number" placeholder="Filme" name="filme" required/></br>
                    <input type="number" placeholder="Sala" name="sala" required/></br>
                    <input type="text" placeholder="Horário" name="horario" required/></br>
                    Legendado:<input type="radio" name="legendado" value="Legendado" checked="checked"/></br>
                    <input type="hidden" name="command" value="Login"/>
                    <input type="image" src="img/enviar.png" alt="Submit Form" name="command"/>
                </form>
            </div>
           
                <p><a id="3">Mudar:</a></p><br>
                <form name="command" action="FrontController" method="POST">
                    <input type="number" placeholder="Codigo da Sessao" name="codigo" required/></br></br>
                    <input type="number" placeholder="Filme" name="filme" required/></br>
                    <input type="number" placeholder="Sala" name="sala" required/></br>
                    <input type="text" placeholder="Horário" name="horario" required/></br>
                    Legendado:<input type="radio" name="legendado" value="Legendado" checked="checked"/></br>
                    <input type="hidden" name="command" value="Login"/>
                    <input type="image" src="img/enviar.png" alt="Submit Form" name="command"/>
                </form>
           
            
                <h2><p>Deletar:</p></h2><br>
                <form name="command" action="FrontController" method="POST">
                    <input type="number" placeholder="Codigo da Sessao" name="codigo" required/></br></br>
                    <input type="hidden" name="command" value="Login"/>
                    <input type="image" src="img/enviar.png" alt="Submit Form" name="command"/>
                </form>
            </div>
    </body>
</html>
