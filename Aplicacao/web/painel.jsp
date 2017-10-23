<%@page import="Model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Painel Administrativo</title>
    </head>
    <body>
         <%
             
            Usuario usuario = new Usuario();
            usuario = (Usuario)request.getSession().getAttribute("usuario");
            System.out.println("Usuario "+usuario.getNome()+" logado!");
            if(usuario == null){
               response.sendRedirect("login.jsp");
            }
        %>
        id: ${usuario.getId()}!
        nome: ${usuario.getNome()}!
        sobrenome: ${usuario.getSobrenome()}!
        email: ${usuario.getEmail()}!
        senha: ${usuario.getSenha()}!
        tipo: ${usuario.getTipo()}!
        <form action="Logout" method="post">
            <input type="submit" value="Sair" />
        </form>
    </body>
</html>
