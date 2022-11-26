/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.kass.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author kevin
 */
@Entity
public class Curso implements Serializable{
    
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso")
    private Integer idCurso;
    
    @Column(name = "nombre_curso") 
    private String nombreCurso;
    
    @Column(name = "precio_curso")
    private Double precioCurso;
    
    
    @OneToMany(mappedBy = "curso")
    private List<Asignacion> asignaciones;
    

    public Curso() {
    }

    public Curso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public List<Asignacion> getAsignaciones() {
        return asignaciones;
    }

    public void setAsignaciones(List<Asignacion> asignaciones) {
        this.asignaciones = asignaciones;
    }

    
    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public Double getPrecioCurso() {
        return precioCurso;
    }

    public void setPrecioCurso(Double precioCurso) {
        this.precioCurso = precioCurso;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.idCurso);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Curso other = (Curso) obj;
        if (!Objects.equals(this.idCurso, other.idCurso)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Curso{" + "idCurso=" + idCurso + ", nombreCurso=" + nombreCurso + ", precioCurso=" + precioCurso + '}';
    }
    
    
    
    
    
    
}
