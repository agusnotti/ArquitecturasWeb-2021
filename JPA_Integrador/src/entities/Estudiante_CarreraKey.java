package entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Estudiante_CarreraKey implements Serializable {

	private static final long serialVersionUID = 5083293818445151026L;

	@Column(name = "estudiante_id")
    private Long estudianteId;

    @Column(name = "carrera_id")
    private Long carreraId;

	public Estudiante_CarreraKey() {
		super();
	}

	public Long getEstudianteId() {
		return estudianteId;
	}

	public void setEstudianteId(Long estudianteId) {
		this.estudianteId = estudianteId;
	}

	public Long getCarreraId() {
		return carreraId;
	}

	public void setCarreraId(Long carreraId) {
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
