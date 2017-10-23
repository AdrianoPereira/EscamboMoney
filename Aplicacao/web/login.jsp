<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="conteudo">
             <h2>Login</h2>
             <form action="Logar" method="post">
                 <label for="email">Email</label>
                 <input type="email" name="email" id="email" />

                 <label for="senha">Senha</label>
                 <input type="password" name="senha" id="senha" />

                 <input type="submit" value="Entrar" />
             </form>
        </div>
    </body>
</html>
