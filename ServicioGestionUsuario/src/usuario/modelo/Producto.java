
package usuario.modelo;

import java.util.List;

public class Producto {
   
    private Integer id;
    private String nombre;
    private String descripcion;
    private boolean disponible;
    private Supermercado supermercado;
    private Float precio;
    private Integer cantidad;
    private List<String> categorias;

    public Producto() {
    }

    public Producto(String nombre, String descripcion, boolean disponible, Supermercado supermercado, Float precio, Integer cantidad, List<String> categorias) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.disponible = disponible;
        this.supermercado = supermercado;
        this.precio = precio;
        this.cantidad = cantidad;
        this.categorias = categorias;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public Supermercado getSupermercado() {
        return supermercado;
    }

    public void setSupermercado(Supermercado supermercado) {
        this.supermercado = supermercado;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public List<String> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<String> categorias) {
        this.categorias = categorias;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", disponible=" + disponible + ", supermercado=" + supermercado + ", precio=" + precio + ", cantidad=" + cantidad + ", categorias=" + categorias + '}';
    }
    
}
