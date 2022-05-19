package servlet;

import controlador.ConsumidorGateway;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import usuario.modelo.Cliente;
import usuario.modelo.Wishlist;

@WebServlet(name = "GestionarProducto", urlPatterns = {"/gestionarProducto"})
public class GestionarProducto extends HttpServlet {

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

        ConsumidorGateway cg = new ConsumidorGateway();

        Cliente cliente = (Cliente) session.getAttribute("cliente");
        Wishlist lista = new Wishlist(cliente.getIdCliente(), Integer.parseInt(request.getParameter("id")));
        ArrayList<Wishlist> wishlists = cg.consultarWishlists();
        boolean agregar = true;

        if (seleccionado.equals("agregarALista")) {
            for (Wishlist wishlist : wishlists) {
                if (wishlist.getProductoId().equals(Integer.parseInt(request.getParameter("id")))) {
                    agregar = false;
                }
            }

            if (agregar == true) {
                cg.guardarWishlist(lista);
            }

            rd = request.getRequestDispatcher("productos.jsp");
            rd.forward(request, response);

        }

        if (seleccionado.equals("eliminarLista")) {
            cg.eliminarWishlist(Integer.parseInt(request.getParameter("id")));
            rd = request.getRequestDispatcher("wishlist.jsp");
            rd.forward(request, response);
        }

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
