package usuario.controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class BaseDAO<T> {

    private static final String CONEXION_CONSUMIDOR = "jdbc:mysql://localhost:3306/consumidor?autoReconnet=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String CONEXION_SUPERMERCADO = "jdbc:mysql://localhost:3306/supermercado?autoReconnet=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String CONEXION_PROFECO = "jdbc:mysql://localhost:3306/profeco?autoReconnet=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USUARIO = "root";
    private static final String CONTRASENIA = "administrador";
    private static final String CLASSNAME = "com.mysql.jdbc.Driver";

    protected Connection generarConexionConsumidor() throws SQLException {
        try {
            Class.forName(CLASSNAME);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return DriverManager.getConnection(CONEXION_CONSUMIDOR, USUARIO, CONTRASENIA);
    }

    protected Connection generarConexionSupermercado() throws SQLException {
        try {
            Class.forName(CLASSNAME);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return DriverManager.getConnection(CONEXION_SUPERMERCADO, USUARIO, CONTRASENIA);
    }

    protected Connection generarConexionProfeco() throws SQLException {
        try {
            Class.forName(CLASSNAME);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return DriverManager.getConnection(CONEXION_PROFECO, USUARIO, CONTRASENIA);
    }

    
    public abstract ArrayList<T> consultar() throws Exception;

    public abstract T consultar(Integer id) throws Exception;

    public abstract void insertar(T entidad) throws Exception;

    public abstract void actualizar(T entidad) throws Exception;

    public abstract void eliminar(Integer id) throws Exception;

}
