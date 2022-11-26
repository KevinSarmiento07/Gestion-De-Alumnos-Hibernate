/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.kass.test;

import co.com.kass.dao.AlumnoDAO;
import co.com.kass.dao.AsignacionDAO;
import co.com.kass.dao.ContactoDAO;
import co.com.kass.dao.CursoDAO;
import co.com.kass.dao.DomicilioDAO;

/**
 *
 * @author kevin
 */
public class Test {
    public static void main(String[] args) {
        
        
        
        AlumnoDAO alumnoDAO = new AlumnoDAO();
        AsignacionDAO asignacionDAO = new AsignacionDAO();
        ContactoDAO contactoDAO = new ContactoDAO();
        CursoDAO cursoDAO = new CursoDAO();
        DomicilioDAO domicilioDAO = new DomicilioDAO();
        
        alumnoDAO.listar();
        asignacionDAO.listar();
        contactoDAO.listar();
        cursoDAO.listar();
        domicilioDAO.listar();
    }
}
