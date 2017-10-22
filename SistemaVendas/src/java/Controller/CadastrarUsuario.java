package Controller;

import Model.BancoDeDados;
import Model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        BancoDeDados db = new BancoDeDados();
        Usuario usuario = new Usuario();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>");out.println("Titulo"); out.println("</title>");
        out.println("</head>");
        
        out.println("<body>");
        if(db.conectar() != null){
            out.println("conectado!");
        }else{
            out.println("falhou");
        }

        usuario.setNome(request.getParameter("nome"));
        usuario.setSobrenome(request.getParameter("sobrenome"));
        usuario.setEmail(request.getParameter("email"));
        usuario.setSenha(request.getParameter("senha"));
        usuario.setTipo(3); // Tipo usuario: usuario com pk 3

       if(db.verificarEmailLogin(usuario)){
           out.println("Usuario "+usuario.getNome()+" cadastrado");
           db.cadastrarUsuario(usuario);
       }else{
           out.println("Usuário ja existe!");
       }

        out.println("</body>");
        out.println("</html>");
    }
}
