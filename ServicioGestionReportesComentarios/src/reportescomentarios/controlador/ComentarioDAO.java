package reportescomentarios.controlador;

import reportescomentarios.controlador.BaseDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import reportescomentarios.modelo.Comentario;

public class ComentarioDAO extends BaseDAO<Comentario> {

    @Override
    public ArrayList<Comentario> consultar() throws Exception {

        ArrayList<Comentario> listaComentarios = new ArrayList<>();

        try {
            Connection conexion = this.generarConexionConsumidor();
            Statement comando = conexion.createStatement();
            ResultSet resultado = comando.executeQuery("SELECT idcomentarios,clienteid,supermercadoid,calificacion,comentario FROM comentarios");

            while (resultado.next()) {

                Comentario comentario = new Comentario();

                comentario.setId(resultado.getInt("idcomentarios"));
                comentario.setCalificacion(resultado.getInt("calificacion"));
                comentario.setClienteid(resultado.getInt("clienteid"));
                comentario.setSupermercadoid(resultado.getInt("supermercadoid"));
                comentario.setComentario(resultado.getString("comentario"));

                listaComentarios.add(comentario);
            }

            conexion.close();
            return listaComentarios;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return listaComentarios;
        }

    }

    @Override
    public Comentario consultar(Integer id) throws Exception {
        Comentario comentario = null;

        try {
            Connection conexion = this.generarConexionConsumidor();
            Statement comando = conexion.createStatement();
            String codigoSQL = String.format("SELECT idcomentarios,clienteid,supermercadoid,calificacion,comentario WHERE idcomentarios = '%d'", id);

            ResultSet resultado = comando.executeQuery(codigoSQL);

            if (resultado.next()) {
                Integer clienteid = resultado.getInt("clienteid");

                comentario = new Comentario(id, clienteid);
                return comentario;
            }

            conexion.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

        return comentario;
    }

    @Override
    public void insertar(Comentario comentario) throws Exception {

        try {
            Connection conexion = this.generarConexionConsumidor();
            Statement comando = conexion.createStatement();
            String codigoSQL = String.format("INSERT INTO comentarios(clienteid,supermercadoid,calificacion,comentario) VALUES('%d','%d','%d','%s')",
                    comentario.getClienteid(), comentario.getSupermercadoid(), comentario.getCalificacion(), comentario.getComentario());

            comando.executeUpdate(codigoSQL);
            conexion.close();
            System.out.println("Comentario se registró correctamente");

        } catch (Exception e) {
            System.out.println("Error al registrar el comentario!");
        }
    }

    @Override
    public void actualizar(Comentario comentario) throws Exception {

        if (comentario.getId() == null) {
            throw new Exception("Id de comentario no encontrado");
        }

        try {
            Connection conexion = this.generarConexionConsumidor();
            Statement comando = conexion.createStatement();
            String codigoSQL = String.format(
                    "UPDATE comentarios SET clienteid='%d',supermercadoid='%d',calificacion='%d',comentario='%s' WHERE idcomentarios=%d",
                    comentario.getClienteid(), comentario.getSupermercadoid(), comentario.getCalificacion(), comentario.getComentario(), comentario.getId());

            int conteoRegistrosAfectados = comando.executeUpdate(codigoSQL);

            if (conteoRegistrosAfectados == 1) {
                System.out.println("Se actualizó el comentario");
            } else {
                System.out.println("No se pudo actualizar el comentario");
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
                    "DELETE FROM comentarios WHERE idcomentarios = %d", id);
            int conteoRegistrosAfectados = comando.executeUpdate(codigoSQL);

            if (conteoRegistrosAfectados == 1) {
                System.out.println("Se eliminó el comentario: " + id);
            } else {
                System.out.println("No se pudo eliminar el comentario");
            }

            conexion.close();

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

}
