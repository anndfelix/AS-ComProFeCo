
package usuario.modelo;


public class ListaSupermercado {
    
    private Integer id;
    private Integer clienteId;
    private Float total;

    public ListaSupermercado() {
    }

    public ListaSupermercado(Integer id) {
        this.id = id;
    }

    public ListaSupermercado(Integer clienteId, Float total) {
        this.clienteId = clienteId;
        this.total = total;
    }

    public ListaSupermercado(Integer id, Integer clienteId, Float total) {
        this.id = id;
        this.clienteId = clienteId;
        this.total = total;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "ListaSupermercado{" + "id=" + id + ", clienteId=" + clienteId + ", total=" + total + '}';
    }
    
}
