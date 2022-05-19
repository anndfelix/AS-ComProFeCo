
package supermercado.controlador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import supermercado.modelo.Supermercado;

public class SupermercadoDAO extends BaseDAO<Supermercado> {

    @Override
    public ArrayList<Supermercado> consultar() throws Exception {

        ArrayList<Supermercado> listaSupermercados = new ArrayList<>();

        try {
            Connection conexion = this.generarConexionConsumidor();
            Statement comando = conexion.createStatement();
            ResultSet resultado = comando.executeQuery("SELECT idsupermercado,nombre,direccion,telefono FROM supermercados");

            while (resultado.next()) {

                Supermercado supermercado = new Supermercado();

                supermercado.setId(resultado.getInt("idsupermercado"));
                supermercado.setNombre(resultado.getString("nombre"));
                supermercado.setDireccion(resultado.getString("direccion"));
                supermercado.setTelefono(resultado.getString("telefono"));

                listaSupermercados.add(supermercado);
            }
            conexion.close();
            return listaSupermercados;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return listaSupermercados;
        }

    }

    @Override
    public Supermercado consultar(Integer id) throws Exception {

        Supermercado supermercado = null;

        try {
            Connection conexion = this.generarConexionConsumidor();
            Statement comando = conexion.createStatement();
            String codigoSQL = String.format("SELECT idsupermercado,nombre,direccion,telefono FROM supermercados WHERE idsupermercado = '%d'", id);

            ResultSet resultado = comando.executeQuery(codigoSQL);

            if (resultado.next()) {
                String nombre = resultado.getString("nombre");
                String direccion = resultado.getString("direccion");
                String telefono = resultado.getString("telefono");
                
                supermercado = new Supermercado(id, nombre, direccion, telefono);
                return supermercado;
            }

            conexion.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

        return supermercado;
    }

    @Override
    public void insertar(Supermercado supermercado) throws Exception {

        try {
            Connection conexion = this.generarConexionConsumidor();
            Statement comando = conexion.createStatement();
            String codigoSQL = String.format("INSERT INTO supermercados(nombre, direccion, telefono) VALUES('%s','%s','%s')",
                    supermercado.getNombre(),
                    supermercado.getDireccion(),
                    supermercado.getTelefono());

            comando.executeUpdate(codigoSQL);
            conexion.close();
            System.out.println("Supermercado se registró correctamente");

        } catch (Exception e) {
            System.out.println("Error al registrar supermercado!");
        }
    }

    @Override
    public void actualizar(Supermercado supermercado) throws Exception {

        if (supermercado.getId() == null) {
            throw new Exception("Id de supermercado no encontrado");
        }

        try {
            Connection conexion = this.generarConexionConsumidor();
            Statement comando = conexion.createStatement();
            String codigoSQL = String.format(
                    "UPDATE supermercados SET nombre='%s', direccion='%s', telefono='%s' WHERE idsupermercado=%d",
                    supermercado.getNombre(),
                    supermercado.getDireccion(),
                    supermercado.getTelefono(),
                    supermercado.getId());

            int conteoRegistrosAfectados = comando.executeUpdate(codigoSQL);

            if (conteoRegistrosAfectados == 1) {
                System.out.println("Se actualizó el supermercado");
            } else {
                System.out.println("No se pudo actualizar el supermercado");
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
                    "DELETE FROM supermercados WHERE idsupermercado = %d", id);
            int conteoRegistrosAfectados = comando.executeUpdate(codigoSQL);

            if (conteoRegistrosAfectados == 1) {
                System.out.println("Se eliminó el supermercado: " + id);
            } else {
                System.out.println("No se pudo eliminar el supermercado");
            }

            conexion.close();

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

}
