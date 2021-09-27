package entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Estudiante {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id;
	
	@Column
	private String nombre; // nombres -> puede tener mas de 1 
	@Column
	private String apellido;
	@Column
	private int edad;
	@Column
	private char genero; // m - f
	@Column
	private int dni;
	@Column
	private String ciudadResidencia;
	@Column
	private int libretaUniversitaria;
	
	@ManyToMany
	private List<Carrera> carreras;
	
	public Estudiante() {
		super();
	}
	
}
