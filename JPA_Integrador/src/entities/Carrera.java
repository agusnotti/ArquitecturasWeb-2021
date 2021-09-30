package entities;

import javax.persistence.*;
import java.util.List;


@Entity
public class Carrera {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;
	
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


	public Long getId() {
		return id;
	}


	@Override
	public String toString() {
		return "Carrera [id=" + id + ", nombre=" + nombre + ", estudiantes=" + estudiantes + "]";
	}
	
	

}
