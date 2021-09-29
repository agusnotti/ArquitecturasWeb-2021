package entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Carrera {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;
	
	// antiguedad y si esta graduado o no deberia ir en la tabla estudiante_carrera ??
	
	@Column
	private String nombre;
	
	@OneToMany (mappedBy = "carrera")
	private List<Estudiante_Carrera> carreras;
	
	
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


	public List<Estudiante_Carrera> getCarreras() {
		return carreras;
	}


	public void setCarreras(List<Estudiante_Carrera> carreras) {
		this.carreras = carreras;
	}


	public Long getId() {
		return id;
	}
	
	
	
	
	

}
