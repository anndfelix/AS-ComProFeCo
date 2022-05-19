package controlador;

import interfaces.ConsumidorInterfaz;
import java.util.ArrayList;
import productos.modelo.Producto;
import reportescomentarios.modelo.Comentario;
import reportescomentarios.modelo.Inconsistencia;
import usuario.controlador.ClienteDAO;
import usuario.controlador.DetalleListaSupermercadoDAO;
import usuario.controlador.ListaSupermercadoDAO;
import usuario.controlador.WishlistDAO;
import usuario.modelo.Cliente;
import usuario.modelo.DetalleListaSupermercado;
import usuario.modelo.ListaSupermercado;
import usuario.modelo.Wishlist;



public class ConsumidorGateway implements ConsumidorInterfaz {

    productos.controlador.ProductoDAO productoDAO = new productos.controlador.ProductoDAO();
    ClienteDAO clienteDAO = new ClienteDAO();
    WishlistDAO wishlistDAO = new WishlistDAO();
    ListaSupermercadoDAO listaSupermercadoDAO = new ListaSupermercadoDAO();
    DetalleListaSupermercadoDAO detalleListaSupermercadoDAO = new DetalleListaSupermercadoDAO();

    @Override
    public ArrayList<productos.modelo.Producto> consultarProductos() {

        ArrayList<productos.modelo.Producto> listaProductos = new ArrayList<>();

        try {
            listaProductos = productoDAO.consultar();
            return listaProductos;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return listaProductos;
        }
    }

    @Override
    public ArrayList<Producto> consultarProducto(String identificador) {
        ArrayList<Producto> listaProductos = new ArrayList<>();

        try {
            listaProductos = productoDAO.buscarProducto(identificador);
            return listaProductos;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return listaProductos;
        }
    }

    @Override
    public void guardarWishlist(Wishlist wishlist) {
        try {
            wishlistDAO.insertar(wishlist);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void guardarListaSupermercado(ListaSupermercado listaSupermercado) {
        try {
            listaSupermercadoDAO.insertar(listaSupermercado);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void guardarDetallesListaSupermercado(DetalleListaSupermercado detalles) {
        try {
            detalleListaSupermercadoDAO.insertar(detalles);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void generarComentario(Comentario comentario) {
        try {
          //  comentarioDAO.insertar(comentario);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void generarReporteInconsistencia(Inconsistencia inconsistencia) {
        try {
         //   inconsistenciaDAO.insertar(inconsistencia);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void registrarUsuario(Cliente cliente) {
        try {
            clienteDAO.insertar(cliente);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public Cliente iniciarSesion(String usuario, String contraseña) {

        Cliente cliente = null;

        try {
            cliente = clienteDAO.autenticacion(usuario, contraseña);
            return cliente;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return cliente;
        }
    }

    @Override
    public void eliminarUsuario(Integer clienteid) {
       try {
           clienteDAO.eliminar(clienteid);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void actualizarUsuario(Cliente cliente) {
       try {
            clienteDAO.actualizar(cliente);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public ArrayList<ListaSupermercado> consultarPorUsuario(Integer clienteId) {
        ArrayList<ListaSupermercado> listasSupermercado = new ArrayList<>();

        try {
            listasSupermercado = listaSupermercadoDAO.consultarPorUsuario(clienteId);
            return listasSupermercado;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return listasSupermercado;
        }
    }

    @Override
    public ArrayList<DetalleListaSupermercado> consultarPorLista(Integer listaid) {
         ArrayList<DetalleListaSupermercado> listaDetalles = new ArrayList<>();
         
        try {
            listaDetalles = detalleListaSupermercadoDAO.consultarPorLista(listaid);
            return listaDetalles;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return listaDetalles;
        }
    }

    @Override
    public void actualizarDetalleLista(DetalleListaSupermercado detalles) {
         try {
            detalleListaSupermercadoDAO.actualizar(detalles);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void actualizarListaSupermercado(ListaSupermercado listaSupermercado) {
       try {
            listaSupermercadoDAO.actualizar(listaSupermercado);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public ArrayList<Wishlist>  consultarWishlistPorUsuario(Integer clienteid) {
        
       ArrayList<Wishlist> listaWishlists = new ArrayList<>();
        
        try {
            listaWishlists = wishlistDAO.consultarPorUsuario(clienteid);
            return listaWishlists;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return listaWishlists;
        }
    }

    @Override
    public ArrayList<Wishlist> consultarWishlists() {
       
        ArrayList<Wishlist> listaWishlists = new ArrayList<>();

        try {
            listaWishlists = wishlistDAO.consultar();
            return listaWishlists;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return listaWishlists;
        }
    }

    @Override
    public Producto consultarProductoPorId(Integer id) {
       Producto producto = null;

        try {
            producto = productoDAO.consultar(id);
            return producto;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return producto;
        }
    }

    @Override
    public void eliminarWishlist(Integer id) {
        try {
            wishlistDAO.eliminar(id);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
