package entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

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
	
	@OneToMany (mappedBy = "estudiante")
	private List<Estudiante_Carrera> estudiantes;
	
	public Estudiante() {
		super();
	}
	
}
