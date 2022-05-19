package usuario.controlador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import usuario.modelo.Cliente;

public class ClienteDAO extends BaseDAO<Cliente> {

    @Override
    public ArrayList<Cliente> consultar() throws Exception {

        ArrayList<Cliente> listaClientes = new ArrayList<>();

        try {
            Connection conexion = this.generarConexionConsumidor();
            Statement comando = conexion.createStatement();
            ResultSet resultado = comando.executeQuery("SELECT id,nombre,telefono,email,usuario FROM clientes");

            while (resultado.next()) {

                Cliente cliente = new Cliente();

                cliente.setIdCliente(resultado.getInt("id"));
                cliente.setNombre(resultado.getString("nombre"));
                cliente.setTelefono(resultado.getString("telefono"));
                cliente.setEmail(resultado.getString("email"));
                cliente.setUsuario(resultado.getString("usuario"));

                listaClientes.add(cliente);
            }
            conexion.close();
            return listaClientes;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return listaClientes;
        }

    }

    @Override
    public Cliente consultar(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void insertar(Cliente cliente) throws Exception {
       
        try {
            Connection conexion = this.generarConexionConsumidor();
            Statement comando = conexion.createStatement();
            String codigoSQL = String.format("INSERT INTO clientes(usuario, email, contraseña, nombre, telefono) VALUES('%s','%s','%s','%s','%s')",
                    cliente.getUsuario(),
                    cliente.getEmail(),
                    cliente.getContrasenia(),
                    cliente.getNombre(),
                    cliente.getTelefono());

            comando.executeUpdate(codigoSQL);
            conexion.close();
            System.out.println("Cliente se registró correctamente");

        } catch (Exception e) {
            System.out.println("Error al registrar cliente!");
        }
    }

    @Override
    public void actualizar(Cliente cliente) throws Exception {

        if (cliente.getIdCliente() == null) {
            throw new Exception("Id de cliente no encontrado");
        }

        try {
            Connection conexion = this.generarConexionConsumidor();
            Statement comando = conexion.createStatement();
            String codigoSQL = String.format(
                    "UPDATE clientes SET usuario='%s', email='%s', contraseña='%s', nombre='%s', telefono='%s' WHERE id=%d",
                    cliente.getUsuario(),
                    cliente.getEmail(),
                    cliente.getContrasenia(),
                    cliente.getNombre(),
                    cliente.getTelefono(),
                    cliente.getIdCliente()
            );

            int conteoRegistrosAfectados = comando.executeUpdate(codigoSQL);

            if (conteoRegistrosAfectados == 1) {
                System.out.println("Se actualizó el cliente");
            } else {
                System.out.println("No se pudo actualizar el cliente");
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
                    "DELETE FROM clientes WHERE id = %d", id);
            int conteoRegistrosAfectados = comando.executeUpdate(codigoSQL);

            if (conteoRegistrosAfectados == 1) {
                System.out.println("Se eliminó el cliente: " + id);
            } else {
                System.out.println("No se pudo eliminar el cliente");
            }

            conexion.close();

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    public Cliente autenticacion(String usuario, String contraseña) {
        Cliente cliente = null;
        try {
            Connection conexion = this.generarConexionConsumidor();
            Statement comando = conexion.createStatement();
            String codigoSQL = String.format(
                    "SELECT id, usuario, email, contraseña, nombre, telefono FROM clientes WHERE usuario = '%s' AND contraseña = '%s'",
                    usuario, contraseña
            );
            
            ResultSet resultado = comando.executeQuery(codigoSQL);
            if (resultado.next()) {
                Integer id = resultado.getInt("id");
                String email = resultado.getString("email");
                String nombre = resultado.getString("nombre");
                String telefono = resultado.getString("telefono");
                cliente = new Cliente(id ,nombre, email, telefono, usuario, contraseña);
                System.out.println("Se autenticó el cliente: " + usuario);
            }
            conexion.close();
            return cliente;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return cliente;
        }
    }
    
}
