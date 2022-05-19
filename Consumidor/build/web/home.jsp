<%-- 
    Document   : home
    Created on : Nov 25, 2021, 2:48:03 AM
    Author     : ucova
--%>

<%@page import="usuario.modelo.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%
            Cliente cliente = (Cliente) session.getAttribute("cliente");
            if (null == cliente) {
                response.sendRedirect("index.jsp");
            }
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Perfil de cliente</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://kit.fontawesome.com/c7d94c22d4.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"></script>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body data-bs-spy="scroll" data-bs-target=".navbar" data-bs-offset="50">

        <%-- Incluye la barra de navegación --%>
        <%@include file="jspf/navbar.jspf"%>


        <div class="container-fluid m-0 px-0" style="padding-top:80px;">
            <div class="row">
                <div class="col-sm-3"></div>
                <div class="col-sm-6">
                    <br><h1>¡Bienvenido, ${cliente.usuario}!</h1>
                    <div>
                        <br><p>Los detalles de tu cuenta son los siguientes:</p>
                        <table class="table">
                            <tr>
                                <td>Usuario: </td>
                                <td>${cliente.usuario}</td>
                                <td><a data-bs-toggle="modal" data-bs-target="#cambiarUsuario" href="#"><i class="fas fa-chevron-right"></i></a></td>
                            </tr>
                            <tr>
                                <td>Correo electr&oacute;nico: </td>
                                <td>${cliente.email}</td>
                                <td><a data-bs-toggle="modal" data-bs-target="#cambiarEmail" href="#"><i class="fas fa-chevron-right"></i></a></td>
                            </tr>
                            <tr>
                                <td>Nombre: </td>
                                <td>${cliente.nombre}</td>
                                <td><a data-bs-toggle="modal" data-bs-target="#cambiarNombre" href="#"><i class="fas fa-chevron-right"></i></a></td>
                            </tr>
                            <tr>
                                <td>Tel&eacute;fono: </td>
                                <td>${cliente.telefono}</td>
                                <td><a data-bs-toggle="modal" data-bs-target="#cambiarTelefono" href="#"><i class="fas fa-chevron-right"></i></a></td>
                            </tr>
                        </table>
                        <div class="d-flex justify-content-between">
                            <small><a class="text-info" href="cerrarSesion" style="text-decoration: none;">Cerrar sesi&oacute;n</a></small>
                            <small><a class="text-danger" data-bs-toggle="modal" data-bs-target="#eliminarCuenta" href="#" style="text-decoration: none;">Eliminar cuenta</a></small>
                        </div>
                    </div>
                </div>
                <div class="col-sm-3">

                </div>
            </div>
        </div>

        <div class="modal fade" id="cambiarUsuario">
            <div class="modal-dialog modal-dialog-centered">
                <div class="modal-content">

                    <!-- Modal Header -->
                    <div class="modal-header">
                        <h4 class="modal-title">Modificar usuario</h4>
                        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                    </div>

                    <!-- Modal body -->
                    <div class="modal-body">
                        <form action="actualizarUsuario?tarea=actualizarUsuario" method="POST">
                            <small>Usuario</small>
                            <input type="text" class="form-control mb-2" id="usuario" placeholder="Usuario" name="usuario" value="${cliente.usuario}" required>
                            <div class="mt-5">
                                <button type="submit" class="btn btn-primary btn-lg" data-bs-dismiss="modal">Guardar</button>
                                <button type="button" class="btn btn-light btn-lg" data-bs-dismiss="modal">Cancelar</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <!-- Modal email -->
        <div class="modal fade" id="cambiarEmail">
            <div class="modal-dialog modal-dialog-centered">
                <div class="modal-content">

                    <!-- Modal Header -->
                    <div class="modal-header">
                        <h4 class="modal-title">Modificar email</h4>
                        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                    </div>

                    <!-- Modal body -->
                    <div class="modal-body">
                        <form action="actualizarUsuario?tarea=actualizarEmail" method="POST">
                            <small>Email</small>
                            <input type="text" class="form-control mb-2" id="email" placeholder="Correo electr&oacute;nico" name="email" value="${cliente.email}" required>
                            <div class="mt-5">
                                <button type="submit" class="btn btn-primary btn-lg" data-bs-dismiss="modal">Guardar</button>
                                <button type="button" class="btn btn-light btn-lg" data-bs-dismiss="modal">Cancelar</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>                    

        <!-- Modal nombre -->
        <div class="modal fade" id="cambiarNombre">
            <div class="modal-dialog modal-dialog-centered">
                <div class="modal-content">

                    <!-- Modal Header -->
                    <div class="modal-header">
                        <h4 class="modal-title">Modificar nombre</h4>
                        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                    </div>

                    <!-- Modal body -->
                    <div class="modal-body">
                        <form action="actualizarUsuario?tarea=actualizarNombre" method="POST">
                            <small>Nombre</small>
                            <input type="text" class="form-control mb-2" id="nombre" placeholder="Nombre" name="nombre" value="${cliente.nombre}" required>
                            <div class="mt-5">
                                <button type="submit" class="btn btn-primary btn-lg" data-bs-dismiss="modal">Guardar</button>
                                <button type="button" class="btn btn-light btn-lg" data-bs-dismiss="modal">Cancelar</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
                            
        <!-- Modal teléfono -->
        <div class="modal fade" id="cambiarTelefono">
            <div class="modal-dialog modal-dialog-centered">
                <div class="modal-content">

                    <!-- Modal Header -->
                    <div class="modal-header">
                        <h4 class="modal-title">Modificar tel&eacute;fono</h4>
                        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                    </div>

                    <!-- Modal body -->
                    <div class="modal-body">
                        <form action="actualizarUsuario?tarea=actualizarTelefono" method="POST">
                            <small>Tel&eacute;fono</small>
                            <input type="text" class="form-control mb-2" id="telefono" placeholder="Tel&eacute;fono" name="telefono" value="${cliente.telefono}" required>
                            <div class="mt-5">
                                <button type="submit" class="btn btn-primary btn-lg" data-bs-dismiss="modal">Guardar</button>
                                <button type="button" class="btn btn-light btn-lg" data-bs-dismiss="modal">Cancelar</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <!-- Modal eliminar cuenta -->
        <div class="modal fade" id="eliminarCuenta">
            <div class="modal-dialog modal-dialog-centered">
                <div class="modal-content">

                    <!-- Modal Header -->
                    <div class="modal-header">
                        <h4 class="modal-title text-danger">¡Advertencia!</h4>
                        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                    </div>

                    <!-- Modal body -->
                    <div class="modal-body">
                        <form action="eliminarUsuario" method="POST">
                            <p>¿Est&aacute; seguro de realizar esta acci&oacute;n?</p>
                            <div class="mt-5">
                                <button type="submit" class="btn btn-danger btn-lg" data-bs-dismiss="modal">Confirmar</button>
                                <button type="button" class="btn btn-light btn-lg" data-bs-dismiss="modal">Cancelar</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
