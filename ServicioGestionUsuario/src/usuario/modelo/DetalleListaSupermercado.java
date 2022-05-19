
package usuario.modelo;

public class DetalleListaSupermercado {
   
    private Integer id;
    private Integer listaSupermercadoId;
    private Integer productoId;
    private Float precio;
    private Integer cantidad;

    public DetalleListaSupermercado() {
    }

    public DetalleListaSupermercado(Integer listaSupermercadoId, Integer productoId, Float precio, Integer cantidad) {
        this.listaSupermercadoId = listaSupermercadoId;
        this.productoId = productoId;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getListaSupermercadoId() {
        return listaSupermercadoId;
    }

    public void setListaSupermercadoId(Integer listaSupermercadoId) {
        this.listaSupermercadoId = listaSupermercadoId;
    }

    public Integer getProductoId() {
        return productoId;
    }

    public void setProductoId(Integer productoId) {
        this.productoId = productoId;
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

    @Override
    public String toString() {
        return "DetalleListaSupermercado{" + "id=" + id + ", listaSupermercadoId=" + listaSupermercadoId + ", productoId=" + productoId + ", precio=" + precio + ", cantidad=" + cantidad + '}';
    }

}
