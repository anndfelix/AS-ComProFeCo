
<%@page import="java.util.ArrayList"%>
<%@page import="productos.modelo.Producto"%>
<%@page import="controlador.ConsumidorGateway"%>
<%@page import="usuario.modelo.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    ConsumidorGateway cg = new ConsumidorGateway();
    ArrayList<Producto> listaProductos = cg.consultarProductos();
%>
<!DOCTYPE html>
<html>
    <head>
        <%
            Cliente cliente = (Cliente) session.getAttribute("cliente");
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ComProFeCo</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://kit.fontawesome.com/c7d94c22d4.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"></script>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body data-bs-spy="scroll" data-bs-target=".navbar" data-bs-offset="50">

        <%-- Incluye la barra de navegación --%>
        <%@include file="jspf/navbar.jspf"%>

        <div class="container" style="padding-top:100px;">
            <br><h1>Productos</h1>
            <input type="text" class="form-control" id="busqueda" placeholder="Busqueda de productos..." name="busqueda">
            <form action="gestionarProducto?tarea=buscarProducto" method="POST">
                <br><button type="submit" class="btn btn-primary btn-sm">Buscar</button>
            </form>

            <div class="card-header my-3">Todos los productos</div>
            <div class="row">
                <%
                    if (!listaProductos.isEmpty()) {
                        for (Producto p : listaProductos) {%>
                <div class="col-md-3 my-3">
                    <div class="card w-100" style="width: 18rem;">
                        <img class="card-img-top" src="images/header.jpg" alt="imagen">
                        <div class="card-body">
                            <h5 class="card-title"><%= p.getNombre()%></h5>
                            <h6>Precio: $<%= p.getPrecio()%></h6>
                            <h8><%= p.getDescripcion()%></h8>
                            <div class="mt-3 d-flex justify-content-between">
                                <form action="gestionarProducto?tarea=agregarALista" method="POST">
                                    <input type="hidden" name="id" value="<%= p.getId()%>" />
                                    <input type="hidden" name="total" value="<%= p.getPrecio()%>" />
                                    <button type="submit" class="btn btn-primary btn-sm">Agregar a la lista</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <%}
                    }
                %>
            </div>
        </div>

    </body>
</html>
