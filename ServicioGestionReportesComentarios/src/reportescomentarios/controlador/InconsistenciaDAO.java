package reportescomentarios.controlador;

import reportescomentarios.controlador.BaseDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import reportescomentarios.modelo.Inconsistencia;

public class InconsistenciaDAO extends BaseDAO<Inconsistencia> {

    @Override
    public ArrayList<Inconsistencia> consultar() throws Exception {

        ArrayList<Inconsistencia> listaInconsistencias = new ArrayList<>();

        try {
            Connection conexion = this.generarConexionConsumidor();
            Statement comando = conexion.createStatement();
            ResultSet resultado = comando.executeQuery("SELECT idinconsistencia,clienteid,supermercadoid,descripcion,categoria FROM inconsistencias");

            while (resultado.next()) {

                Inconsistencia inconsistencia = new Inconsistencia();

                inconsistencia.setId(resultado.getInt("idcomentarios"));
                inconsistencia.setClienteid(resultado.getInt("clienteid"));
                inconsistencia.setSupermercadoid(resultado.getInt("supermercadoid"));
                inconsistencia.setDescripcion(resultado.getString("descripcion"));
                inconsistencia.setCategoria(resultado.getString("categoria"));
                
                listaInconsistencias.add(inconsistencia);
            }

            conexion.close();
            return listaInconsistencias;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return listaInconsistencias;
        }

    }

    @Override
    public Inconsistencia consultar(Integer id) throws Exception {
        Inconsistencia inconsistencia = null;

        try {
            Connection conexion = this.generarConexionConsumidor();
            Statement comando = conexion.createStatement();
            String codigoSQL = String.format("SELECT idinconsistencia,clienteid,supermercadoid,descripcion,categoria FROM inconsistencias WHERE idinconsistencia = '%d'", id);

            ResultSet resultado = comando.executeQuery(codigoSQL);

            if (resultado.next()) {
                Integer clienteid = resultado.getInt("clienteid");

                inconsistencia = new Inconsistencia(id, clienteid);
                return inconsistencia;
            }

            conexion.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

        return inconsistencia;
    }

    @Override
    public void insertar(Inconsistencia inconsistencia) throws Exception {

        try {
            Connection conexion = this.generarConexionConsumidor();
            Statement comando = conexion.createStatement();
            String codigoSQL = String.format("INSERT INTO inconsistencias(clienteid,supermercadoid,descripcion,categoria) VALUES('%d','%d','%s','%s')",
                    inconsistencia.getClienteid(), inconsistencia.getSupermercadoid(), inconsistencia.getDescripcion(), inconsistencia.getCategoria());

            comando.executeUpdate(codigoSQL);
            conexion.close();
            System.out.println("Inconsistencia se registró correctamente");

        } catch (Exception e) {
            System.out.println("Error al registrar la inconsistencia!");
        }
    }

    @Override
    public void actualizar(Inconsistencia inconsistencia) throws Exception {

        if (inconsistencia.getId() == null) {
            throw new Exception("Id de inconsistencia no encontrado");
        }

        try {
            Connection conexion = this.generarConexionConsumidor();
            Statement comando = conexion.createStatement();
            String codigoSQL = String.format(
                    "UPDATE inconsistencias SET clienteid='%d',supermercadoid='%d',descripcion='%s',categoria='%s' WHERE idinconsistencia=%d",
                    inconsistencia.getClienteid(), inconsistencia.getSupermercadoid(), inconsistencia.getDescripcion(), inconsistencia.getCategoria(), inconsistencia.getId());

            int conteoRegistrosAfectados = comando.executeUpdate(codigoSQL);

            if (conteoRegistrosAfectados == 1) {
                System.out.println("Se actualizó la inconsistencia");
            } else {
                System.out.println("No se pudo actualizarla inconsistencia");
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
                    "DELETE FROM inconsistencias WHERE idinconsistencia = %d", id);
            int conteoRegistrosAfectados = comando.executeUpdate(codigoSQL);

            if (conteoRegistrosAfectados == 1) {
                System.out.println("Se eliminó la inconsistencia: " + id);
            } else {
                System.out.println("No se pudo eliminar la inconsistencia");
            }

            conexion.close();

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

}
