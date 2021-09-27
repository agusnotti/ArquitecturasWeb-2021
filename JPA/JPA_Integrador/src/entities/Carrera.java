package entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Carrera {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id;
	
	// antiguedad y si esta graduado o no deberia ir en la tabla estudiante_carrera ??
	@Column
	private int antiguedad;
	@Column
	private char graduado; // s - n
	
	@ManyToMany (mappedBy = "carreras")
	private List<Estudiante> estudiantes;
	
	
	public Carrera() {
		super();
	}
	
	
	

}
