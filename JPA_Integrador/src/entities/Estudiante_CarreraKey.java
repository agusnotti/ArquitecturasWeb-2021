package entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Estudiante_CarreraKey implements Serializable {

	private static final long serialVersionUID = 5083293818445151026L;

	@Column(name = "estudiante_id")
    private int estudianteId;

    @Column(name = "carrera_id")
    private int carreraId;

    
    public Estudiante_CarreraKey(int estudianteId, int carreraId) {
		super();
		this.estudianteId = estudianteId;
		this.carreraId = carreraId;
	}

	public int getEstudianteId() {
		return estudianteId;
	}

	public void setEstudianteId(int estudianteId) {
		this.estudianteId = estudianteId;
	}

	public int getCarreraId() {
		return carreraId;
	}

	public void setCarreraId(int carreraId) {
		this.carreraId = carreraId;
	}
    
	@Override
	public int hashCode() {
		return Objects.hash(carreraId, estudianteId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estudiante_CarreraKey other = (Estudiante_CarreraKey) obj;
		return carreraId == other.carreraId && estudianteId == other.estudianteId;
	}

	
    
}
