<%-- 
    Document   : signup
    Created on : 23/10/2017, 09:22:04
    Author     : kassio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="conteudo">
            <h2>Sign Up</h2>
            <form action="CadastrarUsuario" method="post">
                <div class="form-nome">
                    <label for="nome">Nome</label>
                    <input type="text" name="nome" id="nome" />
                </div>

                <div class="form-sobrenome">
                    <label for="sobrenome">Sobrenome</label>
                    <input type="text" name="sobrenome" id="sobrenome" />
                </div>

                <div class="form-email">
                    <label for="email">Email</label>
                    <input type="email" name="email" id="email" />
                </div>
                
                <div class="form-senha">
                    <label for="senha">Senha</label>
                    <input type="password" name="senha" id="senha" />
                </div>

                <div class="form-confirmar-senha">
                    <label for="confirmar-senha">Confirmar senha</label>
                    <input type="password" name="confirmar-senha" id="confirmar-senha" />
                </div>

                <input type="submit" value="Cadastrar" />
            </form>
       </div>
    </body>
</html>
