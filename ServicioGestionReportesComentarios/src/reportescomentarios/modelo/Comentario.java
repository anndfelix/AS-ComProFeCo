
package reportescomentarios.modelo;

public class Comentario {
   
    private Integer id;
    private Integer clienteid;
    private Integer supermercadoid;
    private Integer calificacion;
    private String comentario;

    public Comentario() {
    }

    public Comentario(Integer id, Integer clienteid, Integer supermercadoid, Integer calificacion, String comentario) {
        this.id = id;
        this.clienteid = clienteid;
        this.supermercadoid = supermercadoid;
        this.calificacion = calificacion;
        this.comentario = comentario;
    }

    public Comentario(Integer clienteid, Integer supermercadoid, Integer calificacion, String comentario) {
        this.clienteid = clienteid;
        this.supermercadoid = supermercadoid;
        this.calificacion = calificacion;
        this.comentario = comentario;
    }

    public Comentario(Integer id, Integer clienteid) {
        this.id = id;
        this.clienteid = clienteid;
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

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "Comentario{" + "id=" + id + ", clienteid=" + clienteid + ", supermercadoid=" + supermercadoid + ", calificacion=" + calificacion + ", comentario=" + comentario + '}';
    }
    
}
