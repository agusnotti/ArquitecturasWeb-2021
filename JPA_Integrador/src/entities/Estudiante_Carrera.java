package entities;

//import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class Estudiante_Carrera {

	@EmbeddedId
	private Estudiante_CarreraKey id;
	
	@ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "estudiante_id")
    private Estudiante estudiante;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "carrera_id")
    private Carrera carrera;

    
    @Column
	private int antiguedad;
	@Column
	private boolean graduado;

    public Estudiante_Carrera() {
        super();
    }

    public Estudiante_Carrera(Estudiante_CarreraKey id, Estudiante estudiante, Carrera carrera, int antiguedad, boolean graduado) {
        super();
        this.id = id;
        this.estudiante = estudiante;
        this.carrera = carrera;
        this.antiguedad = antiguedad;
        this.graduado = graduado;
    }
}
