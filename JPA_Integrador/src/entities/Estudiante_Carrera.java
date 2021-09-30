package entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Estudiante_Carrera {

	@EmbeddedId
	private Estudiante_CarreraKey id;
	
	@ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "estudiante_id", nullable = false)
    private Estudiante estudiante;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "carrera_id", nullable = false)
    private Carrera carrera;

    
    @Column
	private Timestamp fechaInscripcion;
	@Column
	private Timestamp fechaGraduacion;
	
	
	public Estudiante_Carrera() {
		super();
	}


	public Estudiante_Carrera(Estudiante estudiante, Carrera carrera, Timestamp fechaInscripcion, Timestamp fechaGraduacion) {
		super();
		this.estudiante = estudiante;
		this.carrera = carrera;
		this.fechaInscripcion = fechaInscripcion;
		this.fechaGraduacion = fechaGraduacion;
		this.id = new Estudiante_CarreraKey(estudiante.getId(), carrera.getId());
	}


	public Estudiante_CarreraKey getId() {
		return id;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}


	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}


	public Carrera getCarrera() {
		return carrera;
	}


	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}


	public Timestamp getFechaInscripcion() {
		return fechaInscripcion;
	}


	public void setFechaInscripcion(Timestamp fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}


	public Timestamp getFechaGraduacion() {
		return fechaGraduacion;
	}


	public void setFechaGraduacion(Timestamp fechaGraduacion) {
		this.fechaGraduacion = fechaGraduacion;
	}


	@Override
	public String toString() {
		return "Estudiante_Carrera [estudiante=" + estudiante + ", carrera=" + carrera + ", fechaInscripcion="
				+ fechaInscripcion + ", fechaGraduacion=" + fechaGraduacion + "]";
	}




}
