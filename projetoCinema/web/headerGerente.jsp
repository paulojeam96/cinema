<%-- 
    Document   : header
    Created on : 11/05/2015, 20:40:21
    Author     : Paulo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <div id='cssmenu'>
        <ul>
            <li><a href='#'><span>Home</span></a></li>
            <li class='active has-sub'><a href='#'><span>Manutenção</span></a>
                <ul>
                    <li class='has-sub'><a href='manter_usuario.jsp'><span>Manter Usuario</span></a>

                    </li>
                    <li class='has-sub'><a href='manter_sala.jsp'><span>Manter Sala</span></a>

                    </li>
                    <li class='has-sub'><a href='manter_filme.jsp'><span>Manter Filme</span></a>

                    </li>
                    <li class='has-sub'><a href='manter_sessao.jsp'><span>Manter Sessão</span></a>

                    </li>
                </ul>
            </li>
            <li><a href='#'><span>Minha Conta</span></a></li>
            <li class='last'><a href='index.jsp'><span>Sair</span></a></li>
        </ul>
    </div>
</html>
