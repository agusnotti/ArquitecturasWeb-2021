package rest;

public class Usuario {

	private int id;
	private String nombre;
	private String apellido;
	
	
	public Usuario() {
		super();
	}

	public Usuario(int id, String nombre, String apellido) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
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

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + "]";
	}
	
	
}
