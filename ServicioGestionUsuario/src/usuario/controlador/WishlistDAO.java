
package usuario.controlador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import usuario.modelo.Wishlist;

public class WishlistDAO extends BaseDAO<Wishlist>{
    
@Override
    public ArrayList<Wishlist> consultar() throws Exception {

        ArrayList<Wishlist> listaWishlist = new ArrayList<>();

        try {
            Connection conexion = this.generarConexionConsumidor();
            Statement comando = conexion.createStatement();
            ResultSet resultado = comando.executeQuery("SELECT idwishlist,clienteid,productoid FROM wishlists");

            while (resultado.next()) {

                Wishlist wishlist = new Wishlist();

                wishlist.setIdWishlist(resultado.getInt("idwishlist"));
                wishlist.setClienteId(resultado.getInt("clienteid"));
                wishlist.setProductoId(resultado.getInt("productoid"));
                
                listaWishlist.add(wishlist);
            }
            conexion.close();
            return listaWishlist;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return listaWishlist;
        }

    }

    @Override
    public Wishlist consultar(Integer id) throws Exception {
        Wishlist wishlist = null;

        try {
            Connection conexion = this.generarConexionConsumidor();
            Statement comando = conexion.createStatement();
            String codigoSQL = String.format("SELECT idwishlist,clienteid,productoid FROM wishlists WHERE clienteid = '%d'", id);

            ResultSet resultado = comando.executeQuery(codigoSQL);

            if (resultado.next()) {
                Integer idwishlist = resultado.getInt("idwishlist");
                Integer clienteid = resultado.getInt("clienteid");
                Integer productoid = resultado.getInt("productoid");
                
                wishlist = new Wishlist(idwishlist, clienteid, productoid);
                return wishlist;
            }

            conexion.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

        return wishlist;
    }

    @Override
    public void insertar(Wishlist wishlist) throws Exception {

        try {
            Connection conexion = this.generarConexionConsumidor();
            Statement comando = conexion.createStatement();
            String codigoSQL = String.format("INSERT INTO wishlists(clienteid,productoid) VALUES('%d','%d')",
                    wishlist.getClienteId(),wishlist.getProductoId());

            comando.executeUpdate(codigoSQL);
            conexion.close();
            System.out.println("Lista se registró correctamente");

        } catch (Exception e) {
            System.out.println("Error al registrar la lista!");
        }
    }

    @Override
    public void actualizar(Wishlist wishlist) throws Exception {

        if (wishlist.getIdWishlist()== null) {
            throw new Exception("Id de lista no encontrado");
        }

        try {
            Connection conexion = this.generarConexionConsumidor();
            Statement comando = conexion.createStatement();
            String codigoSQL = String.format(
                    "UPDATE wishlists SET clienteid='%d', productoid='%d' WHERE idwishlist=%d",
                    wishlist.getClienteId(),
                    wishlist.getProductoId(),
                    wishlist.getIdWishlist());

            int conteoRegistrosAfectados = comando.executeUpdate(codigoSQL);

            if (conteoRegistrosAfectados == 1) {
                System.out.println("Se actualizó la lista");
            } else {
                System.out.println("No se pudo actualizar la lista");
            }

            conexion.close();

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void eliminar(Integer id) throws Exception {

        try {
            Connection conexion = this.generarConexionConsumidor();
            Statement comando = conexion.createStatement();
            String codigoSQL = String.format(
                    "DELETE FROM wishlists WHERE productoid = %d", id);
            int conteoRegistrosAfectados = comando.executeUpdate(codigoSQL);

            if (conteoRegistrosAfectados == 1) {
                System.out.println("Se eliminó la lista: " + id);
            } else {
                System.out.println("No se pudo eliminar la lista");
            }

            conexion.close();

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
    
      public ArrayList<Wishlist> consultarPorUsuario(Integer clienteid) throws Exception {

        ArrayList<Wishlist> listaWishlist = new ArrayList<>();

        try {
            Connection conexion = this.generarConexionConsumidor();
            Statement comando = conexion.createStatement();
            String codigoSQL = String.format("SELECT idwishlist,clienteid,productoid FROM wishlists WHERE clienteid=%d",clienteid);

            ResultSet resultado = comando.executeQuery(codigoSQL);
            
            while (resultado.next()) {

                Wishlist wishlist = new Wishlist();

                wishlist.setIdWishlist(resultado.getInt("idwishlist"));
                wishlist.setClienteId(resultado.getInt("clienteid"));
                wishlist.setProductoId(resultado.getInt("productoid"));
                
                listaWishlist.add(wishlist);
            }
            conexion.close();
            return listaWishlist;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return listaWishlist;
        }

    }

}
