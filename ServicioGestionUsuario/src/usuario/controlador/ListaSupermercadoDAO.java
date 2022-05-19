
package usuario.controlador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import usuario.modelo.ListaSupermercado;
import usuario.modelo.Wishlist;

public class ListaSupermercadoDAO extends BaseDAO<ListaSupermercado> {

    @Override
    public ArrayList<ListaSupermercado> consultar() throws Exception {

        ArrayList<ListaSupermercado> listaSupermercado = new ArrayList<>();

        try {
            Connection conexion = this.generarConexionConsumidor();
            Statement comando = conexion.createStatement();
            ResultSet resultado = comando.executeQuery("SELECT idlistasupermercado,clienteid,total FROM listasupermercado");

            while (resultado.next()) {

                ListaSupermercado lista = new ListaSupermercado();

                lista.setId(resultado.getInt("idlistasupermercado"));
                lista.setClienteId(resultado.getInt("clienteid"));
                lista.setTotal(resultado.getFloat("total"));

                listaSupermercado.add(lista);
            }
            conexion.close();
            return listaSupermercado;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return listaSupermercado;
        }

    }

     public ArrayList<ListaSupermercado> consultarPorUsuario(Integer id) {
       ArrayList<ListaSupermercado> listaSupermercado = new ArrayList<>();
        try{
            Connection conexion = this.generarConexionConsumidor();
            Statement comando = conexion.createStatement();
            String codigoSQL = String.format("SELECT idlistasupermercado,clienteid,total FROM listasupermercado WHERE idlistasupermercado = '%d'", id);
            ResultSet resultado = comando.executeQuery(codigoSQL);
            
            while(resultado.next()){
                ListaSupermercado lista = new ListaSupermercado();

                lista.setId(resultado.getInt("idlistasupermercado"));
                lista.setClienteId(resultado.getInt("clienteid"));
                lista.setTotal(resultado.getFloat("total"));

                listaSupermercado.add(lista);
            }
            
            conexion.close();
            System.out.println("Se consulto la lista del cliente");
            return listaSupermercado;
        
        } catch (Exception ex){
            System.err.println(ex.getMessage());
            return listaSupermercado;
        }
    }
    
    @Override
    public ListaSupermercado consultar(Integer id) throws Exception {
         ListaSupermercado lista = null;

        try {
            Connection conexion = this.generarConexionConsumidor();
            Statement comando = conexion.createStatement();
            String codigoSQL = String.format("SELECT idlistasupermercado,clienteid,total FROM listasupermercado WHERE idlistasupermercado = '%d'", id);

            ResultSet resultado = comando.executeQuery(codigoSQL);

            if (resultado.next()) {
                Integer clienteid = resultado.getInt("clienteid");
                Float total = resultado.getFloat("total");
                
                lista = new ListaSupermercado(id, clienteid, total);
                return lista;
            }

            conexion.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

        return lista;
    }

    @Override
    public void insertar(ListaSupermercado lista) throws Exception {

        try {
            Connection conexion = this.generarConexionConsumidor();
            Statement comando = conexion.createStatement();
            String codigoSQL = String.format("INSERT INTO listasupermercado(clienteid, total) VALUES('%d','%f')",
                    lista.getClienteId(),
                    lista.getTotal());

            comando.executeUpdate(codigoSQL);
            conexion.close();
            System.out.println("Lista se registró correctamente");

        } catch (Exception e) {
            System.out.println("Error al registrar la lista!");
        }
    }

    @Override
    public void actualizar(ListaSupermercado lista) throws Exception {

        if (lista.getId() == null) {
            throw new Exception("Id de lista no encontrado");
        }

        try {
            Connection conexion = this.generarConexionConsumidor();
            Statement comando = conexion.createStatement();
            String codigoSQL = String.format(
                    "UPDATE listasupermercado SET clienteid='%d', total='%f' WHERE id=%d",
                    lista.getClienteId(),
                    lista.getTotal(),
                    lista.getId());

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
                    "DELETE FROM listasupermercado WHERE id = %d", id);
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

}
