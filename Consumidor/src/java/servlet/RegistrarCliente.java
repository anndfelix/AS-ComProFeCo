
package servlet;

import controlador.ConsumidorGateway;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import usuario.modelo.Cliente;

@WebServlet(name = "RegistrarCliente", urlPatterns = {"/registrarCliente"})
public class RegistrarCliente extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd;

        Cliente cliente = new Cliente();
      
        String usuario = (String) request.getParameter("reg_usuario");
        String email = (String) request.getParameter("email");
        String contra =(String) request.getParameter("reg_contrasenia");
        String nombre = (String) request.getParameter("nombre");
        String telefono = (String) request.getParameter("telefono");
     
        cliente = new Cliente(nombre, email, telefono, usuario, contra);
        
        ConsumidorGateway cg = new ConsumidorGateway();
        cg.registrarUsuario(cliente);
        
        cliente = cg.iniciarSesion(cliente.getUsuario(), cliente.getContrasenia());

        HttpSession session = request.getSession();
        session.setAttribute("cliente", cliente);
        
        rd = request.getRequestDispatcher("home.jsp");
        rd.forward(request, response);
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
