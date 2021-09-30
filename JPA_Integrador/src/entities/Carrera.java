package entities;

import javax.persistence.*;
import java.util.List;

//import javax.persistence.ManyToMany;

@Entity
public class Carrera {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;
	
	// antiguedad y si esta graduado o no deberia ir en la tabla estudiante_carrera ??
	
	@Column
	private String nombre;
	
	@OneToMany (mappedBy = "carrera")
	private List<Estudiante_Carrera> estudiantes;
	
	
	public Carrera() {
		super();
	}


	public Carrera(String nombre) {
		super();
		this.nombre = nombre;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public List<Estudiante_Carrera> getEstudiantes() {
		return estudiantes;
	}


	public void setEstudiantes(List<Estudiante_Carrera> estudiantes) {
		this.estudiantes = estudiantes;
	}


	public Long getId() {
		return id;
	}
	
	
	
	
	

}
