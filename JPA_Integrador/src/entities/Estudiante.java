package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//import javax.persistence.ManyToMany;

@Entity
public class Estudiante {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;
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
	private List<Estudiante_Carrera> carreras;
	
	public Estudiante() {
		super();
	}
	public Estudiante(String nombre, String apellido, int edad, char genero, int dni, String ciudadResidencia,
			int libretaUniversitaria) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.genero = genero;
		this.dni = dni;
		this.ciudadResidencia = ciudadResidencia;
		this.libretaUniversitaria = libretaUniversitaria;
		this.carreras = new ArrayList<>();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public char getGenero() {
		return genero;
	}
	public void setGenero(char genero) {
		this.genero = genero;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public String getCiudadResidencia() {
		return ciudadResidencia;
	}
	public void setCiudadResidencia(String ciudadResidencia) {
		this.ciudadResidencia = ciudadResidencia;
	}
	public int getLibretaUniversitaria() {
		return libretaUniversitaria;
	}
	public void setLibretaUniversitaria(int libretaUniversitaria) {
		this.libretaUniversitaria = libretaUniversitaria;
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
