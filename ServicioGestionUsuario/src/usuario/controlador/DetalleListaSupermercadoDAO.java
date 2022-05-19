package usuario.controlador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import usuario.modelo.DetalleListaSupermercado;
import usuario.modelo.ListaSupermercado;

public class DetalleListaSupermercadoDAO extends BaseDAO<DetalleListaSupermercado> {

    @Override
    public ArrayList<DetalleListaSupermercado> consultar() throws Exception {

        ArrayList<DetalleListaSupermercado> listaDetalles = new ArrayList<>();

        try {
            Connection conexion = this.generarConexionConsumidor();
            Statement comando = conexion.createStatement();
            ResultSet resultado = comando.executeQuery("SELECT id,listaid,productoid,cantidad FROM detalleslista");

            while (resultado.next()) {

                DetalleListaSupermercado detalle = new DetalleListaSupermercado();

                detalle.setId(resultado.getInt("id"));
                detalle.setListaSupermercadoId(resultado.getInt("listaid"));
                detalle.setProductoId(resultado.getInt("productoid"));
                detalle.setCantidad(resultado.getInt("cantidad"));

                listaDetalles.add(detalle);
            }
            conexion.close();
            return listaDetalles;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return listaDetalles;
        }

    }
    
      public ArrayList<DetalleListaSupermercado> consultarPorLista(Integer id) {
       ArrayList<DetalleListaSupermercado> listaDetalles = new ArrayList<>();
        try{
            Connection conexion = this.generarConexionConsumidor();
            Statement comando = conexion.createStatement();
            String codigoSQL = String.format("SELECT idlistasupermercado,clienteid,total FROM listasupermercado WHERE idlistasupermercado = '%d'", id);
            ResultSet resultado = comando.executeQuery(codigoSQL);
            
            while(resultado.next()){
               DetalleListaSupermercado detalle = new DetalleListaSupermercado();

                detalle.setId(resultado.getInt("id"));
                detalle.setListaSupermercadoId(resultado.getInt("listaid"));
                detalle.setProductoId(resultado.getInt("productoid"));
                detalle.setCantidad(resultado.getInt("cantidad"));

                listaDetalles.add(detalle);
            }
            
            conexion.close();
            return listaDetalles;
        
        } catch (Exception ex){
            System.err.println(ex.getMessage());
            return listaDetalles;
        }
    }
    

    @Override
    public DetalleListaSupermercado consultar(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void insertar(DetalleListaSupermercado detalle) throws Exception {

        try {
            Connection conexion = this.generarConexionConsumidor();
            Statement comando = conexion.createStatement();
            String codigoSQL = String.format("INSERT INTO detalleslista(listaid, productoid, cantidad) VALUES('%d','%d','%d')",
                    detalle.getListaSupermercadoId(),
                    detalle.getProductoId(),
                    detalle.getCantidad());

            comando.executeUpdate(codigoSQL);
            conexion.close();
            System.out.println("Detalle se registró correctamente");

        } catch (Exception e) {
            System.out.println("Error al registrar el detalle!");
        }
    }

    @Override
    public void actualizar(DetalleListaSupermercado detalle) throws Exception {

        if (detalle.getId() == null) {
            throw new Exception("Id de detalle no encontrado");
        }

        try {
            Connection conexion = this.generarConexionConsumidor();
            Statement comando = conexion.createStatement();
            String codigoSQL = String.format(
                    "UPDATE detalleslista SET listaid='%d', productoid='%d', cantidad='%d' WHERE id=%d",
                    detalle.getListaSupermercadoId(),
                    detalle.getProductoId(),
                    detalle.getCantidad(),
                    detalle.getId());

            int conteoRegistrosAfectados = comando.executeUpdate(codigoSQL);

            if (conteoRegistrosAfectados == 1) {
                System.out.println("Se actualizó el detalle");
            } else {
                System.out.println("No se pudo actualizar el detalle");
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
                    "DELETE FROM detalleslista WHERE id = %d", id);
            int conteoRegistrosAfectados = comando.executeUpdate(codigoSQL);

            if (conteoRegistrosAfectados == 1) {
                System.out.println("Se eliminó el detalle: " + id);
            } else {
                System.out.println("No se pudo eliminar el detalle");
            }

            conexion.close();

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

}
