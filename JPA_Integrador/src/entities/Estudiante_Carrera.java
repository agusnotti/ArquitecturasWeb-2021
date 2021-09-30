package entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Estudiante_Carrera {

	@EmbeddedId
	private Estudiante_CarreraKey id;
	
	@ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "estudiante_id")
    private Estudiante estudiante;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "carrera_id")
    private Carrera carrera;

    
    @Column
	private Timestamp fechaInscripcion;
	@Column
	private boolean graduado;
	
	
	public Estudiante_Carrera() {
		super();
	}


	public Estudiante_Carrera(Estudiante estudiante, Carrera carrera, Timestamp fechaInscripcion, boolean graduado) {
		super();
		this.estudiante = estudiante;
		this.carrera = carrera;
		this.fechaInscripcion = fechaInscripcion;
		this.graduado = graduado;
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


	public boolean isGraduado() {
		return graduado;
	}


	public void setGraduado(boolean graduado) {
		this.graduado = graduado;
	}
	
	
	
}
