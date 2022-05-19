
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

@WebServlet(name = "ActualizarUsuario", urlPatterns = {"/actualizarUsuario"})
public class ActualizarUsuario extends HttpServlet {

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

        String seleccionado = request.getParameter("tarea");
      
        HttpSession session = request.getSession();
        RequestDispatcher rd;
        
        Cliente cliente = (Cliente) session.getAttribute("cliente");
       
        ConsumidorGateway cg = new ConsumidorGateway();
       
        switch (seleccionado) {
            case "actualizarUsuario":
                cliente.setUsuario(request.getParameter("usuario"));
                try {
                    cg.actualizarUsuario(cliente);
                } catch (Exception e){
                    System.err.println(e.getMessage());
                }
                break;
                
            case "actualizarEmail":
                cliente.setEmail(request.getParameter("email"));
                try {
                    cg.actualizarUsuario(cliente);
                } catch (Exception e){
                    System.err.println(e.getMessage());
                }
                break;
                
            case "actualizarNombre":
                cliente.setNombre(request.getParameter("nombre"));
                try {
                    cg.actualizarUsuario(cliente);
                } catch (Exception e){
                    System.err.println(e.getMessage());
                }
                break;
                
            case "actualizarTelefono":
                cliente.setTelefono(request.getParameter("telefono"));
                try {
                    cg.actualizarUsuario(cliente);
                } catch (Exception e){
                    System.err.println(e.getMessage());
                }
                break;
            default:
                break;
        }
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
