/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.kass.web;

/**
 *
 * @author kevin
 */


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;

@WebServlet("/ServletRedireccionar")
public class ServletRedireccionar extends HttpServlet{
    
    
    @Override
    protected void doGet(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException{
        
        request.getRequestDispatcher("/WEB-INF/agregarAlumno.jsp").forward(request, response);
    }
}
