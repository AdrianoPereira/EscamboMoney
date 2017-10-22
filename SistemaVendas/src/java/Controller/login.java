package Controller;

import Model.BancoDeDados;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "login", urlPatterns = {"/login"})
public class login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        BancoDeDados db = new BancoDeDados();
        
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
        out.println("</body>");
        
        out.println("</html>");
        
    }

}
