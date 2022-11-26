<%-- 
    Document   : listadoAlumnos
    Created on : 11/11/2022, 7:27:56 p. m.
    Author     : kevin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Alumnos</title>
    </head>
    <body>

        Listar Alumnos

        <table border="1">
            <br/>
            <a href="${pageContext.request.contextPath}/ServletRedireccionar">Agregar</a>
            <br/>
           
            <tr>
                <th>Alumno ID</th>
                <th>Nombre</th>
                <th>Domicilio</th>
                <th>Email</th>
                <th>Telefono</th>
            </tr>
            <c:forEach var="alumno" items="${alumnos}">
                <tr>
                    <td>
                        <a href="${pageContext.request.contextPath}/ServletModificar?idAlumno=${alumno.idAlumno}">
                        ${alumno.idAlumno}
                        </a>
                        
                    </td>
                    <td>${alumno.nombre} ${alumno.apellido}</td>
                    <td>${alumno.domicilio.calle} ${alumno.domicilio.noCalle} ${alumno.domicilio.pais}</td>
                    <td>${alumno.contacto.email}</td>
                    <td>${alumno.contacto.telefono}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
