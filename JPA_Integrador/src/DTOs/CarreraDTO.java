package DTOs;

import entities.Carrera;
import entities.Estudiante;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class CarreraDTO implements Serializable {

    Carrera carrera;
    HashMap<String,List<Estudiante>> estudiantesGraduados;
    HashMap<String,List<Estudiante>> estudiantesInscriptos;

    public CarreraDTO(Carrera carrera, HashMap<String,List<Estudiante>> estudiantesGraduados, HashMap<String,List<Estudiante>> estudiantesInscriptos) {
        this.carrera = carrera;
        this.estudiantesGraduados = estudiantesGraduados;
        this.estudiantesInscriptos = estudiantesInscriptos;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public  HashMap<String,List<Estudiante>> getEstudiantesGraduados() {
        return estudiantesGraduados;
    }

    public void setEstudiantesGraduados( HashMap<String,List<Estudiante>> estudiantesGraduados) {
        this.estudiantesGraduados = estudiantesGraduados;
    }

    public  HashMap<String,List<Estudiante>> getEstudiantesNG() {
        return estudiantesInscriptos;
    }

    public void setEstudiantesNG( HashMap<String,List<Estudiante>> estudiantesNG) {
        this.estudiantesInscriptos = estudiantesNG;
    }
}
