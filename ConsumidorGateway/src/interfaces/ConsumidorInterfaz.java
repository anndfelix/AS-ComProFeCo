
package interfaces;

import java.util.ArrayList;
import productos.modelo.Producto;
import reportescomentarios.modelo.Comentario;
import reportescomentarios.modelo.Inconsistencia;
import usuario.modelo.Cliente;
import usuario.modelo.DetalleListaSupermercado;
import usuario.modelo.ListaSupermercado;
import usuario.modelo.Wishlist;



public interface ConsumidorInterfaz {
    
    public ArrayList<Producto> consultarProductos(); //ProductosOfertas
    public ArrayList<Producto> consultarProducto(String identificador); //ProductosOfertas
    public void guardarWishlist(Wishlist wishlist); //GestionUsuario
    public void guardarListaSupermercado(ListaSupermercado listaSupermercado); //GestionUsuario
    public void guardarDetallesListaSupermercado(DetalleListaSupermercado detalles); //GestionUsuario
    public void generarComentario(Comentario comentario); //ReportesComentarios
    public void generarReporteInconsistencia(Inconsistencia inconsistencia); //ReportesComentarios
    public void registrarUsuario(Cliente cliente); //GestionUsuario
    public Cliente iniciarSesion(String usuario, String contraseña); //GestionUsuario
    public void eliminarUsuario(Integer clienteid); //GestionUsuario
    public void actualizarUsuario(Cliente cliente);  //GestionUsuario
    public ArrayList<ListaSupermercado> consultarPorUsuario(Integer clienteId); //GestionUsuario
    public ArrayList<DetalleListaSupermercado> consultarPorLista (Integer listaid); //GestionUsuario
    public void actualizarDetalleLista(DetalleListaSupermercado detalles); //GestionUsuario
    public void actualizarListaSupermercado(ListaSupermercado listaSupermercado); //GestionUsuario
    public ArrayList<Wishlist> consultarWishlistPorUsuario(Integer clienteid);
    public ArrayList<Wishlist> consultarWishlists();
    public Producto consultarProductoPorId(Integer id);
    public void eliminarWishlist(Integer id);
    
}
