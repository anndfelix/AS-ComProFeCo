
<%@page import="usuario.modelo.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

        <%@include file="jspf/navbar_inicio.jspf"%>

        <div id="inicio" class="hero-image">
            <div class="hero-text">
                <h1 id="titulo">ComProFeCo</h1>
                <p id="subtitulo">Unete a nuestra inicitiva para la transparencia de grandes, pequeños y microsupermercados!</p>
            </div>
        </div>

        <div class="offcanvas offcanvas-end" id="demo">
            <div class="offcanvas-header">
                <div class="container">
                    <form action="iniciarSesion" method="POST">
                        <div class="my-3">
                            <label for="usuario" class="form-label">Usuario:</label>
                            <input type="text" class="form-control" id="usuario" placeholder="Usuario" name="usuario" required>
                        </div>
                        <div class="mb-3">
                            <label for="contrasenia" class="form-label">Contrase&ntilde;a:</label>
                            <input type="password" class="form-control" id="contrasenia" placeholder="Contrase&ntilde;a" name="contrasenia" required>

                            <div style="color: #FF0000;">${errorMessage}</div>
                        </div>

                        <div class="d-grid">
                            <button type="submit" class="btn btn-primary btn-block my-1">Iniciar sesi&oacute;n</button>
                        </div>
                    </form>
                    <p class="text-center mt-1"><a href="#">¿Ha olvidado su contrase&ntilde;a?</a></p>
                    <hr>
                    <div class="text-center">
                        <button type="button" class="btn btn-success btn-block my-1" data-bs-toggle="modal" data-bs-target="#registro">Registrarse</button>
                    </div>

                </div>
            </div>
        </div>

        <div class="modal" id="registro">
            <div class="modal-dialog">
                <div class="modal-content">

                    <div class="modal-header">
                        <h4 class="modal-title">Crear nueva cuenta</h4>
                        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                    </div>

                    <div class="modal-body">
                        <form action="registrarCliente" method="POST">
                            <!-- Usuario -->
                            <input type="text" maxlength="20" 
                                   pattern="[a-zA-Z0-9_]{5,20}"
                                   title="El nombre de usuario debe ser mayor a 5 y menor a 20 caracteres, sin caracteres especiales."
                                   class="form-control mb-2" id="reg_usuario" placeholder="Usuario" name="reg_usuario" required>

                            <!-- Nombre -->
                            <input type="text" maxlength="20" 
                                   pattern="[a-zA-ZàáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð ,.'-]{5,50}"
                                   title="El nombre debe ser mayor a 3 y menor a 20 caracteres, sin d&iacute;gitos."
                                   class="form-control mb-2" id="nombre" placeholder="Nombre" name="nombre" required>

                            <!-- Email -->
                            <input type="email" maxlength="50" 
                                   title="Favor de introducir un correo v&aa&aacute;lido"
                                   class="form-control mb-2" id="email" placeholder="Correo electr&oacute;nico" name="email" required>

                            <!-- Contraseña -->
                            <input type="password" maxlength="15" pattern="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\S+$).{6,}$"
                                   title="La contraseña debe ser mayor a 6 caracteres y debe incluir por lo menos una mayúscula y un d&iacute;gito. M&aacute;ximo 15 caracteres."
                                   class="form-control mb-2" id="reg_contrasenia" placeholder="Contrase&ntilde;a" name="reg_contrasenia" required>

                            <!-- Confirmar contraseña -->
                            <input type="password" maxlength="15" pattern="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\S+$).{6,}$"
                                   title="La contraseña debe ser mayor a 6 caracteres y debe incluir por lo menos una mayúscula y un d&iacute;gito. M&aacute;ximo 15 caracteres."
                                   class="form-control mb-2" id="reg_confirmar_contrasenia" placeholder="Confirmar contrase&ntilde;a" name="reg_confirmar_contrasenia" required>

                            <!-- Teléfono -->
                            <input type="tel" pattern="[0-9]{10}" 
                                   title="El número de telefóno debe ser a 10 dígitos."
                                   class="form-control mb-2" id="telefono" placeholder="Tel&eacute;fono" name="telefono" required>

                            <!-- Modal footer -->
                            <div class="modal-footer justify-content-center mt-4">
                                <button type="submit" class="btn btn-success">Registrarse</button>
                            </div>
                        </form>
                    </div>

                </div>
            </div>
        </div>

        <div id="nosotros" class="container mt-5">
            <div class="row ">
                <div class="col-sm-2"></div>
                <div class="col-sm-4">
                    <h1>Sobre PROFECO</h1><br>    
                    <p>La Procuraduría Federal del Consumidor (PROFECO) tiene como misión proteger y
                        promover los derechos de los consumidores, garantizando relaciones comerciales
                        equitativas que fortalezcan la cultura de consumo responsable y el acceso en mejores
                        condiciones de mercado a productos y servicios, asegurando certeza, legalidad y
                        seguridad jurídica dentro del marco normativo de los Derechos Humanos reconocidos
                        para los consumidores.</p>
                    <br>
                    <p class="display-6">Misi&oacute;n</p>
                    <p>Empoderar al consumidor mediante la protección efectiva del ejercicio de sus derechos y la confianza ciudadana, promoviendo un
                        consumo razonado, informado, sostenible, seguro y saludable, a fin de corregir injusticias del mercado, fortalecer el mercado interno y el
                        bienestar de la población..</p>
                    <br>
                    <p class="display-6">Visi&oacute;n</p>
                    <p>Ser una Institución cercana a la gente, efectiva en la protección y defensa de los consumidores, reconocida por su estricto apego a la
                        ley, con capacidad de fomentar la igualdad, la no discriminación, la participación ciudadana, y 
                        la educación para un consumo responsable.</p>
                </div>
                <div class="col-sm-4">
                    <img class="img-fluid" src="images/profeco.jpg" alt="doctor" width="500">
                    <img class="img-fluid" src="images/profeco1.jpg" alt="doctor" width="500">
                    <img class="img-fluid" src="images/profeco2.jpeg" alt="doctor" width="500">
                </div>
                <div class="col-sm-2"></div>
            </div>
        </div>
                        
        <div id="contacto" class="container-fluid mt-5 bg-light">
            <div class="row">
                <div class="col">
                    <h1>Cont&aacute;ctanos</h1>
                    <form action="/action_page.php">
                        <div class="mb-3 mt-3">
                            <label for="name">Nombre completo</label>
                            <input type="text" class="form-control" id="name" aria-describedby="emailHelp" placeholder="Nombre completo" required>
                        </div>
                        <div class="mb-3">
                            <label for="email">Correo electr&oacute;nico</label>
                            <input type="email" class="form-control" id="email" aria-describedby="emailHelp" placeholder="Correo electr&oacute;nico" required>
                            <small id="emailHelp" class="form-text text-muted">Nunca compartiremos su informaci&oacute;n con nadie m&aacute;s.</small>
                        </div>
                        <div class="mb-3">
                            <label for="message">Mensaje</label>
                            <textarea class="form-control" id="message" rows="6" required></textarea>
                        </div>
                        <div class="mx-auto">
                            <button type="submit" class="btn btn-primary text-right">Enviar</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <div class="mt-5 p-4 bg-dark text-white text-center">
            <p>Todos los derechos reservados</p>
            <img class="img-fluid" src="images/logopfco.png" alt="doctor" width="200">
        </div>

        <script>
            var password = document.getElementById("reg_contrasenia"), confirm_password = document.getElementById("reg_confirmar_contrasenia");

            function validatePassword() {
                if (password.value !== confirm_password.value) {
                    confirm_password.setCustomValidity("Las contraseñas no coinciden");
                } else {
                    confirm_password.setCustomValidity('');
                }
            }
            password.onchange = validatePassword;
            confirm_password.onkeyup = validatePassword;
        </script>
    </body>
</html>
