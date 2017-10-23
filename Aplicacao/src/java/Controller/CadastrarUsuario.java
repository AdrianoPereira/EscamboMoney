package Controller;

import Model.BancoDeDados;
import Model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CadastrarUsuario", urlPatterns = {"/CadastrarUsuario"})
public class CadastrarUsuario extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String nome = request.getParameter("nome");
            String sobrenome = request.getParameter("sobrenome");
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");
            String confirmarSenha = request.getParameter("confirmar-senha");
            int tipo = 1;
            CriptografarSenha hash = new CriptografarSenha();
            BancoDeDados db = new BancoDeDados();
            try {
                senha = hash.converter(senha);
                System.out.println("Senha criptografada com sucesso!");
            } catch (NoSuchAlgorithmException ex) {
                System.out.println("Erro ao criptografar senha!");
                Logger.getLogger(CadastrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Usuario usuario = new Usuario();
            
            usuario.setNome(nome);
            usuario.setSobrenome(sobrenome);
            usuario.setEmail(email);
            usuario.setSenha(senha);
            usuario.setTipo(tipo);
            
        try {
            db.cadastrarUsuario(usuario);
            System.out.println("Usuario "+usuario.getNome()+" cadastrado com sucesso");
            response.sendRedirect("login.jsp");
        } catch (ClassNotFoundException ex) {
            response.sendRedirect("signup.jsp");
            System.out.println("Falha ao cadastrar "+usuario.getNome()+"!");
            Logger.getLogger(CadastrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
    }
}
