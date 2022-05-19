
# Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
# Click nbfs://nbhost/SystemFileSystem/Templates/Other/Dockerfile to edit this template

FROM openjdk:lastest
COPY .dist/ServicioGestionUsuario.jar /usr/app
WORKDIR /user/app
ENTRYPOINT {"java","-jar","ServicioGestionUsuario.jar"}
