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

@WebServlet(name = "Logar", urlPatterns = {"/Logar"})
public class Logar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        BancoDeDados db = new BancoDeDados();
        Usuario cliente = new Usuario();
       
        cliente.setEmail(request.getParameter("email"));
        cliente.setSenha(request.getParameter("senha"));
        
        CriptografarSenha hash = new CriptografarSenha();
        
        try {
            cliente.setSenha(hash.converter(cliente.getSenha())); 
            System.out.println("Senha criptografada: ");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Logar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            cliente = db.getUsuario(cliente); 
            if(cliente != null){
                System.out.println("Login realizado com sucesso!");
                request.getSession().setAttribute("usuario", cliente);
                response.sendRedirect("painel.jsp");
            }else{
                response.sendRedirect("login.jsp");
                System.out.println("Usuario ou senha inválido!");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Logar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet Logar</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            try {
//                if(db.conectar() != null){
//                    out.println("ok");
//                }else{
//                    out.println("falhou");
//                }
//                if(db.verificarEmailLogin(usuario)){
//                    System.out.println("Usuario não existe!");
//                }else{
//                    System.out.println("Login realizado com sucesso!");
//                }
//                
//                if(usuario.getEmail().equals(admin.getEmail()) && usuario.getSenha().equals(admin.getSenha()) ){
//                    request.getSession().setAttribute("usuario", usuario);
//                    response.sendRedirect("painel.jsp");
//                }else{
//                    out.println("Usuario incorreto");
//                }
//            } catch (ClassNotFoundException ex) {
//                Logger.getLogger(Logar.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            out.println("</body>");
//            out.println("</html>");
//        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
