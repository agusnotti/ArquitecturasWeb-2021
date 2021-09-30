package repository;


import java.sql.Timestamp;

import javax.persistence.EntityManager;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import entities.Carrera;
import entities.Estudiante;
import entities.Estudiante_Carrera;

public class Estudiante_CarreraRepositoryImpl implements Estudiante_CarreraRepository {

	private EntityManager em;
	
	
	public Estudiante_CarreraRepositoryImpl(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Estudiante_Carrera getEstudianteCarreraById(Long id) {
		return em.find(Estudiante_Carrera.class, id);
	}

	@Override
	public Estudiante_Carrera saveEstudianteCarrera(Estudiante_Carrera ec) {
		if (ec.getId() == null) {
			em.persist(ec);
		} else {
			ec = em.merge(ec);
		}
		return ec;
	}

	@Override
	public void deleteEstudianteCarrera(Estudiante_Carrera ec) {
		if (em.contains(ec)) {
			em.remove(ec);
		} else {
			em.merge(ec);
		}
		
	}
	
	@Override
	public void insertarDesdeCSV(CSVParser csv) {
		for(CSVRecord row: csv) {

			Estudiante estudiante = this.em.find(Estudiante.class, Long.parseLong(row.get("id_estudiante")) );
			Carrera carrera = this.em.find(Carrera.class, Long.parseLong(row.get("id_carrera")) );
			Timestamp fechaInscripcion = Timestamp.valueOf(row.get("fechaInscripcion"));
			
			Timestamp fechaGraduacion = null;
			if(!row.get("fechaGraduacion").equals("null")) {
				fechaGraduacion = Timestamp.valueOf(row.get("fechaGraduacion"));
			}
			
			System.out.println(row.get("fechaGraduacion"));

			Estudiante_Carrera ec = new Estudiante_Carrera(estudiante, carrera, fechaInscripcion, fechaGraduacion);
			try {
				this.saveEstudianteCarrera(ec);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}		
	}

}
