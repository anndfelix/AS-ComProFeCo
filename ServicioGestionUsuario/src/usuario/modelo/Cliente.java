
package usuario.modelo;

public class Cliente extends Usuario {
    
    private Integer idCliente;
    private String nombre;
    private String email;
    private String telefono;

    public Cliente() {
        super();
    }    
    
    public Cliente(String usuario, String contrasenia) {
        super(usuario, contrasenia);
    }

    public Cliente(String nombre, String email, String telefono, String usuario, String contrasenia) {
        super(usuario, contrasenia);
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    public Cliente(Integer idCliente, String nombre, String email, String telefono, String usuario, String contrasenia) {
        super(usuario, contrasenia);
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", nombre=" + nombre + ", email=" + email + ", telefono=" + telefono + '}';
    }
}
