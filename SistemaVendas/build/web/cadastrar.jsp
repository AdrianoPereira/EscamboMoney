<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Escambo Money | Cadastrar</title>
    </head>
    <body>
        <h1>Fazer Cadastro</h1>
        <form action="CadastrarUsuario" method="post">
            <div class="form-nome">
                <label for="nome">Nome</label>
                <input type="text" name="nome" id="nome">
            </div>

            <div class="form-sobrenome">
                <label for="sobrenome">Sobrenome</label>
                <input type="text" name="sobrenome" id="sobrenome">
            </div>

            <div class="form-email">
                <label for="email">E-mail</label>
                <input type="email" name="email" id="email">
            </div>

            <div class="form-senha">
                <label for="senha">Senha</label>
                <input type="password" name="senha" id="senha">
            </div>

            <div class="form-repetir-senha">
                <label for="repetir-senha">Repetir Senha</label>
                <input type="password" name="repetir-senha" id="repetir-senha">
            </div>

            <input type="submit" value="Cadastrar">
        </form>
    </body>
</html>
