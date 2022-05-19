package productos.controlador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import productos.modelo.Producto;

public class ProductoDAO extends BaseDAO<Producto> {

    public ArrayList<Producto> consultar() throws Exception {

        ArrayList<Producto> listaProductos = new ArrayList<>();

        try {
            Connection conexion = this.generarConexionConsumidor();
            Statement comando = conexion.createStatement();
            ResultSet resultado = comando.executeQuery("SELECT idproducto,nombre,descripcion,disponible,supermercado,precio,cantidad,categorias FROM productos");

            while (resultado.next()) {

                Producto producto = new Producto();

                producto.setId(resultado.getInt("idproducto"));
                producto.setNombre(resultado.getString("nombre"));
                producto.setDescripcion(resultado.getString("descripcion"));

                if (resultado.getInt("disponible") == 1) {
                    producto.setDisponible(true);
                } else {
                    producto.setDisponible(false);
                }

                producto.setPrecio(resultado.getFloat("precio"));
                producto.setCantidad(resultado.getInt("cantidad"));

                listaProductos.add(producto);
            }
            conexion.close();
            return listaProductos;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return listaProductos;
        }

    }

    @Override
    public Producto consultar(Integer id) throws Exception {
        Producto producto = new Producto();

        try {
            Connection conexion = this.generarConexionConsumidor();
            Statement comando = conexion.createStatement();
            String codigoSQL = String.format("SELECT idproducto,nombre,descripcion,disponible,supermercado,precio,cantidad,categorias FROM productos WHERE idproducto = '%d'", id);

            ResultSet resultado = comando.executeQuery(codigoSQL);

            if (resultado.next()) {
                producto.setId(resultado.getInt("idproducto"));
                producto.setNombre(resultado.getString("nombre"));
                producto.setDescripcion(resultado.getString("descripcion"));

                if (resultado.getInt("disponible") == 1) {
                    producto.setDisponible(true);
                } else {
                    producto.setDisponible(false);
                }

                producto.setPrecio(resultado.getFloat("precio"));
                producto.setCantidad(resultado.getInt("cantidad"));

            }

            conexion.close();
            return producto;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return producto;

        }

    }

    @Override
    public void insertar(Producto producto) throws Exception {

        try {
            Connection conexion = this.generarConexionConsumidor();
            Statement comando = conexion.createStatement();

            int disponible;

            if (producto.isDisponible()) {
                disponible = 1;
            } else {
                disponible = 0;
            }

            String codigoSQL = String.format("INSERT INTO productos(nombre, descripcion, disponible, supermercado, precio, cantidad, categorias) VALUES('%s','%s','%d','%d','%f','%d','%s')",
                    producto.getNombre(),
                    producto.getDescripcion(),
                    disponible,
                    producto.getSupermercado().getId(),
                    producto.getPrecio(),
                    producto.getCantidad(),
                    producto.getCategorias());

            comando.executeUpdate(codigoSQL);
            conexion.close();
            System.out.println("Producto se registró correctamente");

        } catch (Exception e) {
            System.out.println("Error al registrar producto!");
        }
    }

    @Override
    public void actualizar(Producto producto) throws Exception {

        if (producto.getId() == null) {
            throw new Exception("Id de producto no encontrado");
        }

        int disponible;

        if (producto.isDisponible()) {
            disponible = 1;
        } else {
            disponible = 0;
        }

        try {
            Connection conexion = this.generarConexionConsumidor();
            Statement comando = conexion.createStatement();
            String codigoSQL = String.format(
                    "UPDATE productos SET nombre='%s', descripcion='%s', disponible='%d', supermercado='%d', precio='%f', cantidad = '%d', categorias = '%s' WHERE idproducto=%d",
                    producto.getNombre(),
                    producto.getDescripcion(),
                    disponible,
                    producto.getSupermercado().getId(),
                    producto.getPrecio(),
                    producto.getCantidad(),
                    producto.getCategorias(),
                    producto.getId());

            int conteoRegistrosAfectados = comando.executeUpdate(codigoSQL);

            if (conteoRegistrosAfectados == 1) {
                System.out.println("Se actualizó el producto");
            } else {
                System.out.println("No se pudo actualizar el producto");
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
                    "DELETE FROM productos WHERE idproducto = %d", id);
            int conteoRegistrosAfectados = comando.executeUpdate(codigoSQL);

            if (conteoRegistrosAfectados == 1) {
                System.out.println("Se eliminó el producto: " + id);
            } else {
                System.out.println("No se pudo eliminar el producto");
            }

            conexion.close();

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    public ArrayList<Producto> buscarProducto(String identificador) {

        ArrayList<Producto> listaProductosBuscado = new ArrayList<>();

        try {
            Connection conexion = this.generarConexionConsumidor();
            Statement comando = conexion.createStatement();
            ResultSet resultado = comando.executeQuery("SELECT idproducto,nombre,descripcion,disponible,supermercado,precio,cantidad,categorias FROM productos WHERE nombre LIKE '%" + identificador + "%'");

            while (resultado.next()) {

                Producto producto = new Producto();

                producto.setId(resultado.getInt("idproducto"));
                producto.setNombre(resultado.getString("nombre"));
                producto.setDescripcion(resultado.getString("descripcion"));

                if (resultado.getInt("disponible") == 1) {
                    producto.setDisponible(true);
                } else {
                    producto.setDisponible(false);
                }

                producto.setPrecio(resultado.getFloat("precio"));
                producto.setCantidad(resultado.getInt("cantidad"));

                listaProductosBuscado.add(producto);
            }
            conexion.close();
            return listaProductosBuscado;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return listaProductosBuscado;
        }
    }
}
