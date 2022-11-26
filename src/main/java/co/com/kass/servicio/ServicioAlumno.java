package co.com.kass.servicio;

import co.com.kass.dao.AlumnoDAO;
import co.com.kass.domain.Alumno;
import java.util.ArrayList;
import java.util.List;

public class ServicioAlumno {
    
    private AlumnoDAO alumnoDAO = new AlumnoDAO();
    
    public List<Alumno> listarAlumnos(){
        return alumnoDAO.listar();
    
    }
    
    
    public void guardarAlumno(Alumno alumno){
        if(alumno != null && alumno.getIdAlumno() == null){
            alumnoDAO.insertar(alumno);
        }else{
            alumnoDAO.modificar(alumno);
        }
    }
    
    
    public void eliminarAlumno(Alumno alumno){
        alumnoDAO.eliminar(alumno);
    }
    
    public Alumno encontrarAlumno(Alumno alumno){
        return alumnoDAO.buscarAlumnoPorId(alumno);
    }
    
}
