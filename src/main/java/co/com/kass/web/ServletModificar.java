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
import javax.servlet.http.*;

/**
 *
 * @author kevin
 */
@WebServlet("/ServletModificar")
public class ServletModificar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idAlumnoS = request.getParameter("idAlumno");
        Integer idAlumno = Integer.parseInt(idAlumnoS);

        Alumno alumno = new Alumno();

        alumno.setIdAlumno(idAlumno);

        ServicioAlumno servicioAlumno = new ServicioAlumno();
        alumno = servicioAlumno.encontrarAlumno(alumno);

        // request.setAttribute("alumno", alumno);
        HttpSession session = request.getSession();
        session.setAttribute("alumno", alumno);

        request.getRequestDispatcher("/WEB-INF/modificarAlumno.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServicioAlumno servicioAlumno = new ServicioAlumno();

        String modificar = request.getParameter("Modificar");

        if (modificar != null) {

            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String calle = request.getParameter("calle");
            String noCalle = request.getParameter("noCalle");
            String pais = request.getParameter("pais");
            String email = request.getParameter("email");
            String telefono = request.getParameter("telefono");

            HttpSession session = request.getSession();
            Alumno alumno = (Alumno) session.getAttribute("alumno");

            alumno.setNombre(nombre);
            alumno.setApellido(apellido);
            alumno.getDomicilio().setCalle(calle);
            alumno.getDomicilio().setNoCalle(noCalle);
            alumno.getDomicilio().setPais(pais);
            alumno.getContacto().setEmail(email);
            alumno.getContacto().setTelefono(telefono);

            servicioAlumno.guardarAlumno(alumno);

            session.removeAttribute("alumno");
        } else {
            //caso eliminar
            String idAlumnoS = request.getParameter("idAlumno");
            Integer idAlumno = Integer.parseInt(idAlumnoS);

            Alumno alumno = new Alumno(idAlumno);
            servicioAlumno.eliminarAlumno(alumno);
            
            
        }
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

}
