package usuario.modelo;

import java.util.List;

public class Wishlist {

    private Integer idWishlist;
    private Integer clienteId;
    private Integer productoId;

    public Wishlist() {
    }

    public Wishlist(Integer idWishlist, Integer clienteId, Integer productoId) {
        this.idWishlist = idWishlist;
        this.clienteId = clienteId;
        this.productoId = productoId;
    }

    public Wishlist(Integer clienteId, Integer productoId) {
        this.clienteId = clienteId;
        this.productoId = productoId;
    }

    public Integer getIdWishlist() {
        return idWishlist;
    }

    public void setIdWishlist(Integer idWishlist) {
        this.idWishlist = idWishlist;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public Integer getProductoId() {
        return productoId;
    }

    public void setProductoId(Integer productoId) {
        this.productoId = productoId;
    }

    @Override
    public String toString() {
        return "Wishlist{" + "idWishlist=" + idWishlist + ", clienteId=" + clienteId + ", productoId=" + productoId + '}';
    }

   

}
