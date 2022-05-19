
package reportescomentarios.modelo;

public class Inconsistencia {
    
    private Integer id;
    private Integer clienteid;
    private Integer supermercadoid;
    private String descripcion;
    private String categoria;

    public Inconsistencia() {
    }

    public Inconsistencia(Integer id, Integer clienteid, Integer supermercadoid, String descripcion, String categoria) {
        this.id = id;
        this.clienteid = clienteid;
        this.supermercadoid = supermercadoid;
        this.descripcion = descripcion;
        this.categoria = categoria;
    }

    public Inconsistencia(Integer id, Integer clienteid) {
        this.id = id;
        this.clienteid = clienteid;
    }

    
    public Inconsistencia(Integer clienteid, Integer supermercadoid, String descripcion, String categoria) {
        this.clienteid = clienteid;
        this.supermercadoid = supermercadoid;
        this.descripcion = descripcion;
        this.categoria = categoria;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClienteid() {
        return clienteid;
    }

    public void setClienteid(Integer clienteid) {
        this.clienteid = clienteid;
    }

    public Integer getSupermercadoid() {
        return supermercadoid;
    }

    public void setSupermercadoid(Integer supermercadoid) {
        this.supermercadoid = supermercadoid;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Inconsistencia{" + "id=" + id + ", clienteid=" + clienteid + ", supermercadoid=" + supermercadoid + ", descripcion=" + descripcion + ", categoria=" + categoria + '}';
    }
}
