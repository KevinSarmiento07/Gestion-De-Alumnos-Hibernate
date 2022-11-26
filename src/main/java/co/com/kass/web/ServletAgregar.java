/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.kass.web;

import co.com.kass.domain.Alumno;
import co.com.kass.domain.Contacto;
import co.com.kass.domain.Domicilio;
import co.com.kass.servicio.ServicioAlumno;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;

/**
 *
 * @author kevin
 */
@WebServlet("/ServletAgregar")
public class ServletAgregar extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String calle = request.getParameter("calle");
        String noCalle = request.getParameter("noCalle");
        String pais = request.getParameter("pais");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        
        Domicilio domicilio = new Domicilio();
        domicilio.setCalle(calle);
        domicilio.setNoCalle(noCalle);
        domicilio.setPais(pais);
        
        Contacto contacto = new Contacto();
        contacto.setEmail(email);
        contacto.setTelefono(telefono);
        
        Alumno alumno = new Alumno();
        alumno.setNombre(nombre);
        alumno.setApellido(apellido);
        alumno.setDomicilio(domicilio);
        alumno.setContacto(contacto);
        
        
        ServicioAlumno servicioAlumno = new ServicioAlumno();
        servicioAlumno.guardarAlumno(alumno);
        
        
        
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

}
